import java.rmi.*;
import java.rmi.server.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class NameImp extends UnicastRemoteObject implements Name1 , ActionListener
{
	
	String key="distributedsystem";
	JFrame server;
	JButton send;
	JPanel panel3,panel4,panel6,panel7,button;
     
    JLabel label2,label4,label5,label6;
    JTextArea encrypted,sent;
    Font font=new Font("Serif",Font.PLAIN+Font.BOLD,14);
    Font font1=new Font("Serif",Font.PLAIN+Font.ITALIC,12);
    Font font2=new Font("Serif",Font.PLAIN,14);
    
	public NameImp() throws RemoteException
	{
	  
	 server =new JFrame("Server");
	 Container c=server.getContentPane();
	     
     panel3=new JPanel();
     panel4=new JPanel();    
     panel6=new JPanel();
     panel7=new JPanel();
     button=new JPanel();
        
     panel3.setBackground(Color.black);
     panel4.setBackground(Color.black);    
     panel6.setBackground(Color.black);
     panel7.setBackground(Color.black); 
     button.setBackground(Color.black); 
    
     panel3.setLayout(new GridLayout(3,1));    

     Icon icon3=new ImageIcon("connect4.JPG");    
    
     send=new JButton("send");    
    
     send.setBackground(Color.black);    
     send.setForeground(Color.white);  
   
 
     label4=new JLabel("  Received Message");
     label5=new JLabel(" Message                     ");
    
    
    //label3.setFont(new Font("Serif",Font.PLAIN+Font.BOLD,18));
     label4.setBackground(Color.black);
     label4.setForeground(Color.white);
     label5.setBackground(Color.black);
     label5.setForeground(Color.white);     
     
     label2=new JLabel(icon3);
     label6=new JLabel("                                                         ");

    
     encrypted=new JTextArea(2,20);
     sent=new JTextArea(2,20);
     encrypted.setLineWrap(true);
     encrypted.setWrapStyleWord(true);
     encrypted.setBackground(new Color(211,211,223));
     sent.setBackground(new Color(211,211,223));
    
     panel7.add(label5);
     panel7.add(sent);
     panel6.add(label4);
     panel6.add(encrypted);
     button.add(send);
     
     panel3.add(panel7);
     panel3.add(panel6);
     panel3.add(button);
    
     panel4.add(label2,BorderLayout.NORTH);    
     panel4.add(label6,BorderLayout.CENTER);
     panel4.add(panel3,BorderLayout.SOUTH);    
   
     c.add(panel4,BorderLayout.CENTER); 
     send.addActionListener(this);  
     server.setSize(400,400);
     server.setLocation(200,20);
     server.setResizable(false);
     server.setVisible(true);
	}
	
	
	public String encrypt(String plaintext)
	{
	 
	 
	 plaintext.toLowerCase();
	 
	 String ciphertext="";		    	
		int ASCII=0;	
	///(i>key.length?i%key.length:i)					
		for(int i=0;i<plaintext.length();i++)
		{	  
		      ASCII=(int)(plaintext.charAt(i))^(int)(key.charAt(i));
		      System.out.println(ASCII);
		      ciphertext+=((char)(ASCII+97-32));		   		  
		}
		
		return ciphertext; 
		
	}
	 /*--------------------------------------------------------
	                      - Decrypt Method -
	 --------------------------------------------------------*/	
	public String decrypt(String ciphertext)
	{
		String plaintext="";
		int temp=0,num=0;
		
		for(int i=0;i<ciphertext.length();i++)
		{	
		      num=(int)(ciphertext.charAt(i))-97+32;
		      temp=num^(int)(key.charAt(i));		      
		      plaintext+=((char)Math.abs(temp));		   		  
		}
		return plaintext;	    
	}
	
	public void actionPerformed (ActionEvent e)	
	{
	 if(e.getSource()==send)
	 {
	 	
	  try
		{ 	
  	   	 String  plaintext="";
  	   	 plaintext=sent.getText();
         plaintext.toLowerCase();	 
         String ciphertext="";		    	
		 ciphertext=encrypt(plaintext);
		 
		
		 //Name1 cliObject=(Name1)Naming.lookup("rmi://localhost/Name1");
		 String i=decrypt(cliObject.get(ciphertext));
		 //encrypted.setText(i);
		 //System.out.println(i);
			 				
	   }
	   
	   catch(Exception ee)
	   {
		System.out.println("2:      "+ee);
	   }	
		 	
	 	
	 }	
		
	}
		
	
	public String get(String a) throws RemoteException
	{  
	 
	 String mess=decrypt((String)a);
	 encrypted.setText(mess);
	 return (mess);
	}
}