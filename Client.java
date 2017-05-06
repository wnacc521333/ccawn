import java.net.*;
import java.io.*;
public class Client
{
	public static void main(String[] args)
		throws IOException
	{
		Socket socket = new Socket("127.0.0.1" , 8080);  
		// 将Socket对应的输入流包装成BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// 进行普通IO操作
		String line = br.readLine();
		int k = line.length();
		String array = line.substring(11,k);
		int t = array.length();
		StringBuilder s1 = new StringBuilder(new String(""));
		int head = 1;
		for(int i=2;i<t;i=i+2)
			head = head*(array.charAt(i)-48);
		String hh = head+",";
		s1.append(hh);
		for(int i=2;i<t-2;i=i+2){
			head=1;
			for(int j=0;j<i;j=j+2)
				head = head*(array.charAt(j)-48);	
            for(int j=i+2;j<t;j=j+2)
				head = head*(array.charAt(j)-48);
			String hh2 = head+",";
		    s1.append(hh2);
		}
		head = 1;
		for(int i=0;i<t-2;i=i+2)
			head = head*(array.charAt(i)-48);
		hh = head+"";
		s1.append(hh);
		System.out.println(s1.toString());
		// 关闭输入流、socket
		br.close();
		socket.close();
	}
}
