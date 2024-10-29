/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Logica;

import Modelo.Clases.Coche;
import Modelo.Clases.Sucursal;
import java.util.List;

/**
 *
 * @author Artur
 */
public class ModelArtur {
    public int getNumCoches(Sucursal sucursal){
        List<Coche> listaCoche = sucursal.getListaCoches();
        int numCoches = listaCoche.size();
        return numCoches;
    }
}
