package com.github.mariusdw.echokube.web.controller.response;

import com.github.mariusdw.echokube.web.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasicResponse {
    private String appName;
    private Integer code;
    private String description;

    public BasicResponse(String appName, ResponseCode responseCode) {
        this.appName = appName;
        this.code = responseCode.getCode();
        this.description = responseCode.getDescription();
    }
}
