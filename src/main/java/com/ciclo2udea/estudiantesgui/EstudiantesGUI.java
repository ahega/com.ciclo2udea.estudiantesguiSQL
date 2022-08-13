package com.ciclo2udea.estudiantesgui;

import controlador.controlador;
import java.io.IOException;

public class EstudiantesGUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        controlador control = new controlador();
        control.iniciar();
        
    }
}
