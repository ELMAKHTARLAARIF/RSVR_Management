package Repositories;

import Domains.UserDomain;

public class UserRepository extends GenericRepository<UserDomain>{

    public UserDomain findByEmail(String email){
        for(UserDomain user: storage.values()){
            if (user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }
    public UserDomain login(String email,String password){
            UserDomain user = findByEmail(email);
            if(user != null && user.getPassword().equals(password)){
                return user;
            }
            return null;
    }
}
