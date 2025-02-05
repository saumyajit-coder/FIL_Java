package VECTOR;

import java.util.Enumeration;
import java.util.Vector;

public class Vector_Eg {
    public static void main(String ar[])
    {
       // Vector v=new Vector(); //def 10 - cap +incr cap
        //Vector v=new Vector(4);//4 -initial capacity + incr cap
        Vector<Object> v=new Vector<>(4,2);//4 -initial cap + 2-incr cap
        System.out.println("Capacity: "+v.capacity());  //capacity=4
        System.out.println("Size: "+v.size());  //size=0
        v.add(23);
        v.add(23);
        v.add(23);
        v.add(23);
        v.add(23);
        System.out.println("Capacity: "+v.capacity());  //capacity=4+2 incr=6
        System.out.println("Size: "+v.size());  //size=5
        Enumeration<Object> e=v.elements();
        while(e.hasMoreElements())
        {
            System.out.print("\t"+e.nextElement());
        }
    }
}
