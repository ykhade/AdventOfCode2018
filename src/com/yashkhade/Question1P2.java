package com.yashkhade;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Question1P2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        Scanner scan = new Scanner(new File("/Users/yashkhade/IdeaProjects/JavaMasterclass/AdventOfCode2018/src/com/yashkhade/input1.txt"));

        String t = "+3 +3 +4 -2 -4";

        long total = 0;
        int count = 0;
        Set<String> hash_set = new HashSet<>();

        while (scan.hasNextLine()){
            if(!hash_set.contains(Long.toString(total))){
                hash_set.add(Long.toString(total));
            }else{
                System.out.println(total);
                break;
            }
            total += scan.nextInt();

            if(!scan.hasNextLine()){
                scan.close();
                scan = new Scanner(new File("/Users/yashkhade/IdeaProjects/JavaMasterclass/AdventOfCode2018/src/com/yashkhade/input1.txt"));
                count++;

            }
        }
        System.out.println(count);

        long stop =  System.currentTimeMillis();

        System.out.println("It took me " + (stop-start) + " ms");

    }

}