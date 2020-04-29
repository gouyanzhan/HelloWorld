package com.siwuxie095.forme.test.test030;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Jiajing Li
 * @date 2020-04-29 10:52:30
 */
public class OptionalConsumer<T> implements Consumer<Optional<T>> {

    private final Consumer<T> consumer;

    private final Runnable runnable;

    public OptionalConsumer(Consumer<T> consumer, Runnable runnable) {
        super();
        this.consumer = consumer;
        this.runnable = runnable;
    }

    public static <T> OptionalConsumer<T> of(Consumer<T> consumer, Runnable runnable) {
        return new OptionalConsumer<>(consumer, runnable);
    }

    @Override
    public void accept(Optional<T> optional) {
        if (optional.isPresent()) {
            consumer.accept(optional.get());
        } else {
            runnable.run();
        }
    }
}

