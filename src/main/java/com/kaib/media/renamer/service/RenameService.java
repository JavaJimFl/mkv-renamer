package com.kaib.media.renamer.service;

import java.io.File;
import java.util.function.Consumer;

public class RenameService {

    public static void renameMKVFiles(File folder, Consumer<String> logger) {
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mkv"));
        if (files == null || files.length == 0) {
            logger.accept("No MKV files found.");
            return;
        }

        for (File file : files) {
            // Placeholder: just echo what would be renamed
            logger.accept("Would rename: " + file.getName());
        }
    }
}
