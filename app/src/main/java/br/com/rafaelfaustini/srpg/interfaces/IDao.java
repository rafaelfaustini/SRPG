package br.com.rafaelfaustini.srpg.interfaces;

import java.util.List;

public interface IDao <I, T> { // Id, Entity
    public T get(I id) throws Exception;

    public List<T> getAll() throws Exception;

    public void insert(T t) throws Exception;

    public void update(T t) throws Exception;

    public void delete(I id) throws Exception;
}
