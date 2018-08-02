package by.dima.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "spittle")
public class Spittle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spittle")
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "time")
    private Date time;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longtitude")
    private Double longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_spitter")
    private Spitter spitter;

    public Spittle() {
    }

    public Spittle(String message, Date time) {
        this(0, message, time, null, null);
    }

    public Spittle(int id, String message, Date time, Double longitude, Double latitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spittle spittle = (Spittle) o;
        return id == spittle.id &&
                Objects.equals(message, spittle.message) &&
                Objects.equals(time, spittle.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, time, latitude, longitude, spitter);
    }
}