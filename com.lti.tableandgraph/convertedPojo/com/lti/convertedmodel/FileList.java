
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
    "fileName",
    "noOfCommits",
    "builds",
    "authors",
    "mode",
    "methods",
    "classLoc",
    "covered"
})
public class FileList {

    @JsonProperty("fileName")
    private String fileName;
    @JsonProperty("noOfCommits")
    private Integer noOfCommits;
    @JsonProperty("builds")
    private Object builds;
    @JsonProperty("authors")
    private Object authors;
    @JsonProperty("mode")
    private Object mode;
    @JsonProperty("methods")
    private Object methods;
    @JsonProperty("classLoc")
    private Object classLoc;
    @JsonProperty("covered")
    private Boolean covered;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileList withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    @JsonProperty("noOfCommits")
    public Integer getNoOfCommits() {
        return noOfCommits;
    }

    @JsonProperty("noOfCommits")
    public void setNoOfCommits(Integer noOfCommits) {
        this.noOfCommits = noOfCommits;
    }

    public FileList withNoOfCommits(Integer noOfCommits) {
        this.noOfCommits = noOfCommits;
        return this;
    }

    @JsonProperty("builds")
    public Object getBuilds() {
        return builds;
    }

    @JsonProperty("builds")
    public void setBuilds(Object builds) {
        this.builds = builds;
    }

    public FileList withBuilds(Object builds) {
        this.builds = builds;
        return this;
    }

    @JsonProperty("authors")
    public Object getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(Object authors) {
        this.authors = authors;
    }

    public FileList withAuthors(Object authors) {
        this.authors = authors;
        return this;
    }

    @JsonProperty("mode")
    public Object getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(Object mode) {
        this.mode = mode;
    }

    public FileList withMode(Object mode) {
        this.mode = mode;
        return this;
    }

    @JsonProperty("methods")
    public Object getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(Object methods) {
        this.methods = methods;
    }

    public FileList withMethods(Object methods) {
        this.methods = methods;
        return this;
    }

    @JsonProperty("classLoc")
    public Object getClassLoc() {
        return classLoc;
    }

    @JsonProperty("classLoc")
    public void setClassLoc(Object classLoc) {
        this.classLoc = classLoc;
    }

    public FileList withClassLoc(Object classLoc) {
        this.classLoc = classLoc;
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

    public FileList withCovered(Boolean covered) {
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
