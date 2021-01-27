package com.github.mariusdw.echokube.config;

import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

@Getter
@Service
public class ApplicationConfig {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "echocube-" + String.valueOf(new Random().nextInt(100000));
    }
}
