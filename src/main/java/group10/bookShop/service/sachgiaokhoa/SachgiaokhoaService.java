package group10.bookShop.service.sachgiaokhoa;

import java.util.List;

import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Sachgiaokhoa;

public interface SachgiaokhoaService {
	Iterable<Sachgiaokhoa> findAll();
	
	List<Sachgiaokhoa> search(String tensach);
	
	Sachgiaokhoa findById(Integer masach);
	
	void save(Sachgiaokhoa sachgiaokhoa);
	
	void delete(Integer masach);
}
