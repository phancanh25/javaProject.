package group10.bookShop.DAO;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Hoadon;
import group10.bookShop.entities.Kinhte;

@Repository
public interface HoadonRepository extends CrudRepository<Hoadon, Integer>{
	List<Hoadon> findByMadonhangContaining(int madonhang);  // tìm kiếm theo line và theo đúng tên mà mình mong muốn
}
