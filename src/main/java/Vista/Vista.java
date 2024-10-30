package Vista;

import Controlador.Controlador; // Asegúrate de importar el controlador
import Modelo.Clases.Coche;
import Modelo.Clases.Empleado;
import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);
    private Controlador controlador; // Referencia al controlador

    public Vista() {
    }

    
    
    public Vista(Controlador controlador) {
        this.controlador = controlador; // Inicializa el controlador
    }

    public void bienvenida() {
        System.out.println("Bienvenido/a al Concesionario Alea Motors");
    }
    
    public void menu() {
        int opcion = -1;
        
        while(opcion != 0){
            System.out.println("Elige una opción: ");
            System.out.println("1. Agregar coche");
            System.out.println("2. Agregar nuevo empleado");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            
            try {
                controlador.ejecutarOpcion(opcion); // Llama al controlador para ejecutar la opción
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int obtenerSucursalID() {
        System.out.println("Introduce en qué sucursal quieres introducir el coche: ");
        System.out.println("1. Madrid.");
        System.out.println("2. Barcelona.");
        System.out.println("3. Valencia");
        int idSucursal = 0;
        
        while (idSucursal < 1 || idSucursal > 3){
            idSucursal = sc.nextInt();
        }
        
        return idSucursal; // Retorna el ID de la sucursal
    }

    public Coche nuevoCoche() {
        System.out.println("Introduce la marca del coche: ");
        String marca = sc.nextLine();
        
        System.out.println("Introduce el modelo del coche: ");
        String modelo = sc.nextLine();
        
        System.out.println("Introduce el año de creación del coche: ");
        int creacion = sc.nextInt();
        
        System.out.println("Introduce el precio de mercado del coche: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Introduce el color del coche: ");
        String color = sc.nextLine();
        
        System.out.println("Introduce el número de puertas del coche: ");
        int numPuertas = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduce el tipo de combustible del coche: ");
        String combustible = sc.nextLine();
        
        Coche coche = new Coche(marca, modelo, creacion, precio, color, numPuertas, combustible);
        return coche;
    }
    
    public Empleado nuevoEmpleado(){
        System.out.println("Introduce el nombre del nuevo empleado: ");
        String nombre = sc.nextLine();
        
        System.out.println("Introduce los apellidos del nuevo empleado: ");
        String apellidos = sc.nextLine();
        
        System.out.println("Introduce el DNI del nuevo empleado: ");
        String dni = sc.nextLine();
        
        System.out.println("Introduce el puesto del nuevo empleado: ");
        String puesto = sc.nextLine();
        
        System.out.println("Introduce el teléfono del nuevo empleado: ");
        int telefono = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduce el correo electrónico del nuevo empleado: ");
        String correo = sc.nextLine();
        
        System.out.println("Introduce el sueldo del nuevo empleado: ");
        double sueldo = sc.nextDouble();
        
        Empleado empleado = new Empleado(nombre, apellidos, dni, puesto, telefono, correo, sueldo);
        
        return empleado;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
}
