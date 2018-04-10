import helper.CTRAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class SPN {
    private int r = 4;
    private int n = 4;
    private int m = 4;

    private int keyLength = m * n;
    private List<String> keys;
    private List<String> inversKeys;

    private SBox sBox;
    private Bitpermutation bitPermutation;

    public SPN() {
        sBox = new SBox();
        bitPermutation = new Bitpermutation();

        generateKeys();
        generateInverseKeys();
    }

    // Agreed Key between the two parties
    private String spnkey = "00111010100101001101011000111111";

    // Random Bitstring with length 16
    private String randomBitstring = "0000010011010010";


    public String encrypt(String cleartext) {
        // Initialer Weissschritt
        try {
            String step1 = CTRAlgorithm.xorStrings(cleartext, keys.get(0));

            // Start with rounds
            String step2 = doRoundJob(step1, 1);
            String step3 = doRoundJob(step2, 2);
            String step4 = doRoundJob(step3, 3);

            // Final round
            String sBoxFinalString = "";
            for (int sb = 0; sb < step4.length(); sb += 4) {
                sBoxFinalString += sBox.getFromOriginal(step4.substring(sb, sb+4));
            }

            String chiffretext = CTRAlgorithm.xorStrings(sBoxFinalString, keys.get(r-1));

            return chiffretext;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.exit(0);
        }

        //TODO
        return null;
    }

    private String doRoundJob(String tmpString, int key) throws Exception {
        String sboxString = "";
        for (int sb = 0; sb < tmpString.length(); sb += 4) {
            sboxString += sBox.getFromOriginal(tmpString.substring(sb, sb+4));
        }

        String bitPermString = bitPermutation.permute(sboxString);

        return CTRAlgorithm.xorStrings(bitPermString, keys.get(key));
    }

    public String decrypt(String chiffretext) {
        //TODO
        return null;
    }

    private void generateKeys() {
        keys = new ArrayList<>();

        for (int k = 0; k < (r + 1); k++) {
            int start = 4 * k;
            int end = start + keyLength;
            String key = spnkey.substring(start, end);
            keys.add(key);
        }
    }

    private void generateInverseKeys() {
        inversKeys = new ArrayList<>();

        inversKeys.add(keys.get(r));
        for(int k = r - 1; k > 0; k--) {
            inversKeys.add(bitPermutation.permute(keys.get(k)));
        }
        inversKeys.add(keys.get(0));
    }

    public String getSpnkey() {
        return spnkey;
    }

    public String getRandomBitstring() {
        return randomBitstring;
    }

}
