
public class HashItem {
  
	private int info; // ��ʾ�Ƿ��ѱ�ռ��
	private int data; // ������
	
	HashItem(int data)
	{
		this.data = data;
	}
	
	HashItem(int info,int data)
	{
		this.info = info;
		this.data = data;
	}
	
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
	
	
}
