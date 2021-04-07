package bai6_Inheritance.Bai_tap.Lop_2D_va_3D;

public class Point_3D extends Point_2D {
    private float z=0.0f;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Point_3D() {
    }

    public Point_3D(float x, float y,float z) {
        super(x, y);
        this.z=z;
    }
    public void setXYZ(float x,float y,float z){
        super.setXY(x,y);
        this.z=z;
    }
    public float[] getXYZ(){
        float[] array={getX(),getY(),z};
        return array;
    }

    @Override
    public String toString() {
        return "Point_3D{" +"x=" +getX() +
                " , y=" + getY() +
                " , z=" + z +
                '}';
    }
}
