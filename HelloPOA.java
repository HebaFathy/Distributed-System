package HelloApp;

/**
 *	Generated from IDL definition of interface "Hello"
 *	@author JacORB IDL compiler 
 */


public abstract class HelloPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, HelloApp.HelloOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "insert", new java.lang.Integer(0));
		m_opsHash.put ( "sayHello", new java.lang.Integer(1));
	}
	private String[] ids = {"IDL:HelloApp/Hello:1.0","IDL:omg.org/CORBA/Object:1.0"};
	public HelloApp.Hello _this()
	{
		return HelloApp.HelloHelper.narrow(_this_object());
	}
	public HelloApp.Hello _this(org.omg.CORBA.ORB orb)
	{
		return HelloApp.HelloHelper.narrow(_this_object(orb));
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // insert
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_string(insert(_arg0));
				break;
			}
			case 1: // sayHello
			{
				_out = handler.createReply();
				_out.write_string(sayHello());
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
