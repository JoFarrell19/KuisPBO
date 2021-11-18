package Model;

public class User {
    private int idUser;
    private String name;
    private String email;
    private String password;
    private int idCategory;
    
    public User(String name, String email, String password, int idCategory) {
        
        this.name = name;
        this.email = email;
        this.password = password;
        this.idCategory = idCategory;
    }
    public User() {
    }


    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

}
