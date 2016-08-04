package test.makuha.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.makuha.entity.Person;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Person> getAllContacts() {
		return em.createNamedQuery(Person.getAllContacts).getResultList();
	}

	@Override
	public Person getContactById(int idperson) {
		return em.find(Person.class, idperson);
	}

	@Override
	public void addContact(Person person) {
		em.persist(person);
	}

	@Override
	public void updateContact(Person person) {
		em.merge(person);
	}

	@Override
	public void deleteContact(int id) {
		Person person = em.find(Person.class, id);
		em.remove(person);
	}

	@Override
	public List<Object> searchByFIO(String fio) {
		List<Person> contacts = getAllContacts();
		List<Object> result = new ArrayList<Object>();
		Iterator itr = contacts.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (String.valueOf(obj[1]).contains(fio))
				result.add(obj);
		}
		return result;
	}
}
