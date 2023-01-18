package Model;
/**
 * Eine Klasse um Bilder mit Urls zu verknüpfen
 * @author Kernegger Leopold
 * @version 29.9.22
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
public class WortEintrag{
    private String wort;
    private String url;

    /**
     * constructor
     * @param wort das Wort
     * @param url die URL
     * @throws MalformedURLException wenn URL falsch
     */
    public WortEintrag (String wort, String url) throws MalformedURLException, MalformedInputException{
        this.setUrl(url);
        this.setWort(wort);
    }

    /**
     * checkt URL
     * @param url die URL
     * @return ob die URL ok ist
     */
    public static boolean checkURL(String url){
        try {
            URL test  = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }
    /**
     * ein setter für
     * @param url die URL
     * @throws MalformedURLException url falsch
     */
    public void setUrl(String url) throws MalformedURLException {
        if(checkURL(url)){
            this.url = url;
        }
        else{
            throw new MalformedURLException("URL doesnt match");
        }
    } 
    /**
     * ein geter
     * @return die URL
     */
    public String getUrl() {
        return url;
    }
    /**
     * ein setter
     * @param wort das Wort
     */
    public void setWort(String wort) throws MalformedInputException{
        if(wort != null && wort.length() >= 2){
            this.wort = wort;
        } else{
            throw new MalformedInputException(wort.length());
        }
    }
    /**
     * ein getter
     * @return das Wort
     */
    public String getWort() {
        return wort;
    }
    /**
     * to String override
     */
    @Override
    public String toString() {
        String test  = this.wort;
        test = test + "; ";
        test = test + this.url;
        return test;
    }
}