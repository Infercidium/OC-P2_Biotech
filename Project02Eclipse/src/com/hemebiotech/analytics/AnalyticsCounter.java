package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * Class containing 4 methods, from extracting an input file to creating an output file
 */
public class AnalyticsCounter
{
    /**
     * Open a txt file, add each symptom line to a list, then close the file
     *
     * @param fichier file absolute or relative path allowing to reach the txt file
     * @return list containing the symptoms of the txt file, possible duplicate, empty list if no txt file
     */
    public List<String> read(String fichier)
    {
        ISymptomReader read = new ReadSymptomDataFromFile(fichier);
        return read.getSymptoms();
    }
    /**
     * Returns the inserted list sorted in ASCII
     *
     * @param result a list of unsorted symptoms
     * @return a list of all symptoms by ascii order duplicates are possible / probable
     */
    public List<String> sort(List<String> result)
    {
        Collections.sort(result);
        return result;
    }
    /**
     * Turns a list into a map
     * Duplicates become the map value
     *
     * @param result a list of symptoms
     * @return a map of symptoms, map key is the symptom and map value is the occurence
     */
    public Map<String, Integer> count(List<String> result) {
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
     *Transcribe a map between a title and a summary in a file
     *
     * @param counter a map of symptoms
     */
   public void write(Map<String, Integer> counter){
       int totalSympt = 0;
       FileWriter writer = null;
       try {
           writer = new FileWriter("result.out");
           writer.write("List of Symptom(s): \n\n");
           for (Map.Entry<String, Integer> symptoms : counter.entrySet()) {
               writer.write(symptoms.getKey() + " = " + symptoms.getValue() + "\n");
               totalSympt += symptoms.getValue();
           }
           writer.write("\n Different symptom(s) = " + counter.size() + "\n Number of symptom(s) = " + totalSympt);
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("Unable to create file or written");
       } finally {
           try {
               if (writer != null) {
                   writer.close();
               }
           } catch (IOException e) {
               e.printStackTrace();
               System.out.println("Unable to close file");
           }
       }
   }
}