public class Customers {
    String nameOfCustomer;
    String birthdayOfCustomer;
    String addressOfCustomer;
    String linkPicture;

    public Customers() {
    }

    public Customers(String nameOfCustomer, String birthdayOfCustomer, String addressOfCustomer, String linkPicture) {
        this.nameOfCustomer = nameOfCustomer;
        this.birthdayOfCustomer = birthdayOfCustomer;
        this.addressOfCustomer = addressOfCustomer;
        this.linkPicture = linkPicture;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getBirthdayOfCustomer() {
        return birthdayOfCustomer;
    }

    public void setBirthdayOfCustomer(String birthdayOfCustomer) {
        this.birthdayOfCustomer = birthdayOfCustomer;
    }

    public String getAddressOfCustomer() {
        return addressOfCustomer;
    }

    public void setAddressOfCustomer(String addressOfCustomer) {
        this.addressOfCustomer = addressOfCustomer;
    }

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }
}
