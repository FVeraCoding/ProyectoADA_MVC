package nuevoMain;

import Controlador.Controlador;
import Modelo.Logica.Modelo;
import Vista.Vista;

public class Main {

    public static void main(String[] args) {
        try {
            
            Modelo modelo = new Modelo();
            Vista vista = new Vista(); 
            Controlador controlador = new Controlador(modelo, vista);
    
            vista.setControlador(controlador);

            
            controlador.iniciar();
            
        } catch (Exception e) {
            System.out.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }

}
