package group10.bookShop.service.vanhoctrongnuoc;

import java.util.List;

import group10.bookShop.entities.Vanhoctrongnuoc;

public interface VanhoctrongnuocService {
	Iterable<Vanhoctrongnuoc> findAll();
	
	List<Vanhoctrongnuoc> search(String tensach);
	
	Vanhoctrongnuoc findById(Integer masach);
	
	void save(Vanhoctrongnuoc kanhoctrongnuoc);
	
	void delete(Integer masach);
}	
