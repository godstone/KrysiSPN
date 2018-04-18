package helper;

import com.sun.tools.corba.se.idl.constExpr.NotEqual;
import sun.tools.tree.DoubleExpression;

import java.math.BigInteger;
import java.util.Arrays;

import static utils.AsciiConverter.asciiToBinary;

public class CTRAlgorithm {

    public static String encrypt(String value, String randomY, String key, int i) {
        int l = randomY.length();
        double modValue = Math.pow(2,l);

        // y + i mod modValue xor key xor value
        String newVal = addTwoBinaryStrings(randomY, Integer.toString(i));
        double modRes = Double.parseDouble(newVal) % modValue;

        try {
            BigInteger bigInt = new BigInteger(Double.toString(modRes));
            String encrypted = OperationHelper.xorStrings(OperationHelper.xorStrings(bigInt.toString(2), key), value);
            return encrypted;
        } catch (Exception e) {}

        return null;
    }

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
