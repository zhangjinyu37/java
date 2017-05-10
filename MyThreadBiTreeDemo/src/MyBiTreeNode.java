//线索二叉树的结点类
public class MyBiTreeNode {

	private MyBiTreeNode leftNode;//左孩子结点
	private MyBiTreeNode rightNode;//右孩子结点
	private boolean leftFlag; //是否是左线索
	private boolean rightFlag;//是否是右线索
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
