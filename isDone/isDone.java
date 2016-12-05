//First
public boolean isDone(){
  List<Integer> nums = new ArrayList<Integer>();
  for(int i=1; i<16;i++){ 
    nums.add(i);
  }
  for(int r=0, i=0; r <side; r++){
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

//Second
public boolean isDone(){
    int num=0;
    bool broke=false
    for(int r=0; r <side&& !broke; r++){
      for(int c=0; c <side; c++){
	  if(values[r][c]!=0){
	      if(values[r][c]!=num+1){
		  broke=true;
		  break;
	      }
	  }
      }
    }
    return !broke;
}
//Three
public boolean isDone(){
    for(int i=0, r=0, c=0;i<15; c++){
	if(
