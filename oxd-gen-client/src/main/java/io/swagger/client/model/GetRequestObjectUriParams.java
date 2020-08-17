/*
 * oxd-server
 * oxd-server
 *
 * OpenAPI spec version: 4.2
 * Contact: yuriyz@gluu.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * GetRequestObjectUriParams
 */


public class GetRequestObjectUriParams {
  @SerializedName("oxd_id")
  private String oxdId = null;

  @SerializedName("params")
  private Map<String, Object> params = null;

  @SerializedName("request_object_signing_alg")
  private String requestObjectSigningAlg = null;

  @SerializedName("oxd_host_url")
  private String oxdHostUrl = null;

  public GetRequestObjectUriParams oxdId(String oxdId) {
    this.oxdId = oxdId;
    return this;
  }

   /**
   * Get oxdId
   * @return oxdId
  **/
  @Schema(example = "bcad760f-91ba-46e1-a020-05e4281d91b6", required = true, description = "")
  public String getOxdId() {
    return oxdId;
  }

  public void setOxdId(String oxdId) {
    this.oxdId = oxdId;
  }

  public GetRequestObjectUriParams params(Map<String, Object> params) {
    this.params = params;
    return this;
  }

  public GetRequestObjectUriParams putParamsItem(String key, Object paramsItem) {
    if (this.params == null) {
      this.params = new HashMap<String, Object>();
    }
    this.params.put(key, paramsItem);
    return this;
  }

   /**
   * Get params
   * @return params
  **/
  @Schema(description = "")
  public Map<String, Object> getParams() {
    return params;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }

  public GetRequestObjectUriParams requestObjectSigningAlg(String requestObjectSigningAlg) {
    this.requestObjectSigningAlg = requestObjectSigningAlg;
    return this;
  }

   /**
   * choose the JWS alg algorithm (JWA) that must be required by the Authorization Server. Valid values are none, HS256, HS384, HS512, RS256, RS384, RS512, ES256, ES384, ES512, PS256, PS384, PS512
   * @return requestObjectSigningAlg
  **/
  @Schema(example = "RS256", description = "choose the JWS alg algorithm (JWA) that must be required by the Authorization Server. Valid values are none, HS256, HS384, HS512, RS256, RS384, RS512, ES256, ES384, ES512, PS256, PS384, PS512")
  public String getRequestObjectSigningAlg() {
    return requestObjectSigningAlg;
  }

  public void setRequestObjectSigningAlg(String requestObjectSigningAlg) {
    this.requestObjectSigningAlg = requestObjectSigningAlg;
  }

  public GetRequestObjectUriParams oxdHostUrl(String oxdHostUrl) {
    this.oxdHostUrl = oxdHostUrl;
    return this;
  }

   /**
   * Get oxdHostUrl
   * @return oxdHostUrl
  **/
  @Schema(example = "https://<oxd-host>", required = true, description = "")
  public String getOxdHostUrl() {
    return oxdHostUrl;
  }

  public void setOxdHostUrl(String oxdHostUrl) {
    this.oxdHostUrl = oxdHostUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetRequestObjectUriParams getRequestObjectUriParams = (GetRequestObjectUriParams) o;
    return Objects.equals(this.oxdId, getRequestObjectUriParams.oxdId) &&
        Objects.equals(this.params, getRequestObjectUriParams.params) &&
        Objects.equals(this.requestObjectSigningAlg, getRequestObjectUriParams.requestObjectSigningAlg) &&
        Objects.equals(this.oxdHostUrl, getRequestObjectUriParams.oxdHostUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oxdId, params, requestObjectSigningAlg, oxdHostUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetRequestObjectUriParams {\n");
    
    sb.append("    oxdId: ").append(toIndentedString(oxdId)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    requestObjectSigningAlg: ").append(toIndentedString(requestObjectSigningAlg)).append("\n");
    sb.append("    oxdHostUrl: ").append(toIndentedString(oxdHostUrl)).append("\n");
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