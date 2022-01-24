package com.raul;

import java.io.*;
import java.net.MalformedURLException;

public class BinaryFileDownloader extends FileDownloader {

    private byte _bytes[] = new byte[2048];

    public BinaryFileDownloader(String src, String destination) throws MalformedURLException {
        super(src, destination);
    }

    @Override
    public void download() throws IOException {
        try (InputStream urlStream = _url.openStream()) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(urlStream)) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(_path.toString())) {
                    int bytes;
                    while ((bytes = bufferedInputStream.read(_bytes, 0, _bytes.length)) != -1){
                        fileOutputStream.write(_bytes, 0, bytes);
                    }
                }
            }
        }
    }
}
