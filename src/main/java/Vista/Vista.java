package Vista;

import Controlador.ControladorFernando; // AsegÃºrate de importar el controlador
import Modelo.Clases.Coche;
import Modelo.Clases.Concesionario;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

public class Vista {

    private Scanner sc = new Scanner(System.in);
    private ControladorFernando controlador;

    public Vista() {
    }

    public Vista(ControladorFernando controlador) {
        this.controlador = controlador;
    }

    public void bienvenida() {
        System.out.println("Bienvenido/a al Concesionario Alea Motors.");
    }

    //MENÚS
    public void menu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("Elige una opción: ");
            System.out.println("1. Agregar coche/empleado a una sucursal.");
            System.out.println("2. Leer Información.");
            System.out.println("3. Modificar información.");
            System.out.println("4. Eliminar coche/empleado.");
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
    
    public void menuModificar(){
         int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué deseas modificar?");
            System.out.println("1. Sucursal.");
            System.out.println("2. Coche.");
            System.out.println("3. Empleado");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        this.menuModificarSucursal();
                        break;
                    case 2:
                        this.menuModificarCoche();
                        break;
                    case 3:
                        //this.menuModificarEmpleado();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    /*public void menuModificarEmpleado(){
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué te gustaría modificar?");
            System.out.println("1. Puesto.");
            System.out.println("2. Telefono");
            System.out.println("3. Correo electrónico");
            System.out.println("4. Sueldo");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.modificarPuestoEmpleado();
                        break;
                    case 2:
                        controlador.modificarTelefonoEmpleado();
                        break;
                    case 3:
                        controlador.modificarCorreoEmpleado();
                        break;
                    case 4:
                        controlador.modificarSueldoEmpleado();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }*/
    
    public void menuModificarCoche(){
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué quieres modificar?");
            System.out.println("1. Precio.");
            System.out.println("0. Volver.");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.modificarPrecioCoche();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }
    
    public void menuModificarSucursal(){
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué quieres modificar?");
            System.out.println("1. Teléfono.");
            System.out.println("2. Jefe.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.modificarTelefonoSucursal();
                        break;
                    case 2:
                        controlador.modificarJefeSucursal();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    public void menuAgregar() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué acción quieres realizar?");
            System.out.println("1. Agregar nuevo coche a sucursal.");
            System.out.println("2. Agregar nuevo empleado a sucursal.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.agregarCoche();
                        break;
                    case 2:
                        controlador.agregarEmpleado();
                        break;
                    case 0:

                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void menuLeer() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Sobre qué quieres leer información?");
            System.out.println("1. Concesionario");
            System.out.println("2. Sucursal.");
            System.out.println("3. Coches.");
            System.out.println("4. Empleados.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        this.menuLeerConcesionario();
                        break;
                    case 2:
                        this.menuLeerSucursal();
                        break;
                    case 3:
                        this.menuLeerCoches();
                        break;
                    case 4:
                        this.menuLeerEmpleados();
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void menuLeerEmpleados() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué quieres saber?");
            System.out.println("1. Información general de un empleado.");
            System.out.println("2. Empleados en un determinado puesto.");
            System.out.println("3. Empleados de una sucursal determinada.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.mostrarEmpleadoSegunID();
                        break;
                    case 2:
                        controlador.mostrarEmpleadosSegunPuesto();
                        break;
                    case 3:
                        controlador.leerEmpleados();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    public void menuLeerConcesionario() throws JAXBException {
        int opcion = -1;

        while (opcion != 1) {
            System.out.println("1. Información general del concesionario.");
            opcion = sc.nextInt();
            sc.nextLine();
        }
        controlador.mostrarInfoGeneralConcesionario();
    }

    public void menuLeerSucursal() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué quieres saber?");
            System.out.println("1. Información general de la sucursal.");
            System.out.println("2. Número de empleados de la sucursal.");
            System.out.println("3. Número de coches de la sucursal.");
            System.out.println("4. Información sobre los empleados de la sucursal.");
            System.out.println("5. Información sobre los coches de la sucursal.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.mostrarInfoGeneralSucursal();
                        break;
                    case 2:
                        controlador.mostrarNumeroEmpleados();
                        break;
                    case 3:
                        controlador.mostrarNumeroCoches();
                        break;
                    case 4:
                        controlador.leerEmpleados();
                        break;
                    case 5:
                        controlador.leerCoches();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    public void menuLeerCoches() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué quieres saber?");
            System.out.println("1. Información general de un coche.");
            System.out.println("2. Coches de una marca determinada.");
            System.out.println("3. Coches con un número de puertas determinado.");
            System.out.println("4. Coches según el tipo de combustible.");
            System.out.println("5. Coches según su año de fabricación.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.mostrarInfoGeneralCoche();
                        break;
                    case 2:
                        controlador.mostrarInfoCochesPorMarca();
                        break;
                    case 3:
                        controlador.mostrarInfoCochesPorPuertas();
                        break;
                    case 4:
                        controlador.mostrarInfoCochesPorCombustible();
                        break;
                    case 5:
                        controlador.mostrarInfoCochesPorAñoFabricacion();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }
    
    public void menuEliminar(){
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("¿Qué deseas eliminar del sistema?");
            System.out.println("1. Empleado");
            System.out.println("2. Coche.");
            System.out.println("0. Volver");

            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        controlador.eliminarEmpleado();
                        break;
                    case 2:
                        controlador.eliminarCoche();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // CREAR COCHE Y CREAR EMPLEADO.
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

    public Empleado nuevoEmpleado() {
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

    // MOSTRAR INFORMACION AL USUARIO
    public void mostrarEmpleadosSegunPuesto(ArrayList<Empleado> listaEmpleadosPuesto){
        if(!listaEmpleadosPuesto.isEmpty()){
            for(Empleado empleado : listaEmpleadosPuesto){
                System.out.println(empleado.toString());
            }
        }else{
            System.out.println("No se ha encontrado ningún empleado en el puesto especificado.");
        }
    }
    
    public void mostrarInfoGeneralConcesionario(Concesionario concesionario) {
        System.out.println(concesionario.toString());
    }

    public void mostrarInformacionCoches(Sucursal sucursal) {
        if (sucursal != null) {
            System.out.println("Lista de coches de la sucursal de " + sucursal.getLocalizacion() + ":");
            for (Coche coche : sucursal.getListaCoches()) {
                System.out.println(coche.toString());
            }
        } else {
            System.out.println("La sucursal seleccionada no ha sido encontrada.");
        }
    }

    public void mostrarInformacionEmpleados(Sucursal sucursal) {
        if (sucursal != null) {
            System.out.println("Lista de empleados de la sucursal de " + sucursal.getLocalizacion() + ":");
            for (Empleado empleado : sucursal.getListaEmpleados()) {
                System.out.println(empleado.toString());
            }
        } else {
            System.out.println("La sucursal seleccionada no ha sido encontrada.");
        }
    }

    public void mostrarNumeroEmpleados(int numeroEmpleados) {
        System.out.println("La sucursal tiene " + numeroEmpleados + " empleados.");
    }

    public void mostrarNumeroCoches(int numeroCoches) {
        System.out.println("La sucursal tiene " + numeroCoches + " coches.");
    }

    public void mostrarInfoGeneralSucursal(Sucursal sucursal) {
        if (sucursal != null) {
            System.out.println(sucursal.toString());
        } else {
            System.out.println("No se ha encontrado la sucursal.");
        }
    }

    public void mostrarInfoGeneralCoche(Coche coche) {
        if (coche != null) {
            System.out.println(coche.toString());
        } else {
            System.out.println("No se ha encontrado ningún coche con ese ID.");
        }
    }

    public void mostrarCochesPorMarca(ArrayList<Coche> listaCochesMarca) {
        if (!listaCochesMarca.isEmpty()) {
            for (Coche coche : listaCochesMarca) {
                System.out.println(coche.toString());
            }
        } else {
            System.out.println("No existen coches de la marca introducida.");
        }

    }

    public void mostrarCochesNumeroPuertas(ArrayList<Coche> listaCochesNumPuertas) {
        if (!listaCochesNumPuertas.isEmpty()) {
            for (Coche coche : listaCochesNumPuertas) {
                System.out.println(coche.toString());
            }
        } else {
            System.out.println("No existen coches con el número de puertas introducido.");
        }

    }

    public void mostrarCochesCombustible(ArrayList<Coche> listaCochesCombustible) {
        if (!listaCochesCombustible.isEmpty()) {
            for (Coche coche : listaCochesCombustible) {
                System.out.println(coche.toString());
            }
        } else {
            System.out.println("No existen coches con el combustible introducido");
        }
    }

    public void mostrarCochesAñoFabricacion(ArrayList<Coche> listaCochesAñoFabricacion) {
        if (!listaCochesAñoFabricacion.isEmpty()) {
            for (Coche coche : listaCochesAñoFabricacion) {
                System.out.println(coche.toString());
            }
        }
    }

    public void mostrarInfoGeneralEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println(empleado.toString());

        } else {
            System.out.println("No se ha encontrado ningún empleado con ese ID");
        }
    }
    
    public void mostrarMensajeEmpleadoEliminado(){
        System.out.println("El empleado se ha eliminado correctamente.");
    }
    
    public void mostrarMensajeCocheEliminado(){
        System.out.println("El coche ha sido eliminado correctamente.");
    }
    
    public void mostrarMensajeTelefonoModificado(){
        System.out.println("El teléfono ha sido modificado correctamente.");
    }
    
    public void mostrarMensajeJefeModificado(){
        System.out.println("El jefe ha sido modificado correctamente.");
    }
    
    public void mostrarMensajePrecioCocheModificado(){
        System.out.println("El precio del coche ha sido modificado correctamente.");
    }
    
    public void mostrarMensajeErrorModificarPrecioCoche(){
        System.out.println("El precio del coche no se ha podido modificar porque este no existe.");
    }
    
    

    // OBTENER INFORMACION DEL USUARIO
    
    public double obtenerNuevoPrecioCoche(){
        System.out.println("Escribe el nuevo precio del coche: ");
        double nuevoPrecio = sc.nextDouble();
        sc.nextLine();
        
        return nuevoPrecio;
    }
    
    public String obtenerNuevoJefeSucursal(){
        System.out.println("Escribe el nuevo jefe: ");
        String nuevoJefe = sc.nextLine();
        return nuevoJefe;
    }
    
    public int obtenerNuevoTelefonoSucursal(){
        System.out.println("Introduce el nuevo teléfono: ");
        int nuevoTelefono = sc.nextInt();
        sc.nextLine();
        
        return nuevoTelefono;
    }
    
    public String obtenerEmpleadoSegunPuesto(){
         String puesto = "";
        int opcion = -1;

        while (opcion < 1 || opcion > 4) {
            System.out.println("Indica el puesto que quieres buscar: ");
            System.out.println("1. Vendedor/a");
            System.out.println("2. Contable");
            System.out.println("3. Administrativo/a");
            System.out.println("4. Marketing");
            opcion = sc.nextInt();
            sc.nextLine();
        }

        switch (opcion) {
            case 1:
                puesto = "Vendedor/a";
                break;
            case 2:
                puesto = "Contable";
                break;
            case 3:
                puesto = "Administrativo/a";
                break;
            case 4:
                puesto = "Marketing";
                break;
        }

        return puesto;

    }
    
    public int obtenerAñoFabricacion() {
        System.out.println("Introduce el año de fabricación del coche: ");
        int añoFabricacion = sc.nextInt();

        return añoFabricacion;
    }

    public String obtenerTipoCombustible() {
        String combustible = "";
        int opcion = -1;

        while (opcion < 1 || opcion > 4) {
            System.out.println("Indica el tipo de combustible que quieres buscar: ");
            System.out.println("1. Gasolina");
            System.out.println("2. Diesel");
            System.out.println("3. Híbrido");
            System.out.println("4. Eléctrico");
            opcion = sc.nextInt();
            sc.nextLine();
        }

        switch (opcion) {
            case 1:
                combustible = "Gasolina";
                break;
            case 2:
                combustible = "Diesel";
                break;
            case 3:
                combustible = "Híbrido";
                break;
            case 4:
                combustible = "Eléctrico";
                break;
        }

        return combustible;

    }

    public int obtenerNumeroPuertas() {
        System.out.println("Introduce el número de puertas: ");
        int numPuertas = sc.nextInt();

        return numPuertas;
    }

    public String obtenerMarcaCoche() {
        System.out.println("Introduce la marca del coche: ");
        String marca = sc.nextLine();

        return marca;
    }

    public int obtenerSucursalID() {
        System.out.println("Introduce la sucursal: ");
        System.out.println("1. Madrid.");
        System.out.println("2. Barcelona.");
        System.out.println("3. Valencia");
        int idSucursal = 0;

        while (idSucursal < 1 || idSucursal > 3) {
            idSucursal = sc.nextInt();
        }
        sc.nextLine();

        return idSucursal;
    }

    public int obtenerEmpleadoID() {
        System.out.println("Introduce el ID del empleado: ");
        int id = sc.nextInt();

        return id;
    }

    public int obtenerCocheID() {
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
