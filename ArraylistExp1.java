import java.util.ArrayList;
import java.util.*;
public class ArraylistExp1 {
public static void main(String ar[])
    {
        ArrayList<Integer> st=new ArrayList<>();  //it does not support premitive class
        st.add(23);                             //we use the Wrapper class.
        st.add(24);
        st.add(25);
        st.add(26);
        st.add(27);
        System.out.println(st);
        st.clear();
        System.out.println(st);
    }
}