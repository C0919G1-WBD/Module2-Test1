package com.service;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAll();

    void add(E e);

    void delete(int id);

    void edit(int id, E e);
}
