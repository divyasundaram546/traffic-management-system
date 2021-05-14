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

public class PickupFrame extends JFrame implements ActionListener {
	
	 private int count = 0;

	
    Container container = getContentPane();
    JLabel vinLabel = new JLabel("VEHICLE_NO");
    JLabel licenseLabel = new JLabel("LICENSE_NO");
    JLabel nameLabel = new JLabel("CAR_OWNER");
    JLabel ageLabel = new JLabel("AGE");
  
    JLabel addressLabel = new JLabel("ADDRESS");
    JLabel phoneLabel = new JLabel("PHONE_NO");
    
    JLabel dateLabel = new JLabel("DATE");
    JLabel timeLabel = new JLabel("TIME");
    JLabel reasonLabel = new JLabel("REASON");
    JLabel fineLabel = new JLabel("FINE");
    JLabel policeLabel = new JLabel("POLICE_ID");
    JLabel policenameLabel = new JLabel("POLICE_NAME");
   
    
    
    
    JTextField vinTextField = new JTextField();
    JTextField licenseTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField ageTextField = new JTextField();
  
    JTextField addressTextField = new JTextField();
    JTextField phoneTextField = new JTextField();
    
    JTextField dateTextField = new JTextField();
    JTextField timeTextField = new JTextField();
    JTextField reasonTextField = new JTextField();
    JTextField fineTextField = new JTextField();
    JTextField policeTextField = new JTextField();
    JTextField policenameTextField = new JTextField();

    
  
   
    JButton resetButton = new JButton("RESET");
    JButton submitButton = new JButton("SUBMIT");
    JButton closeButton = new JButton("CLOSE");
   


    PickupFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        


    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        vinLabel.setBounds(100, 70, 100, 30);
        licenseLabel.setBounds(100, 140, 100, 30);
        nameLabel.setBounds(100, 210, 100, 30);
        ageLabel.setBounds(100, 280, 100, 30);
      
        addressLabel.setBounds(100, 350, 100, 30);
        phoneLabel.setBounds(100, 420, 100, 30);
        
        dateLabel.setBounds(450, 70, 100, 30);
        timeLabel.setBounds(450, 140, 100, 30);
        reasonLabel.setBounds(450, 210, 100, 30);
        fineLabel.setBounds(450, 280, 100, 30);
        policeLabel.setBounds(450, 350, 100, 30);
        policenameLabel.setBounds(450, 420, 100, 30);
  
        
        vinTextField.setBounds(200, 70, 150, 30);
        licenseTextField.setBounds(200, 140, 150, 30);
        nameTextField.setBounds(200, 210, 150, 30);
        ageTextField.setBounds(200, 280, 150, 30);
   
        addressTextField.setBounds(200, 350, 150, 30);
        phoneTextField.setBounds(200, 420, 150, 30);
        
        dateTextField.setBounds(550, 70, 150, 30);
        timeTextField.setBounds(550, 140, 150, 30);
        reasonTextField.setBounds(550, 210, 150, 30);
        fineTextField.setBounds(550, 280, 150, 30);
        policeTextField.setBounds(550, 350, 150, 30);
        policenameTextField.setBounds(550, 420, 150, 30);
      
       

        
        resetButton.setBounds(150, 500, 100, 30);
        submitButton.setBounds(350,500, 100, 30);
        closeButton.setBounds (550, 500, 100, 30);


    }

    public void addComponentsToContainer() {
    	container.add(vinLabel);
        container.add(licenseLabel);
        container.add(nameLabel);
        container.add(ageLabel);
   
        container.add(addressLabel);
	container.add(phoneLabel);
	
        container.add(dateLabel);
        container.add(timeLabel);
        container.add(reasonLabel);
        container.add(fineLabel);
	container.add(policeLabel);
        container.add(policenameLabel);
       
        
        container.add(vinTextField);
        container.add(licenseTextField);
        container.add(nameTextField);
        container.add(ageTextField);
        
        container.add(addressTextField);
	container.add(phoneTextField);
	
        container.add(dateTextField);
        container.add(timeTextField);
        container.add(reasonTextField);
	container.add(fineTextField);
	container.add(policeTextField);
        container.add(policenameTextField);
    
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
            String vinText;
            String licenseText;
            String nameText;
            String ageText;
        
            String addressText;
	        String phoneText;
	    
            String dateText;
            String timeText;
            String reasonText;
            String fineText;
	    String policeText;
            String policenameText;
  
            vinText = vinTextField.getText();
            licenseText = licenseTextField.getText();
            nameText = nameTextField.getText();
            ageText = ageTextField.getText();
        
            addressText = addressTextField.getText();
	    phoneText = phoneTextField.getText();
	    
            dateText = dateTextField.getText();
            timeText = timeTextField.getText();
            reasonText = reasonTextField.getText();
            fineText = fineTextField.getText();
	    policeText = policeTextField.getText();
            policenameText = policenameTextField.getText();
           
          
            if (vinText.equals("")|| licenseText.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill the details","Error",JOptionPane.ERROR_MESSAGE);
			}
			else  //else insert query is run properly
                            {
				String IQuery = "INSERT INTO pickup(vehicle_no,license_no,car_owner,age,address,phone_no,date,time,reason,fine,police_id,police_name)  VALUES('"+vinText+"','" + licenseText +"','"+nameText+"','"+ageText+"','"+addressText+"','"+phoneText+"','"+dateText+"','"+timeText+"','"+reasonText+"','"+fineText+"','"+policeText+"','"+policenameText+"')";
				
				System.out.println(IQuery);//print on console
				System.out.println("Connecting to a selected database...");
				ConnectDB con1=new ConnectDB();
				
				Connection conn=con1.connect();
			try {
				((Connection)conn).createStatement().execute(IQuery);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String SMessage = "Record added for "+vinText;
			
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
    }else if (e.getSource() == resetButton) {
        vinTextField.setText("");
        licenseTextField.setText("");
        nameTextField.setText("");
        
        addressTextField.setText("");
    phoneTextField.setText("");
        dateTextField.setText("");
        timeTextField.setText("");
        reasonTextField.setText("");
        fineTextField.setText("");
    policeTextField.setText("");
        policenameTextField.setText("");
             
    }else
	   {
        System.exit(0);
	   }
      
}}
