package group10.bookShop.service.hoadon;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group10.bookShop.DAO.HoadonRepository;
import group10.bookShop.DAO.KinhteRepository;
import group10.bookShop.DAO.SachRepository;
import group10.bookShop.entities.Hoadon;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Sach;

@Service
public class HoadonServiceImpl implements HoadonService{
	@Autowired
	private HoadonRepository hoadonRepository;  // lop service goi lop dao 
	
	@Override
	public Iterable<Hoadon> findAll() {
		return hoadonRepository.findAll();
	}
	
	@Override
	public Hoadon findById(int madonhang) {
		return hoadonRepository.findById(madonhang).get();
	}
	
	@Override
	public void save(Hoadon hoadon) {
		hoadonRepository.save(hoadon);	
	}
	
	@Override
	public void delete(int madonhang) {
		Hoadon hoadon = hoadonRepository.findById(madonhang).get();
		hoadonRepository.delete(hoadon);
	}

	@Override
    public List<Hoadon> search(int madonhang) {
        return hoadonRepository.findByMadonhangContaining(madonhang);
    }

	

	
}
