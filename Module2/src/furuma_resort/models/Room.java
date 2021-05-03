package furuma_resort.models;

public class Room extends Services {
    private ExtraServices freeServices;

    public Room() {
    }

    public Room(ExtraServices freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String id,String nameOfService, double areaOfEmploy, double priceOfRent, int maximumOfPerson,
                String typeOfEmploy,  ExtraServices freeServices) {
        super( id,nameOfService, areaOfEmploy, priceOfRent, maximumOfPerson, typeOfEmploy);
        this.freeServices = freeServices;
    }

    public ExtraServices getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(ExtraServices freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServices=" + freeServices +
                ", id='" + id + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", areaOfEmploy=" + areaOfEmploy +
                ", priceOfRent=" + priceOfRent +
                ", maximumOfPerson=" + maximumOfPerson +
                ", typeOfEmploy='" + typeOfEmploy + '\'' +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }
}
