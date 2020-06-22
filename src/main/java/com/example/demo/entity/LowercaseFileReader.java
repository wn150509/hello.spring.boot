package com.example.demo.entity;

import java.nio.file.Path;

public abstract class LowercaseFileReader extends BaseFileReader {
    protected LowercaseFileReader(Path path) {
        super(path);
    }

    @Override
    protected String mapFileLine(String line){
        return line.toLowerCase();
    }
}
