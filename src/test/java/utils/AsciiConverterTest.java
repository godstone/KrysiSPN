package utils;

import org.junit.Assert;
import org.junit.Test;

import static utils.AsciiConverter.asciiToBinary;
import static utils.AsciiConverter.binaryToAscii;


public class AsciiConverterTest {

    @Test
    public void convertAsciiToBinary() {
        Assert.assertEquals("01100001", asciiToBinary("a"));
        Assert.assertEquals("01000001", asciiToBinary("A"));
        Assert.assertEquals("011000010110001001100011", asciiToBinary("abc"));
        Assert.assertEquals("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100", asciiToBinary("ein kleiner test"));
    }

    @Test
    public void convertBinaryToAscii() {
        Assert.assertEquals("a", binaryToAscii("01100001"));
        Assert.assertEquals("A", binaryToAscii("01000001"));
        Assert.assertEquals("abc", binaryToAscii("011000010110001001100011"));
        Assert.assertEquals("ein kleiner test", binaryToAscii("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100"));
    }
}
