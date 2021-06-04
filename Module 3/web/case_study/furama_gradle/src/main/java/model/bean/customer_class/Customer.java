package model.bean.customer_class;

public class Customer {
    protected int customer_id;
    protected CustomerType customer_type_id;
    protected String customer_name;
    protected String customer_birthday;
    protected int customer_gender;
    protected String customer_id_card;
    protected String customer_phone;
    protected String customer_email;
    protected String customer_address;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, String customer_phone, String customer_email, String customer_address) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
    }

    public Customer(CustomerType customer_type_id, String customer_name, String customer_birthday, int customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address) {
        this.customer_type_id = customer_type_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
    }

    public Customer(int customer_id, CustomerType customer_type_id, String customer_name, String customer_birthday,
                    int customer_gender, String customer_id_card, String customer_phone, String customer_email,
                    String customer_address) {
        this.customer_id = customer_id;
        this.customer_type_id = customer_type_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public CustomerType getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(CustomerType customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public int getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(int customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
