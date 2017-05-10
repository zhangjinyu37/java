import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//设计一个学生类
public class Students {
  
    private String sid;//学号
    private String name;//姓名
    private char gender;//性别
    private Date birthday;//出生日期
    private String contact;//地址
	
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println("学号："+this.sid);
		System.out.println("姓名："+this.name);
		System.out.println("性别："+this.gender);
		System.out.println("出生日期："+sdf.format(this.birthday));
		System.out.println("联系方式："+this.contact);
	}
	
	public static void main(String[] args)
	{
		Calendar c = Calendar.getInstance();
		c.set(1995, 5, 30);
		Date d = c.getTime();
		Students s=new Students("S0001","张三丰",'男',d,"西安市高新四路50号");
	    
	    s.printStudentsInfo();
	}
}
