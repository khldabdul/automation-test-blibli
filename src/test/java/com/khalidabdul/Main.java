package com.khalidabdul;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        String data = "Rp 3.0000.000,-";
        data = data.replaceAll("\\D+","");
        System.out.println(data);

        Integer [] diskon = {10, 18, 15, 10, 9, 3, 20, 3, 15, 3, 3, 11, 11, 10, 10, 10};
        Arrays.sort(diskon, Collections.reverseOrder());
        System.out.println(Arrays.toString(diskon));
    }

}
