package listingFiles;

import java.io.File;

public class ListFiles {
	public static void main(String args[]) {
		File curr_dir = new File(args[0]);
		ListFiles obj = new ListFiles();
		obj.getAllFiles(curr_dir);
	}

	public void getAllFiles(File curr_dir)
	{
		
			File[] filelist= curr_dir.listFiles();
			for(File f:filelist)
			{	
				if(f.isDirectory() )
					System.out.println(f.getName());
				else
					System.out.println(f.getName());
			}
		
	}
}
