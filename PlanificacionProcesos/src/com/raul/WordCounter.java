package com.raul;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCounter extends Thread {

    // ATRIBUTOS
    private String _path;
    private String[] _wordsInLine;
    private int _allWors;

    // CONSTRUCTOR
    public WordCounter(String path) throws IOException {
        _path = path;
    }

    // METODOS
    public void counter() throws IOException {

        File _file = new File(_path);
        FileReader fileReader = new FileReader(_file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        _allWors = 0;

        while ((line = bufferedReader.readLine()) != null) {
            _wordsInLine = line.split(" ");
            _allWors += _wordsInLine.length;
        }
        bufferedReader.close();
        System.out.printf("File %s has %d words %n", _file.toString(), _allWors);
    }

    public static void main(String[] args) throws IOException {

        WordCounter wordCounter = new WordCounter(args[0]);
        wordCounter.counter();
    }
}
