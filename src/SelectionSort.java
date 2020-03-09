
public class SelectionSort {

	static void sort(int[] a) {
		int n =a.length;
		for(int i=0;i<n-1;i++) {
			int index = i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[index])
					index = j;
			}
			int temp=a[index];
			a[index] = a[i];
			a[i] = temp;
		}
	}
	
	static void print(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+",");
		}
	}

	public static void main(String[] args) {

		int arr[] = {64,25,12,22,11};
		sort(arr);
		System.out.println("Sorted array");
		print(arr);
	}

}
