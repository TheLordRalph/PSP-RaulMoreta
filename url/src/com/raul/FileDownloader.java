package com.raul;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FileDownloader {
    protected final URL _url;
    protected final Path _path;

    public FileDownloader(String src, String destination) throws MalformedURLException {
        _url = new URL(src);
        _path = Paths.get(System.getProperty("user.home"), "downloads", destination);
    }

    public abstract void download() throws IOException;

}
