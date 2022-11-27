package HelloApp;

/**
 *	Generated from IDL definition of interface "Hello"
 *	@author JacORB IDL compiler 
 */

public final class HelloHelper
{
	public static void insert (final org.omg.CORBA.Any any, final HelloApp.Hello s)
	{
		any.insert_Object (s);
	}
	public static HelloApp.Hello extract (final org.omg.CORBA.Any any)
	{
		return narrow (any.extract_Object ());
	}
	public static org.omg.CORBA.TypeCode type ()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc( "IDL:HelloApp/Hello:1.0", "Hello");
	}
	public static String id()
	{
		return "IDL:HelloApp/Hello:1.0";
	}
	public static Hello read (final org.omg.CORBA.portable.InputStream in)
	{
		return narrow (in.read_Object ());
	}
	public static void write (final org.omg.CORBA.portable.OutputStream _out, final HelloApp.Hello s)
	{
		_out.write_Object(s);
	}
	public static HelloApp.Hello narrow (final org.omg.CORBA.Object obj)
	{
		if( obj == null )
			return null;
		try
		{
			return (HelloApp.Hello)obj;
		}
		catch( ClassCastException c )
		{
			if( obj._is_a("IDL:HelloApp/Hello:1.0"))
			{
				HelloApp._HelloStub stub;
				stub = new HelloApp._HelloStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
}
