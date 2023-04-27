/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Reader implements Role{
    private final String name = "Reader";
    private final String description = "Can Read Documents that have already been saved to the space";

    public String description(){
        return description;
    }

    public String name(){
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reader other = (Reader) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }
    @Override
    public String toString(){
        return(name + ":\n" + description + "\n");
    }
}
