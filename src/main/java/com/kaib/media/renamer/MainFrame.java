package com.kaib.media.renamer;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("MKV Renamer");

        // Basic window setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Example menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Exit"));
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Example content
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Hello, modern Swing!", SwingConstants.CENTER), BorderLayout.CENTER);
        add(panel);
    }

    public static void main(String[] args) {
        // Set modern look and feel
        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}

