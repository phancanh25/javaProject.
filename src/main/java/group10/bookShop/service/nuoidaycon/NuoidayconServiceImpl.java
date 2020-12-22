package group10.bookShop.service.nuoidaycon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.NuoidayconRepository;
import group10.bookShop.entities.Nuoidaycon;

	@Service
	public class NuoidayconServiceImpl implements NuoidayconService{
		@Autowired
		private NuoidayconRepository nuoidayconRepository;  // lop service goi lop dao 
		
		@Override
		public Iterable<Nuoidaycon> findAll() {
			return nuoidayconRepository.findAll();
		}
		
		@Override
		public Nuoidaycon findById(Integer masach) {
			return nuoidayconRepository.findById(masach).get();
		}
		
		@Override
		public void save(Nuoidaycon nuoidaycon) {
			nuoidayconRepository.save(nuoidaycon);	
		}
		
		@Override
		public void delete(Integer masach) {
			Nuoidaycon nuoidaycon= nuoidayconRepository.findById(masach).get();
			nuoidayconRepository.delete(nuoidaycon);
		}

		@Override
	    public List<Nuoidaycon> search(String tensach) {
	        return nuoidayconRepository.findByTensachContaining(tensach);
	    }
	}


