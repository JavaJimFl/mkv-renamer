package com.kaib.media.renamer.service;

import com.kaib.media.renamer.model.FileInfo;
import javafx.concurrent.Task;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScanService {

    public Task<List<FileInfo>> createTask(Path root) {
        return new Task<>() {
            @Override
            protected List<FileInfo> call() throws IOException {
                try (Stream<Path> stream =
                         Files.walk(root).filter(p -> p.toString().endsWith(".mkv"))) {
                    List<FileInfo> list = stream
                            .map(p -> new FileInfo(p, p.toFile().length()))
                            .collect(Collectors.toList());
                    updateValue(list);
                    return list;
                }
            }
        };
    }
}
