package onetoone.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();
        Account account1 = new Account();
        account1.setAccountNumber("00092");
        account1.setDateOdEmployee(LocalDate.of(2020,02,01));
        session.save(account1);


        Account account2 = new Account();
        account2.setAccountNumber("00085");
        account2.setDateOdEmployee(LocalDate.of(2020,05,25));
        session.save(account2);


        Account account3 = new Account();
        account3.setAccountNumber("00078");
        account3.setDateOdEmployee(LocalDate.of(2020,03,18));
        session.save(account3);



        Employee employee1 = new Employee();
        employee1.setFirstName("Tom");
        employee1.setLastName("Tommy");
        employee1.setAccount(account1);
        session.save(employee1);


        Employee employee2 = new Employee();
        employee2.setFirstName("John");
        employee2.setLastName("Johnny");
        employee2.setAccount(account2);
        session.save(employee2);


        Employee employee3 = new Employee();
        employee3.setFirstName("James");
        employee3.setLastName("Jammy");
        employee3.setAccount(account3);
        session.save(employee3);

        session.getTransaction().commit();
        session.close();
        //transaction.commit();




    }
}
