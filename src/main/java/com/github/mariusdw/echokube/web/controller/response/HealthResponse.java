package com.github.mariusdw.echokube.web.controller.response;

import com.github.mariusdw.echokube.web.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HealthResponse extends BasicResponse {
    public enum HealthStatus {
        OK,
    }

    private HealthStatus status;

    public HealthResponse(String appName, ResponseCode responseCode) {
        super(appName, responseCode);
        this.status = HealthStatus.OK;
    }

    public HealthResponse(String appName, ResponseCode responseCode, HealthStatus status) {
        super(appName, responseCode);
        this.status = status;
    }
}
