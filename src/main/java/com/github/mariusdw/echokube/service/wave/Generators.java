package com.github.mariusdw.echokube.service.wave;

import java.util.Map;

public class Generators {
    public enum Type {
        SIN
    }

    public interface Generator {
        double generate(double v);
    }

    private final static Map<Type, Generator> lookup = Map.of(
            Type.SIN, Generators::generateSine
    );

    private static double generateSine(double v) {
        return Math.sin(v);
    }

    public static Generator getGenerator(Type type) {
        return lookup.get(type);
    }
}
