import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * һ��B���ļ�ʵ�֡�
 * @param <K> - ������
 * @param <V> - ֵ����
 */
public class BTree<K, V>
{
        
        /**
         * ��B���ڵ�������������ֵ�ķ��ؽ����
         * <p/> 
         * �ý������������ɡ���һ���ֱ�ʾ�˴β����Ƿ�ɹ���
         * ������ҳɹ����ڶ����ֱ�ʾ������ֵ��B���ڵ��е�λ�ã�
         * �������ʧ�ܣ��ڶ����ֱ�ʾ������ֵӦ�ò����λ�á�
         */
        private static class SearchResult
        {
                private boolean result;
                private int index;
                
                public SearchResult(boolean result, int index)
                {
                        this.result = result;
                        this.index = index;
                }
                
                public boolean getResult()
                {
                        return result;
                }
                
                public int getIndex()
                {
                        return index;
                }
        }
        
        /**
         * Ϊ�˼��������ʱֻ֧�����͵�key��
         * �ȵ�������ɺ�֧�ַ��͡� 
         * <p/>
         * 
         * TODO ��Ҫ���ǲ�������µĴ�ȡ��
         */
        private static class BTreeNode
        {
                /** �ڵ�Ĺؼ��֣��Էǽ����� */
                private List<Integer> keys;
                /** �ڽڵ���ӽڵ� */
                private List<BTreeNode> children;
                /** �Ƿ�ΪҶ�ӽڵ� */
                private boolean leaf;
                
                public BTreeNode()
                {
                        keys = new ArrayList<Integer>();
                        children = new ArrayList<BTreeNode>();
                        leaf = false;
                }
                
                public boolean isLeaf()
                {
                        return leaf;
                }
                
                public void setLeaf(boolean leaf)
                {
                        this.leaf = leaf;
                }
                
                /**
                 * ���عؼ��ֵĸ���������Ƿ�Ҷ�ӽڵ㣬�ýڵ��
                 * �ӽڵ����Ϊ({@link #size()} + 1)��
                 * 
                 * @return �ؼ��ֵĸ���
                 */
                public int size()
                {
                        return keys.size();
                }
                
                /**
                 * �ڽڵ��в��Ҹ�����<code>key</code>������ڵ��д��ڸ�����
                 * <code>key</code>���򷵻�һ��<code>SearchResult</code>��
                 * ��ʶ�˴β��ҳɹ�������<code>key</code>�ڽڵ��е������͸���
                 * <code>key</code>��Ӧ��ֵ����������ڣ��򷵻�<code>SearchResult</code>
                 * ��ʶ�˴β���ʧ�ܣ�����<code>key</code>Ӧ�ò����λ�ã���<code>key</code>
                 * ��Ӧ��ֵΪnull��
                 * <p/>
                 * �������ʧ�ܣ����ؽ���е�������Ϊ[0, {@link #size()}]��
                 * ������ҳɹ������ؽ���е�������Ϊ[0, {@link #size()} - 1]
                 * <p/>
                 * ����һ�����ֲ����㷨�����Ա�֤ʱ�临�Ӷ�ΪO(log(t))��
                 * 
                 * @param key - �����ļ�ֵ
                 * @return - ���ҽ��
                 */
                public SearchResult searchKey(Integer key)
                {
                        int l = 0;
                        int h = keys.size() - 1;
                        int mid = 0;
                        while(l <= h)
                        {
                                mid = (l + h) / 2; // ����ôд�ɣ�BTreeʵ���У�l+h���������
                                if(keys.get(mid) == key)
                                        break;
                                else if(keys.get(mid) > key)
                                        h = mid - 1;
                                else // if(keys.get(mid) < key)
                                        l = mid + 1;
                        }
                        boolean result = false;
                        int index = 0;
                        if(l <= h) // ˵�����ҳɹ�
                        {
                                result = true;
                                index = mid; // index��ʾԪ�����ڵ�λ��
                        }
                        else
                        {
                                result = false;
                                index = l; // index��ʾԪ��Ӧ�ò����λ��
                        }
                        return new SearchResult(result, index);
                }
                
                /**
                 * ��������<code>key</code>׷�ӵ��ڵ��ĩβ��
                 * һ��Ҫȷ�����ø÷���֮�󣬽ڵ��еĹؼ��ֻ���
                 * �Էǽ����š�
                 * 
                 * @param key - �����ļ�ֵ
                 */
                public void addKey(Integer key)
                {
                        keys.add(key);
                }
                
                /**
                 * ɾ�����������ļ�ֵ��
                 * <p/>
                 * ����Ҫ�Լ���֤�����������ǺϷ��ġ�
                 * 
                 * @param index - ����������
                 */
                public void removeKey(int index)
                {
                        keys.remove(index);
                }
                
                /**
                 * �õ��ڵ��и��������ļ�ֵ��
                 * <p/>
                 * ����Ҫ�Լ���֤�����������ǺϷ��ġ�
                 * 
                 * @param index - ����������
                 * @return �ڵ��и��������ļ�ֵ
                 */
                public Integer keyAt(int index)
                {
                        return keys.get(index);
                }
                
                /**
                 * �ڸýڵ��в��������<code>key</code>��
                 * �÷�����֤����֮�����ֵ�����Էǽ����š�
                 * <p/>
                 * �����÷�����ʱ�临�Ӷ�ΪO(t)��
                 * <p/>
                 * TODO ��Ҫ���Ǽ�ֵ�Ƿ�����ظ���
                 * 
                 * @param key - �����ļ�ֵ
                 */
                public void insertKey(Integer key)
                {
                        SearchResult result = searchKey(key);
                        insertKey(key, result.getIndex());
                }
                
                /**
                 * �ڸýڵ��и���������λ�ò��������<code>key</code>��
                 * ����Ҫ�Լ���֤<code>key</code>��������ȷ��λ�á�
                 * 
                 * @param key - �����ļ�ֵ
                 * @param index - ����������
                 */
                public void insertKey(Integer key, int index)
                {
                        /* TODO
                         * ͨ���½�һ��ArrayList��ʵ�ֲ�����ĺܶ��ģ���������
                         * Ҫ��������C�е�reallocate�ͺ��ˡ�
                         */
                        List<Integer> newKeys = new ArrayList<Integer>();
                        int i = 0;
                        
                        // index = 0����index = keys.size()��û������
                        for(; i < index; ++ i)
                                newKeys.add(keys.get(i));
                        newKeys.add(key);
                        for(; i < keys.size(); ++ i)
                                newKeys.add(keys.get(i));
                        keys = newKeys;
                }
                
                /**
                 * ���ؽڵ��и����������ӽڵ㡣
                 * <p/>
                 * ����Ҫ�Լ���֤�����������ǺϷ��ġ�
                 * 
                 * @param index - ����������
                 * @return ����������Ӧ���ӽڵ�
                 */
                public BTreeNode childAt(int index)
                {
                        if(isLeaf())
                                throw new UnsupportedOperationException("Leaf node doesn't have children.");
                        return children.get(index);
                }
                
                /**
                 * ���������ӽڵ�׷�ӵ��ýڵ��ĩβ��
                 * 
                 * @param child - �������ӽڵ�
                 */
                public void addChild(BTreeNode child)
                {
                        children.add(child);
                }
                
                /**
                 * ɾ���ýڵ��и�������λ�õ��ӽڵ㡣
                 * </p>
                 * ����Ҫ�Լ���֤�����������ǺϷ��ġ�
                 * 
                 * @param index - ����������
                 */
                public void removeChild(int index)
                {
                        children.remove(index);
                }
                
                /**
                 * ���������ӽڵ���뵽�ýڵ��и�������
                 * ��λ�á�
                 * 
                 * @param child - �������ӽڵ�
                 * @param index - �ӽڵ�������λ��
                 */
                public void insertChild(BTreeNode child, int index)
                {
                        List<BTreeNode> newChildren = new ArrayList<BTreeNode>();
                        int i = 0;
                        for(; i < index; ++ i)
                                newChildren.add(children.get(i));
                        newChildren.add(child);
                        for(; i < children.size(); ++ i)
                                newChildren.add(children.get(i));
                        children = newChildren;
                }
        }
        
        private static final int DEFAULT_T = 2;
        
        /** B���ĸ��ڵ� */
        private BTreeNode root;
        /** ����B���Ķ��壬B����ÿ���Ǹ��ڵ�Ĺؼ�����n����(t - 1) <= n <= (2t - 1) */
        private int t = DEFAULT_T;
        /** �Ǹ��ڵ�����С�ļ�ֵ�� */
        private int minKeySize = t - 1;
        /** �Ǹ��ڵ������ļ�ֵ�� */
        private int maxKeySize = 2*t - 1;
        
        public BTree()
        {
                root = new BTreeNode();
                root.setLeaf(true);
        }
        
        public BTree(int t)
        {
                this();
                this.t = t;
                minKeySize = t - 1;
                maxKeySize = 2*t - 1;
        }
        
        /**
         * ����������<code>key</code>��
         * <p/>
         * TODO ��Ҫ���¶��巵�ؽ����Ӧ�÷���
         * <code>key</code>��Ӧ��ֵ��
         * 
         * @param key - �����ļ�ֵ
         * @return TODO �÷���ֵ����
         */
        public int search(Integer key)
        {
                return search(root, key);
        }
        
        /**
         * ���Ը����ڵ�Ϊ���������У��ݹ�����
         * ������<code>key</code>
         * 
         * @param node - �����ĸ��ڵ�
         * @param key - �����ļ�ֵ
         * @return TODO
         */
        private static int search(BTreeNode node, Integer key)
        {
                SearchResult result = node.searchKey(key);
                if(result.getResult())
                        return result.getIndex();
                else
                {
                        if(node.isLeaf())
                                return -1;
                        else 
                                search(node.childAt(result.getIndex()), key);
                                
                }
                return -1;
        }
        
        /**
         * ����һ�����ӽڵ�<code>childNode</code>��
         * <p/>
         * ����Ҫ�Լ���֤�������ӽڵ������ڵ㡣
         * 
         * @param parentNode - ���ڵ�
         * @param childNode - ���ӽڵ�
         * @param index - ���ӽڵ��ڸ��ڵ��е�����
         */
        private void splitNode(BTreeNode parentNode, BTreeNode childNode, int index)
        {
                assert childNode.size() == maxKeySize;
                
                BTreeNode siblingNode = new BTreeNode();
                siblingNode.setLeaf(childNode.isLeaf());
                // �����ӽڵ�������Ϊ[t, 2t - 2]��(t - 1)���ؼ��ֲ����µĽڵ���
                for(int i = 0; i < minKeySize; ++ i)
                        siblingNode.addKey(childNode.keyAt(t + i));
                // ��ȡ���ӽڵ��е��м�ؼ��֣�������Ϊ(t - 1)
                Integer key = childNode.keyAt(t - 1);
                // ɾ�����ӽڵ�������Ϊ[t - 1, 2t - 2]��t���ؼ���
                for(int i = maxKeySize - 1; i >= t - 1; -- i)
                        childNode.removeKey(i);
                if(!childNode.isLeaf()) // ������ӽڵ㲻��Ҷ�ڵ㣬����Ҫ�������ӽڵ�
                {
                        // �����ӽڵ�������Ϊ[t, 2t - 1]��t���ӽڵ�����µĽڵ���
                        for(int i = 0; i < minKeySize + 1; ++ i)
                                siblingNode.addChild(childNode.childAt(t + i));
                        // ɾ�����ӽڵ�������Ϊ[t, 2t - 1]��t���ӽڵ�
                        for(int i = maxKeySize; i >= t; -- i)
                                childNode.removeChild(i);
                }
                // ��key���븸�ڵ�
                parentNode.insertKey(key, index);
                // ���½ڵ���븸�ڵ�
                parentNode.insertChild(siblingNode, index + 1);
        }
        
        /**
         * ��һ�������ڵ��в��������<code>key</code>��
         * 
         * @param node - �����ڵ�
         * @param key - �����ļ�ֵ
         */
        private void insertNotFull(BTreeNode node, Integer key)
        {
                assert node.size() < maxKeySize;
                
                if(node.isLeaf()) // �����Ҷ�ӽڵ㣬ֱ�Ӳ���
                        node.insertKey(key);
                else
                {
                        /* �ҵ�key�ڸ����ڵ�Ӧ�ò����λ�ã���ôkeyӦ�ò���
                         * ��λ�ö�Ӧ��������
                         */
                        SearchResult result = node.searchKey(key);
                        BTreeNode childNode = node.childAt(result.getIndex());
                        if(childNode.size() == 2*t - 1) // ����ӽڵ������ڵ�
                        {
                                // ���ȷ���
                                splitNode(node, childNode, result.getIndex());
                                /* ���������key���ڷ���֮�������ɵļ�ֵ������Ҫ������¼�ֵ���ұߣ�
                                 * ������ߡ�
                                 */
                                if(key > node.keyAt(result.getIndex()))
                                        childNode = node.childAt(result.getIndex() + 1);
                        }
                        insertNotFull(childNode, key);
                }
        }
        
        /**
         * ��B���в��������<code>key</code>��
         * 
         * @param key - �����ļ�ֵ
         */
        public void insert(Integer key)
        {
                if(root.size() == maxKeySize) // ������ڵ����ˣ���B������
                {
                        BTreeNode newRoot = new BTreeNode();
                        newRoot.setLeaf(false);
                        newRoot.addChild(root);
                        splitNode(newRoot, root, 0);
                        root = newRoot;
                }
                insertNotFull(root, key);
        }
        
        /**
         * ��B����ɾ��һ��������<code>key</code>��
         * 
         * @param key - �����ļ�ֵ
         */
        public void delete(Integer key)
        {
                // root���������Ҫ��һЩ���⴦��
                delete(root, key);
        }
        
        /**
         * ���Ը���<code>node</code>Ϊ����������ɾ��ָ����<code>key</code>��
         * <p/>
         * ɾ����ʵ��˼����ο����㷨���ۡ��ڶ���ĵ�18�¡�
         * <p/>
         * TODO ��Ҫ�ع�������̫����
         * 
         * @param node - �����Ľڵ�
         * @param key - �����ļ�ֵ
         */
        public void delete(BTreeNode node, Integer key)
        {
                // �ù�����Ҫ��֤���ԷǸ��ڵ�ִ��ɾ������ʱ����ؼ��ָ�������Ϊt��
                assert node.size() >= t || node == root;
                
                SearchResult result = node.searchKey(key);
                /*
                 * ��Ϊ���ǲ��ҳɹ��������0 <= result.getIndex() <= (node.size() - 1)��
                 * ���(result.getIndex() + 1)���������
                 */
                if(result.getResult())
                {
                        // 1.����ؼ����ڽڵ�node�У�������Ҷ�ڵ㣬��ֱ��ɾ����
                        if(node.isLeaf())
                                node.removeKey(result.getIndex());
                        else
                        {
                                // 2.a ����ڵ�node��ǰ��key���ӽڵ��������t���ؼ���
                                BTreeNode leftChildNode = node.childAt(result.getIndex());
                                if(leftChildNode.size() >= t)
                                {
                                        // ʹ��leftChildNode�е����һ����ֵ����node�е�key
                                        node.removeKey(result.getIndex());
                                        node.insertKey(leftChildNode.keyAt(leftChildNode.size() - 1), result.getIndex());
                                        delete(leftChildNode, leftChildNode.keyAt(leftChildNode.size() - 1));
                                        // node.
                                }
                                else
                                {
                                        // 2.b ����ڵ�node�к���key���ӽڵ��������t���ؼ���
                                        BTreeNode rightChildNode = node.childAt(result.getIndex() + 1);
                                        if(rightChildNode.size() >= t)
                                        {
                                                // ʹ��rightChildNode�еĵ�һ����ֵ����node�е�key
                                                node.removeKey(result.getIndex());
                                                node.insertKey(rightChildNode.keyAt(0), result.getIndex());
                                                delete(rightChildNode, rightChildNode.keyAt(0));
                                        }
                                        else // 2.c ǰ��key�ͺ���key���ӽڵ㶼ֻ����t-1���ؼ���
                                        {
                                                node.removeKey(result.getIndex());
                                                node.removeChild(result.getIndex() + 1);
                                                // ��key��rightChildNode�еļ�ֵ�ϲ���leftChildNode
                                                leftChildNode.addKey(key);
                                                for(int i = 0; i < rightChildNode.size(); ++ i)
                                                        leftChildNode.addKey(rightChildNode.keyAt(i));
                                                // ��rightChildNode�е��ӽڵ�ϲ���leftChildNode������еĻ�
                                                if(!rightChildNode.isLeaf())
                                                {
                                                        for(int i = 0; i <= rightChildNode.size(); ++ i)
                                                                leftChildNode.addChild(rightChildNode.childAt(i));
                                                }
                                                delete(leftChildNode, key);
                                        }
                                }
                        }
                }
                else
                {
                        /*
                         * ��Ϊ���ǲ���ʧ�ܵ������0 <= result.getIndex() <= node.size()��
                         * ���(result.getIndex() + 1)�������
                         */
                        if(node.isLeaf()) // ����ؼ��ֲ��ڽڵ�node�У�������Ҷ�ڵ㣬��ʲô����������Ϊ�ùؼ��ֲ��ڸ�B����
                        {
                               return;
                        }
                        BTreeNode childNode = node.childAt(result.getIndex());
                        if(childNode.size() >= t)
                                delete(childNode, key); // �ݹ�ɾ��
                        else // 3
                        {
                                // �Ȳ����ұߵ��ֵܽڵ�
                                BTreeNode siblingNode = null;
                                int siblingIndex = -1;
                                if(result.getIndex() < node.size()) // �������ֵܽڵ�
                                {
                                        if(node.childAt(result.getIndex() + 1).size() >= t)
                                        {
                                                siblingNode = node.childAt(result.getIndex() + 1);
                                                siblingIndex = result.getIndex() + 1;
                                        }
                                }
                                // ����ұߵ��ֵܽڵ㲻������������������ߵ��ֵܽڵ�
                                if(siblingNode == null)
                                {
                                        if(result.getIndex() > 0) // �������ֵܽڵ�
                                        {
                                                if(node.childAt(result.getIndex() - 1).size() >= t)
                                                {
                                                        siblingNode = node.childAt(result.getIndex() - 1);
                                                        siblingIndex = result.getIndex() - 1;
                                                }
                                        }
                                }
                                // 3.a ��һ�������ֵܽڵ����ٰ���t���ؼ���
                                if(siblingNode != null)
                                {
                                        if(siblingIndex < result.getIndex()) // ���ֵܽڵ���������
                                        {
                                                childNode.insertKey(node.keyAt(siblingIndex), 0);
                                                node.removeKey(siblingIndex);
                                                node.insertKey(siblingNode.keyAt(siblingNode.size() - 1), siblingIndex);
                                                siblingNode.removeKey(siblingNode.size() - 1);
                                                // �����ֵܽڵ�����һ�������Ƶ�childNode
                                                if(!siblingNode.isLeaf())
                                                {
                                                        childNode.insertChild(siblingNode.childAt(siblingNode.size()), 0);
                                                        siblingNode.removeChild(siblingNode.size());
                                                }
                                        }
                                        else // ���ֵܽڵ���������
                                        {
                                                childNode.insertKey(node.keyAt(result.getIndex()), childNode.size() - 1);
                                                node.removeKey(result.getIndex());
                                                node.insertKey(siblingNode.keyAt(0), result.getIndex());
                                                siblingNode.removeKey(0);
                                                // �����ֵܽڵ�ĵ�һ�������Ƶ�childNode
                                                // childNode.insertChild(siblingNode.childAt(0), childNode.size() + 1);
                                                if(!siblingNode.isLeaf())
                                                {
                                                        childNode.addChild(siblingNode.childAt(0));
                                                        siblingNode.removeChild(0);
                                                }
                                        }
                                        delete(childNode, key);
                                }
                                else // 3.b ������������ҽڵ㶼����t-1���ؼ���
                                {
                                        if(result.getIndex() < node.size()) // �������ֵ�
                                        {
                                                BTreeNode rightSiblingNode = node.childAt(result.getIndex() + 1);
                                                childNode.addKey(node.keyAt(result.getIndex()));
                                                node.removeKey(result.getIndex());
                                                node.removeChild(result.getIndex() + 1);
                                                for(int i = 0; i < rightSiblingNode.size(); ++ i)
                                                        childNode.addKey(rightSiblingNode.keyAt(i));
                                                if(!rightSiblingNode.isLeaf())
                                                {
                                                        for(int i = 0; i <= rightSiblingNode.size(); ++ i)
                                                                childNode.addChild(rightSiblingNode.childAt(i));
                                                }
                                        }
                                        else // ������ڵ�
                                        {
                                                BTreeNode leftSiblingNode = node.childAt(result.getIndex() - 1);
                                                childNode.addKey(node.keyAt(result.getIndex() - 1));
                                                node.removeKey(result.getIndex() - 1);
                                                node.removeChild(result.getIndex() - 1);
                                                for(int i = leftSiblingNode.size() - 1; i >= 0; -- i)
                                                        childNode.insertKey(leftSiblingNode.keyAt(i), 0);
                                                if(!leftSiblingNode.isLeaf())
                                                {
                                                        for(int i = leftSiblingNode.size(); i >= 0; -- i)
                                                                childNode.insertChild(leftSiblingNode.childAt(i), 0);
                                                }
                                        }
                                        // ���node��root����node�������κιؼ�����
                                        if(node == root && node.size() == 0)
                                                root = childNode;
                                        delete(childNode, key);
                                }
                        }
                }
        }
        
        /**
         * һ���򵥵Ĳ�α���B��ʵ�֣��������B����
         * <p/>
         * TODO ���Ľ���ʹ��ʾ�������󻯡�
         */
        public void output()
        {
                Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
                queue.offer(root);
                while(!queue.isEmpty())
                {
                        BTreeNode node = queue.poll();
                        for(int i = 0; i < node.size(); ++ i)
                                System.out.print(node.keyAt(i) + " ");
                        System.out.println();
                        if(!node.isLeaf())
                        {
                                for(int i = 0; i <= node.size(); ++ i)
                                        queue.offer(node.childAt(i));
                        }
                }
        }
        
        public static void main(String[] args)
        {
                Random random = new Random();
                BTree<Integer, Byte[]> btree = new BTree<Integer, Byte[]>();
                for(int i = 0; i < 10; ++ i)
                {
                        int r = random.nextInt(100);
                        System.out.println(r);
                        btree.insert(r);
                }
                System.out.println("----------------------");
                btree.output();
        }
}