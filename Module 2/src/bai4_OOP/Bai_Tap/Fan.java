package bai4_OOP.Bai_Tap;

public class Fan {
    private final int slow=1,medium=2,fast=3;
    private int speed=1;
    private boolean on=false;
    private double radius=5;
    private String color="blue";


    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public String toString(){
        if (on){
            return speed+" "+color+" "+ radius+" "+ "fan is on";
        } else {
            return color+" " + radius+" " + "fan is off";
        }
    }

    public static void main(String[] args) {
//        Fan fan1=new Fan();
//        System.out.println(fan1.toString());
        Fan fan1=new Fan(3,true,10,"yellow");
        Fan fan2=new Fan(2,false,5,"blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

}
