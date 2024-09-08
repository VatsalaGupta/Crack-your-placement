import java.util.*;//pratice

public class Main {
	public static void main(String[] args) {
		// int arr[]={2,5,8,9,10,4};
		// int n=6;

		// int key=1;
		// int index=linearSearch(n,arr,key);
		// if(index==-1){
		// System.out.print("not found");
		// }else {
		// System.out.print("found");
		// }

		// int largest=largest(n,arr);
		// System.out.print(largest);

		// System.out.println();

		// int smallest=smallest(n,arr);
		// System.out.print(smallest);

		// int arr[]={2,3,4,5,6,7,78,90};
		// int n=8;
		// int target=92;
		// binarySearch(n,arr,target);

		// reverse(arr,n);
		// for(int i=0;i<n;i++){
		// System.out.print(arr[i]+" ");
		// }

		// pairs(arr,n);

		// int arr[]={2,3,4,5};
		// int n=4;
		// subArray(n,arr);
	}

	public static int linearSearch(int n, int arr[], int key) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int largest(int n, int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int smallest(int n, int arr[]) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void binarySearch(int n, int arr[], int target) {
		int start = 0;
		int end = n - 1;
		int ans = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				ans = mid;
				break;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.print(ans);
	}

	public static void reverse(int arr[], int n) {
		int start = 0;
		int end = n - 1;

		while (start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}

	public static void pairs(int arr[], int n) {
		int ts = 0;
		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			for (int j = i + 1; j < n; j++) {
				System.out.print("(" + curr + " " + arr[j] + ")");
				ts++;
			}
			System.out.println();
		}
		System.out.print(ts);
	}

	public static void subArray(int n, int arr[]) {
		for (int i = 0; i < n; i++) {
			int start = i;
			for (int j = i; j < n; j++) {
				int end = j;
				for (int k = start; k <= end; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void maxSub(int n, int arr[]) { // brute force= o(n^3)
		int currSum = 0;
		int maxsum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int start = i;
			for (int j = i; j < n; j++) {
				int end = j;
				currSum = 0;
				for (int k = start; k <= end; k++) {
					currSum += arr[k];
				}
				// System.out.print(currSum+" ");
				if (maxsum < currSum) {
					maxsum = currSum;
				}
				// System.out.println();
			}
		}
		System.out.print("maxsum=" + maxsum + " ");
	}
	public static void maxxSub(int n,int arr[]){ //prefix sum o(n^2)
	    int currSum=0;
	    int maxsum=Integer.MIN_VALUE;
	    
	    int prefix[]=new int[arr.length];
	    prefix[0]=arr[0];
	    for(int i=1;i<n;i++){
	        prefix[i]=prefix[i-1]+arr[i];
	    }
	    
	    for(int i=0;i<n;i++){
	        int start=i;
	        for(int j=i;j<n;j++){
	            int end=j;
	            currSum=start==0?prefix[end]:prefix[end]-prefix[start-1];
	            if(maxsum<currSum){
	                maxsum=currSum;
	            }
	        }
	    }
	    System.out.print("maxsum="+maxsum+" ");
	}
	public static void kadane(int n,int arr[]){ //kadane's algorithm
	    int currSum=0;
	    int maxSum=Integer.MIN_VALUE;
	    
	    for(int i=0;i<n;i++){
	        currSum+=arr[i];
	        if(currSum<0){
	            currSum=0;
	        }
	        maxSum=Math.max(maxSum,currSum);
	    }
	    System.out.print(maxSum);
	}
}