public enum Gegenstandstyp {
    TSS("Kasten"),
    TSM("Tisch"),
    TSL("Bett");

    private final String desc;

    private Gegenstandstyp(String desc) {
        this.desc = desc;
    }

    public String getDescription(){
        return this.desc;
    }
}
