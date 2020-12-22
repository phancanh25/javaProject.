package group10.bookShop.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Kynangsong;

@Repository
public interface KynangsongRepository extends CrudRepository<Kynangsong, Integer>{
	List<Kynangsong> findByTensachContaining(String term);  // tìm kiếm theo line và theo đúng tên mà mình mong muốn
}
