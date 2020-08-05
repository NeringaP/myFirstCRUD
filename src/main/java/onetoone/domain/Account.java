package onetoone.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_number")
    private String accountNumber;

    private LocalDate dateOdEmployee;

    @OneToOne(mappedBy = "account")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getDateOdEmployee() {
        return dateOdEmployee;
    }

    public void setDateOdEmployee(LocalDate dateOdEmployee) {
        this.dateOdEmployee = dateOdEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", dateOdEmployee=" + dateOdEmployee +
                ", employee=" + employee +
                '}';
    }
}
