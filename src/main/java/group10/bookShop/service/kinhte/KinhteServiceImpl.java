package group10.bookShop.service.kinhte;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.SachRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Sach;

@Service
public class KinhteServiceImpl implements KinhteService{
	@Autowired
	private KinhteRepository kinhteRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Kinhte> findAll() {
		return kinhteRepository.findAll();
	}
	
	@Override
	public Kinhte findById(Integer masach) {
		return kinhteRepository.findById(masach).get();
	}
	
	@Override
	public void save(Kinhte kinhte) {
		kinhteRepository.save(kinhte);	
	}
	
	@Override
	public void delete(Integer masach) {
		Kinhte kinhte = kinhteRepository.findById(masach).get();
		kinhteRepository.delete(kinhte);
	}

	@Override
    public List<Kinhte> search(String tensach) {
        return kinhteRepository.findByTensachContaining(tensach);
    }

	

	
}
