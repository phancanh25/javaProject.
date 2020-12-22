package group10.bookShop.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Vanhocnuocngoai;
import group10.bookShop.entities.Vanhoctrongnuoc;

@Repository
public interface VanhocnuocngoaiRepository extends CrudRepository<Vanhocnuocngoai, Integer>{
	List<Vanhocnuocngoai> findByTensachContaining(String term);  // tìm kiếm theo line và theo đúng tên mà mình mong muốn
}

