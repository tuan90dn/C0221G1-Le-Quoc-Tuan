package furuma_resort.models;

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


    public Villa(String id,String nameOfService, double areaOfEmploy, double priceOfRent,
                 int maximumOfPerson, String typeOfEmploy,
                 String standardOfRoom, String differentServices, double areaOfPool, int amountOfFloor) {
        super(id,nameOfService, areaOfEmploy, priceOfRent, maximumOfPerson, typeOfEmploy);
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
    public String toString() {
        return "Villa{" +
                "standardOfRoom='" + standardOfRoom + '\'' +
                ", differentServices='" + differentServices + '\'' +
                ", areaOfPool=" + areaOfPool +
                ", amountOfFloor=" + amountOfFloor +
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
        System.out.println(this.toString());
    }
}
