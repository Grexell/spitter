package by.dima.dao;

import by.dima.model.entity.Spitter;

import java.util.List;

public interface SpitterDAO {
    void addSpitter(Spitter spitter);
    void updateSpitter(Spitter spitter);
    void deleteSpitter(Spitter spitter);
    Spitter getSpitterById(int id);
    List<Spitter> getAll();
}
