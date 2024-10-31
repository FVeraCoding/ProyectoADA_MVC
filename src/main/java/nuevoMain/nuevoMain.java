package nuevoMain;

import Controlador.ControladorFernando;
import Modelo.Logica.ModeloFernando;
import Vista.Vista;

public class nuevoMain {

    public static void main(String[] args) {
        try {
            
            ModeloFernando modelo = new ModeloFernando();
            Vista vista = new Vista(); 
            ControladorFernando controlador = new ControladorFernando(modelo, vista);
    
            vista.setControlador(controlador);

            
            controlador.iniciar();
            
        } catch (Exception e) {
            System.out.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }

}
