//�����������
public class BiTreeNode {

	private BiTreeNode leftChild; // ����
	private BiTreeNode rightChild; // �Һ���
	private Object data; // ����Ԫ��

	BiTreeNode() {
		this.leftChild = null;
		this.rightChild = null;
	}
    
	BiTreeNode(Object data,BiTreeNode leftNode,BiTreeNode rightNode)
	{
		this.data = data;
		this.leftChild = leftNode;
		this.rightChild = rightNode;
	}
	
	
	public BiTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BiTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BiTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BiTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
