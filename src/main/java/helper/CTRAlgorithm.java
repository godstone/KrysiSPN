package helper;

import com.sun.tools.corba.se.idl.constExpr.NotEqual;

import java.util.Arrays;

import static utils.AsciiConverter.asciiToBinary;

public class CTRAlgorithm {


    /*
    XOR Method to compare to Strings
     */
    public static String xorStrings(String firstString, String secondString) throws Exception {
        StringBuilder sb = new StringBuilder();

        try {
            if (firstString.length() == secondString.length()) {
                for(int pos = 0; pos < firstString.length(); pos++) {
                    if (firstString.charAt(pos) == secondString.charAt(pos)) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();

    }


    /*
    Generate bitstring with length 16, cleartext + 1 + zeros until "mod 16 = 0"
     */
    public static String buildBitstring(String ct) {

        StringBuilder stringBuilder = new StringBuilder();

        String zeros = calculateZeros(ct);

        stringBuilder.append(asciiToBinary(ct));
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
