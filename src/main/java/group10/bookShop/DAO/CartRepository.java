package group10.bookShop.DAO;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{
	List<Cart> findByEmailnguoimuaContaining(String term);  // tìm kiếm theo line và theo đúng tên mà mình mong muốn
}
