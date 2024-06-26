package com.example.EmployeeManagement.defaultpackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class NewJFrame extends JFrame {
    // Transformando o método em um construtor
    public NewJFrame() {
        setTitle("My Java Frame");
        setSize(1100, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Configurando o topPanel
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(new Color(12, 17, 20));
        JLabel topLabel = new JLabel("Employee Management System - Java");
        styleLabel(topLabel);
        topPanel.add(topLabel, createGridBagConstraints());

        // Configurando o middlePanel
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBackground(new Color(11, 24, 40));
        GridBagConstraints c = new GridBagConstraints();

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(14, 29, 50));
        addFormFields(leftPanel);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(20, 40, 64));
        GridBagConstraints gbcRightPanel = createGridBagConstraints();
        gbcRightPanel.gridx = 1;
        gbcRightPanel.gridy = 0; // Posição vertical ajustada conforme necessário
        gbcRightPanel.insets = new Insets(10, 10, 10, 10); // Margem externa

        // Adicionar a imagem com borda arredondada
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(160, 160));
        try {
            // Carregar a imagem
            File imgFile = new File("C:\\Users\\Administrador\\OneDrive\\Documentos\\workspace-spring-tool-suite-4-4.19.1.RELEASE\\management_system\\demo\\src\\main\\java\\com\\example\\EmployeeManagement\\images\\img1.jpg");
            BufferedImage bufferedImage = ImageIO.read(imgFile);

            // Escalar a imagem para preencher o JLabel
            int imageSize = Math.min(160, Math.min(bufferedImage.getWidth(), bufferedImage.getHeight()));
            Image scaledImage = bufferedImage.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(scaledIcon);

            // Configurar o JLabel para centralizar a imagem
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setVerticalAlignment(SwingConstants.CENTER);

            imageLabel.setBorder(new RoundedBorder(imageSize / 2)); // Borda arredondada com raio igual à metade da largura/altura

            // Adicionar borda arredondada
            GridBagConstraints gbcImageLabel = new GridBagConstraints();
            gbcImageLabel.gridx = 0;
            gbcImageLabel.gridy = 0;
            gbcImageLabel.insets = new Insets(10, 10, 10, 10); // Margem externa
            rightPanel.add(imageLabel, gbcImageLabel);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Tratar exceção de carregamento de imagem
        }

        // Adicionar os labels
        JLabel label1 = new JLabel("Vinícius Neves Corrêa");
        styleLabel(label1);
        GridBagConstraints gbcLabel1 = new GridBagConstraints();
        gbcLabel1.gridx = 0;
        gbcLabel1.gridy = 1;
        gbcLabel1.insets = new Insets(10, 0, 0, 0); // Ajuste de margem superior
        rightPanel.add(label1, gbcLabel1);

        JLabel label2 = new JLabel("Software Engineer Student");
        styleLabel(label2);
        GridBagConstraints gbcLabel2 = new GridBagConstraints();
        gbcLabel2.gridx = 0;
        gbcLabel2.gridy = 2;
        gbcLabel2.insets = new Insets(10, 0, 0, 0); // Ajuste de margem superior
        rightPanel.add(label2, gbcLabel2);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.6;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        middlePanel.add(leftPanel, c);

        c.weightx = 0.4;
        c.gridx = 1;
        middlePanel.add(rightPanel, c);

        // Configurando o bottomPanel
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBackground(new Color(12, 17, 20));
        JLabel bottomLabel = new JLabel("Bottom Panel");
        styleLabel(bottomLabel);
        bottomPanel.add(bottomLabel, createGridBagConstraints());

        topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
        middlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 360));
        bottomPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        add(topPanel);
        add(middlePanel);
        add(bottomPanel);

        setVisible(true);
    }

    private class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    private void styleLabel(JLabel label) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.PLAIN, 26));
        label.setForeground(new Color(250, 250, 255));
    }

    private void addFormFields(JPanel panel) {
        GridBagConstraints c = createGridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"First Name:", "Last name:", "Email:", "Phone:", "Document:", "Address:", "Resume:"};
        int numLabels = labels.length;

        for (int i = 0; i < numLabels; i++) {
            JLabel label = new JLabel(labels[i]);
            styleLabel(label);
            c.gridx = 0;
            c.gridy = i;
            panel.add(label, c);

            if (labels[i].equals("Resume:")) {

                JButton browseButton = new JButton("Browse");
                c.gridx = 1;
                c.gridwidth = 2; // Span over 2 columns
                panel.add(browseButton, c);

                browseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        int returnValue = fileChooser.showOpenDialog(panel);

                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                        }
                    }
                });
            } else {
                JTextField textField = new JTextField(20);
                c.gridx = 1;
                c.gridy = i;
                panel.add(textField, c);
            }
        }
    }

    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        return c;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewJFrame();
            }
        });
    }
}



