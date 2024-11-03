package Modelo.Logica;

import Modelo.Clases.Coche;
import Modelo.Clases.Concesionario;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Modelo {

    File archivo;
    Concesionario concesionario;

    public Modelo() throws JAXBException {

        this.archivo = new File("src/main/resources/concesionario.xml");
        this.concesionario = this.deserializarConcesionario();

    }

    // INSERT
    public void insertarCoche(Coche coche, int idSucursal) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, JAXBException {

        Sucursal sucursal = getSucursalSegunID(idSucursal);

        if (sucursal != null) {

            sucursal.getListaCoches().add(coche);

            actualizarXML();

        } else {

        }
    }

    public void insertarEmpleado(Empleado empleado, int idSucursal) throws JAXBException {
        Sucursal sucursal = getSucursalSegunID(idSucursal);

        if (sucursal != null) {

            sucursal.getListaEmpleados().add(empleado);

            actualizarXML();

        } else {

        }

    }

    //READ 
    public int getNumeroCoches(int idSucursal) throws JAXBException {
        Sucursal sucursal = this.getSucursalSegunID(idSucursal);
        int numeroCoches = sucursal.getListaCoches().size();

        return numeroCoches;
    }

    public int getNumeroEmpleados(int idSucursal) throws JAXBException {
        Sucursal sucursal = this.getSucursalSegunID(idSucursal);
        int numeroEmpleados = sucursal.getListaEmpleados().size();

        return numeroEmpleados;
    }

    public Sucursal getSucursalSegunID(int id) throws JAXBException {

        ArrayList<Sucursal> listaSucursales = concesionario.getListaSucursales();

        for (Sucursal sucursal : listaSucursales) {
            if (sucursal.getId() == id) {
                return sucursal;
            }
        }

        return null;
    }

    public int getUltimoEmpleadoID() throws JAXBException {
        int ultimoID = 0;
        
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();
        for(Empleado empleado : listaEmpleadosConcesionario){
            if(empleado.getId()>ultimoID){
                ultimoID = empleado.getId();
            }
        }
        
        return ultimoID;
    }

    public int getUltimoCocheID() throws JAXBException{
        int ultimoID = 0;
        
        ArrayList<Coche> listaCochesConcesionario = this.getListaCochesConcesionario();
        for(Coche coche : listaCochesConcesionario){
            if(coche.getId() > ultimoID){
                ultimoID = coche.getId();
            }
        }
        return ultimoID;
    }

    public ArrayList<Coche> getListaCochesConcesionario() throws JAXBException {
        Concesionario concesionario = deserializarConcesionario();
        ArrayList<Coche> listaCoches = new ArrayList<>();

        for (Sucursal sucursal : concesionario.getListaSucursales()) {

            for (int i = 0; i < sucursal.getListaCoches().size(); i++) {
                listaCoches.add(sucursal.getListaCoches().get(i));
            }

        }

        return listaCoches;
    }

    public ArrayList<Empleado> getListaEmpleadosConcesionario() throws JAXBException {
        Concesionario concesionario = deserializarConcesionario();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        for (Sucursal sucursal : concesionario.getListaSucursales()) {

            for (int i = 0; i < sucursal.getListaEmpleados().size(); i++) {
                listaEmpleados.add(sucursal.getListaEmpleados().get(i));
            }

        }

        return listaEmpleados;
    }

    public Coche getCocheSegunID(int id) throws JAXBException {
        ArrayList<Coche> listaCoches = this.getListaCochesConcesionario();

        for (Coche coche : listaCoches) {
            if (coche.getId() == id) {
                return coche;
            }
        }

        return null;
    }

    public ArrayList<Coche> getListaCochesSegunMarca(String marca) throws JAXBException {
        ArrayList<Coche> listaCochesGeneral = this.getListaCochesConcesionario();
        ArrayList<Coche> listaCochesMarca = new ArrayList<>();

        for (Coche coche : listaCochesGeneral) {
            if (coche.getMarca().equalsIgnoreCase(marca)) {
                listaCochesMarca.add(coche);
            }
        }

        return listaCochesMarca;
    }

    public ArrayList<Coche> getListaCochesSegunNumeroPuertas(int numeroPuertas) throws JAXBException {
        ArrayList<Coche> listaCochesGeneral = this.getListaCochesConcesionario();
        ArrayList<Coche> listaCochesPuertas = new ArrayList<>();

        for (Coche coche : listaCochesGeneral) {
            if (coche.getNumPuertas() == numeroPuertas) {
                listaCochesPuertas.add(coche);
            }
        }

        return listaCochesPuertas;
    }

    public ArrayList<Coche> getListaCochesSegunCombustible(String combustible) throws JAXBException {
        ArrayList<Coche> listaCochesGeneral = this.getListaCochesConcesionario();
        ArrayList<Coche> listaCochesCombustible = new ArrayList<>();

        for (Coche coche : listaCochesGeneral) {
            if (coche.getCombustible().equalsIgnoreCase(combustible)) {
                listaCochesCombustible.add(coche);
            }
        }

        return listaCochesCombustible;
    }

    public ArrayList<Coche> getListaCochesSegunAñoFabricacion(int añoFabricacion) throws JAXBException {
        ArrayList<Coche> listaCochesGeneral = this.getListaCochesConcesionario();
        ArrayList<Coche> listaCochesAñoFabricacion = new ArrayList<>();

        for (Coche coche : listaCochesGeneral) {
            if (coche.getCreacion() == añoFabricacion) {
                listaCochesAñoFabricacion.add(coche);
            }
        }

        return listaCochesAñoFabricacion;
    }

    public Empleado getEmpleadoSegunID(int id) throws JAXBException {
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();

        for (Empleado empleado : listaEmpleadosConcesionario) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }

        return null;
    }

    public ArrayList<Empleado> getEmpleadoSegunPuesto(String puesto) throws JAXBException {
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();
        ArrayList<Empleado> listaEmpleadosPuesto = new ArrayList<>();
        
        for(Empleado empleado : listaEmpleadosConcesionario){
            if(empleado.getPuesto().equalsIgnoreCase(puesto)){
                listaEmpleadosPuesto.add(empleado);
            }
        }
        
        return listaEmpleadosPuesto;
    }
    
    // UPDATE
    
    public boolean modificarPrecioCoche(int idCoche, double nuevoPrecio) throws JAXBException{
        Coche coche = this.getCocheSegunID(idCoche);
        
        if(coche!=null){
            coche.setPrecio(nuevoPrecio);
            this.actualizarXML();
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean modificarJefeSucursal(int idSucursal, String nuevoJefe) throws JAXBException{
        Sucursal sucursal = this.getSucursalSegunID(idSucursal);
        if(sucursal != null){
            sucursal.setJefe(nuevoJefe);
            this.actualizarXML();
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean modificarTelefonoSucursal(int idSucursal, int nuevoTelefono) throws JAXBException{
        Sucursal sucursal = this.getSucursalSegunID(idSucursal);
        if(sucursal != null){
            sucursal.setTelefono(nuevoTelefono);
            this.actualizarXML();
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean modificarPuestoEmpleado(int idEmpleado, String nuevoPuesto) throws JAXBException{
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();
       
        
        for(Empleado empleado : listaEmpleadosConcesionario){
            if(empleado.getId() == idEmpleado){
                empleado.setPuesto(nuevoPuesto);
                this.actualizarXML();
                return true;
            }
        }
        return false;
    }
    
    public boolean modificarTelefonoEmpleado(int idEmpleado, int nuevoTelefono) throws JAXBException{
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();
        
        
        for(Empleado empleado : listaEmpleadosConcesionario){
            if(empleado.getId() == idEmpleado){
                empleado.setTelefono(nuevoTelefono);
                this.actualizarXML();
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean modificarCorreoEmpleado(int idEmpleado, String nuevoCorreo) throws JAXBException{
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();
        
        for(Empleado empleado : listaEmpleadosConcesionario){
            if(empleado.getId() == idEmpleado){
                empleado.setCorreo(nuevoCorreo);
                this.actualizarXML();
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean modificarSueldoEmpleado(int idEmpleado, double nuevoSueldo) throws JAXBException{
        ArrayList<Empleado> listaEmpleadosConcesionario = this.getListaEmpleadosConcesionario();
        
        for(Empleado empleado : listaEmpleadosConcesionario){
            if(empleado.getId() == idEmpleado){
                empleado.setSueldo(nuevoSueldo);
                this.actualizarXML();
                return true;
            }
        }
        
        return false;
    }

    // DELETE
    public void eliminarEmpleado(int id) throws JAXBException {
        Concesionario concesionario = this.deserializarConcesionario();
        ArrayList<Sucursal> listaSucursales = concesionario.getListaSucursales();

        for (Sucursal sucursal : listaSucursales) {
            ArrayList<Empleado> listaEmpleados = sucursal.getListaEmpleados();

            for (int i = 0; i < listaEmpleados.size(); i++) {
                if (listaEmpleados.get(i).getId() == id) {
                    listaEmpleados.remove(i);
                    actualizarXML();

                    return;
                }
            }
        }

    }

    public void eliminarCoche(int id) throws JAXBException {
        Concesionario concesionario = this.deserializarConcesionario();
        ArrayList<Sucursal> listaSucursales = concesionario.getListaSucursales();

        for (Sucursal sucursal : listaSucursales) {
            ArrayList<Coche> listaCoches = sucursal.getListaCoches();

            for (int i = 0; i < listaCoches.size(); i++) {
                if (listaCoches.get(i).getId() == id) {
                    listaCoches.remove(i);
                    actualizarXML();

                    return;
                }
            }
        }

    }

    //JAXB      
    public Concesionario deserializarConcesionario() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Concesionario.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        this.concesionario = (Concesionario) unmarshaller.unmarshal(this.archivo);

        return concesionario;
    }

    private void actualizarXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Concesionario.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        marshaller.marshal(concesionario, archivo);
    }

}
