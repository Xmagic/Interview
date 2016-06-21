package IntersectionFor2Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class UniqueIntersection {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<Integer>();
        Integer[] arr2 = new Integer[nums2.length];
        for(int i =0;i< nums2.length; i++) {
        	arr2[i] = nums2[i];
        }
        
        for(int i =0;i< nums1.length; i++)
        {
        	List list2 = new ArrayList(Arrays.asList(arr2));
        	boolean isContains = list2.contains(nums1[i]);
            if(isContains)
                    result.add(nums1[i]);
        }
        
        int i =0;
        TreeSet<Integer> ts = new TreeSet<Integer>(result);
        int[] a = new int[ts.size()];
        Iterator<Integer> ite = ts.iterator();
        while(ite.hasNext()){
          a[i++] = ite.next();
        }
        return a;
    }

}
