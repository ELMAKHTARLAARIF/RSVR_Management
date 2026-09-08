package Repositories.Implementation;

import java.util.List;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
public interface IGenericRepository<T> {
    UUID create(T entity);
    void update(UUID id, T entity);
    void delete(UUID id);
    List<T> getAll();
    T findById(UUID id);
    void affiche(UUID id);
}