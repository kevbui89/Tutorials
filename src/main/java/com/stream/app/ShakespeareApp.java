package com.stream.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShakespeareApp
{
  public static void main(String[] args) throws IOException
  {
    String path = "/Users/kbui/GoToDev/Tutorials/src/main/java/com/stream/files/";

    // generates a Set<String> with all the words (lines) in the file
    Set<String> shakespeareWords = Files.lines(Paths.get(path + "words.shakespeare.txt"))
        .collect(Collectors.toSet());

    // generates a Set<String> with all the words (lines) in the file
    Set<String> scrabbleWords = Files.lines(Paths.get(path + "ospd.txt"))
        .map(String::toLowerCase)
        .collect(Collectors.toSet());

    // print the number of words of each file
    // System.out.println("# words of Shakespeare: " + shakespeareWords.size());
    // System.out.println("# words of Scrabble: " + scrabbleWords.size());

    final int[] scrabbleENScore = {
        // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
        1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

    // Function takes string as parameter and returns an integer
    // takes a wordTest as parameter, we will build a special stream using the chars()
    // chars() is a new method in Java 8 which returns an IntStream that is a Stream of int
    // primitive type
    // That IntStream is composed of all the letters of that word (in ascii int values)
    // we can map this stream of letter into a stream of score of letter
    // for each letter, we will take the score from the scrabbleENScore array
    // by substracting the current letter ascii score - 'a' ascii score
    // and calculate the sum of each letter in the word
    Function<String, Integer> score = word -> word.chars()
        .map(letter -> scrabbleENScore[letter - 'a']).sum();

    ToIntFunction<String> intScore = word -> word.chars()
        .map(letter -> scrabbleENScore[letter - 'a']).sum();

    // this prints out [119, 111, 114, 100]
    // those are the ascii int value of each letter
    String wordTest = "word";
    IntStream chars = wordTest.chars();
    System.out.println(chars.boxed().collect(Collectors.toList()));

    System.out.println("Score of hello: " + intScore.applyAsInt("hello"));

    // goes through the entire shakespeare stream
    // filters out any word that is not in scrabble
    // returns the max word from the shakespeare list that is in scrabble
    String bestWord = shakespeareWords.stream()
        .filter(word -> scrabbleWords.contains(word))
        .max(Comparator.comparing(score)).get();

    System.out.println("Best word: " + bestWord);

    // returns an IntSummaryStatistics stream that contains
    // count: count of all words from shakespeare that are in scrabble
    // sum: sum of all the score of the words
    // min: word with least score
    // average: average score of each word
    // max: word with max score
    // using the mapToInt(intScore) to determine the score
    IntSummaryStatistics intSummaryStatistics = shakespeareWords.stream()
        .parallel()
        .filter(scrabbleWords::contains)
        .mapToInt(intScore)
        .summaryStatistics();

    System.out.println("Stats: " + intSummaryStatistics);
  }
}
