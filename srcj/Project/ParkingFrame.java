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

public class ParkingFrame extends JFrame implements ActionListener {
	
	 private int count = 0;

	
    Container container = getContentPane();
  
    JLabel levelLabel = new JLabel("PARKING LEVEL");
    JLabel amountLabel = new JLabel("PARKING AMOUNT");
    JLabel dateLabel = new JLabel("DATE");
    JLabel timeLabel = new JLabel("TIME");
    
    
  
    JTextField levelTextField = new JTextField();
    JTextField amountTextField = new JTextField();
    JTextField dateTextField = new JTextField();
    JTextField timeTextField = new JTextField();
    
  
    
    JButton resetButton = new JButton("RESET");
    JButton submitButton = new JButton("SUBMIT");
    JButton closeButton = new JButton("CLOSE");
   
    String login_Id1;

    ParkingFrame(String login_Id) {
        login_Id1=login_Id;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        
     	 

     	 

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
       
        levelLabel.setBounds(100, 80, 100, 30);
        amountLabel.setBounds(100, 150, 200, 30);
        timeLabel.setBounds(100, 220, 100, 30);
        dateLabel.setBounds(100, 290, 100, 30);
    
      
        levelTextField.setBounds(220, 80, 150, 30);
        amountTextField.setBounds(220, 150, 150, 30);
        timeTextField.setBounds(220, 220, 150, 30);
        dateTextField.setBounds(220, 290, 150, 30);
   

       
        resetButton.setBounds(50, 350, 100, 30);
        submitButton.setBounds(200, 350, 100, 30);
        closeButton.setBounds(350, 350, 100, 30);


    }

    public void addComponentsToContainer() {
  
        container.add(levelLabel);
        container.add(amountLabel);
        container.add(dateLabel);
        container.add(timeLabel);
       
        container.add(levelTextField);
        container.add(amountTextField);
        container.add(dateTextField);
        container.add(timeTextField);
    	
        container.add(resetButton);
        container.add(submitButton);
        container.add(closeButton);
     
    
    }

    public void addActionEvent() {
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
        closeButton.addActionListener(this);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of SUBMIT button
        if (e.getSource() == submitButton) {
            String carText;
            String levelText;
            String amountText;
            String dateText;
            String timeText;
          
            levelText = levelTextField.getText();
            amountText = amountTextField.getText();
            dateText = dateTextField.getText();
            timeText = timeTextField.getText();
            if (levelText.equals("")|| amountText.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill the details","Error",JOptionPane.ERROR_MESSAGE);
			}
			else  //else insert query is run properly
                            {
				String IQuery = "INSERT INTO parking(parking_car_id,parking_level,parking_fees_amount, date,time)  VALUES('"+login_Id1+"','" + levelText +"','" + amountText +"','"+dateText+"','"+timeText + "')";
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
				String SMessage = "Record added for "+ login_Id1;
				
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
            
            
       //     if (carText.equalsIgnoreCase("NULL")) {
         //       JOptionPane.showMessageDialog(this, "Submitted Successfully");
           // } else {
         //       JOptionPane.showMessageDialog(this, "Submission Unsuccessful");
           // }
            

        }else if (e.getSource() == resetButton) {

            levelTextField.setText("");
            amountTextField.setText("");
            dateTextField.setText("");
            timeTextField.setText("");
     
        }else
 	   {
            System.exit(0);
  	   }
      
       
    }
      

       
}