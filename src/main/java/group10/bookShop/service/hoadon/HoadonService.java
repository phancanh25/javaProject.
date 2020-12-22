package group10.bookShop.service.hoadon;

import java.util.List;
import java.util.UUID;

import group10.bookShop.entities.Hoadon;
import group10.bookShop.entities.Kinhte;

public interface HoadonService {
	Iterable<Hoadon> findAll();
	
	List<Hoadon> search(int madonhang);
	
	Hoadon findById(int madonhang);
	
	void save(Hoadon hoadon);
	
	void delete(int madonhang);
}
