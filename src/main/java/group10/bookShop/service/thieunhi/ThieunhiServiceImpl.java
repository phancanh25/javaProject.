package group10.bookShop.service.thieunhi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.ThieunhiRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Thieunhi;
import group10.bookShop.service.kinhte.KinhteService;

@Service
public class ThieunhiServiceImpl implements ThieunhiService{
	@Autowired
	private ThieunhiRepository thieunhiRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Thieunhi> findAll() {
		return thieunhiRepository.findAll();
	}
	
	@Override
	public Thieunhi findById(Integer masach) {
		return thieunhiRepository.findById(masach).get();
	}
	
	@Override
	public void save(Thieunhi thieunhi) {
		thieunhiRepository.save(thieunhi);	
	}
	
	@Override
	public void delete(Integer masach) {
		Thieunhi thieunhi = thieunhiRepository.findById(masach).get();
		thieunhiRepository.delete(thieunhi);
	}

	@Override
    public List<Thieunhi> search(String tensach) {
        return thieunhiRepository.findByTensachContaining(tensach);
    }
}