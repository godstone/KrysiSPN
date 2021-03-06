import java.util.*;
import java.util.stream.Collectors;

/**
 * This class represents the bitpermutation which is needed in the SPN.
 */
public class Bitpermutation {
    // Holding all key-value-pairs for the permutation
    private Map<Integer, Integer> bitmap = new HashMap<Integer, Integer>();

    public Bitpermutation() {
        fillBitmap();
    }

    /**
     * Do the permutation for a given inputString with the bitmap in this class.
     *
     * @param input
     * @return
     */
    public String permute(String input) {
        List<Character> newString = prepareList(input.length());

        for (int i = 0; i < input.length(); i++) {
            int newIndex = bitmap.get(i);
            newString.set(newIndex, input.charAt(i));
        }

        return newString.stream().map(c -> c.toString()).collect(Collectors.joining());
    }

    /**
     * Prepare a new list where the result of the permutation can be saved.
     *
     * @param size
     * @return
     */
    private List<Character> prepareList(int size) {
        Character[] chars = new Character[size];
        Arrays.fill(chars, 'x');

        return Arrays.asList(chars);
    }

    /**
     * Fill the bitmap with the defined keys and values from the task.
     */
    private void fillBitmap() {
        bitmap.put(0,0);
        bitmap.put(1,4);
        bitmap.put(2,8);
        bitmap.put(3,12);
        bitmap.put(4,1);
        bitmap.put(5,5);
        bitmap.put(6,9);
        bitmap.put(7,13);
        bitmap.put(8,2);
        bitmap.put(9,6);
        bitmap.put(10,10);
        bitmap.put(11,14);
        bitmap.put(12,3);
        bitmap.put(13,7);
        bitmap.put(14,11);
        bitmap.put(15,15);
    }

}
