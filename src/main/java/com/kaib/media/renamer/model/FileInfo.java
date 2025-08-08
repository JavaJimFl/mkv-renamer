package com.kaib.media.renamer.model;

import java.nio.file.Path;

public record FileInfo(Path path, long sizeBytes) { }
