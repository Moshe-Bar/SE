package primitives;

public class Point3D
{
    //default values
    private static final Point3D defaultPoint3D = new Point3D(1,1,1);

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
        //if values not valid the fields would stay on default values
        this(defaultPoint3D);

        Coordinate xTest = new Coordinate(x);
        Coordinate yTest = new Coordinate(y);
        Coordinate zTest = new Coordinate(z);
        if(!legalArguments(xTest,yTest,zTest))
        {
            throw new IllegalArgumentException("One or more illegal arguments ");
        }
        this.x = xTest;
        this.y = yTest;
        this.z = zTest;
    }

    public Point3D(Coordinate x, Coordinate y, Coordinate z)
    {
        //if values not valid the fields would stay on default values
        this(defaultPoint3D);

        if(!legalArguments(x,y,z))
        {
            throw new NullPointerException("One or more arguments are null or zero");
        }
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    public Point3D(Point3D other)
    {
        if(other == null)
        {
            //default values
            this.x = new Coordinate(1);
            this.y = new Coordinate(1);
            this.z = new Coordinate(1);

            throw new NullPointerException("One or arguments provided are null");
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
        return new Vector(x.get() - other.x.get(),y.get() - other.y.get(),z.get() - other.z.get());
    }

    public Point3D add(Vector vec)
    {
        nullArgumentReaction(vec);
        Point3D temp = new Point3D(vec.getDirection());
        return new Point3D(temp.x.get() + x.get(),temp.y.get() + y.get(),temp.z.get() +z.get());
    }

    private double distance2(Point3D other)
    {
        nullArgumentReaction(other);

        double temp = (x.get() - other.x.get())*(x.get() - other.x.get()) + (y.get() - other.y.get())*(y.get() - other.y.get())
                + (z.get() - other.z.get())*(z.get() - other.z.get());
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
    private boolean legalArguments(Coordinate x,Coordinate y, Coordinate z)
    {
        if(x == null || y == null || z == null ||x.get() == 0 || y.get() == 0 || z.get() == 0)
        {
            return false;
        }
        return true;
    }

    private void nullArgumentReaction(Object... obj)
    {
        for(Object o:obj)
        {
            if(o == null)
            {
                throw new NullPointerException("One or more null arguments provided");
            }
        }
    }
}
