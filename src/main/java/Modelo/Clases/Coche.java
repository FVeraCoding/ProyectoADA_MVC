
package Modelo.Clases;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "marca", "modelo", "creacion", "precio", "color", "numPuertas", "combustible" })
public class Coche {

    private int id;
    private String marca;
    private String modelo;
    private int creacion;
    private double precio;
    private String color;
    private int numPuertas;
    private String combustible;
    

    public Coche() {
    }
    
    

    public Coche(String marca, String modelo, int creacion, double precio, String color, int numPuertas, String combustible) {
        
        this.marca = marca;
        this.modelo = modelo;
        this.creacion = creacion;
        this.precio = precio;
        this.color = color;
        this.numPuertas = numPuertas;
        this.combustible = combustible;
    }
    
    

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlElement(name = "modelo")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @XmlElement(name = "creacion")
    public int getCreacion() {
        return creacion;
    }

    public void setCreacion(int creacion) {
        this.creacion = creacion;
    }

    @XmlElement(name = "precio")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlElement(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlElement(name = "num_puertas")
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @XmlElement(name = "combustible")
    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}
