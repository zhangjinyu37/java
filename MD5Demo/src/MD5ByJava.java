import java.security.MessageDigest;

public class MD5ByJava {
	private final static String[] hexArray = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }; // �洢ʮ������ֵ������

	/** ����ָ�����ַ������������ܺ���ַ��� */
	public static String createEncrypPassword(String string) {
		return encrypByMD5(string);
	}

	/** ��������������Ƿ���ȷ */
	public static boolean verificationPassword(String password, String string) {
		if (password.equals(encrypByMD5(string))) {
			return true;
		} else {
			return false;
		}
	}

	/** ��ָ�����ַ�������MD5���� */
	private static String encrypByMD5(String originString) {
		if (originString != null) {
			try {
				// ��������MD5�㷨����ϢժҪ
				MessageDigest md = MessageDigest.getInstance("MD5");
				// ʹ��ָ�����ֽ������ժҪ���������£�Ȼ�����ժҪ����
				byte[] results = md.digest(originString.getBytes());
				// ���õ����ֽ��������ַ�������
				String resultString = byteArrayToHex(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/** ���ֽ�����ת����16���ƣ������ַ�������ʽ���� */
	private static String byteArrayToHex(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHex(b[i]));
		}
		return resultSb.toString();
	}

	/** ��һ���ֽ�ת����16���ƣ������ַ�������ʽ���� */
	private static String byteToHex(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexArray[d1] + hexArray[d2];
	}

	public static void main(String[] args) {
		String password = "123456";
		String encryPass = MD5ByJava.createEncrypPassword(password);
		System.out.println(encryPass);
		String myPassword = "123456";
		if (MD5ByJava.verificationPassword(encryPass, myPassword)) {
			System.out.println("������ȷ��");
		} else {
			System.out.println("�������");
		}
	}

}
