package com.mycompany.ejercicio_resuelto_pag406;

import javax.swing.*;
import java.awt.*;

public class Vendedor extends JFrame {

    String nombre;
    String apellidos;
    int edad;

    JTextField txtNombre;
    JTextField txtApellidos;
    JTextField txtEdad;
    JButton btnImprimir;

        Vendedor() {
        setTitle("Vendedor");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);
        
        panel.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panel.add(txtApellidos);
        
        panel.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panel.add(txtEdad);
        
        panel.add(new JLabel(""));
        btnImprimir = new JButton("Imprimir");
        panel.add(btnImprimir);
        
        btnImprimir.addActionListener(e -> {
            try {
                nombre = txtNombre.getText();
                apellidos = txtApellidos.getText();
                
                if (nombre.trim().isEmpty() || apellidos.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                        "Debe ingresar el nombre y los apellidos");
                    return;
                }
                
                int e1 = Integer.parseInt(txtEdad.getText());
                
                verificarEdad(e1);
                imprimir();
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "La edad debe ser un número entero");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,
                    ex.getMessage());
            }
        });
        
        add(panel);
        setVisible(true);
    }

    void verificarEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException(
                "La edad no puede ser negativa ni mayor a 120");
        }
        
        if (edad <= 18) {
            throw new IllegalArgumentException(
                "El vendedor debe ser mayor de 18 años");
        }
        
        this.edad = edad;
    }

    void imprimir() {
        JOptionPane.showMessageDialog(this,
            "Nombre del vendedor = " + nombre +
            "\nApellidos del vendedor = " + apellidos +
            "\nEdad del vendedor = " + edad);
    }

    public static void main(String[] args) {
        new Vendedor();
    }
}