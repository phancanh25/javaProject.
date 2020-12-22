package group10.bookShop.service.vanhocnuocngoai;

import java.util.List;

import group10.bookShop.entities.Vanhocnuocngoai;

public interface VanhocnuocngoaiService {
	Iterable<Vanhocnuocngoai> findAll();
	
	List<Vanhocnuocngoai> search(String tensach);
	
	Vanhocnuocngoai findById(Integer masach);
	
	void save(Vanhocnuocngoai kanhocnuocngoai);
	
	void delete(Integer masach);
}
