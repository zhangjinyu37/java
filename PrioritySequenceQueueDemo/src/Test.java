
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       PrioritySequenceQueue queue = new PrioritySequenceQueue();
       Element temp;
       
       //����������
       queue.append(new Element(1,30));
       queue.append(new Element(2,20));
       queue.append(new Element(3,40));
       queue.append(new Element(4,20));
       queue.append(new Element(5,0));
       
       //�������ȼ����ӡ�
       System.out.println("���  ���ȼ�");
       while(!queue.isEmpty())
       {
    	   temp =(Element)queue.delete();
    	   System.out.println(temp.getElement()+" "+temp.getPriority());
       }
       
       
	}

}
