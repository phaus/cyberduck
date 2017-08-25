package ch.cyberduck.core.onedrive;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.*;
import ch.cyberduck.core.exception.LoginCanceledException;
import ch.cyberduck.core.ssl.DefaultX509KeyManager;
import ch.cyberduck.core.ssl.DefaultX509TrustManager;
import ch.cyberduck.test.IntegrationTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

@Category(IntegrationTest.class)
public class OneDriveBusinessContextLoginTest {

    @BeforeClass
    public static void protocol() {
        ProtocolFactory.get().register(new OneDriveProtocol());
    }

    @Test(expected = LoginCanceledException.class)
    public void testLogin() throws Exception {
        final Profile profile = ProfileReaderFactory.get().read(
                new Local("../profiles/Microsoft OneDrive Business.cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname());
        final OneDriveSession session = new OneDriveSession(host, new DefaultX509TrustManager(), new DefaultX509KeyManager());
        new LoginConnectionService(new DisabledLoginCallback() {
            @Override
            public void prompt(final Host bookmark, final Credentials credentials, final String title, final String reason, final LoginOptions options) throws LoginCanceledException {
                assertEquals("OAuth2 Authentication", title);
                throw new LoginCanceledException();
            }
        }, new DisabledHostKeyCallback(),
                new DisabledPasswordStore() {
                    @Override
                    public String getPassword(Scheme scheme, int port, String hostname, String user) {
                        if("Microsoft OneDrive Business OAuth2 Access Token".equals(user)) {
                            return System.getProperties().getProperty("onedrive.business.accesstoken");
                        }
                        if("Microsoft OneDrive Business OAuth2 Refresh Token".equals(user)) {
                            return System.getProperties().getProperty("onedrive.business.refreshtoken");
                        }
                        return null;
                    }

                    @Override
                    public String getPassword(String hostname, String user) {
                        return super.getPassword(hostname, user);
                    }
                }, new DisabledProgressListener()).connect(session, PathCache.empty(), new DisabledCancelCallback());
        assertEquals("/b!9prv2DvXt0Cua27a0kKBHlYP69u02QdCtkueQRimv8UsYPDHr-_uQoMvBiuYAjdH", (new OneDriveHomeFinderFeature(session).find().getAbsolute()));
    }
}
