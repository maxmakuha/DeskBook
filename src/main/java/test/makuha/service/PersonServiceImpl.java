package test.makuha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.makuha.dao.PersonDAO;
import test.makuha.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public List<Person> getAllContacts() {
		return personDAO.getAllContacts();
	}

	@Override
	public Person getContactById(int personId) {
		return personDAO.getContactById(personId); 
	}

	@Override
	public void addContact(Person person) {
		personDAO.addContact(person);
	}

	@Override
	public void updateContact(Person person) {
		personDAO.updateContact(person);
	}

	@Override
	public void deleteContact(int id) {
		personDAO.deleteContact(id);
	}

	@Override
	public List<Object> searchByFIO(String fio) {
		return personDAO.searchByFIO(fio);
	}
}