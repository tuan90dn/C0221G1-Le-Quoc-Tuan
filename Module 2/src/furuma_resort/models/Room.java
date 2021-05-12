package furuma_resort.models;

public class Room extends DanhBa {
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

//    public Room(String id, String nameService, double areaEmploy, double price, int maximum, String type, String nameExtraService, String unit, double priceExtra) {
//    }

    public ExtraServices getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(ExtraServices freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + freeServices;
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }
}
