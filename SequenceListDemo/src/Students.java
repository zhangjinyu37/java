//ѧ����
public class Students {

	private String sid;// ѧ��
	private String name;// ����
	private String gender;// �Ա�
	private int age;// ����
    
	public Students()
	{
		
	}
	
	public Students(String sid,String name,String gender,int age)
	{
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.age =age;
	}
	
	public String toString()
	{
	   return "ѧ�ţ�"+this.getSid()+" ������"+this.getName()+" �Ա�"+this.getGender()+" ����:"+this.getAge();	
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
