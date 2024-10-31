package Controlador;

import Modelo.Clases.Coche;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import Modelo.Logica.ModeloFernando;
import Vista.Vista;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class ControladorFernando {
    private ModeloFernando modelo;
    private Vista vista;

    public ControladorFernando(ModeloFernando modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() throws SAXException, IOException, ParserConfigurationException, JAXBException, XPathExpressionException {
        vista.bienvenida();
        vista.menu(); 
    }

    public void agregarCoche() throws SAXException, IOException, ParserConfigurationException, JAXBException, XPathExpressionException {
        Coche coche = vista.nuevoCoche();
        coche.setId(modelo.getUltimoCocheID() + 1); 
        modelo.insertarCoche(coche, vista.obtenerSucursalID()); 
        System.out.println("Coche a�adido: " + coche.getMarca() + " " + coche.getModelo());
    }
    
    public void agregarEmpleado() throws XPathExpressionException, SAXException, IOException, JAXBException, ParserConfigurationException{
        Empleado empleado = vista.nuevoEmpleado();
        empleado.setId(modelo.getUltimoEmpleadoID()+1);
        modelo.insertarEmpleado(empleado, vista.obtenerSucursalID());
        System.out.println("Empleado a�adido: "+empleado.getNombre() + " "+empleado.getApellidos()+ " "+" - "+empleado.getPuesto());
    }
    
    public void leerEmpleados() throws JAXBException{
        int idSucursal = vista.obtenerSucursalID();
        Sucursal sucursal = modelo.obtenerSucursal(idSucursal);
        vista.mostrarInformacionEmpleados(sucursal);   
    }
    
    public void leerCoches() throws JAXBException{
        int idSucursal = vista.obtenerSucursalID();
        Sucursal sucursal = modelo.obtenerSucursal(idSucursal);
        vista.mostrarInformacionCoches(sucursal);
    }

    
    public void ejecutarOpcion(int opcion) throws SAXException, IOException, ParserConfigurationException, JAXBException, XPathExpressionException {
        switch (opcion) {
            case 1:
                agregarCoche(); 
                break;
                
            case 2: 
                agregarEmpleado();
                break;
                
            case 3:
                mostrarNumeroEmpleados();
                break;
                
            case 4:
                mostrarNumeroCoches();
                break;
                
            case 5:
                leerEmpleados();
                break;
                
            case 6:
                leerCoches();
                break;
                
            case 7:
                eliminarEmpleado();
                break;
                
            case 8:
                eliminarCoche();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opci�n no v�lida. Int�ntalo de nuevo.");
                break;
        }
    }
    
    public void mostrarNumeroEmpleados() throws JAXBException{
        int numeroEmpleados = modelo.getNumeroEmpleados(vista.obtenerSucursalID());
        vista.mostrarNumeroEmpleados(numeroEmpleados);
    }
    
    public void mostrarNumeroCoches() throws JAXBException{
        int numeroCoches = modelo.getNumeroCoches(vista.obtenerSucursalID());
        vista.mostrarNumeroCoches(numeroCoches);
    }
    
    public void eliminarEmpleado() throws JAXBException{
        int idEmpleado = vista.obtenerEmpleadoID();
        modelo.eliminarEmpleado(idEmpleado);
    }
    
    public void eliminarCoche() throws JAXBException{
        int idCoche = vista.obtenerCocheID();
        modelo.eliminarCoche(idCoche);
    }
}
