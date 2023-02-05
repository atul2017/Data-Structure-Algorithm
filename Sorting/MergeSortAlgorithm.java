package Sorting;

public class MergeSortAlgorithm {

    public static void main(String[] args){
        System.out.println("This sample code is for the Merge Sort");
        int arr[] = {5,7,10,45,1,3,9};
        new MergeSortAlgorithm().sortArray(arr,0,arr.length-1);
    }


    void sortArray(int[] arr, int start, int end){

        if(start<end){
            int mid = (start+end-1)/2;

            sortArray(arr,start,mid);

            sortArray(arr,mid+1,end);

            mergeArrays(arr,start,mid,end);
        }
    }


    void mergeArrays(int[] arr,int start,int mid,int end){

        System.out.print("Hi");

        int arrayOneLength =  mid-start+1;
        int arrayTwoLength =  end-mid;

        int[] arrayOne = new int[arrayOneLength];
        int[] arrayTwo = new int[arrayTwoLength];

        for(int d=0;d<arrayOneLength;d++){
            arrayOne[d] = arr[start+d];
        }
        for(int p=0;p<arrayTwoLength;p++){
            arrayTwo[p] = arr[mid+1+p];
        }

        int i=0;
        int j=0;
        int k=start;

        while(i<arrayOneLength && j<arrayTwoLength){
            if(arrayOne[i]<=arrayTwo[j]){
                arr[k] = arrayOne[i];
                i++;
            }else {
                arr[k] = arrayTwo[  j];
                j++;
            }
            k++;
        }

        while(i<arrayOneLength){
            arr[k] = arrayOne[i];
            i++;
            k++;
        }

        while(j<arrayTwoLength){
            arr[k] = arrayTwo[j];
            j++;
            k++;
        }

        //print the result array
        for(int d=0;d<arr.length;d++){
            System.out.print(arr[d]+" ");
        }
    }
}
