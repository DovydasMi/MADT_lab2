package com.example.madt_lab2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    private TextCounting textCounting;

    @Before
    public void setUp() {
        textCounting = new TextCounting();
    }

    @Test
    public void testCountChars_NormalInput() {
        final String givenString = "Hello World";

        final int expectedResult = 11;
        final int actualResult = textCounting.countCharacters(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountChars_NullInput() {
        final String givenString = null;

        final int expectedResult = 0;
        final int actualResult = textCounting.countCharacters(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_NormalInput() {
        final String givenString = "Hello this is a test";

        final int expectedResult = 5;
        final int actualResult = textCounting.countWords(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_WithPunctuation() {
        final String givenString = "Hello, this is: A test!";

        final int expectedResult = 5;
        final int actualResult = textCounting.countWords(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_EmptyInput() {
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = textCounting.countWords(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWords_WithPunctuationAndSpacesAroundPunctuationAndMultiplePunctuation() {
        final String givenString = "Hello  ,,,this  is  : A  test ! ";

        final int expectedResult = 5;
        final int actualResult = textCounting.countWords(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountSentences_NormalInput() {
        final String givenString = "Hello World. It is a nice day!";

        final int expectedResult = 2;
        final int actualResult = textCounting.countSentences(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountSentences_NoPunctuationAtTheEnd() {
        final String givenString = "Hello World";

        final int expectedResult = 1;
        final int actualResult = textCounting.countSentences(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountSentences_EmptyInput() {
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = textCounting.countSentences(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountSentences_MultiplePunctuation() {
        final String givenString = "Hello World!!! This is a test..";

        final int expectedResult = 2;
        final int actualResult = textCounting.countSentences(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountSentences_MultipleSpaces() {
        final String givenString = "Hello World.      It is a nice day!";

        final int expectedResult = 2;
        final int actualResult = textCounting.countSentences(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountNumbers_NormalInput() {
        final String givenString = "There is 3 apples and 2 oranges";

        final int expectedResult = 2;
        final int actualResult = textCounting.countNumbers(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountNumbers_DecimalNumbers() {
        final String givenString = "The answers were 2.15 and 44.18";

        final int expectedResult = 2;
        final int actualResult = textCounting.countNumbers(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountNumbers_NoNumbers() {
        final String givenString = "Hello world";

        final int expectedResult = 0;
        final int actualResult = textCounting.countNumbers(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountNumbers_NumberWith3Dots() {
        final String givenString = "The number is 3.14.1";

        final int expectedResult = 2;
        final int actualResult = textCounting.countNumbers(givenString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountNumbers_NumberWithCommaInsteadOfDot() {
        final String givenString = "The number Pi is 3,14";

        final int expectedResult = 2;
        final int actualResult = textCounting.countNumbers(givenString);
        assertEquals(expectedResult, actualResult);
    }
}