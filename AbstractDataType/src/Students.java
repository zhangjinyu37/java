import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//���һ��ѧ����
public class Students {
  
    private String sid;//ѧ��
    private String name;//����
    private char gender;//�Ա�
    private Date birthday;//��������
    private String contact;//��ַ
	
    public Students(String sid,String name,char gender,Date birthday,String contact)
    {
       this.sid = sid;
       this.name = name;
       this.gender = gender;
       this.birthday = birthday;
       this.contact = contact;
    }
    
	void printStudentsInfo()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		System.out.println("ѧ�ţ�"+this.sid);
		System.out.println("������"+this.name);
		System.out.println("�Ա�"+this.gender);
		System.out.println("�������ڣ�"+sdf.format(this.birthday));
		System.out.println("��ϵ��ʽ��"+this.contact);
	}
	
	public static void main(String[] args)
	{
		Calendar c = Calendar.getInstance();
		c.set(1995, 5, 30);
		Date d = c.getTime();
		Students s=new Students("S0001","������",'��',d,"�����и�����·50��");
	    
	    s.printStudentsInfo();
	}
}
