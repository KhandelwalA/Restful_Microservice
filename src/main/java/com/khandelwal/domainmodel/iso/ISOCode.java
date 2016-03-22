
package com.khandelwal.domainmodel.iso;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "RestResponse"
})
public class ISOCode {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("RestResponse")
    private com.khandelwal.domainmodel.iso.RestResponse RestResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The RestResponse
     */
    @JsonProperty("RestResponse")
    public com.khandelwal.domainmodel.iso.RestResponse getRestResponse() {
        return RestResponse;
    }

    /**
     * 
     * (Required)
     * 
     * @param RestResponse
     *     The RestResponse
     */
    @JsonProperty("RestResponse")
    public void setRestResponse(com.khandelwal.domainmodel.iso.RestResponse RestResponse) {
        this.RestResponse = RestResponse;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(RestResponse).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ISOCode) == false) {
            return false;
        }
        ISOCode rhs = ((ISOCode) other);
        return new EqualsBuilder().append(RestResponse, rhs.RestResponse).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
