import java.io.*;

public class CountLines {
	public static void main(String args[]) throws Exception{
		CountLines cl= new CountLines();
		for(int i= 0;i< args.length;i++)
			System.out.println(cl.countLinesfile(args[i]));
		
	}

public int countLinesfile(String filename)  {
	try{
    InputStream is = new BufferedInputStream(new FileInputStream(filename));
        byte[] c = new byte[1024];
        int count = 0;
        int readChars = 0;
        boolean empty = true;
        while ((readChars = is.read(c)) != -1) {
            empty = false;
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n') {
                    ++count;
                }
            }
        }
        is.close();
        return (count == 0 && !empty) ? 1 : count;     
    } 
    catch(FileNotFoundException f){
    	f.printStackTrace();
    	return -1;
    }
	catch(IOException i){
		i.printStackTrace();
		return -1;
	}
}
}
