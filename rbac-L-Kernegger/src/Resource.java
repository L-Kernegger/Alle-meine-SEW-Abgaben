import java.util.HashSet;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Resource {
    private HashSet<Role> roles;

    public Resource(){
        this.roles = new HashSet<>();
    }

    public Resource(Role role){
        this.roles = new HashSet<>();
        roles.add(role);
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public void removeRole(Role role){
        this.roles.remove(role);
    }

    public String RoleDesc(){
        return this.roles.toString();
    }

    public HashSet<Role> RoleList(){
        return this.roles;
    }

    public boolean accesible(User user){
        HashSet<Role> intersection = new HashSet<>(this.RoleList());
        intersection.retainAll(user.RoleList());

        return !intersection.isEmpty();
    }
}
