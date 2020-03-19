package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry
{
    Point3D _p;
    Vector _normal;
    public Plane(Point3D point,Vector normal)
    {
        _p = new Point3D(point);
        _normal = new Vector(normal);
    }

    public Plane(Point3D x,Point3D y, Point3D z)
    {
        Vector U = new Vector(x.subtract(y));
        Vector V = new Vector(x.subtract(z));
        _normal = new Vector(U.crossProduct(V));
        _p = new Point3D(x);
    }

    public Point3D get_p() {
        return _p;
    }

    public Vector getNormal(Point3D point)
    {
        return _normal;
    }
}
