package group10.bookShop.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByEmailContaining(String term);
}
