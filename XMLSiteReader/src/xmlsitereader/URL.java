package xmlsitereader;
/**
 *
 ** @author Stephen Paden 
 ** Company: Eagle Creek Software Services 
 ** Date: 2/27/2014
 *
 */
public class URL {
    private String urlPath;
    private boolean isPage;
    private boolean isDocument;
    private boolean isImage;

    // watch his every move, super constructor!
    public URL(String urlPath, boolean isPage, boolean isDocument, boolean isImage) {        
        this.urlPath = urlPath;
        this.isPage = isPage;
        this.isDocument = isDocument;
        this.isImage = isImage;
    }
    
    // get & set
    public void setURLPath(String urlPath) { this.urlPath =  urlPath; }
    public void setIsPage(boolean page) { this.isPage = page; }    
    public void setIsDocument(boolean document) { this.isDocument = document; }    
    public void setIsImage(boolean image) { this.isImage = image; }    
    public String getURL() { return urlPath; }    
    public boolean getIsPage() { return isPage; }    
    public boolean getIsDocument() { return isDocument; }    
    public boolean getIsImage() { return isImage; }
    

}
