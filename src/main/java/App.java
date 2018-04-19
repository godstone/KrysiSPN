public class App {

    public static void main(String[] args) {
        final String key = "00111010100101001101011000111111";
        final String chiffreText = "00000100110100100000101110111000000000101000111110001110011111110110000001010001010000111010000000010011011001110010101110110000";
        CTRAlgorithm algorithm = new CTRAlgorithm(key);
        String cleartext = null;
        try {
            cleartext = algorithm.decrypt(chiffreText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(cleartext);
    }

}
