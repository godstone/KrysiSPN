import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBoxTest {
    private SBox sbox;

    @Before
    public void setUp() {
        sbox = new SBox();
    }

    @Test
    public void getFromOriginalTest() {
        String sBoxString = sbox.getFromOriginal("0000");
        Assert.assertEquals("same", sBoxString, "1110");

        sBoxString = sbox.getFromOriginal("1111");
        Assert.assertEquals("same again", sBoxString, "0111");
    }

    @Test
    public void getFromInversTest() {
        String inversBoxString = sbox.getFromInvers("1110");
        Assert.assertEquals("[invers] same", inversBoxString, "0000");

        inversBoxString = sbox.getFromInvers("0111");
        Assert.assertEquals("[invers] same again", inversBoxString, "1111");
    }
}
