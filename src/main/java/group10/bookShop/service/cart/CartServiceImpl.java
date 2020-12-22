package group10.bookShop.service.cart;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.CartRepository;
import group10.bookShop.DAO.HoadonRepository;
import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.SachRepository;
import group10.bookShop.entities.Cart;
import group10.bookShop.entities.Hoadon;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Sach;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Cart> findAll() {
		return cartRepository.findAll();
	}
	
	@Override
	public Cart findById(int madonhang) {
		return cartRepository.findById(madonhang).get();
	}
	
	@Override
	public void save(Cart cart) {
		cartRepository.save(cart);	
	}
	
	@Override
	public void delete(int madonhang) {
		Cart cart = cartRepository.findById(madonhang).get();
		cartRepository.delete(cart);
	}

	@Override
    public List<Cart> search(String emailnguoimua) {
        return cartRepository.findByEmailnguoimuaContaining(emailnguoimua);
    }

	

	
}
