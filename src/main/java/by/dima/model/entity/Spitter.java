package by.dima.model.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "spitter")
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spitter")
    private int id;

    @Pattern(regexp = "[\\w\\d]+", message = "username mast be from symbols or digits")
    @Size(min = 4, max = 15, message = "")
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Size(min = 6, max = 15)
    @Column(name = "password")
    private String password;

    @Email(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
//    @Size(min = 6, max = 50)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "spitter")
    private List<Spittle> spittles;

    public Spitter() {
    }

    public Spitter(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.email = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spitter spitter = (Spitter) o;
        return id == spitter.id &&
                Objects.equals(username, spitter.username) &&
                Objects.equals(password, spitter.password) &&
                Objects.equals(email, spitter.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, spittles);
    }
}