//�����������
public class MyBiTreeNode {

	private MyBiTreeNode leftChild; // ����
	private MyBiTreeNode rightChild; // �Һ���
	private Object data; // ����Ԫ��

	MyBiTreeNode() {
		this.leftChild = null;
		this.rightChild = null;
	}
    
	MyBiTreeNode(Object data,MyBiTreeNode leftNode,MyBiTreeNode rightNode)
	{
		this.data = data;
		this.leftChild = leftNode;
		this.rightChild = rightNode;
	}
	
	
	public MyBiTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(MyBiTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public MyBiTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(MyBiTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
