package xmlsitereader;

/**
 *
 * @author spaden
 */
public class URL {

    String urlPath;
    boolean isPage;
    boolean isDocument;
    boolean isImage;

    public URL(String url, boolean page, boolean document, boolean image) {        
        urlPath = url;
        isPage = page;
        isDocument = document;
        isImage = image;
    }
    
    public void setIsPage(boolean page) {
        this.isPage = page;
    }
    
    public void setIsDocument(boolean document) {
        this.isDocument = document;
    }
    
    public void setIsImage(boolean image) {
        this.isImage = image;
    }
    
    
    private String getURL() {
        return urlPath;
    }
    

}
