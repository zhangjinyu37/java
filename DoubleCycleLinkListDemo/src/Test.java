
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      DoubleCycleLinkList list = new DoubleCycleLinkList();
      for(int i=0;i<10;i++)
      {
    	 int temp = ((int)(Math.random()*100))%100;
    	 list.insert(i, temp);
    	 System.out.print(temp+" ");
      }
      list.delete(4);
      System.out.println("\n------ɾ�������Ԫ��֮��-------");
	  for(int i=0;i<list.size;i++)
	  {
		  System.out.print(list.get(i)+" ");
	  }
	}

}
