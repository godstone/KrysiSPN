package helper;

/**
 * This class holds some methods to do operations which are needed several times.
 */
public class OperationHelper {
    /**
     * Helper method to do the xor operation for two binary strings.
     *
     * @param firstString
     * @param secondString
     * @return
     */
    public static String xor(String firstString, String secondString) {
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
