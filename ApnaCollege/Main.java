import java.util.*;//pratice

public class Main
{
	public static void main(String[] args) {
	  int arr[]={2,5,8,9,10,4};
	  int n=6;
	  
	  
// 	  int key=1;
// 	  int index=linearSearch(n,arr,key);
// 	  if(index==-1){
// 	      System.out.print("not found");
// 	  }else {
// 	      System.out.print("found");
// 	  }
     
     int largest=largest(n,arr);
     System.out.print(largest);
     
     System.out.println();
     
     int smallest=smallest(n,arr);
     System.out.print(smallest);
	}
	public static int linearSearch(int n,int arr[],int key){
	    for(int i=0;i<n;i++){
	        if(arr[i]==key){
	          return i;
	        }
	    }
	    return -1;
	}
	public static int largest(int n,int arr[]){
	    int max=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	        if(arr[i]>max){
	            max=arr[i];
	        }
	    }
	    return max;
	}
	public static int smallest(int n,int arr[]){
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<n;i++){
	        if(arr[i]<min){
	            min=arr[i];
	        }
	    }
	    return min;
	}
	public static void binarySearch(int n,int arr[],int target){
	    int start=0;
	    int end=n-1;
	    int ans=-1;
	    
	    while(start<=end){
	        int mid=(start+end)/2;
	        if(arr[mid]==target){
	            ans=mid;
	            break;
	        }else if(arr[mid]<target){
	            start=mid+1;
	        }else {
	            end=mid-1;
	        }
	    }
	    System.out.print(ans);
	}
}