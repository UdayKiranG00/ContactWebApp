package ud.contact.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ud.contact.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

//	@Modifying
//	@Query("update contacts c set c.name=?1,c.email=?2,c.mobile_no=?3 where c.id=?4")
//	public int updateCon(String name,String email,Long mobile_no,int id);
}
