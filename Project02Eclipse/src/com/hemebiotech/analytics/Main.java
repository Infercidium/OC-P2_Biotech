package com.hemebiotech.analytics;
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
        analitics.writter(analitics.counter(analitics.sorter(analitics.reader(fichier))));
    }
}