package group10.bookShop.service.sachngoaingu;

import java.util.List;

import group10.bookShop.entities.Sachngoaingu;

public interface SachngoainguService {
	Iterable<Sachngoaingu> findAll();
	
	List<Sachngoaingu> search(String tensach);
	
	Sachngoaingu findById(Integer masach);
	
	void save(Sachngoaingu sachngoaingu);
	
	void delete(Integer masach);
}
