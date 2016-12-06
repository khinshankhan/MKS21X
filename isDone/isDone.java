//First
public boolean isDone(){
  List<Integer> nums = new ArrayList<Integer>();
  for(int i=0; i<15;i++){ 
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
//DIDNT COMPARE ON BOTH SIDES GRRRR
/*public boolean isDone(){
    int num=0;
    for(int r=0; r <side; r++){
	for(int c=0; c <side; c++){
	  if(values[r][c]!=0){
	      if(values[r][c]!=num+1){
		  return false;
	      }
	      num=values[r][c];
	  }
      }
    }
    return true;
    }*/

//REAL SECOND AFTER MUCH WORK 
public boolean isDone(){
	for(int i = 0; i < side; i++){
	    for(int a = 0; a < side; j++){
		if(!(i == side-1 && a == side-1)){
		    int r = 0;
		    int c = 0;
		    if(a == side-1){
			r = 1;
			c = a + 1;
		    }
		    if(!(values[i][a] < values[i+r][a+1-c] || values[i+r][a+1-c] == 0)){
			return false;
		    }	    
		}
	    }
	}
	return true;
    }
//Three
public boolean isDone(){
    for(int i=0, r=0, c=0;i<15; c++){
	if()}}
