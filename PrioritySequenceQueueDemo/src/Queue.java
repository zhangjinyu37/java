//���нӿ�
public interface Queue {

   //���
   public void append(Object obj) throws Exception;
   //����
   public Object delete() throws Exception;
   //��ö�ͷԪ��
   public Object getFront() throws Exception;
   //�ж϶����Ƿ�Ϊ��
   public boolean isEmpty();
}
