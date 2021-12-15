package ud.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ud.contact.entity.Contact;
import ud.contact.props.AppProps;
import ud.contact.service.ContactService;


@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	AppProps appProps = new AppProps();

	@GetMapping("/contact")
	public String contactLoader(Model model) {
		Contact contactinfo = new Contact();
		model.addAttribute("contact", contactinfo);
		return "contactinfo";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
		contact.setActiveSwitch('A');
		boolean isSaved = contactService.save(contact);
		if(isSaved) {
			model.addAttribute("success", appProps.getMessages().get("saveSuccess"));
			
		}else {
			model.addAttribute("error",appProps.getMessages().get("saveFail"));
		}
		return "contactinfo";
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewallcontacts";
	}
	@GetMapping("/edit")
	public String updateContact(@RequestParam("cid")Integer contactId,Model model) {
		Contact contact = contactService.getContact(contactId);
		model.addAttribute("contact", contact);
		return "contactinfo";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId) {
		contactService.deleteContact(contactId);
		return "redirect:viewContacts";
	}
	
}
