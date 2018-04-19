
import com.sun.tools.corba.se.idl.constExpr.NotEqual;
import helper.OperationHelper;
import sun.tools.tree.DoubleExpression;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.AsciiConverter.asciiToBinary;

public class CTRAlgorithm {
    private final String key;

    public CTRAlgorithm(String key) {
        this.key = key;
    }

    public String decrypt(String chiffretext) throws Exception {
        String encryptedString = "";

        int l = 16;
        double modValue = Math.pow(2,l);

        // Split chiffretext
        List<String> yElements = this.splitChiffreText(chiffretext, l);

        // Calculate every x element and set the string together
        String yMinusOne = yElements.get(0);
        for (int y = 1; y < yElements.size(); y++) {
            String tempVal = addTwoBinaryStrings(yMinusOne, Integer.toString(y-1, 2));
            Double modRes = Double.parseDouble(tempVal) % modValue;
            String valAfterMod = Integer.toBinaryString(modRes.intValue());

            SPN spn = new SPN(key);
            String afterSpn = spn.encrypt(valAfterMod);
            encryptedString += OperationHelper.xorStrings(afterSpn, yElements.get(y));

        }

        return encryptedString;
    }

    /**
     * Helper method to split chiffretext into y blocks
     *
     * @param chiffreText
     * @param length
     * @return
     */
    private List<String> splitChiffreText(String chiffreText, int length) {
        int amountOfBlock =  chiffreText.length() / length;
        List<String> blocks = new ArrayList<>();

        int start = 0;
        for(int i = 0; i < amountOfBlock; i++) {
            start = i * length;
            blocks.add(chiffreText.substring(start, start + length));
        }

        return blocks;
    }

    // todo: move to helper operation
    private static String addTwoBinaryStrings(String firstString, String secondString) {
        int sum = Integer.parseInt(firstString,2) + Integer.parseInt(secondString,2);
        return Integer.toString(sum, 2);
    }

    /**
     * Generate bitstring with length 16, cleartext + 1 + zeros until "mod 16 = 0"
     * @param cleartxt
     * @return
     */
    public static String buildBitstring(String cleartxt) {

        StringBuilder stringBuilder = new StringBuilder();

        String zeros = calculateZeros(cleartxt);

        stringBuilder.append(asciiToBinary(cleartxt));
        stringBuilder.append("1");
        stringBuilder.append(zeros);

        String bitstring = stringBuilder.toString();

        return bitstring;
    }

    /*
    Generate String with 0 until given bitstring fits mod16
     */
    private static String calculateZeros(String ct) {

        String[] zeroList = new String[16 - (ct.length() % 16)];
        Arrays.fill(zeroList, 0);

        String zeros = String.join("",zeroList);

        return zeros;
    }


}
