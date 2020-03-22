package primitives;

public class Ray
{
    //default values
    private static final Point3D defaultPoo  = new Point3D(1,1,1);
    private static final Vector defaultDirection  = new Vector(1,1,1);

    //fields
    private Point3D _POO;
    private Vector _direction;

    // ***************** Constructors ********************** //


    public Ray(Ray other)
    {
        checkForNullArguments(other);

        this._POO = other.getPOO();
        this._direction = other.getDirection();

    }

    public Ray(Point3D poo, Vector direction)
    {
        boolean illegalArgument = false;

        if(poo==null)
        {
            this._POO = defaultPoo;
            illegalArgument = true;
        }
        if(direction == null)
        {
            this._direction = defaultDirection;
            illegalArgument = true;
        }
        if(illegalArgument)throw  new IllegalArgumentException("One or more illegal arguments provided");

        this._POO = new Point3D(poo);
        this._direction = new Vector(direction);
        this._direction.normalized();
    }

    //getters
    public Vector getDirection() { return new Vector(_direction); }
    public Point3D getPOO()       { return new Point3D(_POO);     }


    private void checkForNullArguments(Object... obj)
    {
        for(Object o:obj)
        {
            if(o == null)
            {
                throw new NullPointerException("There were one or more null arguments provided");
            }
        }
    }

}
