package xmlsitereader;

import java.io.FileNotFoundException;

/**
 *
 * @author spaden
 */
public class XMLSiteReader {

    public static void main(String[] args) throws FileNotFoundException {
        XML newXML = new XML();
        newXML.parseXML();
        newXML.printResults();     
    }    
}
