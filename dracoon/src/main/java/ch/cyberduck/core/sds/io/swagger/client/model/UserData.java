/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.8.0-LTS  - built at: 2018-05-03 15:44:37<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.8.0-LTS
 * Contact: develop@dracoon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-23T09:31:14.222+02:00")
public class UserData {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("lockStatus")
  private Integer lockStatus = null;

  @JsonProperty("isLocked")
  private Boolean isLocked = null;

  @JsonProperty("authMethods")
  private List<UserAuthMethod> authMethods = new ArrayList<UserAuthMethod>();

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("title")
  private String title = null;

  /**
   * Gender
   */
  public enum GenderEnum {
    M("m"),
    
    F("f"),
    
    N("n");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenderEnum fromValue(String text) {
      for (GenderEnum b : GenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender = null;

  @JsonProperty("expireAt")
  private DateTime expireAt = null;

  @JsonProperty("hasManageableRooms")
  private Boolean hasManageableRooms = null;

  @JsonProperty("isEncryptionEnabled")
  private Boolean isEncryptionEnabled = null;

  @JsonProperty("lastLoginSuccessAt")
  private DateTime lastLoginSuccessAt = null;

  @JsonProperty("publicKeyContainer")
  private PublicKeyContainer publicKeyContainer = null;

  @JsonProperty("userRoles")
  private RoleList userRoles = null;

  @JsonProperty("userAttributes")
  private UserAttributes userAttributes = null;

  public UserData id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier for the user")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserData login(String login) {
    this.login = login;
    return this;
  }

   /**
   * User login name
   * @return login
  **/
  @ApiModelProperty(required = true, value = "User login name")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public UserData firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * User first name
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "User first name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserData lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * User last name
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "User last name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserData lockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
    return this;
  }

   /**
   * DEPRECATED. User lock status: * &#x60;0&#x60; - locked * &#x60;1&#x60; - Web access allowed * &#x60;2&#x60; - Web and mobile access allowed
   * @return lockStatus
  **/
  @ApiModelProperty(required = true, value = "DEPRECATED. User lock status: * `0` - locked * `1` - Web access allowed * `2` - Web and mobile access allowed")
  public Integer getLockStatus() {
    return lockStatus;
  }

  public void setLockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
  }

  public UserData isLocked(Boolean isLocked) {
    this.isLocked = isLocked;
    return this;
  }

   /**
   * User is locked: * &#x60;false&#x60; - unlocked * &#x60;true&#x60; - locked  Iser is locked and can not login anymore. (default: false)
   * @return isLocked
  **/
  @ApiModelProperty(example = "false", required = true, value = "User is locked: * `false` - unlocked * `true` - locked  Iser is locked and can not login anymore. (default: false)")
  public Boolean getIsLocked() {
    return isLocked;
  }

  public void setIsLocked(Boolean isLocked) {
    this.isLocked = isLocked;
  }

  public UserData authMethods(List<UserAuthMethod> authMethods) {
    this.authMethods = authMethods;
    return this;
  }

  public UserData addAuthMethodsItem(UserAuthMethod authMethodsItem) {
    this.authMethods.add(authMethodsItem);
    return this;
  }

   /**
   * Authentication methods: * &#x60;sql&#x60; * &#x60;active_directory&#x60; * &#x60;radius&#x60; * &#x60;openid&#x60;
   * @return authMethods
  **/
  @ApiModelProperty(required = true, value = "Authentication methods: * `sql` * `active_directory` * `radius` * `openid`")
  public List<UserAuthMethod> getAuthMethods() {
    return authMethods;
  }

  public void setAuthMethods(List<UserAuthMethod> authMethods) {
    this.authMethods = authMethods;
  }

  public UserData email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email (not used)
   * @return email
  **/
  @ApiModelProperty(example = "john.doe@email.com", required = true, value = "Email (not used)")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserData phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Phone Number
   * @return phone
  **/
  @ApiModelProperty(value = "Phone Number")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserData title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Job title
   * @return title
  **/
  @ApiModelProperty(value = "Job title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UserData gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Gender
   * @return gender
  **/
  @ApiModelProperty(example = "n", value = "Gender")
  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public UserData expireAt(DateTime expireAt) {
    this.expireAt = expireAt;
    return this;
  }

   /**
   * Expiration date
   * @return expireAt
  **/
  @ApiModelProperty(example = "2018-01-01T00:00:00", value = "Expiration date")
  public DateTime getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(DateTime expireAt) {
    this.expireAt = expireAt;
  }

  public UserData hasManageableRooms(Boolean hasManageableRooms) {
    this.hasManageableRooms = hasManageableRooms;
    return this;
  }

   /**
   * User has manageable rooms
   * @return hasManageableRooms
  **/
  @ApiModelProperty(example = "false", value = "User has manageable rooms")
  public Boolean getHasManageableRooms() {
    return hasManageableRooms;
  }

  public void setHasManageableRooms(Boolean hasManageableRooms) {
    this.hasManageableRooms = hasManageableRooms;
  }

  public UserData isEncryptionEnabled(Boolean isEncryptionEnabled) {
    this.isEncryptionEnabled = isEncryptionEnabled;
    return this;
  }

   /**
   * User has generated private key. Possible if **TripleCrypt™ technology** is active for this customer
   * @return isEncryptionEnabled
  **/
  @ApiModelProperty(example = "false", value = "User has generated private key. Possible if **TripleCrypt™ technology** is active for this customer")
  public Boolean getIsEncryptionEnabled() {
    return isEncryptionEnabled;
  }

  public void setIsEncryptionEnabled(Boolean isEncryptionEnabled) {
    this.isEncryptionEnabled = isEncryptionEnabled;
  }

  public UserData lastLoginSuccessAt(DateTime lastLoginSuccessAt) {
    this.lastLoginSuccessAt = lastLoginSuccessAt;
    return this;
  }

   /**
   * Last successful logon date
   * @return lastLoginSuccessAt
  **/
  @ApiModelProperty(example = "2018-01-01T00:00:00", value = "Last successful logon date")
  public DateTime getLastLoginSuccessAt() {
    return lastLoginSuccessAt;
  }

  public void setLastLoginSuccessAt(DateTime lastLoginSuccessAt) {
    this.lastLoginSuccessAt = lastLoginSuccessAt;
  }

  public UserData publicKeyContainer(PublicKeyContainer publicKeyContainer) {
    this.publicKeyContainer = publicKeyContainer;
    return this;
  }

   /**
   * Public key container (private key and version)
   * @return publicKeyContainer
  **/
  @ApiModelProperty(value = "Public key container (private key and version)")
  public PublicKeyContainer getPublicKeyContainer() {
    return publicKeyContainer;
  }

  public void setPublicKeyContainer(PublicKeyContainer publicKeyContainer) {
    this.publicKeyContainer = publicKeyContainer;
  }

  public UserData userRoles(RoleList userRoles) {
    this.userRoles = userRoles;
    return this;
  }

   /**
   * List of user roles
   * @return userRoles
  **/
  @ApiModelProperty(value = "List of user roles")
  public RoleList getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(RoleList userRoles) {
    this.userRoles = userRoles;
  }

  public UserData userAttributes(UserAttributes userAttributes) {
    this.userAttributes = userAttributes;
    return this;
  }

   /**
   * User attributes
   * @return userAttributes
  **/
  @ApiModelProperty(value = "User attributes")
  public UserAttributes getUserAttributes() {
    return userAttributes;
  }

  public void setUserAttributes(UserAttributes userAttributes) {
    this.userAttributes = userAttributes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserData userData = (UserData) o;
    return Objects.equals(this.id, userData.id) &&
        Objects.equals(this.login, userData.login) &&
        Objects.equals(this.firstName, userData.firstName) &&
        Objects.equals(this.lastName, userData.lastName) &&
        Objects.equals(this.lockStatus, userData.lockStatus) &&
        Objects.equals(this.isLocked, userData.isLocked) &&
        Objects.equals(this.authMethods, userData.authMethods) &&
        Objects.equals(this.email, userData.email) &&
        Objects.equals(this.phone, userData.phone) &&
        Objects.equals(this.title, userData.title) &&
        Objects.equals(this.gender, userData.gender) &&
        Objects.equals(this.expireAt, userData.expireAt) &&
        Objects.equals(this.hasManageableRooms, userData.hasManageableRooms) &&
        Objects.equals(this.isEncryptionEnabled, userData.isEncryptionEnabled) &&
        Objects.equals(this.lastLoginSuccessAt, userData.lastLoginSuccessAt) &&
        Objects.equals(this.publicKeyContainer, userData.publicKeyContainer) &&
        Objects.equals(this.userRoles, userData.userRoles) &&
        Objects.equals(this.userAttributes, userData.userAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, firstName, lastName, lockStatus, isLocked, authMethods, email, phone, title, gender, expireAt, hasManageableRooms, isEncryptionEnabled, lastLoginSuccessAt, publicKeyContainer, userRoles, userAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserData {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    lockStatus: ").append(toIndentedString(lockStatus)).append("\n");
    sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
    sb.append("    authMethods: ").append(toIndentedString(authMethods)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    hasManageableRooms: ").append(toIndentedString(hasManageableRooms)).append("\n");
    sb.append("    isEncryptionEnabled: ").append(toIndentedString(isEncryptionEnabled)).append("\n");
    sb.append("    lastLoginSuccessAt: ").append(toIndentedString(lastLoginSuccessAt)).append("\n");
    sb.append("    publicKeyContainer: ").append(toIndentedString(publicKeyContainer)).append("\n");
    sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
    sb.append("    userAttributes: ").append(toIndentedString(userAttributes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

