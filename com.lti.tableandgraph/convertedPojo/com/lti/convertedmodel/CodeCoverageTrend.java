
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
    "chartData",
    "labels"
})
public class CodeCoverageTrend {

    @JsonProperty("chartData")
    private List<ChartDatum> chartData = new ArrayList<ChartDatum>();
    @JsonProperty("labels")
    private Object labels;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("chartData")
    public List<ChartDatum> getChartData() {
        return chartData;
    }

    @JsonProperty("chartData")
    public void setChartData(List<ChartDatum> chartData) {
        this.chartData = chartData;
    }

    public CodeCoverageTrend withChartData(List<ChartDatum> chartData) {
        this.chartData = chartData;
        return this;
    }

    @JsonProperty("labels")
    public Object getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Object labels) {
        this.labels = labels;
    }

    public CodeCoverageTrend withLabels(Object labels) {
        this.labels = labels;
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
