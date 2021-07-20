package furuma_resort.models;

public class Customer implements Comparable<Customer> {
    private String fullName;
    private String birthday;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeOfCustomer;
    private String address;
    private DanhBa services;

    public Customer() {
    }

    public Customer(String fullName, String birthday, String gender, String idCard, String phoneNumber,
                    String email, String typeOfCustomer, String address, DanhBa services) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.services = services;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DanhBa getServices() {
        return services;
    }

    public void setServices(DanhBa services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", adress='" + address + '\'' +
                ", services=" + services +
                '}';
    }

    public void showInfor(){
        System.out.println(toString());
    }

    @Override
    public int compareTo(Customer second) {
        int result=this.fullName.compareTo(second.fullName);
        if (result==0){
            int yearOfFirstCustomer= Integer.parseInt(this.birthday.split("/")[2]);
            int yearOfSecondCustomer= Integer.parseInt(second.birthday.split("/")[2]);
            result=yearOfFirstCustomer-yearOfSecondCustomer;
        }
        return result;
    }
}
