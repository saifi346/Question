
public class QuickSort {
	
	static int partition(int[] a,int low ,int high) {
		int p= a[high];
		int i =low-1;
		for(int j=low;j<high;j++) {
			if(a[j]<p) {
				i++;
				int temp = a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp = a[i+1];
		a[i+1]=a[high];
		a[high]=temp;
		return i+1;
	}

	static void sort(int[] a,int low, int high) {
		if(low<high) {
			
		    int p=partition(a,low,high);
			sort(a,low,p-1);
			sort(a,p+1,high);
		}
	}

	static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public static void main(String args[]) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		sort(arr,0,arr.length-1);
		System.out.println("Sorted array");
		print(arr);
	}

}
