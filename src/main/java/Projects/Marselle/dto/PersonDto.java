package Projects.Marselle.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {

    private int id;

    @NotNull
    @Size(min = 2, max = 100, message = "Username should be between 2 and 100")
    private String username;


    @Size(min = 2, max = 100, message = "First name should be between 2 and 100")
    private String first_name;

    private String phoneNumber;

    @Size(min = 2, max = 100, message = "Second name should be between 2 and 100")
    private String second_name;

    private boolean isWorker;

    @NotNull
    @Size(min = 2, max = 100, message = "Password should be between 2 and 100")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonDto() {

    }


    public PersonDto(String username, String first_name, String second_name, String password) {
        this.username = username;
        this.first_name = first_name;
        this.second_name = second_name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
