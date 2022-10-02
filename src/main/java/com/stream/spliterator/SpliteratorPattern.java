package com.stream.spliterator;

import com.stream.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorPattern {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/Users/kbui/GoToDev/Tutorials/src/main/java/com/stream/files/people.txt");
        try (Stream<String> lines = Files.lines(path);) {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
            people.forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
