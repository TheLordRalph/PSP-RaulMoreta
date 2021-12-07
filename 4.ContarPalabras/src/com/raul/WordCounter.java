package com.raul;

import java.io.*;
import java.nio.file.Path;

public class WordCounter {

    private Path _path;

    public WordCounter(Path path) throws IOException {
        _path = path;
    }

    public void counter () throws IOException {

        File _file = new File(String.valueOf(_path));
        var fileReader = new FileReader(_file);
        var bufferedReader = new BufferedReader(fileReader);
        var line = "";
        String[] words = new String[]{};
        int allWors = 0;

        while ((line = bufferedReader.readLine()) != null) {
            words = line.split(" ");
            allWors += words.length;
        }
        bufferedReader.close();
        System.out.printf("File %s has %d words %n", _path.getFileName(), allWors);
    }
}
