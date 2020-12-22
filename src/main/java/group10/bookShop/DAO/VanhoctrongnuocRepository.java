package group10.bookShop.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Vanhoctrongnuoc;

@Repository
public interface VanhoctrongnuocRepository extends CrudRepository<Vanhoctrongnuoc, Integer>{
	List<Vanhoctrongnuoc> findByTensachContaining(String term);  // tìm kiếm theo line và theo đúng tên mà mình mong muốn
}
