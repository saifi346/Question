public class BubbleSort {

	static void sort(int a[]) {
		int n = a.length;
		for(int i=0;i<n-1;i++) 
			for(int j=0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
	}
	
	static void print(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+",");
		}
	}

	public static void main(String args[]) {
		int[] arr = {5,1,4,2,8};
	    sort(arr);
	    System.out.println("Sorted array");
	    print(arr);
	}
}