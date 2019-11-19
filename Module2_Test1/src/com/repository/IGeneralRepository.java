package com.repository;

import java.util.List;

public interface IGeneralRepository<E> {
    List<E> findAll();

    void add(E e);

    void delete(int id);

    void edit(int id, E e);
}
