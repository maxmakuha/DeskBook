package test.makuha.service;

import java.util.List;

import test.makuha.entity.Person;

public interface PersonService {

	public List<Person> getAllContacts();

	public Person getContactById(int personId);

	public void addContact(Person person);

	public void updateContact(Person person);

	public void deleteContact(int id);

	public List<Object> searchByFIO(String fio);
}
