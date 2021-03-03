
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
    "outlierFilesByDevelopers",
    "classCoverage",
    "outlierClassToMethod",
    "nonCoveredData",
    "outlierMethodToLine",
    "classToLineRatio",
    "coverageData",
    "methodToLineRatio",
    "filesByDeveloperRatio",
    "classToMethodRatio",
    "outlierClassToLine",
    "codeCoverageTrend"
})
public class DashboardGetCodeCoverage {

    @JsonProperty("outlierFilesByDevelopers")
    private String outlierFilesByDevelopers;
    @JsonProperty("classCoverage")
    private Double classCoverage;
    @JsonProperty("outlierClassToMethod")
    private String outlierClassToMethod;
    @JsonProperty("nonCoveredData")
    private List<Integer> nonCoveredData = new ArrayList<Integer>();
    @JsonProperty("outlierMethodToLine")
    private String outlierMethodToLine;
    @JsonProperty("classToLineRatio")
    private String classToLineRatio;
    @JsonProperty("coverageData")
    private List<Integer> coverageData = new ArrayList<Integer>();
    @JsonProperty("methodToLineRatio")
    private String methodToLineRatio;
    @JsonProperty("filesByDeveloperRatio")
    private String filesByDeveloperRatio;
    @JsonProperty("classToMethodRatio")
    private String classToMethodRatio;
    @JsonProperty("outlierClassToLine")
    private String outlierClassToLine;
    @JsonProperty("codeCoverageTrend")
    private CodeCoverageTrend codeCoverageTrend;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("outlierFilesByDevelopers")
    public String getOutlierFilesByDevelopers() {
        return outlierFilesByDevelopers;
    }

    @JsonProperty("outlierFilesByDevelopers")
    public void setOutlierFilesByDevelopers(String outlierFilesByDevelopers) {
        this.outlierFilesByDevelopers = outlierFilesByDevelopers;
    }

    public DashboardGetCodeCoverage withOutlierFilesByDevelopers(String outlierFilesByDevelopers) {
        this.outlierFilesByDevelopers = outlierFilesByDevelopers;
        return this;
    }

    @JsonProperty("classCoverage")
    public Double getClassCoverage() {
        return classCoverage;
    }

    @JsonProperty("classCoverage")
    public void setClassCoverage(Double classCoverage) {
        this.classCoverage = classCoverage;
    }

    public DashboardGetCodeCoverage withClassCoverage(Double classCoverage) {
        this.classCoverage = classCoverage;
        return this;
    }

    @JsonProperty("outlierClassToMethod")
    public String getOutlierClassToMethod() {
        return outlierClassToMethod;
    }

    @JsonProperty("outlierClassToMethod")
    public void setOutlierClassToMethod(String outlierClassToMethod) {
        this.outlierClassToMethod = outlierClassToMethod;
    }

    public DashboardGetCodeCoverage withOutlierClassToMethod(String outlierClassToMethod) {
        this.outlierClassToMethod = outlierClassToMethod;
        return this;
    }

    @JsonProperty("nonCoveredData")
    public List<Integer> getNonCoveredData() {
        return nonCoveredData;
    }

    @JsonProperty("nonCoveredData")
    public void setNonCoveredData(List<Integer> nonCoveredData) {
        this.nonCoveredData = nonCoveredData;
    }

    public DashboardGetCodeCoverage withNonCoveredData(List<Integer> nonCoveredData) {
        this.nonCoveredData = nonCoveredData;
        return this;
    }

    @JsonProperty("outlierMethodToLine")
    public String getOutlierMethodToLine() {
        return outlierMethodToLine;
    }

    @JsonProperty("outlierMethodToLine")
    public void setOutlierMethodToLine(String outlierMethodToLine) {
        this.outlierMethodToLine = outlierMethodToLine;
    }

    public DashboardGetCodeCoverage withOutlierMethodToLine(String outlierMethodToLine) {
        this.outlierMethodToLine = outlierMethodToLine;
        return this;
    }

    @JsonProperty("classToLineRatio")
    public String getClassToLineRatio() {
        return classToLineRatio;
    }

    @JsonProperty("classToLineRatio")
    public void setClassToLineRatio(String classToLineRatio) {
        this.classToLineRatio = classToLineRatio;
    }

    public DashboardGetCodeCoverage withClassToLineRatio(String classToLineRatio) {
        this.classToLineRatio = classToLineRatio;
        return this;
    }

    @JsonProperty("coverageData")
    public List<Integer> getCoverageData() {
        return coverageData;
    }

    @JsonProperty("coverageData")
    public void setCoverageData(List<Integer> coverageData) {
        this.coverageData = coverageData;
    }

    public DashboardGetCodeCoverage withCoverageData(List<Integer> coverageData) {
        this.coverageData = coverageData;
        return this;
    }

    @JsonProperty("methodToLineRatio")
    public String getMethodToLineRatio() {
        return methodToLineRatio;
    }

    @JsonProperty("methodToLineRatio")
    public void setMethodToLineRatio(String methodToLineRatio) {
        this.methodToLineRatio = methodToLineRatio;
    }

    public DashboardGetCodeCoverage withMethodToLineRatio(String methodToLineRatio) {
        this.methodToLineRatio = methodToLineRatio;
        return this;
    }

    @JsonProperty("filesByDeveloperRatio")
    public String getFilesByDeveloperRatio() {
        return filesByDeveloperRatio;
    }

    @JsonProperty("filesByDeveloperRatio")
    public void setFilesByDeveloperRatio(String filesByDeveloperRatio) {
        this.filesByDeveloperRatio = filesByDeveloperRatio;
    }

    public DashboardGetCodeCoverage withFilesByDeveloperRatio(String filesByDeveloperRatio) {
        this.filesByDeveloperRatio = filesByDeveloperRatio;
        return this;
    }

    @JsonProperty("classToMethodRatio")
    public String getClassToMethodRatio() {
        return classToMethodRatio;
    }

    @JsonProperty("classToMethodRatio")
    public void setClassToMethodRatio(String classToMethodRatio) {
        this.classToMethodRatio = classToMethodRatio;
    }

    public DashboardGetCodeCoverage withClassToMethodRatio(String classToMethodRatio) {
        this.classToMethodRatio = classToMethodRatio;
        return this;
    }

    @JsonProperty("outlierClassToLine")
    public String getOutlierClassToLine() {
        return outlierClassToLine;
    }

    @JsonProperty("outlierClassToLine")
    public void setOutlierClassToLine(String outlierClassToLine) {
        this.outlierClassToLine = outlierClassToLine;
    }

    public DashboardGetCodeCoverage withOutlierClassToLine(String outlierClassToLine) {
        this.outlierClassToLine = outlierClassToLine;
        return this;
    }

    @JsonProperty("codeCoverageTrend")
    public CodeCoverageTrend getCodeCoverageTrend() {
        return codeCoverageTrend;
    }

    @JsonProperty("codeCoverageTrend")
    public void setCodeCoverageTrend(CodeCoverageTrend codeCoverageTrend) {
        this.codeCoverageTrend = codeCoverageTrend;
    }

    public DashboardGetCodeCoverage withCodeCoverageTrend(CodeCoverageTrend codeCoverageTrend) {
        this.codeCoverageTrend = codeCoverageTrend;
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
