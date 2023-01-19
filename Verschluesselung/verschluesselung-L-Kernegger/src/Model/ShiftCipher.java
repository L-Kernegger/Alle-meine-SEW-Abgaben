package Model;
public class ShiftCipher extends MonoAlphabeticCipher{

    public ShiftCipher(int value) {
        char[] a = new char[30];
        char[] c= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};
        for (int i = 0; i < c.length; i++) {
            if((i+value) < 30){
                a[i] = c[i+value];
            }else {
                a[i] = c[(i+value)-30];
            }
        }
        String secretAlphabet = new String(a);
        this.setSecretAlphabet(secretAlphabet);
    }

    public ShiftCipher(String secretAlphabet) {
        super(secretAlphabet);
    }

    public void setShiftValue(int value){
        char[] a = new char[30];
        char[] c= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};
        for (int i = 0; i < c.length; i++) {
            if(i+value < 30){
                a[i] = c[i+value];
            }else {
                a[i] = c[(i+value)-30];
            }
        }
        super.setSecretAlphabet(new String(a));
    }


    
}
