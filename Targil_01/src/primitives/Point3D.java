package primitives;

public class Point3D
{
    //default values
    private static final Coordinate defaultCoordinate = new Coordinate(1);

    private static final Point3D zero  = new Point3D(0,0,0);

    //fields
    private Coordinate x;
    private Coordinate y;
    private Coordinate z;

    //getters
    public Coordinate getZ() {
        return z;
    }

    public Coordinate getX() {
        return x;
    }

    public Coordinate getY() {
        return y;
    }

    //constructors
    public Point3D(double x, double y, double z)
    {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    public Point3D(Coordinate x, Coordinate y, Coordinate z)
    {
        if(!legalArguments(x,y,z))
        {
            //default values
            this.x = defaultCoordinate;
            this.y = defaultCoordinate;
            this.z = defaultCoordinate;
            throw new NullPointerException("One or more arguments are null ");
        }
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    public Point3D(Point3D other)
    {
        if(!legalArguments(other))
        {
            //default values
            this.y = defaultCoordinate;
            this.z = defaultCoordinate;
            this.x = defaultCoordinate;

            throw new NullPointerException("One or arguments are null");
        }
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
    }

    //overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof Point3D)) return false;
        Point3D other = (Point3D) o;
        return this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z);
    }


    @Override
    public String toString() {
        return "primitives.Point3D : " +
                "x=" + x +
                " y=" + y +
                " z=" + z
                ;
    }


    public Vector subtract(Point3D other)
    {
        nullArgumentReaction();
        return new Vector(x.subtract(other.getX()),y.subtract(other.getY()),z.subtract(other.getZ()));
    }

    public Point3D add(Vector vec)
    {
        nullArgumentReaction(vec);

        Point3D temp = new Point3D(vec.getDirection());
        return new Point3D(temp.x.add(this.x),temp.y.add(this.y),temp.z.add(this.z));
    }

    private double distance2(Point3D other)
    {
        nullArgumentReaction(other);

        double temp = (x.subtract(other.x).get()*x.subtract(other.x).get() + y.subtract(other.y).get()*y.subtract(other.y).get()
                + z.subtract(other.z).get()*z.subtract(other.z).get());
        return temp;
    }

    public double distance(Point3D other)
    {
        nullArgumentReaction(other);
        return Math.sqrt(distance2(other));
    }
    public String detailsToString()
    {
        return "(" + x + "," + y +"," + z +")";
    }
    private boolean legalArguments(Object... obj)
    {
        if(obj == null)
        {
            return false;
        }
        for(Object o:obj)
        {
           if(o == null)
           {
               return false;
           }
        }
        return true;
    }

    private void nullArgumentReaction(Object... obj)
    {
        if(obj == null)
        {
            throw new NullPointerException("One or more null arguments provided");
        }
        for(Object o:obj)
        {
            if(o == null)
            {
                throw new NullPointerException("One or more null arguments provided");
            }
        }
    }
}
