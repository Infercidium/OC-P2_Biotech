package com.hemebiotech.analytics.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile {
    public ReadFile() {
    }

    public void read(ArrayList<String> list, String fichier) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            String line = reader.readLine();

            while (line != null)
            {
                if (list.contains(line)) {
                    line = reader.readLine();
                }else{
                    list.add(line);
                }
            }
        reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to open file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to read file");
        }
        // Mise par ordre table ascii (alphabétique, pas de gestion maj/min)
        Collections.sort(list);
    }
}
