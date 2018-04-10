import org.junit.Assert;
import org.junit.Test;

public class BitpermutationTest {

    @Test
    public void permuteTest() {
        Bitpermutation bpm = new Bitpermutation();
        String permutedString = bpm.permute("abcdefghijklmnop");
        System.out.println(permutedString);
        Assert.assertEquals("String is the same", permutedString, "aeimbfjncgkodhlp");
    }
}
