package co.edu.uniquindio.centroeventos.centroeventos;

import co.edu.uniquindio.centroeventos.centroeventos.utils.PropertiesLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    private JFrame frame;
    private JTextField usuarioField;
    private JPasswordField contraseñaField;
    private boolean autenticacionExitosa;

    public LoginUI() {
        frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());



        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioField = new JTextField(20);

        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaField = new JPasswordField(20);

        JButton iniciarSesionButton = new JButton("Iniciar Sesión");

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contraseña = new String(contraseñaField.getPassword());
                verificarAutenticacion(usuario, contraseña);
                frame.dispose();
            }
        });

        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(contraseñaLabel);
        frame.add(contraseñaField);
        frame.add(iniciarSesionButton);

        frame.setVisible(true);
    }

    private void verificarAutenticacion(String usuario, String contraseña) {
        String usuarioCorrecto = PropertiesLoader.obtenerPropiedad("usuario");
        String contraseñaCorrecta = PropertiesLoader.obtenerPropiedad("contrasena");

        if (usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta)) {
            autenticacionExitosa = true;
        } else {
            autenticacionExitosa = false;
        }
    }

    public void mostrar() {
        while (!autenticacionExitosa) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean autenticacionExitosa() {
        return autenticacionExitosa;
    }
}
