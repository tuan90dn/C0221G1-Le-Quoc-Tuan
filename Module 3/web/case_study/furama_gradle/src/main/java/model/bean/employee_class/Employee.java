package model.bean.employee_class;

public class Employee {
    protected int employee_id;
    protected String employee_name;
    protected String employee_birthday;
    protected String employee_id_card;
    protected String employee_salary;
    protected String employee_phone;
    protected String employee_email;
    protected String employee_address;
    protected EmployeePosition position_id;
    protected EmployeeEducationDegree education_degree_id;
    protected EmployeeDivision division_id;
    protected String username;

    public Employee() {
    }

    public Employee(int employee_id, String employee_name, String employee_birthday, String employee_id_card,
                    String employee_salary, String employee_phone, String employee_email, String employee_address,
                    EmployeePosition position_id, EmployeeEducationDegree education_degree_id, EmployeeDivision division_id, String username) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
    }

    public Employee(String employee_name, String employee_birthday, String employee_id_card, String employee_salary, String employee_phone, String employee_email, String employee_address, EmployeePosition position_id, EmployeeEducationDegree education_degree_id, EmployeeDivision division_id, String username) {
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
    }

    public Employee(int employee_id, String employee_name, String employee_birthday, String employee_address,
                    EmployeePosition position_id, EmployeeEducationDegree education_degree_id, EmployeeDivision division_id) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_address = employee_address;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public EmployeePosition getPosition_id() {
        return position_id;
    }

    public void setPosition_id(EmployeePosition position_id) {
        this.position_id = position_id;
    }

    public EmployeeEducationDegree getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(EmployeeEducationDegree education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public EmployeeDivision getDivision_id() {
        return division_id;
    }

    public void setDivision_id(EmployeeDivision division_id) {
        this.division_id = division_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
