package Modelo.Logica;

import Modelo.Clases.Coche;
import Modelo.Clases.Concesionario;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
    Concesionario concesionario;

    public ModeloFernando() throws JAXBException {

        this.archivo = new File("src/main/resources/concesionario.xml");
        this.concesionario = this.deserializarConcesionario();

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

    public Concesionario deserializarConcesionario() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Concesionario.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        this.concesionario = (Concesionario) unmarshaller.unmarshal(this.archivo);

        return concesionario;
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

    public void insertarCoche(Coche coche, int idSucursal) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, JAXBException {

        Sucursal sucursal = obtenerSucursal(idSucursal);

        if (sucursal != null) {

            sucursal.getListaCoches().add(coche);

            JAXBContext context = JAXBContext.newInstance(Concesionario.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            marshaller.marshal(concesionario, archivo);
            System.out.println("Coche agregado y archivo XML actualizado.");

        } else {
            System.out.println("Sucursal no encontrada.");
        }
    }

    public void insertarEmpleado(Empleado empleado, int idSucursal) throws JAXBException {
        Sucursal sucursal = obtenerSucursal(idSucursal);

        if (sucursal != null) {

            sucursal.getListaEmpleados().add(empleado);

            JAXBContext context = JAXBContext.newInstance(Concesionario.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            marshaller.marshal(concesionario, archivo);
            System.out.println("Coche agregado y archivo XML actualizado.");

        } else {
            System.out.println("Sucursal no encontrada.");
        }

    }

    public Sucursal obtenerSucursal(int id) throws JAXBException {

        ArrayList<Sucursal> listaSucursales = concesionario.getListaSucursales();

        for (Sucursal sucursal : listaSucursales) {
            if (sucursal.getId() == id) {
                return sucursal;
            }
        }

        return null;

    }

}
