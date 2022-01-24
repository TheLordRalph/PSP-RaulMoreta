package com.raul;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) {
        try {

            //FileDownloader fileDownloader = new TextFileDownloader("https://docs.oracle.com/javase/tutorial/networking/urls/index.html", "url.html");
            //fileDownloader.download();

            FileDownloader binaryfileDownloader = new BinaryFileDownloader("https://www.ionlitio.com/images/2006/01/hasselhoff_peta.jpg", "imagen.jpg");
            binaryfileDownloader.download();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
