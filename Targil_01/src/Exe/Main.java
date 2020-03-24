package Exe;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Vector v = new Vector(1,2,3);
        Point3D p = new Point3D(7,8,9);
        Ray r = new Ray(p,v);
        System.out.println(p);
    }
}
