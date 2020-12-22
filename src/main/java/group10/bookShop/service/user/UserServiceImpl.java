package group10.bookShop.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.NuoidayconRepository;
import group10.bookShop.DAO.UserRepository;
import group10.bookShop.entities.Nuoidaycon;
import group10.bookShop.entities.User;

@Service

public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);	
	}
	
	@Override
	public void delete(Integer id) {
		User user= userRepository.findById(id).get();
		userRepository.delete(user);
	}

	@Override
    public List<User> search(String email) {
        return userRepository.findByEmailContaining(email);
    }
}
