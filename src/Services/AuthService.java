package Services;

import Domains.RoomDomain;
import Domains.UserDomain;
import Repositories.Implementation.IGenericRepository;
import Repositories.UserRepository;

import java.util.UUID;

public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID registerUser(String fullName, String email, String phone, String password) {
        UserDomain newUser = new UserDomain(fullName, email, phone, password);
        return userRepository.create(newUser);
    }

    public UserDomain login(String email, String password) {
        return userRepository.login(email, password);
    }
}