package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


public class Tube extends RadialGeometry
{
    Ray _axisRay;
    public Tube(Ray ray,double radius)
    {
        super(radius);
        _axisRay = new Ray(ray);
    }



    public Vector getNormal(Point3D point) {
        return null;
    }
}
