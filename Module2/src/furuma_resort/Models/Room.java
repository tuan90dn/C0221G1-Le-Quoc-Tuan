package furuma_resort.Models;

public class Room extends Services {
    private String freeServices;

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String nameOfService, double areaOfEmploy, double priceOfRent, int maximumOfPerson, String typeOfEmploy, String id, String freeServices) {
        super(nameOfService, areaOfEmploy, priceOfRent, maximumOfPerson, typeOfEmploy, id);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }



    @Override
    public String showInfor() {
        return "Room{" +
                "freeServices='" + freeServices + '\'' +
                '}'+", which is a subclass of "+super.toString();
    }
}
