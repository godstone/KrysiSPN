package main.java;

import main.java.helper.Box;
import main.java.helper.Pair;

public class SBox extends Box {
    public SBox() {
        generatePairs();
    }

    @Override
    protected void generatePairs() {
        pairs.add(new Pair("0000","1110"));
        pairs.add(new Pair("0001","0100"));
        pairs.add(new Pair("0010","1101"));
        pairs.add(new Pair("0011","0001"));
        pairs.add(new Pair("0100","0010"));
        pairs.add(new Pair("0101","1111"));
        pairs.add(new Pair("0110","1011"));
        pairs.add(new Pair("0111","1000"));
        pairs.add(new Pair("1000","0011"));
        pairs.add(new Pair("1001","1010"));
        pairs.add(new Pair("1010","0110"));
        pairs.add(new Pair("1011","1100"));
        pairs.add(new Pair("1100","0101"));
        pairs.add(new Pair("1101","1001"));
        pairs.add(new Pair("1110","0000"));
        pairs.add(new Pair("1111","0111"));
    }
}
