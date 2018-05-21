package main.java.ru.k0r0k0ff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BusinessLogic {

    List<String> arr;
    List<String> data;

    public void fillInitialArray() {
        List<String> initial = new ArrayList<>();

        initial.add("K1\\SK1");
        initial.add("K1\\SK2");
        initial.add("K1\\SK1\\SSK1");
        initial.add("K1\\SK1\\SSK2");
        initial.add("K2");
        initial.add("K2\\SK1\\SSK1");
        initial.add("K2\\SK1\\SSK2");

        List<String> arr = initial.stream().map(x -> x.replace("\\","/")).collect(Collectors.toList());

        this.arr = arr;
    }

    public void parseInitialArrayAndCreateDataForOutput(List<String> initial) {
        TreeSet<String> rawdata = new TreeSet<>();
        List<String> data = new ArrayList<>(10);

        for (String str: initial) {

            String[] start = str.split("^*/");
            String[] parsed = str.split("/");

            rawdata.add(start[0]);

            if(str.contains("/")){

                rawdata.add(String.format(("%s/%s"), parsed[0], parsed[1]));

                if(!parsed[1].equals(parsed[parsed.length - 1])) {
                    rawdata.add(String.format("%s/%s/%s", start[0], parsed[1], parsed[parsed.length - 1]));
                }
            }
        }

        for (String s: rawdata) {
            data.add(s);
        }

        this.data = data;
    }

    void showResult(List<String> data) {

        List<String> list = data.stream().map(x -> x.replace("/","\\")).collect(Collectors.toList());

        for (String s1: list) {
            System.out.println(s1);
        }

        System.out.println("\n");

        Collections.reverse(list);

        for (String s2: list) {
            System.out.println(s2);
        }
    }

}