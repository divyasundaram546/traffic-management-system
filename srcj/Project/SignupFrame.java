package Project;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.Random;


public class SignupFrame extends JFrame implements ActionListener {
	
	
	private String[] userType = {" ",
		    "Citizen", "Police officer" };
	 private int count = 0;

	
    Container container = getContentPane();
  
    JLabel nameLabel = new JLabel("NAME");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel TypeLabel = new JLabel("USER_TYPE");
  
    JTextField nameTextField = new JTextField();
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
  
    JComboBox comboBox = new JComboBox();
    JButton signButton = new JButton("SIGNUP");
    JButton loginButton = new JButton("LOGIN");


    String comboText;
    SignupFrame() {
        setLayoutManager();
      //  Random random = new Random(); 
    //    int Login_Id = random.nextInt(999)    ;
       // System.out.println(Login_Id);
   //     idTextField = new JTextField();
      //  idTextField.setText(String.valueOf(Login_Id));
        
        addComponentsToContainer();
        setLocationAndSize();
        addActionEvent();
        for(int i = 0; i < userType.length; i++)
     	   comboBox.addItem(userType[count++]);
     	 

     	 comboBox.addActionListener(new ActionListener() { 
     	   public void actionPerformed(ActionEvent e) {
      comboText=(String) ((JComboBox) e.getSource()).getSelectedItem();
     
     	   }});
     	
    }

    

    private void text() {
		// TODO Auto-generated method stub
		
	}



	public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
    
        nameLabel.setBounds(50, 80, 100, 30);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50,220, 100, 30);
        TypeLabel.setBounds(50, 290, 100, 30);
       
        nameTextField.setBounds(150, 80, 150, 30);
        userTextField.setBounds(150,150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
     
        comboBox.setBounds(150,290, 150, 30);
        signButton.setBounds(50, 360, 100, 30);
        loginButton.setBounds(200, 360, 100, 30);


    }

    public void addComponentsToContainer() {
  
    	container.add(nameLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(TypeLabel);
       
        container.add(nameTextField);
        container.add(userTextField);
        container.add(passwordField);
    	container.add(comboBox); 
        container.add(signButton);
        container.add(loginButton);
     
    
    }

    public void addActionEvent() {
        signButton.addActionListener(this);
        loginButton.addActionListener(this);
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
    	
        //Coding Part of LOGIN button
        if (e.getSource() == signButton ) {
        	
            String userText;
            String pwdText;
            String nameText;
            nameText= nameTextField.getText();
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equals("")|| pwdText.equals(""))
			{
				JOptionPane.showMessageDialog(null," name or password or Role is wrong","Error",JOptionPane.ERROR_MESSAGE);
			}
			else  //else insert query is run properly
                            {
				
				String IQuery = "INSERT INTO Sign_up(NAME,USERNAME,PASSWORD,USER_TYPE)  VALUES('"+nameText+"','"+userText+"','"+pwdText+"','"+comboText+"')";
				System.out.println(IQuery);//print on console
				System.out.println("Connecting to a selected database...");
				ConnectDB con1=new ConnectDB();
				
				Connection conn=con1.connect();
			try {
				((Connection)conn).createStatement().execute(IQuery);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//select the rows
				// define SMessage variable
				String SMessage = "Record added for "+userText;
				
                                   // create dialog ox which is print message
                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
              
            				this.dispose();
            				 LoginFrame frame1 = new LoginFrame();
            			        frame1.setTitle("Traffic Management System");
            			        frame1.setVisible(true);
            			        frame1.setBounds(10, 10, 400, 600);
            			        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            			        frame1.setResizable(false);
            			        frame1.setLocationRelativeTo(null);  
            	
                    //close connection
				try {
					((java.sql.Connection)conn).close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

        }
            
            
        //Coding Part of RESET button
     //   if (e.getSource() == resetButton) {
         //   userTextField.setText("");
           // passwordField.setText("");
     //   }
       //Coding Part of showPassword JCheckBox
   //     if (e.getSource() == showPassword) {
      //      if (showPassword.isSelected()) {
//          //      passwordField.setEchoChar((char) 0);
//     //       } else {
              //  passwordField.setEchoChar('*');
     //       }


        }
        else  {
        	System.out.println("one");
        this.dispose();
        LoginFrame frame1 = new LoginFrame();
        frame1.setTitle("Traffic Management System");
        frame1.setVisible(true);
        frame1.setBounds(10, 10, 400, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);  
     
    }
 

   
    }}