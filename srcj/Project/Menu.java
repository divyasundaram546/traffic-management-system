package Project;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
 
public class Menu extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = 1L;
 
    private JRadioButton toll;
    private JRadioButton pm;
    private JRadioButton rr;
    private JRadioButton pu;
    private JButton button;
    private ButtonGroup buttonGroup;
 String login_Id;
   
 

    public Menu(String Login_Id) {
    	login_Id=Login_Id;
    	
    	  System.out.println(Login_Id);
    	
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
        
       
 
        toll = new JRadioButton("Toll_Administration_Form");
        toll.setBounds(50, 70, 200, 30);
        toll.setActionCommand("Toll_Administration_Form");
 
        pm = new JRadioButton("Parking_Management_Form");
        pm.setBounds(50, 140, 200, 30);
        pm.setActionCommand("Parking_Management_Form");
 
        rr= new JRadioButton("Report_Run_Form");
        rr.setBounds(50, 210, 200, 30);
        rr.setActionCommand("Report_Run_Form");
        
        pu= new JRadioButton("Pickup_Form");
        pu.setBounds(50, 280, 200, 30);
        pu.setActionCommand("Pickup_Form");
 
        toll.setSelected(true);
 
        button = new JButton("Okay");
        button.setBounds(120,350,100,30);
        button.addActionListener(this);
 
        buttonGroup = new ButtonGroup();
       
        
        
      
        //add radio buttons
        buttonGroup.add(toll);
        buttonGroup.add(pm);
        buttonGroup.add(rr);
        buttonGroup.add(pu);
   
       
        
        add(toll);
        add(pm);
        add(rr);
        add(pu);
        add(button);
        setSize(600,300);    
        setLayout(null);    
        setVisible(true);  
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Okay")) {
            System.out.println(login_Id);
            System.out.println("asdfasdf");
            String bt=buttonGroup.getSelection().getActionCommand();
            if (bt=="Toll_Administration_Form") {
            	 Toll frame = new Toll(login_Id);
                 frame.setTitle("Toll-Administration");
                 frame.setVisible(true);
                 frame.setBounds(20, 20, 500, 600);
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setResizable(false);
                 frame.setLocationRelativeTo(null);  
                 
        }else 
            if (bt=="Parking_Management_Form") {
            	ParkingFrame frame = new ParkingFrame(login_Id);
                frame.setTitle("Parking_Management");
                frame.setVisible(true);
                frame.setBounds(20, 20, 500, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);  
    }else 
    	if (bt=="Report_Run_Form") {
    	ReportFrame frame = new ReportFrame();
        frame.setTitle("Report_Run_Form");
        frame.setVisible(true);
        frame.setBounds(20, 20, 500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);  
}else 
	 {
	PickupFrame frame = new PickupFrame();
    frame.setTitle("Pickup_Form");
    frame.setVisible(true);
    frame.setBounds(20, 20, 800, 700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);  
    }}}
 
   

 
}