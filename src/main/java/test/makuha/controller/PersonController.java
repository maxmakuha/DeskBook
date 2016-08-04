package test.makuha.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.makuha.entity.Person;
import test.makuha.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@RequestMapping(value = { "/", "/contacts" }, method = RequestMethod.GET)
	public String contactsPage(Model model) {
		logger.debug("contactsPage() is executed");
		model.addAttribute("contacts", personService.getAllContacts());
		return "contacts";
	}

	@RequestMapping(value = "/contacts/add", method = RequestMethod.GET)
	public String addContact(Model model) {
		logger.debug("addContact() is executed");
		model.addAttribute("personForm", new Person());
		return "addContact";
	}

	@RequestMapping(value = "/contacts/add", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("personForm") Person person, RedirectAttributes redirectAttributes) {
		logger.debug("saveContact() is executed");
		personService.addContact(person);
		redirectAttributes.addFlashAttribute("person", "Contact added successfully!");
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/edit/id/{idperson}", method = RequestMethod.GET)
	public String editContact(@PathVariable("idperson") int id, Model model, HttpServletRequest request) {
		logger.debug("editContact() is executed");
		model.addAttribute("personForm", personService.getContactById(id));
		model.addAttribute("page", request.getServletPath());
		return "editContact";
	}

	@RequestMapping(value = "/contacts/edit/id/{idperson}", method = RequestMethod.POST)
	public String saveEditedContact(@ModelAttribute("personForm") Person person, @PathVariable("idperson") int id,
			RedirectAttributes redirectAttributes) {
		logger.debug("saveEditedContact() is executed");
		personService.updateContact(person);
		redirectAttributes.addFlashAttribute("person", "Contact edited successfully!");
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/delete/id/{idperson}", method = RequestMethod.GET)
	public String deleteContact(@PathVariable("idperson") int id, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		logger.debug("deleteContact() is executed");
		personService.deleteContact(id);
		String referer = request.getHeader("Referer");
		redirectAttributes.addFlashAttribute("person", "Contact deleted successfully!");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/contacts/search")
	public String search(@RequestParam(value = "searchString", required = false) String searchString, Model model) {
		logger.debug("search() is executed");
		model.addAttribute("contacts", personService.searchByFIO(searchString));
		return "contacts";
	}
}