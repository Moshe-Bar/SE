package geometries;

public abstract class RadialGeometry implements Geometry
{
    double _radius;

    public RadialGeometry(RadialGeometry other)
    {
        this._radius = other._radius;
    }

    public RadialGeometry(double radius)
    {
        _radius = radius;
    }

    public double get_radius() {
        return _radius;
    }
}
