package com.yashkhade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2P1 {
    public static void main(String[] args) throws IOException {
        System.out.println("The value of the checksum is " + solve2A("/Users/yashkhade/IdeaProjects/AdventOfCode2018/src/com/yashkhade/input2.txt"));
    }

    public static int solve2A(String inputFileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFileName));

        int doubleCount = 0;
        int tripleCount = 0;

        for (String line : lines) {
            Map<Character, Integer> found = new HashMap<Character, Integer>();
            for (int i = 0; i < line.length(); i++) {
                Character c = line.charAt(i);
                found.put(c, found.getOrDefault(c, 0) + 1);
            }
            boolean foundDouble = false;
            boolean foundTriple = false;

            for (Map.Entry<Character, Integer> entry : found.entrySet()) {
                if (entry.getValue() == 2 && !foundDouble) {
                    foundDouble = true;
                    doubleCount++;

                }
                if (entry.getValue() == 3 && !foundTriple) {
                    foundTriple = true;
                    tripleCount++;
                }
            }


        }

        return doubleCount * tripleCount;
    }

    //+++++++++++++++++++++++++++++++++++++++

    public static

}