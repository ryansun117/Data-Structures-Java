
public class test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    SongCollection test = new SongCollection();
//    test.setPlayDirection(false);
    Song a = new Song("a", "aa");
    Song b = new Song("b","bb");
    Song c = new Song("c", "cc");
    test.add(a);
    test.add(b);
    test.add(c);
//    test.remove();
    for(Song i : test)
      System.out.println(i);
    
//    String dd= null;
//    boolean trrr = dd.equals("aa");
    

//  SongCollection a = new SongCollection();
//  a.add(new Song("a", "1"));
//  a.remove();
//  a.remove();
  
  }

}
