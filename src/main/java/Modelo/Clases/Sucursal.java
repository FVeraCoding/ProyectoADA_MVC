package Modelo.Clases;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Sucursal {

    private int id;
    private String jefe;
    private String localizacion;
    private int telefono;
    private ArrayList<Coche> listaCoches;
    private ArrayList<Empleado> listaEmpleados; 

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "jefe")
    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    @XmlElement(name = "localizacion")
    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @XmlElement(name = "telefono")
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @XmlElementWrapper(name = "coches")
    @XmlElement(name = "coche")
    public ArrayList<Coche> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(ArrayList<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }

    @XmlElementWrapper(name = "empleados")
    @XmlElement(name = "empleado")
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "Sucursal:" + "\n id: " + id + "\n jefe: " + jefe + "\n localizacion: " + localizacion + "\n telefono: " + telefono + "\n nº de coches: " + listaCoches.size() + "\n nº de enmpleados: " + listaEmpleados.size();
    }

    
    
}
