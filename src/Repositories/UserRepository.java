package Repositories;

import Domains.UserDomain;
import Repositories.Implementation.IMemoryUserRepository;

import java.util.Map;
import java.util.UUID;

public class UserRepository extends GenericRepository<UserDomain>  implements IMemoryUserRepository {

    public UserRepository() {
        super("users.dat");
    }
    public UserDomain findByEmail(String email) {
        for (UserDomain user : storage.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public UserDomain login(String email, String password) {
        UserDomain user = findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public UUID findUserIdByEmail(String email) {
        for (Map.Entry<UUID, UserDomain> entry : storage.entrySet()) {
            if (entry.getValue().getEmail().equalsIgnoreCase(email)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
