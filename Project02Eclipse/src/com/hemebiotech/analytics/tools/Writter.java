package com.hemebiotech.analytics.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writter {
    public Writter() {}

    // Méthode permettant l'écriture de la liste dans le fichier.
    public void written(ArrayList<String> list, int s, int occurence)
        {
            try {
                FileWriter writer = new FileWriter("result.out");
                for (int i = 0; i < s; i++)
                {
                    writer.write(list.get(i) + " = " + occurence + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Unable to create file or written");
            }
        }
}
