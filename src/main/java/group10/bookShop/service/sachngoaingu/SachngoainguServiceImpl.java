package group10.bookShop.service.sachngoaingu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.SachngoainguRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Sachngoaingu;
import group10.bookShop.service.kinhte.KinhteService;

@Service
public class SachngoainguServiceImpl implements SachngoainguService{
	@Autowired
	private SachngoainguRepository sachngoainguRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Sachngoaingu> findAll() {
		return sachngoainguRepository.findAll();
	}
	
	@Override
	public Sachngoaingu findById(Integer masach) {
		return sachngoainguRepository.findById(masach).get();
	}
	
	@Override
	public void save(Sachngoaingu sachngoaingu) {
		sachngoainguRepository.save(sachngoaingu);	
	}
	
	@Override
	public void delete(Integer masach) {
		Sachngoaingu sachngoaingu = sachngoainguRepository.findById(masach).get();
		sachngoainguRepository.delete(sachngoaingu);
	}

	@Override
    public List<Sachngoaingu> search(String tensach) {
        return sachngoainguRepository.findByTensachContaining(tensach);
    }
}