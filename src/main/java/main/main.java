package main;

import Controlador.Controlador;
import Modelo.Logica.ModeloFernando;
import Vista.Vista;

public class main {

    public static void main(String[] args) {
        try {
            
            ModeloFernando modelo = new ModeloFernando();

            
            Vista vista = new Vista(); 

            Controlador controlador = new Controlador(modelo, vista);

            
            vista.setControlador(controlador); 

            
            controlador.iniciar();
        } catch (Exception e) {
            System.out.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }

}
