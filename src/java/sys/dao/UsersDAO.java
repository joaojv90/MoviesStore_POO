package sys.dao;

import sys.model.Users;

public interface UsersDAO {
    
    public Users search (Users users);
    public Users login (Users users);
    
}
