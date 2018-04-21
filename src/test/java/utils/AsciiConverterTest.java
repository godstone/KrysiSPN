package utils;

import helper.StringHelper;
import org.junit.Assert;
import org.junit.Test;


public class AsciiConverterTest {
    @Test
    public void convertBinaryToAscii() {
        Assert.assertEquals("a", StringHelper.binaryToAscii("01100001"));
        Assert.assertEquals("A", StringHelper.binaryToAscii("01000001"));
        Assert.assertEquals("abc", StringHelper.binaryToAscii("011000010110001001100011"));
        Assert.assertEquals("ein kleiner test", StringHelper.binaryToAscii("01100101011010010110111000100000011010110110110001100101011010010110111001100101011100100010000001110100011001010111001101110100"));
    }
}
