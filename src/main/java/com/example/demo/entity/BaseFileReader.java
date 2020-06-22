package com.example.demo.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseFileReader {
    protected Path filePath;

    protected BaseFileReader(Path path){
        this.filePath=path;
    }

    public List<String> readFile()throws IOException{
        return Files.lines(filePath).map(this::mapFileLine).collect(Collectors.toList());
    }

    protected abstract String mapFileLine(String line);
}
