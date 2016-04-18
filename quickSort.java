public int[] quickSort1(int[] arr,int low,int high){ //递归版
    	int i=low,j=high;
    	while(i<j){
	    	while(j>i&&arr[j]>=arr[i]){
	    		j--;
	    	}
	    	if(j>i){
	    		int temp=arr[j];
	    		arr[j]=arr[i];
	    		arr[i]=temp;
	    	}
	    	while(i<j&&arr[i]<=arr[j]){
	    		i++;
	    	}
	    	if(i<j){
	    		int temp=arr[i];
	    		arr[i]=arr[j];
	    		arr[j]=temp;
	    	}
    	}
    	//i==j
    	 if(i>low) quickSort1(arr,low,i-1);
    	 if(high>i) quickSort1(arr,i+1,high);
    	 return arr;
    }
    //数据规模很大时，递归的算法很容易导致栈溢出，改为非递归，模拟栈操作
    public int[] quickSort2(int[] arr){//非递归版，stack栈实现
    	Stack<Integer> stack=new Stack<Integer>();
    	int i=0,j=arr.length-1;
    	stack.push(j);
    	stack.push(i);
    	while(!stack.isEmpty()){
    		int low=stack.pop(),high=stack.pop();
    		i=low;j=high;
	    	while(i<j){
		    	while(j>i&&arr[j]>=arr[i]){
		    		j--;
		    	}
		    	if(j>i){
		    		int temp=arr[j];
		    		arr[j]=arr[i];
		    		arr[i]=temp;
		    	}
		    	while(i<j&&arr[i]<=arr[j]){
		    		i++;
		    	}
		    	if(i<j){
		    		int temp=arr[i];
		    		arr[i]=arr[j];
		    		arr[j]=temp;
		    	}
	    	}
	    	if(high>i){stack.push(high);stack.push(i+1);}//i==j,mid
	    	if(low<i){stack.push(i-1);stack.push(low);}
    	}
    	return arr;
    }
