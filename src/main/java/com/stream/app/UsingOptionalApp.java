package com.stream.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stream.model.NewMath;

public class UsingOptionalApp
{
  public static void main(String[] args) {
    List<Double> result = new ArrayList<>();

    // .parallel() is build on top of the fork/join framework
    // that is build on top of multithreaded computation
    // you will have as many threads as the number of cores on the CPU
    // forEach here is very bad, do not use
    boolean compute = false;
    if (compute)
    {
      ThreadLocalRandom.current()
          .doubles(10)
          .boxed()
          .forEach(aDouble -> NewMath.inv(aDouble)
              .ifPresent(
                  inv -> NewMath.sqrt(inv)
                      .ifPresent(
                          sqrt -> result.add(sqrt)
                      )));

      System.out.println("# result = " + result.size());
    }

    // First path:
    // Takes a double and take the inverse of that double, returning an optional.
    // If this optional is empty, the flatMap will not do anything,
    // The map will not do anything and instead of returning no value,
    // this orElseGet method will be called and will return an empty stream
    // This is converting an empty optional into an empty stream

    // Second path:
    // If double d goes through this computation
    // d -> NewMath.inv(d).flatMap(inv -> NewMath.sqrt(inv)
    // It will return an optional with the inverse of the square root in it
    // This optional will be mapped using sqrt -> Stream.of(sqrt)
    // It takes this optional of d and makes an optional of stream of d
    // and this orElseGet will just be called

    // This is the Optional.flatMap()
    // This is Optional.map()
    // They both return an empty optional if computation does not happen
    // This is a function that takes in a Double and returns a Stream of Doubles
    Function<Double, Stream<Double>> flatMapper =
        d -> NewMath.inv(d)
            .flatMap(inv -> NewMath.sqrt(inv))
            .map(sqrt -> Stream.of(sqrt))
            .orElseGet(() -> Stream.empty());

    List<Double> listResult = ThreadLocalRandom.current()
        .doubles(2)
        .parallel()
        .boxed()
        .flatMap(flatMapper)
        .collect(Collectors.toList());

    System.out.println(listResult.size());
    // System.out.println(Arrays.asList(listResult));

  }
}
