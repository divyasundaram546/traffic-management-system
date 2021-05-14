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

public class Toll extends JFrame implements ActionListener {
	private String[] vehicleType = {" ",
		    "Car/Jeep/Van", "LCV","Bus/Truck","Upto 3 Axle Vehicle","4 to 6 Axle","HCM/EME","7 or more Axle" };
	
	 private int count = 0;

	
    Container container = getContentPane();
    JLabel nameLabel = new JLabel("Toll_Name");
    JLabel boothLabel = new JLabel("Toll_Booth_No");
    JLabel vehicleLabel = new JLabel("Vehicle_Type");
    JLabel amountLabel = new JLabel("Toll_Amount");

    JTextField nameTextField = new JTextField();
    JTextField boothTextField = new JTextField();
    JTextField amountTextField = new JTextField();
   
  
    JComboBox comboBox = new JComboBox();
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("RESET");
    JButton closeButton = new JButton("Close");
   String login_Id1;
    String vehicleText;
    Toll(String login_Id) {
    	 login_Id1=login_Id;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        for(int i = 0; i < vehicleType.length; i++)
     	   comboBox.addItem(vehicleType[count++]);
     	 

        comboBox.addActionListener(new ActionListener() { 
      	   public void actionPerformed(ActionEvent e) {
       vehicleText=(String) ((JComboBox) e.getSource()).getSelectedItem();
      	  
      	   }});


    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(100, 80, 100, 30);
        boothLabel.setBounds(100, 150, 100, 30);
        vehicleLabel.setBounds(100, 220, 100, 30);
        amountLabel.setBounds(100, 290, 100, 30);
       
       nameTextField.setBounds(200, 80, 150, 30);
        boothTextField.setBounds(200, 150, 150, 30);
       amountTextField.setBounds(200, 290, 150, 30);
   
     
        comboBox.setBounds(200, 220, 150, 30);
        submitButton.setBounds(190, 350, 100, 30);
        resetButton.setBounds(40, 350, 100, 30);
        closeButton.setBounds(340, 350, 100, 30);

    }

    public void addComponentsToContainer() {
    	container.add(nameLabel);
        container.add(boothLabel);
        container.add(vehicleLabel);
        container.add(amountLabel);
        
        container.add(nameTextField);
        container.add(boothTextField);
        container.add(amountTextField);
     
    	container.add(comboBox); 
        container.add(submitButton);
        container.add(resetButton);
        container.add(closeButton);
     
    
    }

    public void addActionEvent() {
       submitButton.addActionListener(this);
       resetButton.addActionListener(this);
       closeButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == submitButton) {
            String nameText;
            String boothText;
            
            String amountText;
            nameText= nameTextField.getText();
            boothText = boothTextField.getText();
    
            amountText = amountTextField.getText();
            if (nameText.equals("")|| boothText.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill the details","Error",JOptionPane.ERROR_MESSAGE);
			}
			else  //else insert query is run properly
                            {
				String IQuery = "INSERT INTO toll(id,toll_name,toll_booth_no,vehicle_type,toll_Amount )  VALUES('" + login_Id1 + "','" + nameText +"','" + boothText +"','"+vehicleText+"','"+amountText + "')";
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
				String SMessage = "Record added for "+nameText;
				
                                   // create dialog ox which is print message
                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
              
                    this.dispose();
   				
            				
                    //close connection
				try {
					((java.sql.Connection)conn).close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

        }
            
      

        } else if (e.getSource() == resetButton) {
            nameTextField.setText("");         
            boothTextField.setText("");
            amountTextField.setText(""); 
       
  
        } else
        	   {
                  System.exit(0);
        	   }
   
    }

}