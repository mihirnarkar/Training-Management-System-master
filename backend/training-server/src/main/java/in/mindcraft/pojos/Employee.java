package in.mindcraft.pojos;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    private int employee_id;
    
    @Column(nullable = false)
    private String employee_firstname;
    
    @Column(nullable = false)
    private String employee_lastname;
    
    @Column(unique = true, nullable = false)
    private String employee_email;
    
    @Column(nullable = false)
    private String employee_department;
    
    @Column(nullable = false)
    private String employee_designation;

    @Column(nullable = false)
    private Date employee_dob;
    
    @Column(nullable = false)
    private Date employee_doj;


    public Employee() {
    }

    public Employee(int employee_id, String employee_firstname, String employee_lastname, String employee_email,
            String employee_department, String employee_designation, Date employee_dob, Date employee_doj) {
        this.employee_id = employee_id;
        this.employee_firstname = employee_firstname;
        this.employee_lastname = employee_lastname;
        this.employee_email = employee_email;
        this.employee_department = employee_department;
        this.employee_designation = employee_designation;
        this.employee_dob = employee_dob;
        this.employee_doj = employee_doj;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public String getEmployee_department() {
        return employee_department;
    }

    public String getEmployee_designation() {
        return employee_designation;
    }

    public Date getEmployee_dob() {
        return employee_dob;
    }

    public Date getEmployee_doj() {
        return employee_doj;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployee_firstname(String employee_firstname) {
        this.employee_firstname = employee_firstname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public void setEmployee_department(String employee_department) {
        this.employee_department = employee_department;
    }

    public void setEmployee_designation(String employee_designation) {
        this.employee_designation = employee_designation;
    }

    public void setEmployee_dob(Date employee_dob) {
        this.employee_dob = employee_dob;
    }

    public void setEmployee_doj(Date employee_doj) {
        this.employee_doj = employee_doj;
    }

}
