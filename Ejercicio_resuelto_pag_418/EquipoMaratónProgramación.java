package com.mycompany.ejercicio_resuelto_pag418;

import javax.swing.*;
import java.awt.*;

public class EquipoMaratónProgramación extends JFrame {

    String nombreEquipo;
    String universidad;
    String lenguajeProgramación;

    Programador[] programadores;
    int tamañoEquipo;

    JTextField txtNombreEquipo;
    JTextField txtUniversidad;
    JTextField txtLenguaje;

    JTextField txtNombre;
    JTextField txtApellidos;

    JButton btnAñadir;
    JButton btnCrearEquipo;

    EquipoMaratónProgramación() {

        nombreEquipo = "";
        universidad = "";
        lenguajeProgramación = "";

        tamañoEquipo = 0;
        programadores = new Programador[3];

        setTitle("Equipo Maratón de Programación");
        setSize(450, 390);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel panelEquipo = new JPanel(new GridLayout(3, 2, 10, 5));

        panelEquipo.setBorder(
                BorderFactory.createTitledBorder("Datos del equipo"));

        panelEquipo.add(new JLabel("Nombre del equipo:"));
        txtNombreEquipo = new JTextField();
        panelEquipo.add(txtNombreEquipo);

        panelEquipo.add(new JLabel("Universidad:"));
        txtUniversidad = new JTextField();
        panelEquipo.add(txtUniversidad);

        panelEquipo.add(new JLabel("Lenguaje de programación:"));
        txtLenguaje = new JTextField();
        panelEquipo.add(txtLenguaje);

        JPanel panelProgramador = new JPanel(new GridLayout(2, 2, 10, 5));

        panelProgramador.setBorder(
                BorderFactory.createTitledBorder("Datos del programador"));

        panelProgramador.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelProgramador.add(txtNombre);

        panelProgramador.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelProgramador.add(txtApellidos);

        btnAñadir = new JButton("Añadir programador");
        btnCrearEquipo = new JButton("Crear equipo");

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 15, 0));

        panelBotones.add(btnAñadir);
        panelBotones.add(btnCrearEquipo);

        JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 10, 8));

        panelSuperior.add(panelEquipo);
        panelSuperior.add(panelProgramador);

        panelPrincipal.add(panelSuperior, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnAñadir.addActionListener(e -> {

            try {

                String nombre = txtNombre.getText().trim();
                String apellidos = txtApellidos.getText().trim();

                if (nombre.isEmpty() || apellidos.isEmpty()) {
                    throw new Exception(
                            "Debe ingresar el nombre y los apellidos.");
                }

                if (estáLleno()) {
                    throw new Exception(
                            "El equipo está lleno. No se pudo agregar");
                }

                validarCampo(nombre);
                validarCampo(apellidos);

                Programador programador =
                        new Programador(nombre, apellidos);

                añadir(programador);

                txtNombre.setText("");
                txtApellidos.setText("");

                JOptionPane.showMessageDialog(this,
                        "Programador añadido correctamente.");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnCrearEquipo.addActionListener(e -> {

            try {

                nombreEquipo = txtNombreEquipo.getText().trim();
                universidad = txtUniversidad.getText().trim();
                lenguajeProgramación = txtLenguaje.getText().trim();

                if (nombreEquipo.isEmpty()
                        || universidad.isEmpty()
                        || lenguajeProgramación.isEmpty()) {

                    throw new Exception(
                            "Debe ingresar todos los datos del equipo.");
                }

                if (tamañoEquipo < 2) {

                    throw new Exception(
                            "El equipo debe tener mínimo 2 programadores.");
                }

                StringBuilder resultado = new StringBuilder();

                resultado.append("Nombre del equipo = ")
                        .append(nombreEquipo);

                resultado.append("\nUniversidad = ")
                        .append(universidad);

                resultado.append("\nLenguaje de programación = ")
                        .append(lenguajeProgramación);

                resultado.append("\nTamaño del equipo = ")
                        .append(tamañoEquipo);

                resultado.append("\n\nIntegrantes del equipo:\n");

                for (int i = 0; i < tamañoEquipo; i++) {

                    resultado.append("\nNombre = ")
                            .append(programadores[i].nombre);

                    resultado.append("\nApellidos = ")
                            .append(programadores[i].apellidos);

                    resultado.append("\n");
                }

                JOptionPane.showMessageDialog(
                        this,
                        resultado.toString(),
                        "Equipo creado correctamente",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setVisible(true);
    }

    boolean estáLleno() {

        return tamañoEquipo == programadores.length;
    }

    void añadir(Programador programador) throws Exception {

        if (estáLleno()) {

            throw new Exception(
                    "El equipo está lleno. No se pudo agregar programador.");
        }

        programadores[tamañoEquipo] = programador;

        tamañoEquipo++;
    }

    static void validarCampo(String campo) throws Exception {

        for (int j = 0; j < campo.length(); j++) {

            char c = campo.charAt(j);

            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {

                throw new Exception(
                        "El nombre y los apellidos solo pueden contener letras");
            }
        }

        if (campo.length() >= 20) {

            throw new Exception(
                    "La longitud no debe ser igual o superior a 20 caracteres.");
        }
    }

    public static void main(String args[]) {

        new EquipoMaratónProgramación();
    }
}