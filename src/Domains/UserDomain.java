package Domains;
import java.io.Serializable;
import java.util.UUID;

public class UserDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    private String FullName;
    private String Email;
    private String Phone;
    private String Password;
    private static final int VALID_PASSWORD_LENGTH = 8;


    public UserDomain(String fullName, String email, String phone, String password) {
        setFullName(fullName);
        setEmail(email);
        setPhone(phone);
        setPassword(password);
    }

    public String getFullName() { return this.FullName; }
    public String getEmail() { return this.Email; }
    public String getPhone() { return this.Phone; }
    public String getPassword() { return this.Password; }

    public void setFullName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid name!");
        }
        this.FullName = name;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Enter a valid Email!");
        }
        this.Email = email;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a valid phone number!");
        }
        this.Phone = phone;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < VALID_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password must be at least 8 characters!");
        }
        this.Password = password;
    }
}