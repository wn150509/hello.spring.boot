package com.example.demo.entity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL location=FileReaderTest.class.getClassLoader().getResource("helloworld");
        System.out.println(location);
        Path path= Paths.get(location.toURI());
        BaseFileReader low=new LowercaseFileReader(path){

        };
        BaseFileReader upr=new UppercaseFileReader(path) {

        };
        System.out.println(low.readFile());
        System.out.println(upr.readFile());
    }
}
