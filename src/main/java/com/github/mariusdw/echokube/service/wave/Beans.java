package com.github.mariusdw.echokube.service.wave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.Clock;

@Configuration("WaveBeans")
public class Beans {
    @Bean
    public Clock getUTCClock() {
        return Clock.systemUTC();
    }

    @Bean(name="waveScheduler")
    public ThreadPoolTaskScheduler getTTS() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("waveScheduler");
        scheduler.initialize();

        return scheduler;
    }
}
