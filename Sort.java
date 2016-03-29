
public class Sort {

	/**
	 * @param args
	 */
	static int[] bubble_sort(int[] unsorted)
    {
        for (int i = 0; i < unsorted.length; i++)
        {
            for (int j = 0; j < unsorted.length-i-1; j++)
            {
                if (unsorted[j] > unsorted[j+1])
                {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = temp;
                    //System.out.println("change:"+unsorted[j]+"<->"+unsorted[j+1]);
                }
                
            }
        }
        return unsorted;
    }
	static int[] insert_sort(int[] unsorted){
		int size=unsorted.length;
		int[] sorted=new int[size];
		for(int i=0;i<size;i++){
			int j=0;
			for(j=0;j<i;j++){
				if(unsorted[i]<=sorted[j]){
					//add to the font and move the others after its current position
					int last=i;
					while(last!=j){
						sorted[last]=sorted[last-1];
				        last--;
					}
					sorted[j]=unsorted[i];
					break;
				}	
			}
			if(j==i)  //biggest than every number in array sorted
				sorted[j]=unsorted[i];
			
		}
		return sorted;
	}
    
	static int[] shell_sort(int[] unsorted){
		int[] base={5,3,1};
		int len=unsorted.length;
		for(int i=0;i<base.length;i++){
			for(int j=0;base[i]+j<len;j++){
				int[] arr = new int[(len-j-1)/base[i]+1];
				int index=0;
				for(int z=j;z<len;z+=base[i])
					arr[index++]=unsorted[z];
				arr=insert_sort(arr);
				index=0;
				for(int z=j;z<len;z+=base[i])
					unsorted[z]=arr[index++];
			}
		}
		return unsorted;
	}
	
	static int[] quick_sort(int[] unsorted){
		int len= unsorted.length;
	    int i=0,j=len-1,k=unsorted[0],flag_index=0;
	    while(i<j){
	    	//find the number smaller than k, swap unsorted[j] and unsorted[i]
	    	while(j>i&&unsorted[j]>=k){
	    	 j--;	
	    	}
	    	if(j>i){
	    		//int temp=unsorted[i];
	    		unsorted[i]=unsorted[j];
	    		unsorted[j]=k;
	    		flag_index=j;//current the jth number is  k
	    	}
	    	//find the number bigger than k, swap unsorted[i] and unsorted[j]
	    	while(i<j&&unsorted[i]<=k){
		    	 i++;	
		    }
		    if(i<j){
		    		//int temp=unsorted[i];
		    	 unsorted[j]=unsorted[i];
		    	 unsorted[i]=k;
		    	 flag_index=i;//current the ith number is  k
		    }
	    }
		//the first sort in over, and recursively for the left and the right part
	    int[] left_arr=new int[flag_index],right_arr=new int[len-flag_index-1];
	    for(i=0;i<left_arr.length;i++)
	    	left_arr[i]=unsorted[i];
	    for(i=flag_index+1;i<len;i++)
	    	right_arr[i-flag_index-1]=unsorted[i];
	    if(left_arr.length>1)
	       left_arr=quick_sort(left_arr);
	    if(right_arr.length>1)
	       right_arr=quick_sort(right_arr);
	    for(i=0;i<len;i++){
	    	if(left_arr.length>1&&i<flag_index) unsorted[i]=left_arr[i];
	        if(right_arr.length>1&&i>flag_index) unsorted[i]=right_arr[i-flag_index-1];
	    }
		return unsorted;
	}
	static int[] merge_sort(int[] unsorted,int low, int high){
		int mid=(low+high)/2;
		if(low<high){
			unsorted=merge_sort(unsorted,low,mid);
			unsorted=merge_sort(unsorted,mid+1,high);
			unsorted=merge(unsorted,low,mid,high);
		}
		return unsorted;
	}
	static int[] merge(int[] sorted,int low, int mid, int high){
		//merge the left and the right part while we sort them
		int i=low,j=mid+1,k=0;
		int[] temp_arr=new int[high-low+1];
		while(i<=mid&&j<=high){
			if(sorted[i]<sorted[j]){
				temp_arr[k++]=sorted[i++];
			}else{
				temp_arr[k++]=sorted[j++];
			}
		}
		//put the rest into the temp_arr
		while(i<=mid){
			temp_arr[k++]=sorted[i++];
		}
		while(j<=high){
			temp_arr[k++]=sorted[j++];
		}
		//override the array sorted
		for(i=low;i<=high;i++)
			sorted[i]=temp_arr[i-low];
		return sorted;
	}
   /* public static void main(String[] args)
    {
        //int[] x = {6,2,4,1,5,9};
    	int x[]= {6,2,4,1,5,9};
        //x=bubble_sort(x);
    	//x=insert_sort(x);
    	//x=shell_sort(x);
    	//x=quick_sort(x);
    	x=merge_sort(x,0,5);
        for(int item : x)
        {
            System.out.print(item);
        }
    }*/

}
