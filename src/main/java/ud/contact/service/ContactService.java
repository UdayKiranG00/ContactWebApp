package ud.contact.service;

import java.util.List;

import ud.contact.entity.Contact;

public interface ContactService {

	public boolean save(Contact contact);
	public Contact getContact(Integer id);
	public List<Contact> getAllContacts();
	public boolean deleteContact(Integer id);
//	public boolean updateContact(Contact contact);
}
