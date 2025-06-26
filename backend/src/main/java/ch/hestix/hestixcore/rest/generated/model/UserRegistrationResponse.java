package ch.hestix.hestixcore.rest.generated.model;

import java.net.URI;
import java.util.Objects;
import ch.hestix.hestixcore.rest.generated.model.TokenResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UserRegistrationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-26T16:18:16.117949+02:00[Europe/Zurich]", comments = "Generator version: 7.7.0")
public class UserRegistrationResponse {

  private String username;

  private String email;

  private TokenResponse token;

  public UserRegistrationResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserRegistrationResponse(String username, String email, TokenResponse token) {
    this.username = username;
    this.email = email;
    this.token = token;
  }

  public UserRegistrationResponse username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  @NotNull 
  @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserRegistrationResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @NotNull 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserRegistrationResponse token(TokenResponse token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */
  @NotNull @Valid 
  @Schema(name = "token", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("token")
  public TokenResponse getToken() {
    return token;
  }

  public void setToken(TokenResponse token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRegistrationResponse userRegistrationResponse = (UserRegistrationResponse) o;
    return Objects.equals(this.username, userRegistrationResponse.username) &&
        Objects.equals(this.email, userRegistrationResponse.email) &&
        Objects.equals(this.token, userRegistrationResponse.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, email, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRegistrationResponse {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

