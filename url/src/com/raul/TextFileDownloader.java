package com.raul;

import java.io.*;
import java.net.MalformedURLException;

public class TextFileDownloader extends FileDownloader {


    public TextFileDownloader(String src, String destination) throws MalformedURLException {
        super(src, destination);
    }

    @Override
    public void download() throws IOException {
        try (InputStream inputStream = _url.openStream()) {
            try (InputStreamReader streamReader = new InputStreamReader(inputStream)) {
                try (BufferedReader bufferedReader = new BufferedReader(streamReader)) {
                    try (FileWriter fileWriter = new FileWriter(_path.toString())) {
                        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                bufferedWriter.write(line);
                            }
                        }
                    }
                }
            }
        }
    }
}
