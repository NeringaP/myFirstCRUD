package dao;

import domain.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class PersonDao {

    public void createPerson(Person person) {
        Transaction transaction = null;
        try {
            //create session
            Session session = HibernateUtils.getSessionFactory().openSession();
            //create transaction
            transaction = session.beginTransaction();
            // save person to database
            session.save(person);
            //commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Person getPerson(Integer id) {
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            Person person = session.find(Person.class, id);
            session.close();
            return person;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    public void updatePerson(Person person) {
        Transaction transaction = null;
        try {
            //create session
            Session session = HibernateUtils.getSessionFactory().openSession();
            //create transaction
            transaction = session.beginTransaction();
            // save person to database
            session.update(person);
            //commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deletePerson(Person person) {
        Transaction transaction = null;
        try {
            //create session
            Session session = HibernateUtils.getSessionFactory().openSession();
            //create transaction
            transaction = session.beginTransaction();
            // save person to database
            session.delete(person);
            //commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Person> getAllPersons() {
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            List<Person> persons = session.createQuery("from Person", Person.class).list();
            session.close();
            return persons;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
