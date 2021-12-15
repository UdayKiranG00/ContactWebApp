package ud.contact.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ud.contact.entity.Contact;
import ud.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean save(Contact contact) {
		Contact con=contactRepo.save(contact);
		if(con!=null && con.getContactId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Contact getContact(Integer id) {
		Optional<Contact> con = contactRepo.findById(id);
		if(con.isPresent()) {
			return con.get();
		}
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = contactRepo.findAll();
		allContacts = allContacts.stream().filter(obj->obj.getActiveSwitch()=='A').collect(Collectors.toList());
		// TODO Auto-generated method stub
		return allContacts;
	}

	@Override
	public boolean deleteContact(Integer id) {
		Optional<Contact> optional = contactRepo.findById(id);
		if(optional.isPresent()) {
			Contact contact = optional.get();
			contact.setActiveSwitch('D');
			contactRepo.save(contact);
			return true;
		}
		return false;
	}

}
