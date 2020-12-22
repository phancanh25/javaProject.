package group10.bookShop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group10.bookShop.entities.Sach;

@Repository
public interface DBFileRepository extends JpaRepository<Sach, String> {

}