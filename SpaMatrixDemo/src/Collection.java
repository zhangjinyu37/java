
public interface Collection {
  
	//��ָ��λ�����
	public void add(int index,Object element) throws Exception;
	//�ڼ���ĩ�����
	public void add(Object element) throws Exception;
	//��ָ��λ������Ԫ��
	public void set(int index,Object element) throws Exception;
    //���ָ��λ�õ�Ԫ��
	public Object get(int index) throws Exception;
	//��ü��ϴ�С
	public int size();
	//��ָ��λ��ɾ��
	public void remove(int index) throws Exception;
	//ɾ��ָ������
	public void remove(Object element) throws Exception;
	//�Ƿ����ָ������
	public boolean contain(Object element) throws Exception;
	
	
}
