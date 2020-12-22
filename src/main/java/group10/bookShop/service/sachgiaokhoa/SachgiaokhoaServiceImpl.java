package group10.bookShop.service.sachgiaokhoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.SachgiaokhoaRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Sachgiaokhoa;
import group10.bookShop.service.kinhte.KinhteService;

@Service
public class SachgiaokhoaServiceImpl implements SachgiaokhoaService{
	@Autowired
	private SachgiaokhoaRepository sachgiaokhoaRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Sachgiaokhoa> findAll() {
		return sachgiaokhoaRepository.findAll();
	}
	
	@Override
	public Sachgiaokhoa findById(Integer masach) {
		return sachgiaokhoaRepository.findById(masach).get();
	}
	
	@Override
	public void save(Sachgiaokhoa sachgiaokhoa) {
		sachgiaokhoaRepository.save(sachgiaokhoa);	
	}
	
	@Override
	public void delete(Integer masach) {
		Sachgiaokhoa sachgiaokhoa = sachgiaokhoaRepository.findById(masach).get();
		sachgiaokhoaRepository.delete(sachgiaokhoa);
	}

	@Override
    public List<Sachgiaokhoa> search(String tensach) {
        return sachgiaokhoaRepository.findByTensachContaining(tensach);
    }
}