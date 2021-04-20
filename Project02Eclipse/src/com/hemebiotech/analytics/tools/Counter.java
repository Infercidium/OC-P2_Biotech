package com.hemebiotech.analytics.tools;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Counter {
   public Counter(){}

   public int occurence(int i, ArrayList<String> list, String fichier)
   {
      int occ = 0;
      ReadFile reader = new ReadFile();
      BufferedReader fileopen = reader.read(fichier);
      String line = reader.next(fileopen);
      while (line != null)
      {
         if (list.get(i).contains(line)) {
            occ++;
         }
         line = reader.next(fileopen);
      }
      reader.close(fileopen);
      return occ;
   }
}
