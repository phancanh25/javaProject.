package group10.bookShop.service.kinhte;

import java.util.List;

import group10.bookShop.entities.Kinhte;

public interface KinhteService {
	Iterable<Kinhte> findAll();
	
	List<Kinhte> search(String tensach);
	
	Kinhte findById(Integer masach);
	
	void save(Kinhte kinhte);
	
	void delete(Integer masach);
}
