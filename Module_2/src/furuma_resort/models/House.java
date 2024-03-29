package furuma_resort.models;

public class House extends DanhBa {
    private String standardOfRoom;
    private String differentServices;
    private static int amountOfFloor;


    public House() {
    }

    public House(String standardOfRoom, String differentServices, int amountOfFloor) {
        this.standardOfRoom = standardOfRoom;
        this.differentServices = differentServices;
        this.amountOfFloor = amountOfFloor;
    }

    public House(String id,String nameOfService, double areaOfEmploy, double priceOfRent, int maximumOfPerson,
                 String typeOfEmploy,  String standardOfRoom, String differentServices,
                 int amountOfFloor) {
        super(id,nameOfService, areaOfEmploy, priceOfRent, maximumOfPerson, typeOfEmploy);
        this.standardOfRoom = standardOfRoom;
        this.differentServices = differentServices;
        this.amountOfFloor = amountOfFloor;
    }

    public String getStandardOfRoom() {
        return standardOfRoom;
    }

    public void setStandardOfRoom(String standardOfRoom) {
        this.standardOfRoom = standardOfRoom;
    }

    public String getDifferentServices() {
        return differentServices;
    }

    public void setDifferentServices(String differentServices) {
        this.differentServices = differentServices;
    }

    public int getAmountOfFloor() {
        return amountOfFloor;
    }

    public void setAmountOfFloor(int amountOfFloor) {
        this.amountOfFloor = amountOfFloor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + standardOfRoom+
                "," + differentServices+
                "," + amountOfFloor;
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }


}
