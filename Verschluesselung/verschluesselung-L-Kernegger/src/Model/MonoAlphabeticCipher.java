package Model;
public class MonoAlphabeticCipher implements Cipher{
    private String secretAlphabet;

    public MonoAlphabeticCipher(String secretAlphabet) {
        setSecretAlphabet(secretAlphabet);
    }

    public MonoAlphabeticCipher() {
    }


    @Override
    public String encrypt(String text) {
        text = text.toLowerCase();
        char d;
        boolean done = false;
        char e = 'a';
        char[] alphabet = secretAlphabet.toCharArray();
        char[] standard = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};
        char[] crypt = text.toCharArray();
        String r = "";
        for (int i = 0; i < crypt.length; i++) {
            d = crypt[i];
            for (int j = 0; j < standard.length && !done; j++) {
                if (d == ' '){
                    e = ' ';
                    done = true;
                }
                if(d == standard[j]){
                    e = alphabet[j];
                    done = true;
                }
            }
            r = r + e;
            done = false;
        }
        return r;
    }

    @Override
    public String decrypt(String text) {
        text = text.toLowerCase();
        boolean done = false;
        char d;
        char e = 'a';
        char[] alphabet = secretAlphabet.toCharArray();
        char[] standard = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};
        char[] crypt = text.toCharArray();
        String r = "";
        for (int i = 0; i < crypt.length; i++) {
            d = crypt[i];
            for (int j = 0; j < standard.length && !done; j++) {
                if (d == ' '){
                    e = ' ';
                    done = true;
                }
                if(d == alphabet[j]){
                    done = true;
                    e = standard[j]; 
                }
            }
            done = false;
            r = r + e;
        }
        return r;
    }


    public String getSecretAlphabet() {
        return secretAlphabet;
    }

    public boolean alphabetChecker(char[] x){
        for (int i = 0; i < x.length; i++) {
            char z = x[i];
            for (int j = 0; j < x.length; j++) {
                if (z == x[j]){
                    return false;
                }
            }
        }
        return true;
    }


    protected void setSecretAlphabet(String secretAlphabet) {
        if(secretAlphabet.length() != 30 && !this.alphabetChecker(secretAlphabet.toCharArray())){
           throw new IllegalArgumentException();             
        }
        this.secretAlphabet = secretAlphabet;
    }
}
