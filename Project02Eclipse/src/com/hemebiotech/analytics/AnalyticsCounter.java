package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter
{
    /**
     * returns the inserted list sorted in ASCII
     *
     * @param result a list of unsorted symptoms
     * @return a list of all symptoms by ascii order duplicates are possible / probable
     */
    public List<String> sorter(List<String> result)
    {
        Collections.sort(result);
        return result;
    }

    /**
     * turns a list into a map
     * duplicates become the map value
     *
     * @param result a list of symptoms
     * @return a map of symptoms, map key is the symptom and map value is the occurence
     */
    public Map<String, Integer> counter(List<String> result) {
        Map<String, Integer> counter = new TreeMap<>();
        for (String s : result) {
            if (counter.containsKey(s)) {
                counter.put(s, counter.get(s) + 1);
            } else {
                counter.put(s, 1);
            }
        }
        return counter;
    }

    /**
     *transcribe a map between a title and a summary in a file
     *
     * @param counter a map of symptoms
     */
   public void writter(Map<String, Integer> counter)
    {
        try {
            FileWriter writer = new FileWriter("result.out");
            writer.write("List of Symptom(s): \n\n");
            for (Map.Entry<String, Integer> symptoms : counter.entrySet())
            {
                writer.write(symptoms.getKey() + " = " + symptoms.getValue() + "\n");
                totalSympt += symptoms.getValue();
            }
            writer.write("\n Different symptom(s) = " + counter.size() + "\n Number of symptom(s) = " + totalSympt);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to create file or written");
        }
    }
    private int totalSympt = 0;
}