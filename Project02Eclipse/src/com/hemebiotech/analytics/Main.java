package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;


/**
 * The basic Main Class
 */
public class Main {
    public static void main(String[] args)
    {
        //Définition du chemin
        String fichier = "Project02Eclipse/symptoms.txt";

        //Instantiation
        AnalyticsCounter analitics = new AnalyticsCounter();

        //Déroulement -> symptoms.txt > reader > sorter > counter > writter > result.out
        List<String> resultat = analitics.read(fichier);
       resultat = analitics.sort(resultat);
        Map<String, Integer> count = analitics.count(resultat);
        analitics.write(count);
    }
}