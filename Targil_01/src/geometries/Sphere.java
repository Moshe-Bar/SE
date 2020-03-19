package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry
{
    Point3D _center;
    public Sphere(Point3D center,double radius)
    {
        super(radius);
        _center = new Point3D(center);
    }


    public Vector getNormal(Point3D point)
    {
        return new Vector(point.subtract(_center));
    }
}
