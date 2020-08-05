package main;

import dao.PersonDao;
import domain.Person;
import org.hibernate.Session;
import util.HibernateUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        //Create person
        Person person = new Person("Thomas", "Miller", "tmiller@hacker.com", "USA");
        Person secondPerson = new Person("Ben", "Hill", "bhill@hacker.com", "Australia");
        Person thirdPerson = new Person("Ray", "Kane", "rkane@hacker.com", "Lithuania");
        personDao.createPerson(person);
        personDao.createPerson(secondPerson);
        personDao.createPerson(thirdPerson);

        person = personDao.getPerson(1);

        System.out.println(person);
        System.out.println("------------------------");

        //Update person
        person.setCountry("Russia");
        person.setFirstName("Tautvydas");
        person.setLastName("Cepajevas");
        personDao.updatePerson(person);

        person = personDao.getPerson(1);
        System.out.println(person);
        System.out.println("------------------------");

        //Delete person
        personDao.deletePerson(person);

        //select people
        List<Person> people = personDao.getAllPersons();
        for (Person singlePerson : people) {
            System.out.println(singlePerson);
        }

    }
}
