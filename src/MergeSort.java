
public class MergeSort {
	
	static void merge(int[] a,int l,int m,int r) {
		int i,j,k;
		int n1 = m-l+1;
		int n2 = r-m;
		int L[] = new int[n1];
		int[] R = new int[n2];
		for(i=0;i<n1;i++)
			L[i] = a[l+i];
		for(j=0;j<n2;j++)
			R[j] = a[m+1+j];
		
		i=0;j=0;k=l;
		while(i<n1&&j<n2) {
			if(L[i]<=R[j]) {
				a[k] = L[i];
				i++;
			}
			else {
				a[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			a[k]=L[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			a[k]=R[j];
			j++;
			k++;
		}
		
	}
	
	static void mergeSort(int[] a, int l, int r) {
		if(l<r) {
			int m = l + (r-l)/2;
			mergeSort(a, l, m);
			mergeSort(a, m+1, r);
			merge(a,l,m,r);
			
		}
	}

	static void print(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+",");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted array");
		print(arr);
	}

}
