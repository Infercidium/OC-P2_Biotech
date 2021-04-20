package com.hemebiotech.analytics.tools;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
    public Sorter(){}

    public void sorter(ArrayList<String> list, String fichier)
    {
        ReadFile reader = new ReadFile();
        BufferedReader fileopen = reader.read(fichier);
        String line = reader.next(fileopen);
        while (line != null)
        {
            if (list.contains(line)) {
                line = reader.next(fileopen);
            }else{
                list.add(line);
            }
        }
        reader.close(fileopen);

        // Mise par ordre table ascii (alphabétique, pas de gestion maj/min)
        Collections.sort(list);
    }
}
