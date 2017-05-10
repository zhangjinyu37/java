
public class SpaMatrix {
   
	int rows; //����
	int cols; //����
	int dNum;//����Ԫ�ظ���
    MyVector v;
    
    SpaMatrix(int max)
    {
    	rows = cols = dNum=0;
    	v = new MyVector(max);
    }
    
    //�����û���������Ԫ�����飬����ʼ������
    public void evaluate(int r,int c,int d,Three[] item)throws Exception
    {
    	this.rows = r;
    	this.cols = c;
    	this.dNum = d;
    	for(int i=0;i<d;i++)
    	{
    		v.add(i, item[i]);
    	}
    }
    
    //ϡ������ת��
    public SpaMatrix transport()throws Exception
    {
    	SpaMatrix a = new SpaMatrix(v.size());
    	a.rows = this.cols;
    	a.cols = this.rows;
    	a.dNum = this.dNum;
    	
    	for(int i=0;i<dNum;i++)
    	{
    		Three t = (Three)v.get(i);
    	    a.v.add(i, new Three(t.col,t.row,t.value));
    	}
    	return a;
    }
    
    //��ӡϡ�����ķ���
    public void print() throws Exception
    {
    	System.out.println("�����������"+this.rows);
    	System.out.println("�����������"+this.cols);
    	System.out.println("����Ԫ�ظ�����"+this.dNum);
    	
    	System.out.println("������Ԫ��Ϊ��");
    	for(int i=0;i<dNum;i++)
    	{
    	   System.out.println("a<"+((Three)v.get(i)).row+","+((Three)v.get(i)).col+">="+((Three)v.get(i)).value);	
    	}
    }
}
