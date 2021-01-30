package chatting;

import java.io.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class server extends JFrame implements ActionListener{
	JPanel p1;
	JTextField t1;
	static JTextArea a1;
	JButton b1;
	static ServerSocket skt;
	static Socket s; 
	static DataInputStream sin;
	static DataOutputStream sout;
	Boolean typing;
	server()
  {
	p1=new JPanel();
	p1.setLayout(null);
	p1.setBackground(new Color(7,94,84));
	p1.setBounds(0,0,450,70);
	add(p1);
	
	ImageIcon i1=new ImageIcon(getClass().getResource("icons/arrow.png"));
	Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel l1=new JLabel(i3);
	l1.setBounds(5,5,30,30);
	p1.add(l1);//to add in frame(mandatory)
	
	

	ImageIcon i4=new ImageIcon(getClass().getResource("icons/red.jpg"));
	Image i5=i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
	ImageIcon i6=new ImageIcon(i5);
	JLabel l2=new JLabel(i6);
	l2.setBounds(40,5,60,60);
	p1.add(l2);//to add in frame(mandatory)
	
	JLabel l3=new JLabel("person1");
	l3.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
    l3.setForeground(Color.WHITE);
    l3.setBounds(110,10,100,20);
    p1.add(l3);
    
    
    JLabel l4=new JLabel("Active now");
	l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
    l4.setForeground(Color.WHITE);
    l4.setBounds(110,35,100,20);
    p1.add(l4);
    
    Timer t=new Timer(1,new ActionListener()
    {
    	public void actionPerformed(ActionEvent ae)
    	{
    		if(!typing)
    		{
    			l4.setText("Active now");
    		}
    	}
    });
    t.setInitialDelay();
    
    ImageIcon i7=new ImageIcon(getClass().getResource("icons/video.png"));
    Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon i9 = new ImageIcon(i8);
    JLabel l5 = new JLabel(i9);
    l5.setBounds(290, 20, 30, 30);
    p1.add(l5);
    
    
    ImageIcon i11=new ImageIcon(getClass().getResource("icons/phone.png"));
    Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
    ImageIcon i13 = new ImageIcon(i12);
    JLabel l6 = new JLabel(i13);
    l6.setBounds(350, 20, 35, 30);
    p1.add(l6);
    
    ImageIcon i14=new ImageIcon(getClass().getResource("icons/dot.png"));
    Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
    ImageIcon i16 = new ImageIcon(i15);
    JLabel l7 = new JLabel(i16);
    l7.setBounds(410, 20, 13, 25);
    p1.add(l7);
    
    t1=new JTextField();
    t1.setBounds(5,660,310,30);
    t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 17));
    add(t1);
    t1.addKeyListener(null);
    
    b1 = new JButton("Send");
    b1.setBounds(320,660,100,30);
    b1.setBackground(new Color(7, 94, 84));
    b1.setForeground(Color.WHITE);
    b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 19));
    b1.addActionListener(this);
    add(b1);
    
    a1=new JTextArea();
    a1.setBackground(Color.WHITE);
    a1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    a1.setEditable(false);
    a1.setLineWrap(true);
    a1.setWrapStyleWord(false);
    a1.setBounds(5,73,440,580);
    add(a1);
    
    
    
    
    l1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
    });
    
    
	
    
    
	
	
	setLayout(null);
 	setSize(450,700);
 	setLocation(10,10);
 	setUndecorated(true);
	setVisible(true);
	
	
	
	
}
	public void actionPerformed(ActionEvent ae)
    {
		try
		{
    	String str=t1.getText();
    	
    	a1.setText(a1.getText()+"\n\t\t"+str);
    	sout.writeUTF(str);//exception
    	t1.setText("");
    	}
		
		catch(Exception e)
		{
			
		}
    	 
    }
   public static void main(String[] args)
{
	new server().setVisible(true);
	String msg="";
	try
	{
	 skt=new ServerSocket(6900);
	 s=skt.accept();
	 sin=new DataInputStream(s.getInputStream());
	 sout=new DataOutputStream(s.getOutputStream());
	 msg=sin.readUTF();
	 a1.setText(a1.getText()+"\n"+msg);
	 
	 skt.close();
	 s.close();
	 
	 
	 
	}
	catch(Exception e)
	{
		
	}
	
	
}
}

