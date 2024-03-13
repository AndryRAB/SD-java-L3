package examplehash;
public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.x;
        hash = 73 * hash + this.y;
        return hash;
    }

    
    @Override
    public boolean equals(Object autre) {
        if (this == autre) //raha mitovy adresse dia mlam
            return true;
        if (autre == null) 
            return false;
        if (getClass() != autre.getClass()) 
            return false;
        // après ny fialan tsiny dia zay vao mikabary
        final Point2D other = (Point2D) autre;
        return (this.x==other.x)&&(this.y==other.y);
    }
    
    
}
