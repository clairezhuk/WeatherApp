package com.example.weather.components;

import java.util.HashMap;
import java.util.Map;

public class Wind {
    private Double speed;
    private Integer deg;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}
