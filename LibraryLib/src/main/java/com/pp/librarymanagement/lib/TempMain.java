package com.pp.librarymanagement.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TempMain {
    public static void main(String[] args) {
        String filename = "/Users/pp/Desktop/addresses.csv";
        List<String[]> content = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < content.size(); i++) {
            for (int j = 0; j < content.get(i).length; j++) {
                System.out.print(content.get(i)[j] + ", ");
            }
            System.out.println();
        }
    }
}
