package com.siwuxie095.forme.test.test030;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author Jiajing Li
 * @date 2020-04-29 10:52:47
 */
public class Main {

    /**
     * 说明的问题：
     * 1、OptionalConsumer<T> implements Consumer<Optional<T>> 的用法；
     */
    public static void main(String[] args) {

        //Consumer<Optional<Integer>> c0 = OptionalConsumer.of(System.out::println, ()->{System.out.println("Not fit");});
        //OptionalConsumer c1 = OptionalConsumer.of(System.out::println, ()->{System.out.println("Not fit");});
        //IntStream.range(0, 100).boxed().map(i->Optional.of(i).filter(j->j%2==0)).forEach(1);

        //OptionalConsumer<User> userOptionalConsumer0 = OptionalConsumer.of(x -> System.out.println(x.id), () -> System.out.println("Not Exist"));
        Optional<User> user = Optional.of(new User(1, "Zhang San"));
        //Optional<User> user0 = Optional.empty();
        //List<Optional<User>> list = new ArrayList<>();
        //list.add(user);
        //list.add(user0);
        //list.stream().forEach(userOptionalConsumer0);

        OptionalConsumer<User> userOptionalConsumer1 = OptionalConsumer.of(x -> System.out.println(x.id), () -> System.out.println("Not Exist"));
        userOptionalConsumer1.accept(user);
    }

}
