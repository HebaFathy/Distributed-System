package HelloApp;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL definition of interface "Hello"
 *	@author JacORB IDL compiler 
 */

public class HelloPOATie
	extends HelloPOA
{
	private HelloOperations _delegate;

	private POA _poa;
	public HelloPOATie(HelloOperations delegate)
	{
		_delegate = delegate;
	}
	public HelloPOATie(HelloOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public HelloApp.Hello _this()
	{
		return HelloApp.HelloHelper.narrow(_this_object());
	}
	public HelloApp.Hello _this(org.omg.CORBA.ORB orb)
	{
		return HelloApp.HelloHelper.narrow(_this_object(orb));
	}
	public HelloOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(HelloOperations delegate)
	{
		_delegate = delegate;
	}
	public java.lang.String insert(java.lang.String record)
	{
		return _delegate.insert(record);
	}

	public java.lang.String sayHello()
	{
		return _delegate.sayHello();
	}

}
