package Controlador;

import Modelo.Clases.Coche;
import Modelo.Clases.Concesionario;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import Modelo.Logica.Modelo;
import Vista.Vista;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
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
        vista.mostrarMensajeCocheAñadido();
    }
    
    public void agregarEmpleado() throws XPathExpressionException, SAXException, IOException, JAXBException, ParserConfigurationException{
        Empleado empleado = vista.nuevoEmpleado();
        empleado.setId(modelo.getUltimoEmpleadoID()+1);
        modelo.insertarEmpleado(empleado, vista.obtenerSucursalID());
        vista.mostrarMensajeEmpleadoAñadido();
    }
    
    public void leerEmpleados() throws JAXBException{
        int idSucursal = vista.obtenerSucursalID();
        Sucursal sucursal = modelo.getSucursalSegunID(idSucursal);
        vista.mostrarInformacionEmpleados(sucursal);   
    }
    
    public void leerCoches() throws JAXBException{
        int idSucursal = vista.obtenerSucursalID();
        Sucursal sucursal = modelo.getSucursalSegunID(idSucursal);
        vista.mostrarInformacionCoches(sucursal);
    }
    
    public void mostrarInfoGeneralConcesionario() throws JAXBException{
        Concesionario concesionario = modelo.deserializarConcesionario();
        vista.mostrarInfoGeneralConcesionario(concesionario);  
    }
    
    public void mostrarInfoGeneralSucursal() throws JAXBException{
        int idSucursal = vista.obtenerSucursalID();
        Sucursal sucursal = modelo.getSucursalSegunID(idSucursal);
        vista.mostrarInfoGeneralSucursal(sucursal);
    }
    
    public void mostrarInfoGeneralCoche() throws JAXBException{
        int idCoche = vista.obtenerCocheID();
        Coche coche = modelo.getCocheSegunID(idCoche);
        vista.mostrarInfoGeneralCoche(coche);
    }
    
    public void mostrarInfoCochesPorMarca() throws JAXBException{
        String marca = vista.obtenerMarcaCoche();
        ArrayList<Coche> listaCochesMarca = modelo.getListaCochesSegunMarca(marca);
        vista.mostrarCochesPorMarca(listaCochesMarca);
        
    }
    
    public void mostrarInfoCochesPorPuertas() throws JAXBException{
        int numPuertas = vista.obtenerNumeroPuertas();
        ArrayList<Coche> listaCochesPuertas = modelo.getListaCochesSegunNumeroPuertas(numPuertas);
        vista.mostrarCochesNumeroPuertas(listaCochesPuertas);
    }
    
    public void mostrarInfoCochesPorCombustible() throws JAXBException{
        String combustible = vista.obtenerTipoCombustible();
        ArrayList<Coche> listaCochesCombustible = modelo.getListaCochesSegunCombustible(combustible);
        vista.mostrarCochesCombustible(listaCochesCombustible);
    }
    
    public void mostrarInfoCochesPorAñoFabricacion() throws JAXBException{
        int añoFabricacion = vista.obtenerAñoFabricacion();
        ArrayList<Coche> listaCochesAñoFabricacion = modelo.getListaCochesSegunAñoFabricacion(añoFabricacion);
        vista.mostrarCochesAñoFabricacion(listaCochesAñoFabricacion);
    }
    
    public void mostrarEmpleadoSegunID() throws JAXBException{
        int idEmpleado = vista.obtenerEmpleadoID();
        Empleado empleado = modelo.getEmpleadoSegunID(idEmpleado);
        vista.mostrarInfoGeneralEmpleado(empleado);
    }
    
    public void mostrarEmpleadosSegunPuesto() throws JAXBException{
        String puesto = vista.obtenerEmpleadoSegunPuesto();
        ArrayList<Empleado> listaEmpleadosPuesto = modelo.getEmpleadoSegunPuesto(puesto);
        vista.mostrarEmpleadosSegunPuesto(listaEmpleadosPuesto);
    }

    
    public void ejecutarOpcion(int opcion) throws SAXException, IOException, ParserConfigurationException, JAXBException, XPathExpressionException {
        switch (opcion) {
            case 1:
                vista.menuAgregar();
                break;
                
            case 2: 
                vista.menuLeer();
                break;
                
            case 3:
                vista.menuModificar();
                break;
                
            case 4:
                vista.menuEliminar();
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
                vista.saliendoDelPrograma();
                break;
            default:
                vista.opcionNoValida();
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
        vista.mostrarMensajeEmpleadoEliminado();
    }
    
    public void eliminarCoche() throws JAXBException{
        int idCoche = vista.obtenerCocheID();
        modelo.eliminarCoche(idCoche);
        vista.mostrarMensajeCocheEliminado();
    }
    
    public void modificarTelefonoSucursal() throws JAXBException{
        int id = vista.obtenerSucursalID();
        int nuevoTelefono = vista.obtenerNuevoTelefono();
        modelo.modificarTelefonoSucursal(id, nuevoTelefono);
        vista.mostrarMensajeTelefonoModificado();
    }
    
    public void modificarJefeSucursal() throws JAXBException{
        int id = vista.obtenerSucursalID();
        String nuevoJefe = vista.obtenerNuevoJefeSucursal();
        modelo.modificarJefeSucursal(id, nuevoJefe);
        vista.mostrarMensajeJefeModificado();
    }
    
    public void modificarPrecioCoche() throws JAXBException{
        boolean exito;
        int idCoche = vista.obtenerCocheID();
        double nuevoPrecio = vista.obtenerNuevoPrecioCoche();
        exito = modelo.modificarPrecioCoche(idCoche, nuevoPrecio);
        if(exito == true){
            vista.mostrarMensajePrecioCocheModificado();
        }else{
            vista.mostrarMensajeErrorModificarPrecioCoche();
        }
    }
    
    public void modificarPuestoEmpleado() throws JAXBException{
        int idEmpleado = vista.obtenerEmpleadoID();
        String nuevoPuesto = vista.obtenerEmpleadoSegunPuesto();
        boolean exito;
        
        exito = modelo.modificarPuestoEmpleado(idEmpleado, nuevoPuesto);
        
        if(exito == true){
            vista.mostrarMensajePuestoEmpleadoModificado();
        }else{
            vista.mostrarMensajeErrorModificarPuestoEmpleado();
        }
    }
    
    public void modificarTelefonoEmpleado() throws JAXBException{
        int idEmpleado = vista.obtenerEmpleadoID();
        int nuevoTelefono = vista.obtenerNuevoTelefono();
        boolean exito;
        
        exito = modelo.modificarTelefonoEmpleado(idEmpleado, nuevoTelefono);
        
        if(exito == true){
            vista.mostrarMensajeTelefonoModificado();
        }else{
            vista.mostrarMensajeErrorModificarTelefonoEmpleado();
        }
    }
    
    public void modificarCorreoEmpleado() throws JAXBException{
        int idEmpleado = vista.obtenerEmpleadoID();
        String nuevoCorreo = vista.obtenerNuevoCorreo();
        boolean exito;
        
        exito = modelo.modificarCorreoEmpleado(idEmpleado, nuevoCorreo);
        
        if(exito == true){
            vista.mostrarMensajeCorreoModificado();
        }else{
            vista.mostrarMensajeErrorModificarCorreo();
        }
    }
    
    public void modificarSueldoEmpleado() throws JAXBException{
        int idEmpleado = vista.obtenerEmpleadoID();
        double nuevoSueldo = vista.obtenerNuevoSueldo();
        boolean exito;
        
        exito = modelo.modificarSueldoEmpleado(idEmpleado, nuevoSueldo);
        
        if(exito == true){
            vista.mostrarMensajeSueldoModificado();
        }else{
            vista.mostrarMensajeErrorModificarSueldo();
        }
        
        
    }
}
