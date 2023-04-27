import java.util.HashSet;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class User {
    private HashSet<Role> roles;

    public User(){
        this.roles = new HashSet<>();
    }

    public User(Role role){
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
}
