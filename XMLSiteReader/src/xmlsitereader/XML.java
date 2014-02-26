package xmlsitereader;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 ** @author Stephen Paden 
 ** Company: Eagle Creek Software Services 
 ** Date: 2/26/2014
 *
 */
public class XML {
    private static int sumPages = 0;
    private static int sumDocuments = 0;
    private static int sumOtherItems = 0;
    private int sumTotal = 0;
      
    public XML() {
    }

    public void parseXML() throws FileNotFoundException {

        try {
            
            File newFile = new File("sitemap.xml");
            DocumentBuilderFactory newDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder newBuilder = newDocumentBuilderFactory.newDocumentBuilder();
            Document doc = newBuilder.parse(newFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("loc");

            System.out.println("Base element :" + doc.getDocumentElement().getNodeName());

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node newNode = nodeList.item(temp);
                if (newNode.getChildNodes().toString().contains("loc")) {
                    if (newNode.getTextContent().endsWith(".html")
                            || newNode.getTextContent().endsWith(".htm")
                            || newNode.getTextContent().endsWith(".asp")
                            || newNode.getTextContent().endsWith(".jsp")
                            || newNode.getTextContent().endsWith(".php")) {
                        sumPages++;
                    } else if (newNode.getTextContent().endsWith(".doc")
                            || newNode.getTextContent().endsWith(".pdf")
                            || newNode.getTextContent().endsWith(".docx")) {
                        sumDocuments++;
                    } else {
                        sumOtherItems++;
                    }
                }
                System.out.println(newNode.getTextContent());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int calculateResults() {
        return sumTotal = sumPages + sumDocuments + sumOtherItems;
    }

    public void printResults() {
        System.out.println("Number of pages: " + sumPages);
        System.out.println("Number of documents: " + sumDocuments);
        System.out.println("Number of other items: " + sumOtherItems);
        System.out.println("Total number of elements: " + calculateResults());
    }
}
