package group10.bookShop.service.thieunhi;

import java.util.List;

import group10.bookShop.entities.Thieunhi;

public interface ThieunhiService {
	Iterable<Thieunhi> findAll();
	
	List<Thieunhi> search(String tensach);
	
	Thieunhi findById(Integer masach);
	
	void save(Thieunhi thieunhi);
	
	void delete(Integer masach);
}
