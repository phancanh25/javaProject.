package group10.bookShop.service.kynangsong;

import java.util.List;

import group10.bookShop.entities.Kynangsong;

public interface KynangsongService {
	Iterable<Kynangsong> findAll();
	
	List<Kynangsong> search(String tensach);
	
	Kynangsong findById(Integer masach);
	
	void save(Kynangsong kynangsong);
	
	void delete(Integer masach);
}
