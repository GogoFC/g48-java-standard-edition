package se.lexicon.utilfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
//        Supplier<List<String>> init = () -> new ArrayList<>();
        Supplier<List<String>> init = ArrayList::new;

        List<String> strings = new ArrayList<>();
        List<String> strings1 = init.get();
        List<String> strings2 = Collections.emptyList();





    }
}
