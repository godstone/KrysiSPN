import helper.StringHelper;

public class App {
    public static void main(String[] args) {

        // Given key and chiffreText from the task
        final String key = "00111010100101001101011000111111";
        final String chiffreText = "00000100110100100000101110111000000000101000111110001110011111110110000001010001010000111010000000010011011001110010101110110000";

        // Create a new mode instance and decrypt the given chiffreText
        CounterMode mode = new CounterMode(key);
        String binaryCleartext = mode.decrypt(chiffreText, 16);

        // Clean the added 1 and zeros
        binaryCleartext = binaryCleartext.substring(0, binaryCleartext.lastIndexOf('1'));
        String cleartext = StringHelper.binaryToAscii(binaryCleartext);

        System.out.println("Cleartext: " + cleartext);
    }

}
