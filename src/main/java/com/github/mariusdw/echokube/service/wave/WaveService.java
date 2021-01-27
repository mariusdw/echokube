package com.github.mariusdw.echokube.service.wave;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class WaveService {
    private final Clock clock;
    private final ThreadPoolTaskScheduler tts;
    private final MeterRegistry registry;
    private AtomicLong sineGuage;
    private double step;

    @Autowired
    public WaveService(Clock clock, @Qualifier("waveScheduler") ThreadPoolTaskScheduler tts, MeterRegistry registry) {
        this.clock = clock;
        this.tts = tts;
        this.registry = registry;
    }

    @PostConstruct
    public void init() {
        log.info("Initialising scheduler WS");
        tts.scheduleAtFixedRate(this::generateWave, Duration.ofMillis(30));
        sineGuage = registry.gauge("sine_gauge", new AtomicLong(0));
    }

    protected void generateWave() {
        log.info("Generate wave WS");
        // Looking for a 0.2 increase every second. That way, we get around a full sine every 30 secs.
        // Keep range between -1000 to 1000.
        double r = Generators.getGenerator(Generators.Type.SIN).generate(Math.PI * step) * (double)1000;
        step += 0.0001220703125;
        log.info("Val: " + String.valueOf(r));
        registry.counter("incrementor").increment();
        sineGuage.set(Double.valueOf(r).longValue());
    }
}
