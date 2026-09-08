package Repositories.Implementation;

import java.util.UUID;

public interface IGenericRepository<T> {
    UUID create(T entity);
    void update(UUID id, T entity);
    void delete(UUID id);
    T findById(UUID id);
    void affiche(UUID id);
}