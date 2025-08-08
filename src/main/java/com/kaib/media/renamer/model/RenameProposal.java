package com.kaib.media.renamer.model;

public record RenameProposal(FileInfo original, String newName, boolean selected) { }
