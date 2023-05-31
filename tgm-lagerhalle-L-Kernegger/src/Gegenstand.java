import java.util.Objects;

public class Gegenstand implements Comparable<Gegenstand>{
    private String name;
    private int weight;
    private Gegenstandstyp typ;

    public Gegenstand(String name){
        this.name=name;
    }

    public Gegenstand(String name, int weight, Gegenstandstyp typ){
        this.name = name;
        this.typ = typ;
        this.weight = weight;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Gegenstandstyp getTyp() {
        return typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gegenstand that = (Gegenstand) o;
        return weight == that.weight && Objects.equals(name, that.name) && typ == that.typ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, typ);
    }

    @Override
    public int compareTo(Gegenstand o) {
        if(o.getWeight() == this.getWeight()){
            return 0;
        }
        if(o.getWeight() < this.getWeight()){
            return -1;
        }
        if(o.getWeight() > this.getWeight()){
            return 1;
        }
        return 0;
    }
}
