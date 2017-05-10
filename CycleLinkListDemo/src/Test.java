
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      /*
	  CycleLinkList list = new CycleLinkList();
      for(int i=0;i<10;i++)
      {
    	 int temp = ((int)(Math.random()*100))%100;
    	 list.insert(i, temp);
    	 System.out.print(temp+" ");
      }
      list.delete(4);
      System.out.println("\n------删除第五个元素之后-------");
	  for(int i=0;i<list.size;i++)
	  {
		  System.out.print(list.get(i)+" ");
	  }*/
		
	  Game game = new Game(10,3);
	  game.play();
	
	}

}
