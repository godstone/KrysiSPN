package helper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CTRAlgorithmTest {

    @Test
    public void xorTest(){

        try {
            Assert.assertEquals("0000", CTRAlgorithm.xorStrings("0000", "0000"));
            Assert.assertEquals("1111", CTRAlgorithm.xorStrings("0000", "1111"));
            Assert.assertEquals("1111", CTRAlgorithm.xorStrings("1111", "0000"));
            Assert.assertEquals("0000", CTRAlgorithm.xorStrings("1111", "1111"));
            Assert.assertEquals("0001", CTRAlgorithm.xorStrings("1111", "1110"));
        } catch (Exception e) {
            System.out.print("Fail…");
        }
    }

}
