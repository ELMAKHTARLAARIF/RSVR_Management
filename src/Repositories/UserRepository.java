package Repositories;

import Domains.UserDomain;
import Repositories.Implementation.IMemoryUserRepository;

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
}
