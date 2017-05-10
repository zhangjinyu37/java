
public class Test {

	public static void main(String[] args) {
      
		MyHashTable myHashTable = new MyHashTable(13);
		int[] a = {180,750,600,430,541,900,460}; 
		int i, j, n = 7, item;
		try
		{
			for(i = 0; i < n; i++)
				myHashTable.insert(a[i]);
			
			for(i = 0; i < n; i++){
				j = myHashTable.find(a[i]);
				if(j >= 0){
					item = myHashTable.getValue(j);
					System.out.println("j = " + j + "  ht[] = " + item);
				}
			}
			System.out.println("删除430之前：");
			if(myHashTable.isIn(430))
			{
				System.out.println("元素存在！");
			}
			else
			{
				System.out.println("元素不存在！");
			}
			
			myHashTable.delete(430);
			
			System.out.println("删除430之后：");
			if(myHashTable.isIn(430))
			{
				System.out.println("元素存在！");
			}
			else
			{
				System.out.println("元素不存在！");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
