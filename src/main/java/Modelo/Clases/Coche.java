
package Modelo.Clases;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "marca", "modelo", "fchFabricacion", "precio", "color", "numPuertas", "combustible" })
public class Coche {

    private int id;
    private String marca;
    private String modelo;
    private Date fchFabricacion;
    private double precio;
    private String color;
    private int numPuertas;
    private String combustible;

    public Coche(int id, String marca, String modelo, Date fchFabricacion, double precio, String color, int numPuertas, String combustible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.fchFabricacion = fchFabricacion;
        this.precio = precio;
        this.color = color;
        this.numPuertas = numPuertas;
        this.combustible = combustible;
    }
    
    

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlElement
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @XmlElement(name = "creacion")
    public Date getFchFabricacion() {
        return fchFabricacion;
    }

    public void setFchFabricacion(Date fchFabricacion) {
        this.fchFabricacion = fchFabricacion;
    }

    @XmlElement
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlElement
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

    @XmlElement
    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}
