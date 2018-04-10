package utils;

import org.junit.Assert;
import org.junit.Test;

import static utils.AsciiConverter.AsciiToBinary;
import static utils.AsciiConverter.BinaryToAscii;


public class AsciiConverterTest {

    @Test
    public void convertAsciiToBinary() {
        Assert.assertEquals("01100001", AsciiToBinary("a"));
        Assert.assertEquals("01000001", AsciiToBinary("A"));
        Assert.assertEquals("011000010110001001100011", AsciiToBinary("abc"));
        Assert.assertEquals("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100", AsciiToBinary("ein kleiner test"));
    }

    @Test
    public void convertBinaryToAscii() {
        Assert.assertEquals("a", BinaryToAscii("01100001"));
        Assert.assertEquals("A", BinaryToAscii("01000001"));
        Assert.assertEquals("abc", BinaryToAscii("011000010110001001100011"));
        Assert.assertEquals("ein kleiner test", BinaryToAscii("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100"));


    }
}
