
package com.lti.convertedmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "release",
    "data",
    "fileList",
    "methodList",
    "coveredMethods"
})
public class ChartDatum {

    @JsonProperty("release")
    private String release;
    @JsonProperty("data")
    private List<Integer> data = new ArrayList<Integer>();
    @JsonProperty("fileList")
    private List<FileList> fileList = new ArrayList<FileList>();
    @JsonProperty("methodList")
    private List<MethodList> methodList = new ArrayList<MethodList>();
    @JsonProperty("coveredMethods")
    private Integer coveredMethods;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("release")
    public String getRelease() {
        return release;
    }

    @JsonProperty("release")
    public void setRelease(String release) {
        this.release = release;
    }

    public ChartDatum withRelease(String release) {
        this.release = release;
        return this;
    }

    @JsonProperty("data")
    public List<Integer> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Integer> data) {
        this.data = data;
    }

    public ChartDatum withData(List<Integer> data) {
        this.data = data;
        return this;
    }

    @JsonProperty("fileList")
    public List<FileList> getFileList() {
        return fileList;
    }

    @JsonProperty("fileList")
    public void setFileList(List<FileList> fileList) {
        this.fileList = fileList;
    }

    public ChartDatum withFileList(List<FileList> fileList) {
        this.fileList = fileList;
        return this;
    }

    @JsonProperty("methodList")
    public List<MethodList> getMethodList() {
        return methodList;
    }

    @JsonProperty("methodList")
    public void setMethodList(List<MethodList> methodList) {
        this.methodList = methodList;
    }

    public ChartDatum withMethodList(List<MethodList> methodList) {
        this.methodList = methodList;
        return this;
    }

    @JsonProperty("coveredMethods")
    public Integer getCoveredMethods() {
        return coveredMethods;
    }

    @JsonProperty("coveredMethods")
    public void setCoveredMethods(Integer coveredMethods) {
        this.coveredMethods = coveredMethods;
    }

    public ChartDatum withCoveredMethods(Integer coveredMethods) {
        this.coveredMethods = coveredMethods;
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
