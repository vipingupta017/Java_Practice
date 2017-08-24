import java.net.*;
import java.io.*;

public class MyClient {
	public static void main(String args[]) {
		try {
			Socket cs = new Socket("localhost", 6002);
			DataOutputStream dout = new DataOutputStream(cs.getOutputStream());
			DataInputStream din = new DataInputStream(cs.getInputStream());

			dout.writeUTF(args[0]);
			dout.flush();

			String str2 = "";
			str2 = din.readUTF();
			System.out.println("Server says: " + str2);
			
			String f_str= "";
			f_str= din.readUTF();
			System.out.println(f_str);
			dout.close();
			din.close();
			cs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}