package com.hemebiotech.analytics.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writter {
    public Writter() {}

    // Méthode permettant l'écriture de la liste dans le fichier.
    public void written(ArrayList<String> list, String fichier)
        {
           Counter counter = new Counter();
            try {
                FileWriter writer = new FileWriter("result.out");
                for (int i = 0; i < list.size(); i++)
                {
                    writer.write(new StringBuilder().append(list.get(i)).append(" = ").append(counter.occurence(i, list, fichier)).append("\n").toString());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Unable to create file or written");
            }
        }
}
