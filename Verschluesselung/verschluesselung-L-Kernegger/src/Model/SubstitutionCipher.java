package Model;
public class SubstitutionCipher extends MonoAlphabeticCipher{

    public SubstitutionCipher(String secretAlphabet) {
        super(secretAlphabet);
    }

    @Override
    protected void setSecretAlphabet(String secretAlphabet) {
        super.setSecretAlphabet(secretAlphabet);
    }
}