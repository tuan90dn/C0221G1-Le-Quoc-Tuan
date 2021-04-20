package furuma_resort.Models;

public class Villa extends Services  {
    private String standardOfRoom;
    private String differentServices;
    private double areaOfPool;
    private int amountOfFloor;

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

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public int getAmountOfFloor() {
        return amountOfFloor;
    }

    public void setAmountOfFloor(int amountOfFloor) {
        this.amountOfFloor = amountOfFloor;
    }

    public Villa() {
    }


    public Villa(String nameOfService, double areaOfEmploy, double priceOfRent, int maximumOfPerson, String typeOfEmploy, String id, String standardOfRoom, String differentServices, double areaOfPool, int amountOfFloor) {
        super(nameOfService, areaOfEmploy, priceOfRent, maximumOfPerson, typeOfEmploy, id);
        this.standardOfRoom = standardOfRoom;
        this.differentServices = differentServices;
        this.areaOfPool = areaOfPool;
        this.amountOfFloor = amountOfFloor;
    }

    public Villa(String standardOfRoom, String differentServices, double areaOfPool, int amountOfFloor) {
        this.standardOfRoom = standardOfRoom;
        this.differentServices = differentServices;
        this.areaOfPool = areaOfPool;
        this.amountOfFloor = amountOfFloor;
    }
    @Override
    public String showInfor() {
        return "Villa{" +
                "standardOfRoom='" + standardOfRoom + '\'' +
                ", differentServices='" + differentServices + '\'' +
                ", areaOfPool=" + areaOfPool +
                ", amountOfFloor=" + amountOfFloor +
                '}'+", which is a subclass of "+super.toString();
    }
}
