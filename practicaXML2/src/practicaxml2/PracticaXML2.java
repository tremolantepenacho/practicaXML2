/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaxml2;

import org.w3c.dom.*;
import javax.xml.parsers.* ;
import javax.xml.transform.* ;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hector
 */
public class PracticaXML2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Jugador[] lista=new Jugador[3];
            lista[0]=new Jugador("Carlos",10,1000,5);
            lista[1]=new Jugador("Pepe",18,800,4);
            lista[2]=new Jugador("María",52,81000,15);
           
            
            
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            
            DOMImplementation implementacion = builder.getDOMImplementation() ;
            Document documento = implementacion.createDocument(null, "usuarios", null);
            documento.setXmlVersion("1.0"); 
            
            
            for (int i=0;i<lista.length;i++){
                Element usuario=documento.createElement("usuario");
                
                
                Node nombre=documento.createElement("nombre");
                nombre.setTextContent(lista[i].getNombre());
                usuario.appendChild(nombre);
                
                Node  horas=documento.createElement("horas");
                horas.setTextContent(""+lista[i].getHoras());
                usuario.appendChild(horas);
                
                Node  punt=documento.createElement("puntuacion");
                punt.setTextContent(""+lista[i].getPuntuacion());
                usuario.appendChild(punt);
                
                Node  nivel=documento.createElement("nivel");
                nivel.setTextContent(""+lista[i].getNivel());
                usuario.appendChild(nivel);
                
                documento.getDocumentElement().appendChild(usuario);
                
            }
            
            
            Source fuente= new DOMSource(documento);
            Result resultado = new StreamResult(new java.io.File("jugadoresJava.xml"));
            Transformer transf;
            try {
                transf = TransformerFactory.newInstance().newTransformer();
                transf.transform (fuente, resultado ) ;
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(PracticaXML2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(PracticaXML2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(PracticaXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
