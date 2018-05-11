package by.dima.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "spitter")
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spitter")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "spitter")
    private Set<Spittle> spittles;

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

    public Set<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(Set<Spittle> spittles) {
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