package xmlsitereader;

import java.io.FileNotFoundException;
/**
 *
 ** @author Stephen Paden 
 ** Company: Eagle Creek Software Services 
 ** Date: 2/26/2014
 *
 */
public class XMLSiteReader {

    public static void main(String[] args) throws FileNotFoundException {
        XML newXML = new XML();
        newXML.parseXML();
        newXML.printResults();     
    }    
}
