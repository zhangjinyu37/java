import java.util.Vector;

/**
 * ������������
 * @author simoniu
 *
 */
public class BiSearchTree{
	private BiTreeNode root;
	Vector vector = new Vector();
	
	private void inOrder(BiTreeNode t, Visit vs){
		if(t != null){
			inOrder(t.getLeft(),vs);
			vs.print(new Integer(t.getData()));
			inOrder(t.getRight(),vs);
		}
	}
	
	private void preOrder(BiTreeNode t, Visit vs){
		if(t != null){
			vs.print(new Integer(t.getData()));
			preOrder(t.getLeft(),vs);
			preOrder(t.getRight(),vs);
		}
	}
	
	public BiSearchTree(){
		root = null;		
	}
	
	public void setRoot(BiTreeNode t){
		root = t;		
	}
	
	public BiTreeNode getRoot(){
		return root;		
	}
	
	public void inOrder(Visit vs){
		inOrder(root, vs);
	}
	
	public void preOrder(Visit vs){
		preOrder(root, vs);
	}
	
	public BiTreeNode getLeft(BiTreeNode current){
		return current != null ? current.getLeft() : null;
	}
	
	public BiTreeNode getRight(BiTreeNode current){
		return current != null ? current.getRight() : null;
	}
	
	public BiTreeNode find(int item){
		if(root != null){
			BiTreeNode temp = root;
			while(temp != null){
				if(temp.getData() == item) return temp;//���ҳɹ�

				if(temp.getData() < item)
					temp = temp.getRight();			//������������
				else
					temp = temp.getLeft();			//������������
			}
		}
		return null;									//����ʧ��
	}
	
	public void insert(BiTreeNode ptr, int item){
		if(item < ptr.getData()){
			if(ptr.getLeft() == null){
				BiTreeNode temp = new BiTreeNode(item);	//�����½��
				temp.setParent(ptr);	//��ptr�����Ϊtemp���ĸ����
				ptr.setLeftChild(temp);	//��temp�����Ϊptr�������ӽ��
			}			   
			else insert(ptr.getLeft(), item); 		//���������ݹ�
		}
		else if(item > ptr.getData()){
			if(ptr.getRight() == null){
				BiTreeNode temp = new BiTreeNode(item); //�����½��
				temp.setParent(ptr); //��ptr�����Ϊtemp���ĸ����
				ptr.setRightChild(temp); //��temp�����Ϊptr�����Һ��ӽ��
			}			   
			else insert(ptr.getRight(), item); 		//���������ݹ�
		}
		return;	
	}

	public void delete(BiTreeNode ptr, int item){
		if(ptr != null){
			if(item < ptr.getData())
				//���������ݹ�
				delete(ptr.getLeft(), item);
			else if(item > ptr.getData())
				//���������ݹ�
				delete(ptr.getRight(), item);
			else if(ptr.getLeft() != null && ptr.getRight() != null){
				//Ҫɾ�����Ѱ�ҵ�������Ҫɾ������������������ڵ����
				BiTreeNode min;
				min = ptr.getRight();			//ȡ��ǰ�����Һ��ӽ��
				while(min.getLeft() != null)
					min = min.getLeft();		//minȡ�������ӽ��
				ptr.setData(min.getData());//��min������ֵ����ptr���
				delete(ptr.getRight(), min.getData());	
					//��ptr�����������еݹ�ɾ��min���
			}
			else{
				if(ptr.getLeft() == null && ptr.getRight() != null){
				//Ҫɾ�����Ѱ�ҵ�������Ҫɾ�����ֻ�������������
					ptr.getParent().setRightChild(ptr.getRight());
						//��ptr˫�׵��Һ���ָ��ָ��ptr���Һ��ӽ��
					ptr.getRight().setParent(ptr.getParent());	
						//��ptr�Һ��ӵ�˫��ָ��ptr��˫�׽��	
				}				    
					
				else if(ptr.getRight() == null && ptr.getLeft() != null){
				//Ҫɾ�����Ѱ�ҵ�������Ҫɾ�����ֻ�������������
					 ptr.getParent().setLeftChild(ptr.getLeft());
						//��ptr˫�׵����ӽ��ָ��ptr�������ӽ��
					 ptr.getLeft().setParent(ptr.getParent());
						//��ptr���ӵ�˫��ָ��ptr��˫�׽��	
				}					
					
				else{
					//Ҫɾ�����Ѱ�ҵ�������Ҫɾ�����ΪҶ�������
					BiTreeNode p = 	ptr.getParent();
					if(p.getLeft() == ptr)	//��Ҫɾ�������˫�׵�������
						p.setLeftChild(null);	//��˫�׵������ÿ�
					else				//��Ҫɾ�������˫�׵��Һ�����
						p.setRightChild(null); 	//��˫�׵��Һ����ÿ�
				}
			}	
		}
	}
}