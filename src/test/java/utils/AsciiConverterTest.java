package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.AsciiConverter.AsciiToBinary;
import static utils.AsciiConverter.BinaryToAscii;


public class AsciiConverterTest {

    @Test
    public void convertAsciiToBinary() {

        assertEquals("01100001", AsciiToBinary("a"));
        assertEquals("01000001", AsciiToBinary("A"));
        assertEquals("011000010110001001100011", AsciiToBinary("abc"));
        assertEquals("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100", AsciiToBinary("ein kleiner test"));

    }

    @Test
    public void convertBinaryToAscii() {

        assertEquals("a", BinaryToAscii("01100001"));
        assertEquals("A", BinaryToAscii("01000001"));
        assertEquals("abc", BinaryToAscii("011000010110001001100011"));
        assertEquals("ein kleiner test", BinaryToAscii("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100"));


    }
}
