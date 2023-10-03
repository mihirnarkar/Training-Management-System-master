package in.mindcraft.pojos;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private int id;

    @Column(name = "username")
    private int username;

    @Column(name = "password")
    private String password;

    public User(){

    }

    public User(int username,String password){
        this.username = username;
        this.password = password;
    }

    public void setUsername(int username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public int getId(){
        return this.id;
    }

}