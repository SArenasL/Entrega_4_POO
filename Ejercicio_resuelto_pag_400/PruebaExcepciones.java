package com.mycompany.Ejercicio_resuelto_pag400;

import javax.swing.*;
import java.awt.*;

public class PruebaExcepciones extends JFrame {

    private JTextArea areaTexto;

    public PruebaExcepciones() {

        setTitle("Manejo de Excepciones");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        inicializarComponentes();

        setVisible(true);
    }

    private void inicializarComponentes() {

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(70, 130, 180));

        JLabel titulo = new JLabel("EXCEPCIONES");
        titulo.setFont(new Font("Arial", Font.BOLD, 21));
        titulo.setForeground(Color.WHITE);

        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaTexto.setEditable(false);
        areaTexto.setBackground(new Color(240, 240, 240));
        areaTexto.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
        panelBotones.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JButton btnPrueba = new JButton("PruebaExcepciones");
        btnPrueba.setBackground(new Color(173, 216, 230));
        btnPrueba.setFont(new Font("Arial", Font.BOLD, 13));
        btnPrueba.addActionListener(e -> ejecutarPruebaExcepciones());
        panelBotones.add(btnPrueba);

        JButton btnLimite = new JButton("ExcepciónFueraLímite");
        btnLimite.setBackground(new Color(173, 216, 230));
        btnLimite.setFont(new Font("Arial", Font.BOLD, 13));
        btnLimite.addActionListener(e -> ejecutarExcepcionFueraLimite());
        panelBotones.add(btnLimite);

        JButton btnFormato = new JButton("ExcepciónFormatoNúmero");
        btnFormato.setBackground(new Color(173, 216, 230));
        btnFormato.setFont(new Font("Arial", Font.BOLD, 13));
        btnFormato.addActionListener(e -> ejecutarExcepcionFormatoNumero());
        panelBotones.add(btnFormato);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(new Color(255, 255, 224));
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 13));
        btnLimpiar.addActionListener(e -> areaTexto.setText(""));
        panelBotones.add(btnLimpiar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void ejecutarPruebaExcepciones() {

        areaTexto.append("PRUEBA DE EXCEPCIONES\n");

        try {

            areaTexto.append("Ingresando al primer try\n");

            int divisor = 0;
            double cociente = 10000 / divisor;

            areaTexto.append("Después de la división\n");

        } catch (ArithmeticException e) {

            areaTexto.append("División por cero\n");

        } finally {

            areaTexto.append("Ingresando al primer finally\n");
        }

        try {

            areaTexto.append("Ingresando al segundo try\n");

            Object objeto = null;
            objeto.toString();

            areaTexto.append("Imprimiendo objeto\n");

        } catch (ArithmeticException e) {

            areaTexto.append("División por cero\n");

        } catch (Exception e) {

            areaTexto.append("Ocurrió una excepción\n");

        } finally {

            areaTexto.append("Ingresando al segundo finally\n");
        }

        areaTexto.append("\n");
        actualizarArea();
    }

    private void ejecutarExcepcionFueraLimite() {

        areaTexto.append("EXCEPCIÓN FUERA DE LÍMITE\n");

        try {

            String texto = "Programación";
            char caracter = texto.charAt(14);

            areaTexto.append(String.valueOf(caracter) + "\n");

        } catch (StringIndexOutOfBoundsException e) {

            areaTexto.append(
                "Indice de string por fuera del límite\n"
            );
        }

        areaTexto.append("\n");
        actualizarArea();
    }

    private void ejecutarExcepcionFormatoNumero() {

        areaTexto.append("EXCEPCIÓN FORMATO NÚMERO\n");

        try {

            int numero = Integer.parseInt("Número");

            areaTexto.append(numero + "\n");

        } catch (NumberFormatException e) {

            areaTexto.append(
                "Excepción de formato de número\n"
            );

        } finally {

            areaTexto.append("Ingresando al finally\n");
        }

        areaTexto.append("\n");
        actualizarArea();
    }

    private void actualizarArea() {

        areaTexto.setCaretPosition(
            areaTexto.getDocument().getLength()
        );
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {
            new PruebaExcepciones();
        });
    }
}