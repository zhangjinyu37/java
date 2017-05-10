public class Edge implements Comparable<Object> {// ���� ʵ��comparable�ӿڷ�������
	private int length;// �ߵĳ���
	private int leftV;// �ߵ�һ�����������
	private int rightV;// �ߵ���һ�����������

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLeftV() {
		return leftV;
	}

	public void setLeftV(int leftV) {
		this.leftV = leftV;
	}

	public int getRightV() {
		return rightV;
	}

	public void setRightV(int rightV) {
		this.rightV = rightV;
	}

	public Edge(int leftV, int length, int rightV) {
		this.leftV = leftV;
		this.length = length;
		this.rightV = rightV;
	}

	public Edge() {

	}

	@Override
	public int compareTo(Object e) {
		if (((Edge) e).length > this.length)
			return -1;
		else if (((Edge) e).length == this.length)
			return 0;
		else
			return 1;
	}

	public String toString() {
		return (this.leftV + "<----" + this.length + "---->" + this.rightV);
	}
}