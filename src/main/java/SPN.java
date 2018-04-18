import helper.CTRAlgorithm;
import helper.OperationHelper;

import java.util.ArrayList;
import java.util.List;

public class SPN {
    private int r = 4;
    private int n = 4;
    private int m = 4;

    private String spnkey;

    private int keyLength = m * n;
    private List<String> keys;
    private List<String> inversKeys;

    private SBox sBox;
    private Bitpermutation bitPermutation;

    public SPN(String key) {
        this.spnkey = key;

        sBox = new SBox();
        bitPermutation = new Bitpermutation();

        generateKeys();
        generateInverseKeys();
    }

    public String encrypt(String cleartext) {
        try {
            // Initialer Weissschritt
            String step1 = OperationHelper.xorStrings(cleartext, keys.get(0));

            // Start with rounds
            String step2 = doRoundJob(step1, 1);
            String step3 = doRoundJob(step2, 2);
            String step4 = doRoundJob(step3, 3);


            // Final round
            String sBoxFinalString = sBox.getStringThroughBox(step4);

            String chiffretext = OperationHelper.xorStrings(sBoxFinalString, keys.get(r));

            return chiffretext;
        } catch (Exception e) {
            System.out.println("Something went wrong in the SPN encryption");
            System.exit(0);
        }

        //TODO
        return null;
    }

    private String doRoundJob(String tmpString, int key) throws Exception {
        String sboxString = sBox.getStringThroughBox(tmpString);
        String bitPermString = bitPermutation.permute(sboxString);

        return OperationHelper.xorStrings(bitPermString, keys.get(key));
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
}
