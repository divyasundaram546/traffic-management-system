package Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
 
public class MenuFrame extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = 1L;
 
  
    private JRadioButton pm;
  
    private JButton button;
    private ButtonGroup buttonGroup;
    String login_Id;
   
 

    public MenuFrame(String Login_Id) {
    	login_Id=Login_Id;
    	
    	  System.out.println(Login_Id);
    	
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
        
        pm = new JRadioButton("Parking_Management_Form");
        pm.setBounds(80, 140, 200, 30);
        pm.setActionCommand("Parking_Management_Form");
       
 
        button = new JButton("Okay");
        button.setBounds(120,210,100,30);
        button.addActionListener(this);
 
        buttonGroup = new ButtonGroup();
       
        buttonGroup.add(pm);
        
      
        //add radio buttons
      
        buttonGroup.add(pm);
       
       
        
      
        add(pm);
       
        add(button);
        setSize(600,300);    
        setLayout(null);    
        setVisible(true);  
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Okay")) {
            System.out.println(login_Id);
            System.out.println("Login Sucessfull");
            String bt=buttonGroup.getSelection().getActionCommand(); 
            if (bt=="Parking_Management_Form") {
            	ParkingFrame frame = new ParkingFrame(login_Id);
                frame.setTitle("Parking_Management");
                frame.setVisible(true);
                frame.setBounds(20, 20, 500, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);  
    }}}
 
   

 
}
