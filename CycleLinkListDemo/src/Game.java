//��Ϸ��
public class Game {

	//����ѭ������
	CycleLinkList list = new CycleLinkList();
	//������
	int num;
	//�������˳�
	int key;
	
	//��Ϸ��ʼ������
	public Game(int num,int key)
	{
	   this.num = num;
	   this.key = key;
	}
	
	public void play() throws Exception
	{
	   for(int i=0;i<num;i++)
	   {
		   list.insert(i, i);  
	   }
       
	   System.out.println("\n-------��Ϸ��ʼ֮ǰ---------\n");
	   for(int i=0;i<list.size;i++)
	   {
		   System.out.print(list.get(i)+" ");
	   }
	   System.out.println("\n-------��Ϸ��ʼ---------\n");
	   int iCount=num; //��ʼ����������num
	   int j=0; //�ۼ����������Ƿ��ܱ�key������
	   
	   Node node = list.head;
	   while(iCount!=1)
	   {
		  if(node.getElement()!=null&& Integer.parseInt(node.getElement().toString())!=-1)
		  {
			j++;  
			if(j%key==0)
			{
				node.setElement(-1);
				iCount--;
				System.out.println();
				for(int i=0;i<list.size;i++)
				{
				   System.out.print(list.get(i)+" ");
				}
			}
		  } 
	      node = node.next;
	   }
	   System.out.println("\n-------��Ϸ����---------\n");
	   for(int i=0;i<list.size;i++)
	   {
		   System.out.print(list.get(i)+" ");
	   }
	}
	
}
