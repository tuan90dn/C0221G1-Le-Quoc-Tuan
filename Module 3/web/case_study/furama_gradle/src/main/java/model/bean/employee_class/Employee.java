package model.bean.employee_class;

public class Employee {
    protected int employeeId;
    protected String employeeName;
    protected String employeeBirthday;
    protected String employeeIdCard;
    protected String employeeSalary;
    protected String employeePhone;
    protected String employeeEmail;
    protected String employeeAddress;
    protected EmployeePosition employeePosition;
    protected EmployeeEducationDegree employeeEducationDegree;
    protected EmployeeDivision employeeDivision;
    protected String userName;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard,
                    String employeeSalary, String employeePhone, String employeeEmail,
                    String employeeAddress, EmployeePosition employeePosition,
                    EmployeeEducationDegree employeeEducationDegree, EmployeeDivision employeeDivision, String userName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeEducationDegree = employeeEducationDegree;
        this.employeeDivision = employeeDivision;
        this.userName = userName;
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard, String employeeSalary,
                    String employeePhone, String employeeEmail, String employeeAddress,
                    EmployeePosition employeePosition, EmployeeEducationDegree employeeEducationDegree,
                    EmployeeDivision employeeDivision, String userName) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeEducationDegree = employeeEducationDegree;
        this.employeeDivision = employeeDivision;
        this.userName = userName;
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeAddress,
                    EmployeePosition employeePosition, EmployeeEducationDegree employeeEducationDegree,
                    EmployeeDivision employeeDivision) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeEducationDegree = employeeEducationDegree;
        this.employeeDivision = employeeDivision;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EmployeeEducationDegree getEmployeeEducationDegree() {
        return employeeEducationDegree;
    }

    public void setEmployeeEducationDegree(EmployeeEducationDegree employeeEducationDegree) {
        this.employeeEducationDegree = employeeEducationDegree;
    }

    public EmployeeDivision getEmployeeDivision() {
        return employeeDivision;
    }

    public void setEmployeeDivision(EmployeeDivision employeeDivision) {
        this.employeeDivision = employeeDivision;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
