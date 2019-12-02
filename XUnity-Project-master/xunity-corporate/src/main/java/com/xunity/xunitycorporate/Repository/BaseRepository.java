package com.xunity.xunitycorporate.Repository;

import java.util.List;

public interface BaseRepository<T, K> {
    void create(T t);
    void update(T t);
    void delete(K k);

    List<T> findAll();
    T findById(K k);
}
