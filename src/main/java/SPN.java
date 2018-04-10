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
        //TODO
        return null;
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
