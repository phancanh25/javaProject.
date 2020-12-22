package group10.bookShop.service.sach;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import group10.bookShop.entities.Sach;

public interface SachService 
{
	Iterable<Sach> findAll();
	
	List<Sach> search(String tensach);
	
	List<Sach> findMasachDesc();
	List<Sach> findLuocxemDesc();
	List<Sach> findSoluongdabanDesc();

	
	Sach findById(Integer masach);
	
	void save(Sach sach);
	
	void delete(Integer masach);
}
