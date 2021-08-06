package com.liobio.bean;

public class Airplane {
    private String engine;
    private String wing_length;
    private Integer carrying;
    private String captain;
    private String assistant_captain;

    public Airplane(String engine, String wing_length, Integer carrying, String captain, String assistant_captain) {
        this.engine = engine;
        this.wing_length = wing_length;
        this.carrying = carrying;
        this.captain = captain;
        this.assistant_captain = assistant_captain;
    }

    public Airplane() {
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "engine='" + engine + '\'' +
                ", wing_length='" + wing_length + '\'' +
                ", carrying=" + carrying +
                ", captain='" + captain + '\'' +
                ", assistant_captain='" + assistant_captain + '\'' +
                '}';
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getWing_length() {
        return wing_length;
    }

    public void setWing_length(String wing_length) {
        this.wing_length = wing_length;
    }

    public Integer getCarrying() {
        return carrying;
    }

    public void setCarrying(Integer carrying) {
        this.carrying = carrying;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getAssistant_captain() {
        return assistant_captain;
    }

    public void setAssistant_captain(String assistant_captain) {
        this.assistant_captain = assistant_captain;
    }
}
