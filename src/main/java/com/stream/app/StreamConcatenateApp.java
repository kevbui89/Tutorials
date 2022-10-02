package com.stream.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcatenateApp
{
  public static void main(String[] args)
  {
    Path path1 = Paths.get("/Users/kbui/GoToDev/Tutorials/src/main/java/com/stream/files/text1.txt");
    Path path2 = Paths.get("/Users/kbui/GoToDev/Tutorials/src/main/java/com/stream/files/text2.txt");
    Path path3 = Paths.get("/Users/kbui/GoToDev/Tutorials/src/main/java/com/stream/files/text3.txt");

    try (Stream<String> firstTest1 = Files.lines(path1);
        Stream<String> firstTest2 = Files.lines(path2);
        Stream<String> secondTest1 = Files.lines(path1);
        Stream<String> secondTest2 = Files.lines(path2);
        Stream<String> secondTest3 = Files.lines(path3))
    {
      // concat takes two arguments (2 streams)
      Stream<String> resultTest1 = Stream.concat(firstTest1, firstTest2);
      System.out.println(resultTest1.collect(Collectors.toList()));

      // reads each line and everytime there is a space, adds the words to the stream
      Function<String, Stream<String>> splitIntoWords =
          line -> Pattern.compile(" ").splitAsStream(line);

      // using the Stream.of() to concat multiple streams
      // using the flatMap() with identity function
      // Stream.of() returns a Stream<Stream<String>>
      // flatMap(Function.identity()) returns a stream of lines
      // flatMap(splitIntoWords) returns a stream of words
      Stream<String> resultTest2 = Stream.of(secondTest1, secondTest2, secondTest3).flatMap(
          Function.identity()).flatMap(splitIntoWords);

      System.out.println(resultTest2.collect(Collectors.toList()));
      }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
