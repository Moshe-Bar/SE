package primitives;


public class Vector
{
    //default values
    private static final Point3D defaultDirection =  new Point3D(1,1,1);
    private static final double defaultSize  = Math.sqrt(3);
    boolean normalized;

    //fields
    private Point3D direction;
    private double size;


    //constructors
    public Vector(double x,double y,double z)
    {
        normalized = false;
        try {
            //nullArgumentReaction(x,y,z);
        }
        catch(NullPointerException ex)
        {
            setDefaultValues();
            throw ex;
        }

        this.direction = new Point3D(x,y,z);
        initialSize();
    }


    public Vector(Point3D direction)
    {
        normalized = false;
        try {
            nullArgumentReaction(direction);
        }
        catch (NullPointerException ex)
        {
            setDefaultValues();
            throw ex;
        }

        this.direction = new Point3D(direction);
        initialSize();
    }


    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {
        normalized = false;
        try {
            nullArgumentReaction(x,y,z);
        }
        catch (NullPointerException ex)
        {
            setDefaultValues();
            throw ex;
        }

        this.direction = new Point3D(x,y,z);
        initialSize();
    }

    public Vector(Vector other)
    {
        normalized = false;
        try {
            nullArgumentReaction(other);
        }
        catch (NullPointerException ex)
        {
            setDefaultValues();
            throw ex;
        }

        this.direction = new Point3D(other.direction);
        this.size = other.size;
    }

    //getters
    public Point3D getDirection() {
        return direction;
    }

    public double getSize()
    {
        return size;
    }

    //override
    @Override
    public String toString()
    {
        return  "Direction : " + direction.detailsToString() + "\n" + "Size = " + size;
    }

    public boolean equals(Object other)
    {
        if(this == other)return true;
        if(!(other instanceof Vector))
        {
            return false;
        }
        if(other == null) return false;
        Vector otherVec = (Vector)other;
        return this.direction.equals(otherVec.direction) && this.size == otherVec.size;
    }



    private void initialSize()
    {
        this.size = Math.sqrt(Math.pow(this.direction.getX().get(),2)+ Math.pow(this.direction.getY().get(),2) + Math.pow(this.direction.getZ().get(),2));
    }
    private void nullArgumentReaction(Object... obj)
    {
        for (Object item:obj)
        {
            if(item == null)
            {
                throw new NullPointerException("One or more null arguments provided");
            }
        }
    }

    //Math functions
    public Vector add(Vector other)
    {
        nullArgumentReaction(other);
        return new Vector(this.direction.add(other));
    }

    public Vector subtract(Vector other)
    {
        nullArgumentReaction(other);
        return  new Vector(this.direction.subtract(other.direction));
    }

    public Vector scale(double scalar)
    {
        return new Vector(new Point3D(this.direction.getX().get()*scalar,this.direction.getX().get()*scalar,this.direction.getX().get()*scalar));
    }

    public double dotProduct(Vector other)
    {
        return direction.getX().get()*other.direction.getX().get() + direction.getY().get()*other.direction.getY().get()
                + direction.getZ().get()*other.direction.getZ().get();
    }

    public Vector crossProduct(Vector other)
    {
        double crossVector_x = direction.getY().get()*other.direction.getZ().get() - direction.getZ().get()*other.direction.getY().get();
        double crossVector_y = direction.getZ().get()*other.direction.getX().get() - direction.getX().get()*other.direction.getZ().get();
        double crossVector_z = direction.getX().get()*other.direction.getY().get() - direction.getY().get()*other.direction.getX().get();

        return new Vector(crossVector_x,crossVector_y,crossVector_z);
    }

    private double length2()
    {
        return direction.getX().get()*direction.getX().get() + direction.getY().get()*direction.getY().get() + direction.getZ().get()*direction.getZ().get();
    }

    public double length()
    {
        return Math.sqrt(length2());
    }

    private Vector normalize()
    {
        if(normalized)
        {
            return this;
        }
        Point3D temp = new Point3D(direction.getX().get()/size,direction.getY().get()/size,direction.getY().get()/size);
        this.direction = new Point3D(temp);
        normalized = true;
        return this;
    }

    public Vector normalized()
    {
        if(normalized)return new Vector(this);
        return new Vector(normalize());
    }


    private void setDefaultValues()
    {
        this.direction = defaultDirection;
        this.size = defaultSize;
    }
}
