package group10.bookShop.service.cart;

import java.util.List;
import java.util.UUID;

import group10.bookShop.entities.Cart;

public interface CartService {
	Iterable<Cart> findAll();
	
	List<Cart> search(String emailnguoimua);
	
	Cart findById(int madonhang);
	
	void save(Cart cart);
	
	void delete(int madonhang);
}