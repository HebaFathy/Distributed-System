import java.rmi.*;

public class NameServer 
{

	
       
	
	public NameServer()
	{
	 
	 
	
	}
	
	
	
	
	public static void main(String args[])
	{
		
		NameServer nameServer=new NameServer();
		try{
			NameImp localObject=new NameImp();
		
			Naming.rebind("rmi:///Name1",localObject);
			
		}
		catch(Exception e)
		{
			System.out.println("1:    "+e);
		}
	}
}