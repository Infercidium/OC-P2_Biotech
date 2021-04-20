package com.hemebiotech.analytics;

import com.hemebiotech.analytics.tools.Counter;
import com.hemebiotech.analytics.tools.ReadFile;
import com.hemebiotech.analytics.tools.Sorter;
import com.hemebiotech.analytics.tools.Writter;

import java.util.ArrayList;

public class AnalyticsCounter
{
	public static void main(String[] args) throws Exception {
		String fichier = "Project02Eclipse/symptoms.txt";
		ArrayList<String> symptoms = new ArrayList<>();
		Sorter sorter = new Sorter();
		Writter writter = new Writter();

		sorter.sorter(symptoms, fichier);
		writter.written(symptoms, fichier);

	}
}
