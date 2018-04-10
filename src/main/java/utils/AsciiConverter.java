package utils;

import java.util.Arrays;

public class AsciiConverter {

    /*
    https://stackoverflow.com/questions/19867918/ascii-to-binary-conversion-program-in-java
     */
    public static String AsciiToBinary(String asciiString){

        byte[] bytes = asciiString.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            // binary.append(' ');
        }
        return binary.toString();
    }


    /*
    https://stackoverflow.com/questions/4211705/binary-to-text-in-java
     */
    public static String BinaryToAscii(String binaryString) {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(
            binaryString.split("(?<=\\G.{8})") // Splits the input string into 8-char-sections (Since a char has 8 bits = 1 byte)
            ).forEach(s -> sb.append((char) Integer.parseInt(s, 2)));

        return sb.toString();

    }


}
