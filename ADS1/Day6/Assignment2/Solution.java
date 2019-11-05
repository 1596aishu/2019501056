import java.lang.*;
import java.util.*;
class DynamicMedian {
    /**
     *The object for minheap.
     */
     MinPQ<Double > minpq;
    /**
     *The object for maxheap.
     */
     MaxPQ<Double > maxpq;
    /**
     * constructor to init.
     */
    DynamicMedian() {
        minpq = new MinPQ<Double>();
        maxpq = new MaxPQ<Double>();
    }
    /**
     * to insert the element into minheap
     * @param      item  The item
     */
    public  void insertAtMin(final double item) {
        minpq.insert(item);
    }
    /**
     * to insert the item into the maxheap
     * @param      item  The item
     */
    public  void insertAtMax(final double item) {
        maxpq.insert(item);
    }
    /**
     * @return    the minimum value
     */
    public  double getMin() {
        return minpq.min();
    }
    /**
     * @return     gets the maximum values
     */
    public  double getMax() {
        return maxpq.max();
    }
    /**
     * @return  maximum value
     */
    public  double delMax() {
        return maxpq.delMax();
    }
    /**
     * @return  The minimum. value from minheap
     */
    public  double delMin() {
        return minpq.delMin();
    }
    /**
     *gets the size of minheap.
     *
     * @return     The minimum size.
     */
    public  int getMinSize() {
        return minpq.size();
    }
    /**
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     */
    public  int getMaxSize() {
        return maxpq.size();
    }
}
 class Solution{
   
    public static double[] dynamicMedian(double[] arr){
        DynamicMedian Dm = new DynamicMedian();
        double med = 0;              
        double[] median = new double[arr.length];
        
		for(int i = 0; i < arr.length; i++){
			if (arr[i] > med) {
				Dm.insertAtMin(arr[i]);
			}
			else if (arr[i] < med) {
				Dm.insertAtMax(arr[i]);
			} 
			else {
				Dm.insertAtMin(arr[i]);
			}
			if (Dm.getMinSize() - Dm.getMaxSize() > 1) {
				Dm.insertAtMax(Dm.delMin());
			}
			if (Dm.getMaxSize() - Dm.getMinSize()  > 1) {
				Dm.insertAtMin(Dm.delMax());
			}
			if (Math.abs(Dm.getMinSize() - Dm.getMaxSize()) == 1) {
				if (Dm.getMinSize() > Dm.getMaxSize()) {
                    med = Dm.getMin();
                    median[i] = med;
				
				}
				else {
                med = Dm.getMax();
                median[i] = med;
				
			}
		}
		if (Dm.getMinSize()  == Dm.getMaxSize()) {
			double min = Dm.getMin();
			double max = Dm.getMax();
            med = (min + max) / 2.0;
            median[i] = med;
			
		}
	}

		return median;
}
 }

