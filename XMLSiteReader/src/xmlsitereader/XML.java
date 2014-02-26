package xmlsitereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 ** @author Stephen Paden Company: 
 ** Eagle Creek Software Services 
 ** Date: 2/26/2014
 *
 */
public class XML {

    private static int sumPages = 0;
    private static int sumDocuments = 0;
    private static int sumOtherItems = 0;
    private int sumTotal = 0;
    public BufferedReader newBufferedWriter = null;
  
    public XML() {
    }

    public void parseXML() throws FileNotFoundException {

        try {

            File fXmlFile = new File("sitemap.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("loc");

            System.out.println("Base element :" + doc.getDocumentElement().getNodeName());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getChildNodes().toString().contains("loc")) {
                    if (nNode.getTextContent().endsWith(".html")
                            || nNode.getTextContent().endsWith(".htm")
                            || nNode.getTextContent().endsWith(".asp")
                            || nNode.getTextContent().endsWith(".jsp")
                            || nNode.getTextContent().endsWith(".php")) {
                        sumPages++;
                    } else if (nNode.getTextContent().endsWith(".doc")
                            || nNode.getTextContent().endsWith(".pdf")
                            || nNode.getTextContent().endsWith(".docx")) {
                        sumDocuments++;
                    } else {
                        sumOtherItems++;
                    }
                }
                System.out.println(nNode.getTextContent());

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
