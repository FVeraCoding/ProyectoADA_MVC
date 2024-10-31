package Vista;

import Controlador.ControladorFernando; // AsegÃºrate de importar el controlador
import Modelo.Clases.Coche;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);
    private ControladorFernando controlador;
    public Vista() {
    }

    
    
    public Vista(ControladorFernando controlador) {
        this.controlador = controlador;
    }

    public void bienvenida() {
        System.out.println("Bienvenido/a al Concesionario Alea Motors");
    }
    
    public void menu() {
        int opcion = -1;
        
        while(opcion != 0){
            System.out.println("Elige una opción: ");
            System.out.println("1. Agregar coche a una sucursal.");
            System.out.println("2. Agregar nuevo empleado a una sucursal.");
            System.out.println("3. Mostrar el número de empleados de una sucursal");
            System.out.println("4. Mostrar el número de coches de una sucursal");
            System.out.println("5. Mostrar los Empleados de una sucursal");
            System.out.println("6. Mostrar los Coches de una sucursal");
            System.out.println("7. Eliminar Empleado de una sucursal.");
            System.out.println("8. Eliminar Coche de una sucursal.");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); 
            
            try {
                controlador.ejecutarOpcion(opcion); 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int obtenerSucursalID() {
        System.out.println("Introduce la sucursal: ");
        System.out.println("1. Madrid.");
        System.out.println("2. Barcelona.");
        System.out.println("3. Valencia");
        int idSucursal = 0;
        
        while (idSucursal < 1 || idSucursal > 3){
            idSucursal = sc.nextInt();
        }
        
        return idSucursal; 
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
    
    
    public void mostrarInformacionCoches(Sucursal sucursal){
        if(sucursal != null){
            System.out.println("Lista de empleados de la sucursal de "+sucursal.getLocalizacion()+":");
            for(Coche coche : sucursal.getListaCoches()){
                System.out.println(coche.toString());
            }
        }else{
            System.out.println("La sucursal seleccionada no ha sido encontrada.");
        }
    }
    
    public void mostrarInformacionEmpleados(Sucursal sucursal){
        if(sucursal != null){
            System.out.println("Lista de empleados de la sucursal de "+sucursal.getLocalizacion()+":");
            for(Empleado empleado : sucursal.getListaEmpleados()){
                System.out.println(empleado.toString());
            }
        }else{
            System.out.println("La sucursal seleccionada no ha sido encontrada.");
        }
    }
    
    public void mostrarNumeroEmpleados(int numeroEmpleados){
        System.out.println("La sucursal tiene "+numeroEmpleados + " empleados.");
    }
    
    public void mostrarNumeroCoches(int numeroCoches){
        System.out.println("La sucursal tiene "+numeroCoches+" coches.");
    }
    
    public int obtenerEmpleadoID(){
        System.out.println("Introduce el ID del empleado: ");
        int id = sc.nextInt();
        
        return id;
    }
    
    public int obtenerCocheID(){
        System.out.println("Introduce el ID del coche: ");
        int id = sc.nextInt();
        return id;
    }
    
    

    public ControladorFernando getControlador() {
        return controlador;
    }

    public void setControlador(ControladorFernando controlador) {
        this.controlador = controlador;
    }
    
    
    
    
}
