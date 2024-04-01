package com.warrios.seminaire.services.crudInterface;


import java.util.List;
import java.util.Optional;

public interface CrudInterface<T> {
     T findById(Integer id);

     List<T> findAll();

     T save(T t);

     void delete(Integer id);

     T update(T update, Integer id);
}
