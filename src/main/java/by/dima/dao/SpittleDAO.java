package by.dima.dao;

import by.dima.model.entity.Spitter;
import by.dima.model.entity.Spittle;

import java.util.List;
import java.util.Set;

public interface SpittleDAO {
    void addSpittle(Spittle spittle);
    void updateSpittle(Spittle spittle);
    void deleteSpittle(Spittle spittle);
    Spittle getSpittleById(int id);
    List<Spittle> getAll();
    List<Spittle> getAllBySpitter(Spitter spitter);
    List<Spittle> getLast(int amount);
}