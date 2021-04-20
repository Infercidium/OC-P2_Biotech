package com.hemebiotech.analytics.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public ReadFile() {
    }

    public BufferedReader read(String fichier) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
                    return reader;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to open file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to read file");
        }
        return null;
    }

    public void close(BufferedReader read)
    {
        try {
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to close file or nonexistent file");
        }
    }

    public String next(BufferedReader read)
    {
        try {
            return read.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read the next line of the file");
            return null;
        }
    }
}