package com.raul;

import java.io.*;
import java.nio.file.Path;

public class WordCounter extends Thread {

    // ATRIBUTOS
    private Path _path;
    private String[] _wordsInLine;
    private int _allWors;

    // CONSTRUCTOR
    public WordCounter(Path path) throws IOException {
        _path = path;
    }

    // METODOS
    public void counter () throws IOException {

        File _file = new File(String.valueOf(_path));
        var fileReader = new FileReader(_file);
        var bufferedReader = new BufferedReader(fileReader);
        var line = "";
        _allWors = 0;

        while ((line = bufferedReader.readLine()) != null) {
            _wordsInLine = line.split(" ");
            _allWors += _wordsInLine.length;
        }
        bufferedReader.close();
        System.out.printf("File %s has %d words %n", _path.getFileName(), _allWors);
    }
}
