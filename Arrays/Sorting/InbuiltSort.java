import java.util.*;
public class InbuiltSort {
    public static void main(String[] args) {
        Integer arr[]={3,1,9,7,8,5,56,34,98,0,7,-1,-9};
        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
