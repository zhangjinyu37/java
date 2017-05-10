import java.util.Stack;
import java.util.regex.Pattern;

public class StringToArithmetic {

	// Ĭ�Ϲ��캯��
	public StringToArithmetic() {

	}

	// ����׺���ʽ�ַ�������õ����
	public static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	// ����׺���ʽת��Ϊ��׺���ʽ
	public static String infixToSuffix(String exp) {
		// ������������ջ
		Stack<Character> s = new Stack<Character>();
		String suffix = ""; // ����ĺ�׺���ʽ�ַ�����
		int len = exp.length();
		for (int i = 0; i < len; i++) {
			char temp; // ��ʱ�ַ�����
			char ch = exp.charAt(i);

			switch (ch) {
			// ���Կո�
			case ' ':
				break;
			// ����������ţ�ֱ��ѹ���ջ��
			case '(':
				s.push(ch);
				break;
			// ����ǼӺŻ��߼��ţ��򵯳����е��ַ�����������У�ֱ������������Ϊֹ
			// Ȼ��Ѹ��������ѹ����ջ��
			case '+':
			case '-':
				while (!s.isEmpty()) {
					temp = s.pop();
					if (temp == '(') {
						s.push(temp);
						break;
					}
					suffix += temp;
				}
				s.push(ch); // �������ѹ����ջ��
				break;
			// ����ǳ˺Ż��߳��ţ��򵯳����е��ַ�����������У�ֱ�����������Ż��߼ӺŻ��߼���Ϊֹ
			// Ȼ��Ѹ��������ѹ����ջ��
			case '*':
			case '/':
				while (!s.isEmpty()) {
					temp = s.pop();
					if (temp == '(' || temp == '+' || temp == '-') {
						s.push(temp);
						break;
					} else {
						suffix += temp;
					}
				}
				s.push(ch);
				break;

			case ')':
				while (!s.isEmpty()) {
					temp = s.pop();
					if (temp == '(') {
						break;
					} else {
						suffix += temp;
					}
				}
				break;
			// Ĭ��������������֣���ֱ�������������
			default:
				suffix += ch;
				break;
			}
		}
		// ���ջ��Ϊ�գ���ʣ�����������ε���������������С�
		while (!s.isEmpty()) {
			suffix += s.pop();
		}

		return suffix;
	}

	// �����׺���ʽ�ַ����õ�������
	public static double suffixToArithmetic(String exp) {
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); // ʹ��������ʽƥ������
		// ��ָ���ַ������ַ���ת��Ϊ�ַ������顣
		String strings[] = exp.split("");
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals(""))
				continue;
			// ��������֣����ջ
			if ((pattern.matcher(strings[i])).matches()) {

				stack.push(Double.parseDouble(strings[i]));
			} else {
				// ��������������������������������
				double y = stack.pop();
				double x = stack.pop();
				stack.push(caculate(x, y, strings[i])); // ������������ѹ��ջ��
			}
		}
		return stack.pop();
	}
	
	private static double caculate(double x, double y, String simble) {
		if (simble.trim().equals("+"))
			return x + y;
		if (simble.trim().equals("-"))
			return x - y;
		if (simble.trim().equals("*"))
			return x * y;
		if (simble.trim().equals("/"))
			return x / y;
		return 0;
	}
}
