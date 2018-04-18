package helper;

public class OperationHelper {
    /*
   XOR Method to compare to Strings
    */
    public static String xorStrings(String firstString, String secondString) throws Exception {
        StringBuilder sb = new StringBuilder();

        try {
            if (firstString.length() == secondString.length()) {
                for(int pos = 0; pos < firstString.length(); pos++) {
                    if (firstString.charAt(pos) == secondString.charAt(pos)) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
