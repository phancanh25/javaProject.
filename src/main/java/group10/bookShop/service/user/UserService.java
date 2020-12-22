package group10.bookShop.service.user;

import java.util.List;

import group10.bookShop.entities.Nuoidaycon;
import group10.bookShop.entities.User;

public interface UserService {
	Iterable<User> findAll();
	
	List<User> search(String email);
	
	User findById(Integer id);
	
	void save(User user);
	
	void delete(Integer id);
}
