package com.github.mariusdw.echokube.web.controller.api;

import com.github.mariusdw.echokube.config.ApplicationConfig;
import com.github.mariusdw.echokube.web.ResponseCode;
import com.github.mariusdw.echokube.web.controller.response.HealthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
public class APIController {
    private final ApplicationConfig config;
    @Autowired
    public APIController(ApplicationConfig config) {
        this.config = config;
    }

    @RequestMapping(method = GET, path = "api/kill")
    public void Kill() {
        log.info("Kill operation invoked, shutting down");
        System.exit(0);
    }

    @RequestMapping(method = GET, path = "api/health")
    public HealthResponse Health() {
        log.info("Health is ok");
        return new HealthResponse(this.config.getName(), ResponseCode.SUCCESS);
    }
}
