package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube
{
    double _height;
    public Cylinder(double height, Ray ray,double radius)
    {
        super(ray,radius);
        _height = height;
    }

    public Vector getNormal(Point3D point)
    {
        return null;
    }
}
