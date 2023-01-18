package Model;
import java.io.*;
public class Save_Worttrainer {


    /**
     * speichert Worttrainer
     * @param file die File
     * @param toSave der Worttrainer der gespeichert werden woll
     * @throws IOException falls des IO net geht
     */    
    public static void speichern(File file, WortTrainer toSave ) throws IOException {
        File f = file;
        BufferedWriter outputStream = null;
        WortEintrag[] temp = toSave.getTraingingsListe().getEintraege();
        try { 
            outputStream = new BufferedWriter(new FileWriter(f));
            for(int i = 0;i < temp.length; i++){
                outputStream.write("" + temp[i].getWort() + "\n");
                outputStream.write("" + temp[i].getUrl()+ "\n");
            }
        } finally {
            if (outputStream != null){
                outputStream.close();
            }
        }
    }

    
    /** 
     * @param fileName
     * @param toSave
     * @throws IOException
     */
    public static void speichern(String fileName, WortTrainer toSave ) throws IOException {
        speichern(new File( fileName), toSave);
    }

    /**
     * default methode der anderen Speichern methode
     * @param toSave der Worttrainer der gespeichert werden soll
     * @throws IOException falls des IO net geht
     */
    public static void speichern(WortTrainer toSave) throws IOException {
        speichern("debug.SEW", toSave);
    }

    /**
     * 
     * @param filename
     * @return
     * @throws IOException
     */
    public static WortTrainer load(File f) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(f));
        int r=0,p=0,h=0,c=0;
        String t = "", k = "", g = "";
        while((r=br.read())!=-1){
            t = t + (char)r;
            if((char)r == '\n'){
                p++;
            }
            r++;
        }
        char[] j = t.toCharArray();
        WortEintrag[] temp = new WortEintrag[p/2];
        for (int i = 0; i < j.length; i++) {
            if(h == 2){
                temp[c] = new WortEintrag(k, g);
                c++;
                k = "";
                g = "";
                h = 0;
            }
            if(j[i] == '\n'){
                if(h == 0){
                    i++;
                }
                h++;
            }
            if(h == 0){
                k = k + j[i];
            }
            if(h == 1){
                g = g + j[i];
            }
        }
        if(h == 2){
            temp[c] = new WortEintrag(k, g);
            c++;
            k = "";
            g = "";
            h = 0;
        }
        br.close();
        WortTrainer y = new WortTrainer(new WortListe(temp));
        y.toString();
        return y;
    }
    
    /** 
     * @return WortTrainer
     * @throws IOException
     */
    public static WortTrainer load() throws IOException{
        return load("debug.SEW");
    }
    
    /** 
     * @param path
     * @return WortTrainer
     * @throws IOException
     */
    public static WortTrainer load(String path) throws IOException{
        return load(new File(path));
    }
}
