package helper;

import java.util.ArrayList;
import java.util.List;

public abstract class Box {
    protected List<Pair> pairs = new ArrayList<>();

    protected abstract void generatePairs();

    public String getFromOriginal(String value) {
        for (Pair pair: pairs) {
            if (pair.getKey().equals(value)) {
                return pair.getValue();
            }
        }
        return "xxxx";
    }

    public String getFromInvers(String value) {
        for (Pair pair: pairs) {
            if (pair.getValue().equals(value)) {
                return pair.getKey();
            }
        }
        return "xxxx";
    }
}
