package group10.bookShop.service.nuoidaycon;

import java.util.List;

import group10.bookShop.entities.Nuoidaycon;

public interface NuoidayconService {
	
	Iterable<Nuoidaycon> findAll();
	
	List<Nuoidaycon> search(String tensach);
	
	Nuoidaycon findById(Integer masach);
	
	void save(Nuoidaycon nuoidaycon);
	
	void delete(Integer masach);
}
