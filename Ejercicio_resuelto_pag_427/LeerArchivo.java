package com.mycompany.ejercicio_resuelto_pag427;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LeerArchivo extends JFrame {

    JTextField txtArchivo;
    JTextArea areaContenido;
    JButton btnLeer;

    LeerArchivo() {
        setTitle("Leer Archivo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelSuperior = new JPanel(new GridLayout(1, 3, 10, 10));

        panelSuperior.add(new JLabel("Localización del archivo:"));

        txtArchivo = new JTextField("C:/prueba.txt");
        panelSuperior.add(txtArchivo);

        btnLeer = new JButton("Leer archivo");
        panelSuperior.add(btnLeer);

        areaContenido = new JTextArea();
        areaContenido.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaContenido);

        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        btnLeer.addActionListener(e -> {
            String nombreArchivo = txtArchivo.getText().trim();

            if (nombreArchivo.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Debe ingresar la localización del archivo");
                return;
            }

            areaContenido.setText("");

            FileInputStream archivo;
            InputStreamReader conversor;
            BufferedReader filtro;

            String línea;

            try {
                archivo = new FileInputStream(nombreArchivo);
                conversor = new InputStreamReader(archivo);
                filtro = new BufferedReader(conversor);

                línea = filtro.readLine();

                while (línea != null) {
                    areaContenido.append(línea + "\n");
                    línea = filtro.readLine();
                }

                filtro.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "No se pudo leer el archivo.");
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LeerArchivo();
    }
}