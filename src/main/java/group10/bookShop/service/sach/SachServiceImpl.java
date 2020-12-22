package group10.bookShop.service.sach;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import group10.bookShop.DAO.SachRepository;
import group10.bookShop.entities.Sach;

@Service
public class SachServiceImpl implements SachService {
	
	@Autowired
	private SachRepository sachRepository;  // lop service goi lop dao 
	
	
	@Override
	public Iterable<Sach> findAll() {
		return sachRepository.findAll();
	}
	
	@Override
	public Sach findById(Integer masach) {
		return sachRepository.findById(masach).get();
	}
	
	@Override
	public void save(Sach sach) {
		sachRepository.save(sach);
	}
	
	@Override
	public void delete(Integer masach) {
		Sach sach = sachRepository.findById(masach).get();
		sachRepository.delete(sach);
	}

	@Override
    public List<Sach> search(String tensach) {
        return sachRepository.findByTensachContaining(tensach);
    }
	
	@Override
    public List<Sach> findMasachDesc() {
        return sachRepository.findByOrderByMasachDesc();
    }
	
	@Override
    public List<Sach> findLuocxemDesc() {
        return sachRepository.findByOrderByLuocxemDesc();
    }
	
	@Override
    public List<Sach> findSoluongdabanDesc() {
        return sachRepository.findByOrderBySoluongdabanDesc();
    }
}
