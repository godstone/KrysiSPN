import utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the SBox which is needed in the spn.
 */
public class SBox {
    private List<Pair> pairs = new ArrayList<>();

    public SBox() {
        generatePairs();
    }

    /**
     * Get the accurate value from the sbox of a given inputValue.
     *
     * @param value
     * @return
     */
    public String getFromOriginal(String value) {
        for (Pair pair: pairs) {
            if (pair.getKey().equals(value)) {
                return pair.getValue();
            }
        }
        return "xxxx";
    }

    /**
     * Do the complete handling of the sbox for a given string.
     *
     * @param value
     * @return
     */
    public String getStringThroughBox(String value) {
        String sBoxString = "";
        for (int sb = 0; sb < value.length(); sb += 4) {
            sBoxString += this.getFromOriginal(value.substring(sb, sb+4));
        }

        return sBoxString;
    }

    /**
     * Generating the List of all pairs for the sbox.
     */
    private void generatePairs() {
        pairs.add(new Pair("0000","1110"));
        pairs.add(new Pair("0001","0100"));
        pairs.add(new Pair("0010","1101"));
        pairs.add(new Pair("0011","0001"));
        pairs.add(new Pair("0100","0010"));
        pairs.add(new Pair("0101","1111"));
        pairs.add(new Pair("0110","1011"));
        pairs.add(new Pair("0111","1000"));
        pairs.add(new Pair("1000","0011"));
        pairs.add(new Pair("1001","1010"));
        pairs.add(new Pair("1010","0110"));
        pairs.add(new Pair("1011","1100"));
        pairs.add(new Pair("1100","0101"));
        pairs.add(new Pair("1101","1001"));
        pairs.add(new Pair("1110","0000"));
        pairs.add(new Pair("1111","0111"));
    }


}
