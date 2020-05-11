package com.siwuxie095.forme.test.test031;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jiajing Li
 * @date 2020-05-11 17:44:27
 */
public class OptionalConsumer<T> {

    private Optional<T> optional;

    private OptionalConsumer(Optional<T> optional) {
        this.optional = optional;
    }

    public static <T> OptionalConsumer<T> of(Optional<T> optional) {
        return new OptionalConsumer<>(optional);
    }

    public OptionalConsumer<T> ifPresent(Consumer<T> consumer) {
        optional.ifPresent(consumer);
        return this;
    }

    public OptionalConsumer<T> ifNotPresent(Runnable runnable) {
        if (!optional.isPresent()) {
            runnable.run();
        }
        return this;
    }
}
