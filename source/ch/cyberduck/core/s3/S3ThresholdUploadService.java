package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.ch
 */

import ch.cyberduck.core.Local;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Preferences;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.InteroperabilityException;
import ch.cyberduck.core.features.Upload;
import ch.cyberduck.core.io.BandwidthThrottle;
import ch.cyberduck.core.io.StreamListener;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public class S3ThresholdUploadService implements Upload {
    private static final Logger log = Logger.getLogger(S3ThresholdUploadService.class);

    private S3Session session;

    public S3ThresholdUploadService(final S3Session session) {
        this.session = session;
    }

    @Override
    public Object upload(final Path file, Local local, final BandwidthThrottle throttle, final StreamListener listener,
                         final TransferStatus status) throws BackgroundException {
        if(status.getLength() > Preferences.instance().getLong("s3.upload.multipart.threshold")) {
            final S3MultipartUploadService service = new S3MultipartUploadService(session);
            try {
                return service.upload(file, local, throttle, listener, status);
            }
            catch(InteroperabilityException e) {
                log.warn(String.format("Failure using multipart upload %s. Fallback to single upload.", e.getMessage()));
                final S3SingleUploadService single = new S3SingleUploadService(session);
                return single.upload(file, local, throttle, listener, status);
            }
        }
        else {
            final S3SingleUploadService single = new S3SingleUploadService(session);
            return single.upload(file, local, throttle, listener, status);
        }
    }
}
