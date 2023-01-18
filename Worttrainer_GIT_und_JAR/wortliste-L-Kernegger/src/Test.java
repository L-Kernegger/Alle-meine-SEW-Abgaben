import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;

import Controller.*;
import Model.*;


public class Test {
    
    /** 
     * @param args
     * @throws MalformedURLException
     * @throws MalformedInputException
     * @throws IOException
     */
    public static void main(String[] args) throws MalformedURLException, MalformedInputException, IOException{
        WortEintrag x = new WortEintrag("Auto", "https://cdn.motor1.com/images/mgl/EKJ2B/s3/auto-neuheiten-2021-2022.jpg");
        WortEintrag z = new WortEintrag("Fuchs","https://www.br.de/kinder/hoeren/doremikro/fuchs-und-gans-108~_v-img__16__9__xl_-d31c35f8186ebeb80b0cd843a7c267a0e0c81647.jpg?version=ff0a4");
        WortEintrag k = new WortEintrag("Ronald Reagan","https://upload.wikimedia.org/wikipedia/commons/7/7a/Ronald_Reagan_1985_presidential_portrait_%28cropped%29.jpg");
        WortEintrag eu = new WortEintrag("Kuh", "https://upload.wikimedia.org/wikipedia/commons/8/88/Melchsee-Frutt_Kuh.jpg");
        WortListe y = new WortListe(1);
        y.addEintrag(x);y.addEintrag(z);y.addEintrag(k);y.addEintrag(eu);
        System.out.println("Wortliste to String / add check: ");
        System.out.println(y.toString());
        WortTrainer i = new WortTrainer(y);
        i.zufall();
        System.out.println("random check");
        System.out.println(i.wort());
        System.out.println("check check:");
        System.out.println(i.check("Fuchs"));
        i.zufall();
        System.out.println(i.checkIgnoreCase("FuchS"));
        System.out.println(i.check("FuHchs"));
        Save_Worttrainer.speichern(i);       
        y.deleteEintraege("Fuchs");
        System.out.println("Delete Test:");
        System.out.println(y.toString());
        y.assertionTest();
        System.out.println("kaskjdkjaskjd");
        WortTrainer p =  Save_Worttrainer.load("debug.SEW");
        System.out.println(p.toString());
        new Controller("debug.SEW");



    }
       

}
