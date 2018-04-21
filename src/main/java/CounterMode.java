
import helper.OperationHelper;
import helper.StringHelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Class for using the counterMode regarding a string with defined key, chiffretext and blocklength.
 */
public class CounterMode {
    private final String key;

    /**
     * Contructor.
     *
     * @param key
     */
    public CounterMode(String key) {
        this.key = key;
    }

    /**
     * Decrypt a given chiffretext with the help of a spn.
     *
     * @param chiffretext
     * @param blockLength
     * @return String
     */
    public String decrypt(String chiffretext, int blockLength) {
        String encryptedString = "";
        BigInteger modValue = BigDecimal.valueOf(Math.pow(2, blockLength)).toBigInteger();

        // Split chiffretext in blocks of the length of 16 bits
        List<String> yElements = StringHelper.splitChiffreText(chiffretext, blockLength);

        // Calculate every element and add it to the encryptedtext which is the x in the end
        BigInteger actualElementNumber = new BigInteger(yElements.get(0), 2);
        for (int y = 1; y < yElements.size(); y++) {

            // Do modulo with 2^l which is presented with the modValue
            BigInteger afterModulo = actualElementNumber.mod(modValue);
            String valueAfterMod = StringHelper.fillZeroToBinary(afterModulo.toString(2), 16);

            // Use spn as the encryption for the counterMode
            SPN spn = new SPN(key);
            String afterSpn = spn.encrypt(valueAfterMod);
            encryptedString += OperationHelper.xor(afterSpn, yElements.get(y));

            actualElementNumber = actualElementNumber.add(BigInteger.ONE);
        }

        return encryptedString;
    }

}