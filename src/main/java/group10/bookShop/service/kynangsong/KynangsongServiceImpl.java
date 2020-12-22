package group10.bookShop.service.kynangsong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.KynangsongRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Kynangsong;
import group10.bookShop.service.kinhte.KinhteService;

@Service
public class KynangsongServiceImpl implements KynangsongService{
	@Autowired
	private KynangsongRepository kynangsongRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Kynangsong> findAll() {
		return kynangsongRepository.findAll();
	}
	
	@Override
	public Kynangsong findById(Integer masach) {
		return kynangsongRepository.findById(masach).get();
	}
	
	@Override
	public void save(Kynangsong kynangsong) {
		kynangsongRepository.save(kynangsong);	
	}
	
	@Override
	public void delete(Integer masach) {
		Kynangsong kynangsong = kynangsongRepository.findById(masach).get();
		kynangsongRepository.delete(kynangsong);
	}

	@Override
    public List<Kynangsong> search(String tensach) {
        return kynangsongRepository.findByTensachContaining(tensach);
    }
}
