package com.mycompany.ejercicio_resuelto_pag412;

import javax.swing.*;
import java.awt.*;

public class CálculosNuméricos extends JFrame {

    JTextField txtValor;
    JButton btnCalcular;

    CálculosNuméricos() {
        setTitle("Cálculos Numéricos");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Valor numérico:"));
        txtValor = new JTextField();
        panel.add(txtValor);

        panel.add(new JLabel(""));
        btnCalcular = new JButton("Calcular");
        panel.add(btnCalcular);

        btnCalcular.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(txtValor.getText());

                String logaritmo = calcularLogaritmoNeperiano(valor);
                String raiz = calcularRaízCuadrada(valor);

                JOptionPane.showMessageDialog(this,
                    logaritmo + "\n" + raiz);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "El valor debe ser numérico");
            }
        });

        add(panel);
        setVisible(true);
    }

    static String calcularLogaritmoNeperiano(double valor) {
        try {
            if (valor <= 0) {
                throw new ArithmeticException();
            }

            double resultado = Math.log(valor);
            return "Resultado del logaritmo neperiano = " + resultado;

        } catch (ArithmeticException e) {
            return "El valor debe ser un número positivo para calcular el logaritmo";
        }
    }

    static String calcularRaízCuadrada(double valor) {
        try {
            if (valor < 0) {
                throw new ArithmeticException();
            }

            double resultado = Math.sqrt(valor);
            return "Resultado de la raíz cuadrada = " + resultado;

        } catch (ArithmeticException e) {
            return "El valor debe ser un número positivo para calcular la raíz cuadrada";
        }
    }

    public static void main(String args[]) {
        new CálculosNuméricos();
    }
}