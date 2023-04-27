import java.io.File;

import javax.sound.midi.Soundbank;

/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Main {
    public static void main(String[] args) {
        User leopold = new User();
        User kevin = new User();

        Resource File = new Resource();
        Resource Programm = new Resource();
        Resource Script = new Resource();

        File.addRole(new Reader());
        Script.addRole(new Editor());
        Script.addRole(new Reader());
        Programm.addRole(new Executioner());

        kevin.addRole(new Reader());
        kevin.addRole(new Editor());
        System.out.println(kevin.RoleDesc());
        kevin.addRole(new Editor());
        System.out.println(kevin.RoleDesc());

        leopold.addRole(new Executioner());

        System.out.println("Kevin auf Programm " + Programm.accesible(kevin));
        System.out.println("leopold auf Script " + Script.accesible(leopold));
        System.out.println("leopold auf Programm " + Programm.accesible(leopold));
    }
}
