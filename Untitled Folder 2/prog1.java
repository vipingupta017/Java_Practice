import java.io.File;
class prog1
{
	public static void main(String args[])
	{
		prog1 obj = new prog1();
		File curr_dir= new File(args[0]);
		obj.getAllFiles(curr_dir);
	}
	public void getAllFiles(File curr_dir)
	{
		try
		{
			File[] filelist= curr_dir.listFiles();
			for(File f:filelist)
			{
				
					if(f.isDirectory() )
					{
						//System.out.println(f.getName());
						File new_dir= new File(f.getName()); 
						if(new_dir== null)
							System.out.println("Nullll");
						getAllFiles(new_dir);
					}
					else
					{
						System.out.println(f.getName());
					}
			}
		}
		finally{
			System.out.println("Null Pointer Here");
		}
	}
}