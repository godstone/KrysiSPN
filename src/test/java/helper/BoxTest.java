package helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;


public class BoxTest {


    // sbox test init
    //


    @Before
    public void setUp() throws Exception {
        SBox sbox = new SBox;
    }


    @Test
    public void useSBoxGetOriginal() {
        Assert.assertEquals("0010",sbox.getFromOriginal("1101"));
    }

    @Test
    public void useSBoxGetInverse() {
        Assert.assertEquals("1101",sbox.getFromOriginal("0010"));
    }

}
