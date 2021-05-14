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

public class ReportFrame extends JFrame implements ActionListener {
	private String[] vehicleType = {" ",
		    "Car", "Truck" , "Bus" , "Bike" };
	
	 private int count = 0;

	
    Container container = getContentPane();
    JLabel vehicleLabel = new JLabel("VEHICLE_NO");
    JLabel typeLabel = new JLabel("VEHICLE_TYPE");
    JLabel accidentLabel = new JLabel("CAUSE_OF_ACCIDENT");
    JLabel locationLabel = new JLabel("LOCATION");
    JLabel punishmentLabel = new JLabel("PUNISHMENT");
    
    
   
    JTextField vehicleTextField = new JTextField();
    JTextField accidentTextField = new JTextField();
    JTextField locationTextField = new JTextField();
    JTextField punishmentTextField = new JTextField();
    
  
    JComboBox comboBox = new JComboBox();
    JButton resetButton = new JButton("RESET");
    JButton submitButton = new JButton("SUBMIT");
    JButton closeButton = new JButton("CLOSE");
   

  
    String typeText;
    ReportFrame() {
    
    	setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        for(int i = 0; i < vehicleType.length; i++)
     	   comboBox.addItem(vehicleType[count++]);
     	 

        comboBox.addActionListener(new ActionListener() { 
       	   public void actionPerformed(ActionEvent e) {
        typeText=(String) ((JComboBox) e.getSource()).getSelectedItem();
       	  
       	   }});


    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        vehicleLabel.setBounds(100, 80, 100, 30);
        typeLabel.setBounds(100, 150, 100, 30);
        accidentLabel.setBounds(100, 220, 200, 30);
        locationLabel.setBounds(100, 290, 100, 30);
        punishmentLabel.setBounds(100, 350, 100, 30);
 
        vehicleTextField.setBounds(250, 80, 150, 30);
        accidentTextField.setBounds(250, 220, 150, 30);
        locationTextField.setBounds(250, 290, 150, 30);
        punishmentTextField.setBounds(250, 350, 150, 30);

        comboBox.setBounds(250, 150, 150, 30);
        resetButton.setBounds(60, 420, 100, 30);
        submitButton.setBounds(200, 420, 100, 30);
        closeButton.setBounds(35`0, 420, 100, 30);


    }

    public void addComponentsToContainer() {
    	container.add(vehicleLabel);
    	   container.add(typeLabel);
        container.add(accidentLabel);
        container.add(locationLabel);
        container.add(punishmentLabel);
        
        container.add(vehicleTextField);
        container.add(accidentTextField);
        container.add(locationTextField);
        container.add(punishmentTextField);
    
    	container.add(comboBox); 
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
            String vehicleText;
            String accidentText;
            String punishmentText;
            String locationText;
            vehicleText = vehicleTextField.getText();
            accidentText = accidentTextField.getText();
            punishmentText = punishmentTextField.getText();
            locationText = locationTextField.getText();
            if (vehicleText.equals("")|| accidentText.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill the details","Error",JOptionPane.ERROR_MESSAGE);
			}
			else  //else insert query is run properly
                            {
				String IQuery = "INSERT INTO report(location,vehicle,accident,punishment,vehicle_identification_no)  VALUES('"+locationText+"','" + typeText +"','"+accidentText+"','"+punishmentText+"','"+vehicleText+"')";
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
			String SMessage = "Record added for "+vehicleText;
			
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
    
      
      
    }else  if (e.getSource() == resetButton) {
        vehicleTextField.setText("");
        accidentTextField.setText("");
        punishmentTextField.setText("");
        locationTextField.setText("");
    }else
	   {
        System.exit(0);
	   }
        
    
    
    }}

