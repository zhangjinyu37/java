//�����������Ľ����
public class MyBiTreeNode {

	private MyBiTreeNode leftNode;//���ӽ��
	private MyBiTreeNode rightNode;//�Һ��ӽ��
	private boolean leftFlag; //�Ƿ���������
	private boolean rightFlag;//�Ƿ���������
	private Object data;
	
	public MyBiTreeNode()
	{
		this.leftNode = null;
		this.rightNode = null;
		this.leftFlag = false;
		this.rightFlag = false;
	}
	
	public MyBiTreeNode(Object data)
	{
		this();
		this.data = data;
	}

	public MyBiTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(MyBiTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public MyBiTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(MyBiTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public boolean getLeftFlag() {
		return leftFlag;
	}

	public void setLeftFlag(boolean leftFlag) {
		this.leftFlag = leftFlag;
	}

	public boolean getRightFlag() {
		return rightFlag;
	}

	public void setRightFlag(boolean rightFlag) {
		this.rightFlag = rightFlag;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
