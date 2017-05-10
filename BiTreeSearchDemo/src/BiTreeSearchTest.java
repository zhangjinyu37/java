
/**
 * ������
 * @author simoniu
 *
 */

public class BiTreeSearchTest{
	public static void main(String[] args){
		BiSearchTree searchTree = new BiSearchTree();
		int[] a = {4, 5, 7, 2, 1, 9, 8, 11, 3};
		int n = 9;
		Visit vs = new Visit();
		BiTreeNode temp = new BiTreeNode(a[0]);
		
		for(int i = 1; i < n; i ++){
			 searchTree.insert(temp, a[i]);
		}
		searchTree.setRoot(temp);
				
		System.out.println("������ɺ�");
		System.out.print("�����������Ϊ��");
		searchTree.inOrder(vs);
		System.out.print("\nǰ���������Ϊ��");
		searchTree.preOrder(vs);
		System.out.println();
		
		System.out.print("���ҵ�����Ԫ��Ϊ��");
		System.out.println(searchTree.find(9).getData());
		
		searchTree.delete(searchTree.getRoot(),4);
			 searchTree.insert(temp, 1);
		
		System.out.println("ɾ�����4��");
		System.out.print("�����������Ϊ��");
		searchTree.inOrder(vs);
		System.out.print("\nǰ���������Ϊ��");
		searchTree.preOrder(vs);
		System.out.println();
	}
}