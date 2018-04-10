import java.util.Arrays;

import static utils.AsciiConverter.asciiToBinary;

public class CTRAlgorithm {


    public static String encryptCTR(String cleartext) {
        String chiffre = null;


        return chiffre;
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
