package com.github.mariusdw.echokube.web;

public enum ResponseCode {
    SUCCESS(0, "Success");

    private Integer code;
    private String description;

    ResponseCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "{\n\t" + "\"code\":" + this.code + "\n}\n";
    }
}
