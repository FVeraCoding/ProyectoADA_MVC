
package Modelo.Clases;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "concesionario")
public class Concesionario {
   
    private String nombre;
    private String CEO;
    private ArrayList<Sucursal> listaSucursales = new ArrayList<>();

    public Concesionario() {
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "CEO")
    public String getCEO() {
        return CEO;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    @XmlElementWrapper(name = "sucursales")
    @XmlElement(name = "sucursal")
    public ArrayList<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(ArrayList<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    @Override
    public String toString() {
        return "Concesionario: " + "\n nombre=" + nombre + "\n CEO=" + CEO + "\n Número de sucursales: " + listaSucursales.size();
    }
    
    
    
}
