package furuma_resort.models;

public abstract class DanhBa {
    protected String id;
    protected String nameOfService;
    protected double areaOfEmploy;
    protected double priceOfRent;
    protected int maximumOfPerson;
    protected String typeOfEmploy;


    public DanhBa() {
    }

    public DanhBa(String id, String nameOfService, double areaOfEmploy,
                  double priceOfRent, int maximumOfPerson, String typeOfEmploy) {
        this.id = id;
        this.nameOfService = nameOfService;
        this.areaOfEmploy = areaOfEmploy;
        this.priceOfRent = priceOfRent;
        this.maximumOfPerson = maximumOfPerson;
        this.typeOfEmploy = typeOfEmploy;

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
        return id+
                "," + nameOfService+
                "," + areaOfEmploy +
                "," + priceOfRent +
                "," + maximumOfPerson +
                "," + typeOfEmploy;
    }

    public abstract void showInfor();

}
