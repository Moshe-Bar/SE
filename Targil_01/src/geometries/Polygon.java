package geometries;

import primitives.Point3D;
import primitives.Vector;

import java.util.List;

public abstract class Polygon implements Geometry
{
    List<Point3D> _points;
    Plane _plane;

    public Vector getNormal(Point3D point)
    {
        //return _plane.getNormal(new Point3D(1,1,1));
        return null;
    }

    public Plane get_plane() {
        return _plane;
    }

    public List<Point3D> get_points()
    {
        return _points;
    }
}
