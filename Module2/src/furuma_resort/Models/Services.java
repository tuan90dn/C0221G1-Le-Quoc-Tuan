package furuma_resort.Models;

public abstract class Services {
    private String nameOfService;
    private double areaOfEmploy;
    private double priceOfRent;
    private int maximumOfPerson;
    private String typeOfEmploy;
    private String id;

    public Services() {
    }

    public Services(String nameOfService, double areaOfEmploy, double priceOfRent, int maximumOfPerson, String typeOfEmploy, String id) {
        this.nameOfService = nameOfService;
        this.areaOfEmploy = areaOfEmploy;
        this.priceOfRent = priceOfRent;
        this.maximumOfPerson = maximumOfPerson;
        this.typeOfEmploy = typeOfEmploy;
        this.id = id;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getAreaOfEmploy() {
        return areaOfEmploy;
    }

    public void setAreaOfEmploy(double areaOfEmploy) {
        this.areaOfEmploy = areaOfEmploy;
    }

    public double getPriceOfRent() {
        return priceOfRent;
    }

    public void setPriceOfRent(double priceOfRent) {
        this.priceOfRent = priceOfRent;
    }

    public int getMaximumOfPerson() {
        return maximumOfPerson;
    }

    public void setMaximumOfPerson(int maximumOfPerson) {
        this.maximumOfPerson = maximumOfPerson;
    }

    public String getTypeOfEmploy() {
        return typeOfEmploy;
    }

    public void setTypeOfEmploy(String typeOfEmploy) {
        this.typeOfEmploy = typeOfEmploy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Services{" +
                "nameOfService='" + nameOfService + '\'' +
                ", areaOfEmploy=" + areaOfEmploy +
                ", priceOfRent=" + priceOfRent +
                ", maximumOfPerson=" + maximumOfPerson +
                ", typeOfEmploy='" + typeOfEmploy + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public abstract String showInfor();

}
