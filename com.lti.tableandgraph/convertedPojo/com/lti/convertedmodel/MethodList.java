
package com.lti.convertedmodel;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "methodName",
    "accessModifier",
    "methodLoc",
    "impacted",
    "className",
    "covered"
})
public class MethodList {

    @JsonProperty("methodName")
    private String methodName;
    @JsonProperty("accessModifier")
    private String accessModifier;
    @JsonProperty("methodLoc")
    private Integer methodLoc;
    @JsonProperty("impacted")
    private Boolean impacted;
    @JsonProperty("className")
    private String className;
    @JsonProperty("covered")
    private Boolean covered;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("methodName")
    public String getMethodName() {
        return methodName;
    }

    @JsonProperty("methodName")
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodList withMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    @JsonProperty("accessModifier")
    public String getAccessModifier() {
        return accessModifier;
    }

    @JsonProperty("accessModifier")
    public void setAccessModifier(String accessModifier) {
        this.accessModifier = accessModifier;
    }

    public MethodList withAccessModifier(String accessModifier) {
        this.accessModifier = accessModifier;
        return this;
    }

    @JsonProperty("methodLoc")
    public Integer getMethodLoc() {
        return methodLoc;
    }

    @JsonProperty("methodLoc")
    public void setMethodLoc(Integer methodLoc) {
        this.methodLoc = methodLoc;
    }

    public MethodList withMethodLoc(Integer methodLoc) {
        this.methodLoc = methodLoc;
        return this;
    }

    @JsonProperty("impacted")
    public Boolean getImpacted() {
        return impacted;
    }

    @JsonProperty("impacted")
    public void setImpacted(Boolean impacted) {
        this.impacted = impacted;
    }

    public MethodList withImpacted(Boolean impacted) {
        this.impacted = impacted;
        return this;
    }

    @JsonProperty("className")
    public String getClassName() {
        return className;
    }

    @JsonProperty("className")
    public void setClassName(String className) {
        this.className = className;
    }

    public MethodList withClassName(String className) {
        this.className = className;
        return this;
    }

    @JsonProperty("covered")
    public Boolean getCovered() {
        return covered;
    }

    @JsonProperty("covered")
    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public MethodList withCovered(Boolean covered) {
        this.covered = covered;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
