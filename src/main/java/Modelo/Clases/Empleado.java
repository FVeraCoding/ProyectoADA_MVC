/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo.Clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "nombre", "apellidos", "dni", "puesto", "telefono", "correo", "sueldo"})
public class Empleado {

    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String puesto;
    private int telefono;
    private String correo;
    private double sueldo;
    
    

    public Empleado() {
    }
    

    
    public Empleado(String nombre, String apellidos, String dni, String puesto, int telefono, String correo, double sueldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.puesto = puesto;
        this.telefono = telefono;
        this.correo = correo;
        this.sueldo = sueldo;
  
    }    

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @XmlElement(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlElement(name = "puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @XmlElement(name = "telefono")
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @XmlElement(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlElement(name = "sueldo")
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
