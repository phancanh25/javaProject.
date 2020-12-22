package group10.bookShop.service.vanhoctrongnuoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.VanhoctrongnuocRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Vanhoctrongnuoc;
import group10.bookShop.service.kinhte.KinhteService;

@Service
public class VanhoctrongnuocServiceImpl implements VanhoctrongnuocService{
	@Autowired
	private VanhoctrongnuocRepository vanhoctrongnuocRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Vanhoctrongnuoc> findAll() {
		return vanhoctrongnuocRepository.findAll();
	}
	
	@Override
	public Vanhoctrongnuoc findById(Integer masach) {
		return vanhoctrongnuocRepository.findById(masach).get();
	}
	
	@Override
	public void save(Vanhoctrongnuoc vanhoctrongnuoc) {
		vanhoctrongnuocRepository.save(vanhoctrongnuoc);	
	}
	
	@Override
	public void delete(Integer masach) {
		Vanhoctrongnuoc vanhoctrongnuoc= vanhoctrongnuocRepository.findById(masach).get();
		vanhoctrongnuocRepository.delete(vanhoctrongnuoc);
	}

	@Override
    public List<Vanhoctrongnuoc> search(String tensach) {
        return vanhoctrongnuocRepository.findByTensachContaining(tensach);
    }
}