//���ȼ�����Ԫ����
public class Element {

	private Object element; // ����
	private int priority; // ���ȼ�
    
	public Element(Object obj,int priority)
	{
		this.element = obj;
		this.priority = priority;
	}
	
	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
