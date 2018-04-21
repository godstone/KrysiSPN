package utils;

import helper.OperationHelper;
import org.junit.Assert;
import org.junit.Test;

public class OperationHelperTest {
    @Test
    public void xorTest(){

        try {
            Assert.assertEquals("0000", OperationHelper.xor("0000", "0000"));
            Assert.assertEquals("1111", OperationHelper.xor("0000", "1111"));
            Assert.assertEquals("1111", OperationHelper.xor("1111", "0000"));
            Assert.assertEquals("0000", OperationHelper.xor("1111", "1111"));
            Assert.assertEquals("0001", OperationHelper.xor("1111", "1110"));
        } catch (Exception e) {
            System.out.print("Fail…");
        }
    }
}
