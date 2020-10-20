package io.jans.ca.common.params;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Yuriy Zabrovarnyy
 * @version 0.9, 22/09/2015
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserInfoParams implements HasRpIdParams {

    @JsonProperty(value = "rp_id")
    private String rp_id;
    @JsonProperty(value = "access_token")
    private String access_token;
    @JsonProperty(value = "id_token")
    private String id_token;

    public GetUserInfoParams() {
    }

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        this.access_token = accessToken;
    }

    public String getRpId() {
        return rp_id;
    }

    public void setRpId(String rpId) {
        this.rp_id = rpId;
    }

    public String getIdToken() {
        return id_token;
    }

    public void setIdToken(String idToken) {
        this.id_token = idToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetUserInfoParams that = (GetUserInfoParams) o;

        if (access_token != null ? !access_token.equals(that.access_token) : that.access_token != null) return false;
        return !(rp_id != null ? !rp_id.equals(that.rp_id) : that.rp_id != null);

    }

    @Override
    public int hashCode() {
        int result = rp_id != null ? rp_id.hashCode() : 0;
        result = 31 * result + (access_token != null ? access_token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GetUserInfoParams");
        sb.append("{access_token='").append(access_token).append('\'');
        sb.append(", rp_id='").append(rp_id).append('\'');
        sb.append(", id_token='").append(id_token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
