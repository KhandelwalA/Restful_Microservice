
package com.khandelwal.domainmodel.iso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "messages",
    "result"
})
public class RestResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("messages")
    private List<Object> messages = new ArrayList<Object>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("result")
    private List<Object> result = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The messages
     */
    @JsonProperty("messages")
    public List<Object> getMessages() {
        return messages;
    }

    /**
     * 
     * (Required)
     * 
     * @param messages
     *     The messages
     */
    @JsonProperty("messages")
    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The result
     */
    @JsonProperty("result")
    public List<Object> getResult() {
        return result;
    }

    /**
     * 
     * (Required)
     * 
     * @param result
     *     The result
     */
    @JsonProperty("result")
    public void setResult(List<Object> result) {
        this.result = result;
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
        return new HashCodeBuilder().append(messages).append(result).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RestResponse) == false) {
            return false;
        }
        RestResponse rhs = ((RestResponse) other);
        return new EqualsBuilder().append(messages, rhs.messages).append(result, rhs.result).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
