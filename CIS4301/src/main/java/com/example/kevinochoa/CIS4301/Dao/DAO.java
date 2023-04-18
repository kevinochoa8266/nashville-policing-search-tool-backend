package com.example.kevinochoa.CIS4301.Dao;


import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();

    void create(T t);

    Optional<T> get(Long id);

    void update(T t, Long id);

    void delete(Long id);
}
