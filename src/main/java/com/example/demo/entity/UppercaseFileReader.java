package com.example.demo.entity;

import java.nio.file.Path;

public abstract class UppercaseFileReader extends BaseFileReader{
    protected UppercaseFileReader(Path path) {
        super(path);
    }

    @Override
    protected String mapFileLine(String line){
        return line.toUpperCase();
    }
}
