import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Encryption_Techniques extends JFrame implements ActionListener {
	
  Container c;
  JPanel panel1,panel3,panel4,panel6,panel7;
  JButton send;
  JLabel label2,label4,label5,label6;
  JTextArea encrypted,sent;
  Font font=new Font("Serif",Font.PLAIN+Font.BOLD,14);
  Font font1=new Font("Serif",Font.PLAIN+Font.ITALIC,12);
  Font font2=new Font("Serif",Font.PLAIN,14);

  //constructor
  public Encryption_Techniques()
  {
  	super("*Client");
    c=getContentPane();

    panel1=new JPanel();
    
    panel3=new JPanel();
    panel4=new JPanel();
    
    panel6=new JPanel();
    panel7=new JPanel();
    
    panel1.setBackground(Color.black);
   
    panel3.setBackground(Color.black);
    panel4.setBackground(Color.black);
    
    panel6.setBackground(Color.black);
    panel7.setBackground(Color.black); 
 
    
    panel3.setLayout(new GridLayout(2,1));
    

    Icon icon3=new ImageIcon("connect4.JPG");
    
    
    send=new JButton("send");
    
    
    send.setBackground(Color.black);
   
    send.setForeground(Color.white);
   
    
    send.addActionListener(this);
   
 
    label4=new JLabel("  Encrypted Message");
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
    panel3.add(panel7);
    panel3.add(panel6);
    
    panel4.add(label2,BorderLayout.NORTH);    
    panel4.add(label6,BorderLayout.CENTER);
    panel4.add(panel3,BorderLayout.SOUTH);
    
    
    
   
    c.add(panel4,BorderLayout.CENTER);
    
 
    
    setSize(500,380);
    setLocation(200,20);
    setResizable(false);
    setVisible(true);
  }


  public void actionPerformed(ActionEvent e)
  {  	
  	

  }





  //main method
  public static void main(String arg[])
  {
    Encryption_Techniques application=new Encryption_Techniques();
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
