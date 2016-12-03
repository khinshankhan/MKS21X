import java.util.*;
public class SuperArrayIterator implements Iterable<String>{
    int start,end;
    public SuperArrayIterator(int start, int end){
    this.start = start;
    this.end = end;
  }
    public Integer next(){
    if(hasNext()){
      start++;
      return start-1;
    }else{
      throw new NoSuchElementException();
    }
  }

  public boolean hasNext(){
    return start < end;
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }

}
