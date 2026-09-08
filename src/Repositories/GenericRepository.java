package Repositories;

import Repositories.Implementation.IGenericRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GenericRepository<T> implements IGenericRepository<T> {

    protected Map<UUID, T> storage = new HashMap<>();

    @Override
    public UUID create(T entity) {
        UUID id = UUID.randomUUID();
        storage.put(id, entity);
        System.out.println("Stored entity with ID: " + id);
        return id;
    }

    @Override
    public void update(UUID id, T entity) {
        if (storage.containsKey(id)) {
            storage.put(id, entity);
            System.out.println("Updated entity with ID: " + id);
        } else {
            System.out.println("Entity with ID " + id + " not found.");
        }
    }

    @Override
    public void delete(UUID id) {
        storage.remove(id);
        System.out.println("Removed entity with ID: " + id);
    }

    @Override
    public T findById(UUID id) {
        return storage.get(id);
    }

    @Override
    public void affiche(UUID id) {
        System.out.println(storage.get(id));
    }
}