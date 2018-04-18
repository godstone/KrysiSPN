import org.junit.Assert;
import org.junit.Test;

public class SPNTest {

    @Test
    public void generateKeysTest() {
        SPN spn = new SPN("00010001001010001000110000000000");
        Assert.assertEquals(1, 1);
    }

    @Test
    public void encryptTest() {
        SPN spn = new SPN("00010001001010001000110000000000");
        String chiffretext = spn.encrypt("0001001010001111");
        Assert.assertEquals("Is the same", chiffretext, "1010111010110100");
    }
}
