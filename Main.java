package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            URL urlHTMl = new URL("https://raw.githubusercontent.com/Ostap-Sulyk/Ostap-Sulyk.github.io/master/index.html");
            URL urlCSS = new URL("https://raw.githubusercontent.com/Ostap-Sulyk/Ostap-Sulyk.github.io/master/style.css");
            Scanner scannerHTML = new Scanner(urlHTMl.openStream());
            Scanner scannerCSS = new Scanner(urlCSS.openStream());

            File myFileHTML = new File("./src/com/company/index.html");
            File myFileCSS = new File("./src/com/company/style.css");

            PrintWriter writerHTMl = new PrintWriter(myFileHTML.getAbsolutePath());
            PrintWriter writerCSS = new PrintWriter(myFileCSS.getAbsolutePath());

            while (scannerHTML.hasNextLine()) {
                String line = scannerHTML.nextLine();
                writerHTMl.println(line);
            }
            writerHTMl.close();
            while(scannerCSS.hasNextLine()){
                writerCSS.println(scannerCSS.nextLine());
            }
            writerCSS.close();


        } catch (MalformedURLException ex) {
            System.out.println("Invalid url");
        } catch (IOException ex) {

            System.out.println("IO errors");
        }

    }
}
