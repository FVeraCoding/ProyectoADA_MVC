
package Controlador;

import Modelo.Logica.ModeloFernando;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;


public class Controlador {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        ModeloFernando modelo = new ModeloFernando();
        
        System.out.println(modelo.getUltimoCocheID());
        System.out.println(modelo.getUltimoEmpleadoID());
    }
}
