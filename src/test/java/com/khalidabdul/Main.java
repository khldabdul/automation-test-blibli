package com.khalidabdul;

public class Main {

    public static void main(String[] args) {
        String data = "Rp 3.0000.000,-";
        data = data.replaceAll("\\D+","");
        System.out.println(data);
    }

}
