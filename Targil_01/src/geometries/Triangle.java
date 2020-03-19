package geometries;

import primitives.Point3D;
import primitives.Vector;

import java.util.*;

public class Triangle extends Polygon
{

    public Triangle(Point3D a,Point3D b,Point3D c)
    {
        _points = new LinkedList<Point3D>();
        _points.add(new Point3D(a));
        _points.add(new Point3D(b));
        _points.add(new Point3D(c));
    }


    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }
}
