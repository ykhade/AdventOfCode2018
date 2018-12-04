package com.yashkhade;


import java.nio.file.Files;
import java.util.*;
import java.io.File;

public class Question4 {

    public static final String inputFile = "/Users/yashkhade/IdeaProjects/AdventOfCode2018/src/com/yashkhade/input4.txt";
    public static final String outputFile = "/Users/yashkhade/IdeaProjects/AdventOfCode2018/src/com/yashkhade/output.txt";

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(new File(inputFile).toPath());
            lines.sort(Comparator.comparing(String::new));

            Files.write(new File(outputFile).toPath(), lines);

            Map<String, int[]> sleepSchedule = new HashMap<>();

            for (int i = 0; i < lines.size(); i++) {
                String shiftStart = lines.get(i);
                String[] tokens = shiftStart.split(" ");
                String guardID = tokens[3].replace("#", "");

                while ((lines.size() - 1) > i && !lines.get(i + 1).contains("begins shift")) {
                    //Parsing the line for specific integers for the asleep, the time to awaken, and time to sleep
                    i++;
                    String isAsleep = lines.get(i);
                    int timeAtSleep = Integer.parseInt(isAsleep.split(" ")[1].split(":")[1].replace("]", ""));

                    i++;
                    String timewake = lines.get(i);
                    int wakesMin = Integer.parseInt(timewake.split(" ")[1].split(":")[1].replace("]", ""));

                    int[] minSleep = sleepSchedule.getOrDefault(guardID, new int[60]);
                    for (int m = timeAtSleep; m < wakesMin; m++) {
                        minSleep[m]++;
                    }
                    //Record the sleep scheduale of each guard and output to a empty file for recording
                    sleepSchedule.put(guardID, minSleep);
                }
            }

            Map.Entry<String, int[]> maxEntry = null;
            int maxSum = 0;
            for (Map.Entry<String, int[]> entry : sleepSchedule.entrySet()) {
                int sum = 0;
                for (int i = 0; i < entry.getValue().length; i++) {
                    sum += entry.getValue()[i];
                }
                if (maxEntry == null || sum > maxSum) {
                    maxEntry = entry;
                    maxSum = sum;
                }
            }

            int maxMinute = 0;
            int maxMinuteAmount = 0;
            for (int i = 0; i < maxEntry.getValue().length; i++) {
                if (maxEntry.getValue()[i] > maxMinuteAmount) {
                    maxMinuteAmount = maxEntry.getValue()[i];
                    maxMinute = i;
                }
            }

            int result = (Integer.parseInt(maxEntry.getKey()) * maxMinute);
            System.out.println("First answer: " + maxEntry.getKey() + "x" + maxMinute + " = " +  result);//71748


            //Second Part

            maxEntry = null;
            maxMinute = 0;
            maxMinuteAmount = 0;
            for (Map.Entry<String, int[]> entry : sleepSchedule.entrySet()) {
                for (int i = 0; i < entry.getValue().length; i++) {
                    if (entry.getValue()[i] > maxMinuteAmount) {
                        maxMinuteAmount = entry.getValue()[i];
                        maxMinute = i;
                        maxEntry = entry;
                    }
                }
            }


            int newResult = (Integer.parseInt(maxEntry.getKey()) * maxMinute);
            System.out.println("Second answer: " + maxEntry.getKey() + "x" + maxMinute + " = " + newResult);//106850


        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}