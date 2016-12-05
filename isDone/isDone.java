//First
public boolean isDone(){
  List<Integer> nums = new ArrayList<Integer>();
  for(int i=1; i<16;i++){ 
    nums.add(i);
  }
  for(int r=0, i=0; r <side; r++, i++){
      for(int c=0; c <side; c++){
	  if(values[r][c]==nums.get(i)){
	      nums.remove(i);
	      i++;
	  }
	  else if(values[r][c]==0){
	      i++;
	  }
      }
  }
  return nums.size()==0;
}
  
  
