package com.kaib.media.renamer;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.kaib.media.renamer.service.RenameService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainApp {
    private JFrame frame;
    private JTextArea logArea;
    private JFileChooser folderChooser;

    public MainApp() {
        frame = new JFrame("MKV Renamer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JButton browseButton = new JButton("Choose Folder");
        JButton renameButton = new JButton("Rename Files");

        browseButton.addActionListener(this::handleBrowse);
        renameButton.addActionListener(this::handleRename);

        topPanel.add(browseButton);
        topPanel.add(renameButton);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        frame.setVisible(true);
    }

    private File selectedFolder = null;

    private void handleBrowse(ActionEvent e) {
        int result = folderChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFolder = folderChooser.getSelectedFile();
            log("Selected folder: " + selectedFolder.getAbsolutePath());
        }
    }

    private void handleRename(ActionEvent e) {
        if (selectedFolder == null) {
            log("Please select a folder first.");
            return;
        }
        RenameService.renameMKVFiles(selectedFolder, this::log);
    }

    private void log(String message) {
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }

    public static void main(String[] args) {
    	
        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext","true");
        FlatDarkLaf.setup(); // or FlatLightLaf.setup()
        
        // optional: animated theme switch later
        FlatAnimatedLafChange.showSnapshot();
        // ... create and show your UI ...
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        
        UIManager.put( "Component.arc", 12 );          // rounded corners
        UIManager.put( "Button.arc", 12 );
        UIManager.put( "TextComponent.arc", 10 );
        UIManager.put( "ScrollBar.thumbArc", 10 );
        UIManager.put( "Component.innerFocusWidth", 1 );
        UIManager.put( "flatlaf.useWindowDecorations", true ); // custom title bar
        // Accent color (hex or system color name)
        UIManager.put( "Component.focusColor", new Color(0x4C,0xAF,0x50) ); // green-ish

        
        
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
