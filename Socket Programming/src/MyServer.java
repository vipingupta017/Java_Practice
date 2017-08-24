import java.io.*;
import java.net.*;
public class MyServer {
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss= new ServerSocket(6002);
			Socket s= ss.accept();
			DataInputStream din= new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
						
			String  str=din.readUTF();   
			System.out.println("File name is= "+str);  
			 
			MyServer obj= new MyServer();
			File curr_dir = new File(".");
			
			if(obj.isFileExist(curr_dir,str)){ 		
				BufferedReader br = new BufferedReader(new FileReader("test.txt"));
				try {
				   StringBuilder sb = new StringBuilder();
				   String line = br.readLine();
				    while (line != null) {
				    	sb.append(line);
				        sb.append(System.lineSeparator());
				        line = br.readLine();
				    }
				    String everything = sb.toString();
				    dout.writeUTF(everything);  
					dout.flush();
				} finally {
				    br.close();
				}
			}
			else{
				System.out.println("Error: File doesn't exist");
			}			
			din.close();
			dout.close();
			ss.close(); 
			s.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public boolean  isFileExist(File curr_dir, String fname)
	{
			File[] filelist= curr_dir.listFiles();
			for(File f:filelist)
			{	
				if(f.isFile() && f.getName().equals(fname))
				{
					return true;
				}
			}
			return false;
	}
}
