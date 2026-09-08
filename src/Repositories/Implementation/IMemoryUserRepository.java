package Repositories.Implementation;

import Domains.UserDomain;

public interface IMemoryUserRepository {
    public UserDomain login(String email,String password);
    UserDomain findByEmail(String email);
}
