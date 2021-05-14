package Project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class LoginFrame extends JFrame implements ActionListener {

	
	
	 private int count = 0;

	
    Container container = getContentPane();
   
	
	
   
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");

  
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
  
  
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton signupButton = new JButton("SIGNUP");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
       
    }
    //    for(int i = 0; i < userType.length; i++)
     //	   comboBox.addItem(userType[count++]);
     	 

     	// comboBox.addActionListener(new ActionListener() { 
     //	   public void actionPerformed(ActionEvent e) {
//     	  textfield2.setText("You Selected : " +      
//     	       ((JComboBox)e.getSource()).getSelectedItem());
     //	   }
    // 	 });
     	
  //  }
    
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
    	
    	
     
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        
        
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
     
     
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(30, 310, 100, 30);
        resetButton.setBounds(150, 310, 100, 30);
        signupButton.setBounds(270, 310, 100, 30);



    }

    public void addComponentsToContainer() {
 
        container.add(userLabel);
        container.add(passwordLabel);
    
        
        container.add(userTextField);
        container.add(passwordField);
      
        container.add(showPassword);
    	
        container.add(loginButton);
        container.add(resetButton);
        container.add(signupButton);
    
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        signupButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
           
            if (userText.equals("")|| pwdText.equals("")) {
            	JOptionPane.showMessageDialog(null,"Please fill the details","Error",JOptionPane.ERROR_MESSAGE);
            }else {	
	            ConnectDB con1=new ConnectDB();
				
				Connection conn=con1.connect();
            	try {
            		String IQuery = "select count(*) from Sign_up where username='"+userText+"'and password='"+pwdText+"'";
            		System.out.println(IQuery);
					PreparedStatement stmt=conn.prepareStatement(IQuery);  
					ResultSet rs=stmt.executeQuery();  
					while(rs.next()){  
					System.out.println(rs); 
					if(rs.getInt(1)==1) {
					System.out.println(rs.getInt(1));  
					JOptionPane.showMessageDialog(this, "Login Successful");
					String IQuery1 = "select Login_Id,USER_TYPE from Sign_up where username='"+userText+"' and password='"+pwdText+"'";
					PreparedStatement stmt1=conn.prepareStatement(IQuery1);  
					ResultSet rs1=stmt1.executeQuery();  
					while(rs1.next()){  
					System.out.println("Executed"); 
					System.out.println(String.valueOf(rs1.getInt(1))+" "+rs1.getString(2)); 
                 String type=rs1.getString(2);
                 
               
				if(type.equals("Citizen")) {
					this.dispose();
					MenuFrame frame = new MenuFrame(String.valueOf(rs1.getInt(1))); 
	            	  
        	        // Setting Bounds of JFrame. 
        	        frame.setBounds(10, 10, 370, 400); 
        	  
        	        // Setting Title of frame. 
        	        
        	        frame.setTitle("Menu"); 
        	  
        	        // Setting Visible status of frame as true. 
        	        frame.setVisible(true); 
        	        
        	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	        frame.setLocationRelativeTo(null);  
					
				}else {
					this.dispose();
					Menu f = new Menu(String.valueOf(rs1.getInt(1))); 
	            	  System.out.println(type);
        	        // Setting Bounds of JFrame. 
        	        f.setBounds(10, 10, 370, 600); 
        	  
        	        // Setting Title of frame. 
        	        
        	        f.setTitle("Menu"); 
        	  
        	        // Setting Visible status of frame as true. 
        	        f.setVisible(true); 
        	        
        	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	        f.setLocationRelativeTo(null);  
					
					}}}else
					{
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
					}
					}
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	        
            	    } 
            
    	  
            } else if(e.getSource() == signupButton) {
            	this.dispose();
        		SignupFrame frame = new SignupFrame();
      	        frame.setTitle("Traffic Management System");
      	        frame.setVisible(true);
      	        frame.setBounds(10, 10, 370, 600);
      	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      	        frame.setResizable(false);
      	      frame.setLocationRelativeTo(null);  
      	     	
            }else if(e.getSource() == resetButton) {
                userTextField.setText("");
                passwordField.setText("");
            }else {
            	 passwordField.setEchoChar((char) 0);
            }


    }

}