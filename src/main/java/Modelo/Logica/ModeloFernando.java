package Modelo.Logica;

import Modelo.Clases.Coche;
import Modelo.Clases.Sucursal;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModeloFernando {

    Document documento;
    File archivo;
    int contadorID;

    public ModeloFernando() {

        this.archivo = new File("src/main/resources/concesionario.xml");

        try {
            this.documento = getDOM(archivo);
        } catch (SAXException ex) {
            Logger.getLogger(ModeloFernando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModeloFernando.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ModeloFernando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Document getDOM(File archivo) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(archivo);
        return doc;
    }

    public int getUltimoCocheID() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        Document doc = getDOM(archivo);
        XPath xpath = XPathFactory.newInstance().newXPath();
        String xPathExpression = "//coche/@id";
        NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

        int ultimoID = Integer.valueOf(nodos.item(nodos.getLength() - 1).getTextContent());

        return ultimoID;

    }

    public int getUltimoEmpleadoID() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
        Document doc = getDOM(archivo);
        XPath xpath = XPathFactory.newInstance().newXPath();
        String xPathExpression = "//empleado/@id";
        NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

        int ultimoID = Integer.valueOf(nodos.item(nodos.getLength() - 1).getTextContent());

        return ultimoID;
    }

    public void insertarCoche(Sucursal sucursal) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        int id = this.getUltimoCocheID()+1;
        String marca;
        String modelo;
        String fchFabricacion;
        double precio;
        String color;
        int numPuertas;
        String combustible;
        
    }

    public void insertarEmpleado(Sucursal sucursal) {

    }

}
