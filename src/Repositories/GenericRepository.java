package Repositories;

import Repositories.Implementation.IGenericRepository;
import java.io.*;
import java.util.*;

public class GenericRepository<T> implements IGenericRepository<T> {
    protected Map<UUID, T> storage = new HashMap<>();
    private final String filePath;

    public GenericRepository(String fileName) {
        this.filePath = fileName;
        loadFromFile();
    }

    @Override
    public UUID create(T entity) {
        UUID id = UUID.randomUUID();
        storage.put(id, entity);
        saveToFile();
        System.out.println("Stored entity with ID: " + id);
        return id;
    }

    @Override
    public void update(UUID id, T entity) {
        if (storage.containsKey(id)) {
            storage.put(id, entity);
            saveToFile();
            System.out.println("Updated entity with ID: " + id);
        } else {
            System.out.println("Entity with ID " + id + " not found.");
        }
    }

    @Override
    public void delete(UUID id) {
        storage.remove(id);
        saveToFile();
        System.out.println("Removed entity with ID: " + id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public T findById(UUID id) {
        return storage.get(id);
    }

    @Override
    public void affiche(UUID id) {
        System.out.println(storage.get(id));
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(storage);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            storage = (Map<UUID, T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}