import helper.OperationHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a SPN and all its functions which are needed for an encryption.
 */
public class SPN {
    private int r = 4;
    private int n = 4;
    private int m = 4;

    private String spnkey;

    private int keyLength = m * n;
    private List<String> keys;

    private SBox sBox;
    private Bitpermutation bitPermutation;

    /**
     * Constructor.
     *
     * @param key
     */
    public SPN(String key) {
        this.spnkey = key;

        sBox = new SBox();
        bitPermutation = new Bitpermutation();

        generateRoundKeys();
    }

    /**
     * Encrypts a given text with the values of this SPN.
     *
     * @param cleartext
     * @return
     */
    public String encrypt(String cleartext) {
        try {
            // Initialer Weissschritt
            String step1 = OperationHelper.xor(cleartext, keys.get(0));

            // Do all rounds between first and last round
            String nextStep = step1;
            for (int x = 1; x < r; x ++) {
                nextStep = doRoundJob(nextStep, x);
            }

            // Final round with s-box and last xor
            String sBoxFinalString = sBox.getStringThroughBox(nextStep);
            String chiffretext = OperationHelper.xor(sBoxFinalString, keys.get(r));

            return chiffretext;
        } catch (Exception e) {
            System.out.println("Something went wrong in the SPN encryption");
            System.exit(0);
        }

        return null;
    }

    /**
     * Helper method to do the rounds with s-box, bitpermutation and xor.
     *
     * @param tmpString
     * @param key
     * @return
     * @throws Exception
     */
    private String doRoundJob(String tmpString, int key) {
        String sboxString = sBox.getStringThroughBox(tmpString);
        String bitPermString = bitPermutation.permute(sboxString);

        return OperationHelper.xor(bitPermString, keys.get(key));
    }

    /**
     * Generate all roundKeys from the main key.
     */
    private void generateRoundKeys() {
        keys = new ArrayList<>();

        for (int k = 0; k < (r + 1); k++) {
            int start = 4 * k;
            int end = start + keyLength;
            String key = spnkey.substring(start, end);
            keys.add(key);
        }
    }
}
