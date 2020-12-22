package group10.bookShop.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Sach;



@Repository
public interface SachRepository extends CrudRepository<Sach, Integer>{
	
	// interger la kieu du lieu khoa chinh cua contact entity
		// lớp crud cung cấp các method như là thêm xóa sửa, không cần implementation mà nó tự tạo khi runtime 
		
	List<Sach> findByTensachContaining(String term);  // tìm kiếm theo line và theo đúng tên mà mình mong muốn
    List<Sach> findByOrderByMasachDesc();
    List<Sach> findByOrderByLuocxemDesc();
    List<Sach> findByOrderBySoluongdabanDesc();

}
