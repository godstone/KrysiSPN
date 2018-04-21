package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class holds some needed methods regarding string handling
 */
public class StringHelper {
    /**
     * Helper method to split chiffretext into y blocks
     *
     * @param chiffreText
     * @param length
     * @return
     */
    public static List<String> splitChiffreText(String chiffreText, int length) {
        int amountOfBlock =  chiffreText.length() / length;
        List<String> blocks = new ArrayList<>();

        int start = 0;
        for(int i = 0; i < amountOfBlock; i++) {
            start = i * length;
            blocks.add(chiffreText.substring(start, start + length));
        }

        return blocks;
    }

    /**
     * Helper method to fill a given binaryString with zeros for a specific length
     *
     * @param binary
     * @param length
     * @return
     */
    public static String fillZeroToBinary(String binary, int length) {
        String binaryWithLeadingZeros = binary;
        for (int i = binary.length(); binaryWithLeadingZeros.length() < length; i++) {
            binaryWithLeadingZeros = "0" + binaryWithLeadingZeros;
        }

        return binaryWithLeadingZeros;
    }

    /**
     * Convert a given binaryString to the appropriate asciiString.
     *
     * @param binaryString
     * @return
     */
    public static String binaryToAscii(String binaryString) {
        StringBuilder sb = new StringBuilder();

        // Splits string into 8-char-sections, parse them to a char and append them to teh string
        Arrays.stream(binaryString.split("(?<=\\G.{8})"))
                .forEach(s -> sb.append((char) Integer.parseInt(s, 2)));

        return sb.toString();
    }
}
