package group10.bookShop.service.vanhocnuocngoai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.VanhocnuocngoaiRepository;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Vanhocnuocngoai;
import group10.bookShop.service.kinhte.KinhteService;

@Service
public class  VanhocnuocngoaiServiceImpl implements  VanhocnuocngoaiService{
	@Autowired
	private  VanhocnuocngoaiRepository vanhocnuocngoaiRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable< Vanhocnuocngoai> findAll() {
		return  vanhocnuocngoaiRepository.findAll();
	}
	
	@Override
	public  Vanhocnuocngoai findById(Integer masach) {
		return  vanhocnuocngoaiRepository.findById(masach).get();
	}
	
	@Override
	public void save( Vanhocnuocngoai  vanhocnuocngoai) {
		 vanhocnuocngoaiRepository.save( vanhocnuocngoai);	
	}
	
	@Override
	public void delete(Integer masach) {
		 Vanhocnuocngoai  vanhocnuocngoai =  vanhocnuocngoaiRepository.findById(masach).get();
		 vanhocnuocngoaiRepository.delete( vanhocnuocngoai);
	}

	@Override
    public List< Vanhocnuocngoai> search(String tensach) {
        return  vanhocnuocngoaiRepository.findByTensachContaining(tensach);
    }
}