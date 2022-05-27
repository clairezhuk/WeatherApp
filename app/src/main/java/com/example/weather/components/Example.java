package com.example.weather.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {
    private Coord coord;
    private List<com.example.weather.components.Weather> weather = null;
    private String base;
    private com.example.weather.components.Main main;
    private Integer visibility;
    private com.example.weather.components.Wind wind;
    private com.example.weather.components.Clouds clouds;
    private Integer dt;
    private com.example.weather.components.Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<com.example.weather.components.Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<com.example.weather.components.Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public com.example.weather.components.Main getMain() {
        return main;
    }

    public void setMain(com.example.weather.components.Main main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public com.example.weather.components.Wind getWind() {
        return wind;
    }

    public void setWind(com.example.weather.components.Wind wind) {
        this.wind = wind;
    }

    public com.example.weather.components.Clouds getClouds() {
        return clouds;
    }

    public void setClouds(com.example.weather.components.Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public com.example.weather.components.Sys getSys() {
        return sys;
    }

    public void setSys(com.example.weather.components.Sys sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
