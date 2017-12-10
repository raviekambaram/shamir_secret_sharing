/* 
 *  Files: Share.java
 *  Courtesy: Robert Bisewski
 */
 
 //the necessary imports
import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
import java.io.*;
import java.math.BigInteger;

//import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.*;
//import java.util.Vector;
import java.util.Random;

//this is where the class starts
@SuppressWarnings("serial")
public class Share extends JFrame implements ActionListener {

    //this string defines the text of the About Program button
    String aboutTxt = "Courtesy: Robert Bisewski, Former ACS Student of University of Winnipeg";
                         
    //this string defines the text of Display Instructions button
    String instructTxt = "Instructions:\n" +
                      "------------------\n\n" +
      
                         "Load/Enter Text: This opens a text\n" +
                         "file that the user selects and dumps\n" +
                         "its contents to the original text box.\n\n" +
                         
                         "Create Shares: This takes the contents\n" +
                         "of the original text box, creates five\n" +
                         "shares, and places them into their boxes.\n\n" +
                          
                         "Reconstruct Original: This takes the\n" +
                         "shares placed in the share boxes and\n" +
                         "uses them to recreate the original text.\n" +
                         "Click the checkboxes to decide which\n" +
                         "shares you wish to use.";

    //the filter that describes what files can be opened
    FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text File", "txt", "TXT");
    
    // the plain text
    String plain;
    int prim = 127; //modulo prime
    //share texts
    String shr1,shr2,shr3,shr4,shr5;
    int strln;
    //the text-areas and the scrollbars used in this program
    private JTextArea originaltxt = new JTextArea("Original Text");
    private JScrollPane scrBar    = new JScrollPane(originaltxt);
    private JTextArea retxt       = new JTextArea("");
    private JScrollPane RscrBar   = new JScrollPane(retxt);
    private JTextArea share1      = new JTextArea("");
    private JScrollPane scrBar1   = new JScrollPane(share1);
    private JTextArea share2      = new JTextArea("");
    private JScrollPane scrBar2   = new JScrollPane(share2);
    private JTextArea share3      = new JTextArea("");
    private JScrollPane scrBar3   = new JScrollPane(share3);
    private JTextArea share4      = new JTextArea("");
    private JScrollPane scrBar4   = new JScrollPane(share4);
    private JTextArea share5      = new JTextArea("");
    private JScrollPane scrBar5   = new JScrollPane(share5);   
    private JLabel JLabel1 = new JLabel();
    private JLabel JLabel2 = new JLabel();
    private JTextField jTextField2  = new JTextField("");
    private JTextField jTextField3  = new JTextField("");
    //this specifies the checkboxes used with this program
    final JCheckBox chk1 = new JCheckBox("", false);
    final JCheckBox chk2 = new JCheckBox("", false);
    final JCheckBox chk3 = new JCheckBox("", false);
    final JCheckBox chk4 = new JCheckBox("", false);
    final JCheckBox chk5 = new JCheckBox("", false);

    //this buttons used in this program
    final JButton bttLoad    = new JButton("Load Text from File");
    final JButton bttCreate  = new JButton("Create Shares");
    final JButton bttRecon   = new JButton("Reconstruct Original");
    final JButton bttDisplay = new JButton("Display Instructions");
    final JButton bttAbout   = new JButton("About Program");
    final JButton bttQuit    = new JButton("Quit Program");

	private long start_time;

	private long end_time;

	private long textcon_Time;

	private long textrecon_Time;

	private long start_time1;

	private long end_time1;
  
  //the default constructor for this program
  public Share() {
	  
    //defines the details of the scrollbars
    originaltxt.setLineWrap(true);
    originaltxt.setWrapStyleWord(true);
    scrBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    scrBar1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share1.setLineWrap(true);
    share1.setWrapStyleWord(true);
    
    scrBar2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share2.setLineWrap(true);
    share2.setWrapStyleWord(true);
    
    scrBar3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share3.setLineWrap(true);
    share3.setWrapStyleWord(true);
    
    scrBar4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share4.setLineWrap(true);
    share4.setWrapStyleWord(true);
    
    scrBar5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share5.setLineWrap(true);
    share5.setWrapStyleWord(true);
    
    RscrBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    retxt.setLineWrap(true);
    retxt.setWrapStyleWord(true);
    JLabel1.setText("Share con Time:");
    JLabel2.setText("Text recon Time:");
    //defines the size of several objects
    scrBar.setPreferredSize(new Dimension(170,160));
    scrBar1.setPreferredSize(new Dimension(170,160));
    chk1.setPreferredSize(new Dimension(175,15));
    scrBar2.setPreferredSize(new Dimension(170,160));
    chk2.setPreferredSize(new Dimension(175,15));
    scrBar3.setPreferredSize(new Dimension(170,160));
    chk3.setPreferredSize(new Dimension(175,15));
    scrBar4.setPreferredSize(new Dimension(170,160));
    chk4.setPreferredSize(new Dimension(175,15));
    scrBar5.setPreferredSize(new Dimension(170,160));
    chk5.setPreferredSize(new Dimension(175,15));
    RscrBar.setPreferredSize(new Dimension(170,160));
    bttLoad.setPreferredSize(new Dimension(170,25));
    bttCreate.setPreferredSize(new Dimension(170,25));
    bttRecon.setPreferredSize(new Dimension(170,25));
    bttDisplay.setPreferredSize(new Dimension(170,25));       
    bttAbout.setPreferredSize(new Dimension(170,25));
    bttQuit.setPreferredSize(new Dimension(170,25));
    jTextField2.setPreferredSize(new Dimension(170,25));
    jTextField3.setPreferredSize(new Dimension(170,25));
  
    //defines the panels used in this program
    JPanel menu = new JPanel(); menu.setBorder(BorderFactory.createTitledBorder("Menu Options:"));
    menu.setPreferredSize(new Dimension(200,220));   
    JPanel originalPan = new JPanel(); originalPan.setBorder(BorderFactory.createTitledBorder("Original Text:"));
    originalPan.setPreferredSize(new Dimension(200,220));
    JPanel share1Pan = new JPanel(); 
    share1Pan.setBorder(BorderFactory.createTitledBorder("Share Text 1:"));
    share1Pan.setPreferredSize(new Dimension(200,220));
    JPanel share2Pan = new JPanel();
    share2Pan.setBorder(BorderFactory.createTitledBorder("Share Text 2:"));
    share2Pan.setPreferredSize(new Dimension(200,220));
    JPanel share3Pan = new JPanel();
    share3Pan.setBorder(BorderFactory.createTitledBorder("Share Text 3:"));
    share3Pan.setPreferredSize(new Dimension(200,220));
    JPanel share4Pan = new JPanel();
    share4Pan.setBorder(BorderFactory.createTitledBorder("Share Text 4:"));
    share4Pan.setPreferredSize(new Dimension(200,220));
    JPanel share5Pan = new JPanel();
    share5Pan.setBorder(BorderFactory.createTitledBorder("Share Text 5:"));
    share5Pan.setPreferredSize(new Dimension(200,220));
    JPanel rePan = new JPanel();
    rePan.setBorder(BorderFactory.createTitledBorder("Reconstructed Text:"));
    rePan.setPreferredSize(new Dimension(200,220));
    JPanel timpan = new JPanel();
    timpan.setBorder(BorderFactory.createTitledBorder("Time Panel:"));
    timpan.setPreferredSize(new Dimension(200,220));
    //defines the layouts of the Content Pane
    getContentPane().setLayout(new FlowLayout());
    
   //adds the panels to the Content Pane
   menu.add(bttLoad);
  menu.add(bttCreate);
   menu.add(bttRecon);
   menu.add(bttDisplay);
   menu.add(bttAbout);
   menu.add(bttQuit);
   originalPan.add(scrBar);
   rePan.add(RscrBar);
   share1Pan.add(scrBar1);
   share1Pan.add(chk1);
   share2Pan.add(scrBar2);
   share2Pan.add(chk2);
   share3Pan.add(scrBar3);
   share3Pan.add(chk3);
   share4Pan.add(scrBar4);
   share4Pan.add(chk4);
   share5Pan.add(scrBar5);
   share5Pan.add(chk5);
   timpan.setLayout(new GridLayout(0, 1));
   //timpan.add(jTextField3);
   getContentPane().add(originalPan);
   getContentPane().add(share1Pan);
   getContentPane().add(share2Pan);
   getContentPane().add(share3Pan);
   getContentPane().add(share4Pan);
   getContentPane().add(share5Pan);
   getContentPane().add(rePan);
   getContentPane().add(menu);
   getContentPane().add(JLabel1);
   getContentPane().add(jTextField2);
   getContentPane().add(JLabel2);
   getContentPane().add(jTextField3);
  //(JComponent)getContentPane()).setBorder(   
		      //BorderFactory.createEmptyBorder(10, 10, 10, 10) );  
   //adds ActionListeners to this program's components
   bttLoad.addActionListener(this);
   bttCreate.addActionListener(this);
   bttRecon.addActionListener(this);
   bttDisplay.addActionListener(this);
   bttAbout.addActionListener(this);
   bttQuit.addActionListener(this);
   
   //this sets essential values of the GUI
   setTitle("ICSI-426 Assignment #3: Text Secret Sharing");
   setSize(1400,520);
   setResizable(false);
   addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
  }

  ////////////////////////////////////////////////////////
  //Basic Program Functions for Input/Output Starts Here// 
  ////////////////////////////////////////////////////////
  
  //this opens a file via the JFileChooser, returns file name & location
  public String SelectFile() {
  
    //variable declaration
    String path = null;
  
    //this creates a JFileChooser gui in order to select a file
    JFileChooser jfc = new JFileChooser();
    jfc.setFileFilter(fnef);
    int buttonClicked = jfc.showOpenDialog(new JLabel("Open File"));
    
    //this checks which button was pressed on the JFileChooser GUI
    if (buttonClicked == JFileChooser.APPROVE_OPTION) {
      path = "" + jfc.getCurrentDirectory() + "\\"
               + (jfc.getSelectedFile().getName()).toLowerCase();
    }
    return path;
  }

  //this reads the contents of the text area to a text file
  public void txtRead(String file) {
   
   //this buffers, then reads the file
    StringBuffer s = new StringBuffer();
    try {
      BufferedReader input = new BufferedReader(new FileReader(file));
      try {
        String line = "";
        while ((line = input.readLine()) != null) {s.append(line + "\n");}
      }
      finally {input.close();}
     }
     catch (Exception x){JOptionPane.showMessageDialog(null, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);}
   
   
   //this display the text
   originaltxt.setText(s.toString());
  }

  //this divides the original text into 5 separate shares
  public void txtShare() 
  {
	start_time = System.currentTimeMillis();  
	Random rand = new Random();
	plain = originaltxt.getText();
	strln = plain.length();
    int[] asc = new int[strln];
    int[] shres = new int[5*strln];
    int[] shre1 = new int[strln];
    int[] shre2 = new int[strln];
    int[] shre3 = new int[strln];
    int[] shre4 = new int[strln];
    int[] shre5 = new int[strln];
    int a =0,b =0,c =0,d =0,e =0;
    int k=0;
    int q=0;
    int a0,a1,a2;
    a1 = rand.nextInt(50) + 1;
	a2 = rand.nextInt(50) + 1;
	StringBuilder sb ;
    for(int i = 0;i<strln;i++)
    {
    	
    	asc[i] =Integer.valueOf(plain.charAt(i));
    	
    		a0 = asc[i];
    	
    	//System.out.println("a0a1a2: "+a0+","+a1+","+a2);
    	for(int j = 1;j<6;j++)
    	{
    		
    		int mult = a0+a1*j+a2*j*j;
    		if(q==5)q=0;
    		if	(q==0)
    		{
    			shre1[a] = mult%prim;
    			//System.out.println("shre1 : "+shre1[a] );
    			a++;
    			
    		}
    		if	(q==1)
    		{
    			shre2[b] = mult%prim;	
    			b++;
    		}
    		if	(q==2)
    		{
    			shre3[c] = mult%prim;	
    			c++;
    		}
    		if	(q==3)
    		{
    			shre4[d] = mult%prim;	
    			d++;
    		}
    		if	(q==4)
    		{
    			shre5[e] = mult%prim;	
    			e++;
    		}
    		
    		shres[k] = mult%prim;
    		//System.out.println(shres[k] );
    		k++;
    		q++;
    	}
   
    }
    sb = new StringBuilder (strln);
    for(int i=0;i<shre1.length;i++)
    {
    	sb.append(Character.toString ((char) shre1[i]));
    }
    share1.setText(sb.toString());
    
    sb = new StringBuilder (strln-1);
    for(int i=0;i<shre2.length;i++)
    {
    	sb.append(Character.toString ((char) shre2[i]));
    }
    share2.setText(sb.toString());
    
    sb = new StringBuilder (strln-1);
    for(int i=0;i<shre3.length;i++)
    {
    	sb.append(Character.toString ((char) shre3[i]));
    }
    share3.setText(sb.toString());
    
    sb = new StringBuilder (strln-1);
    for(int i=0;i<shre4.length;i++)
    {
    	sb.append(Character.toString ((char) shre4[i]));
    }
    share4.setText(sb.toString());
    
    sb = new StringBuilder (strln-1);
    for(int i=0;i<shre5.length;i++)
    {
    	sb.append(Character.toString ((char) shre5[i]));
    }
    share5.setText(sb.toString());
    end_time = System.currentTimeMillis();
    textcon_Time = end_time - start_time;
    jTextField2.setText(Long.toString(textcon_Time));
  }

  //this reconstructs the shares and dumps the result to the reconstructed text area
  public void txtRecon() 
  {
	  start_time1 = System.currentTimeMillis(); 
	  String share1_text = share1.getText();
	  String share2_text = share2.getText();
	  String share3_text = share3.getText();
	  String share4_text = share4.getText();
	  String share5_text = share5.getText();
	  int[] shre1 = new int[strln];
	  int[] shre2 = new int[strln];
	  int[] shre3 = new int[strln];
	  int[] shre4 = new int[strln];
	  int[] shre5 = new int[strln];
	  StringBuilder sb = new StringBuilder (strln);
	  for(int i = 0;i<strln;i++)
	    {
		  shre1[i] =Integer.valueOf(share1_text.charAt(i));
		  shre2[i] =Integer.valueOf(share2_text.charAt(i));
		  shre3[i] =Integer.valueOf(share3_text.charAt(i));
		  shre4[i] =Integer.valueOf(share4_text.charAt(i));
		  shre5[i] =Integer.valueOf(share5_text.charAt(i));
		}
	  if (chk1.isSelected() && chk2.isSelected() && chk3.isSelected() && !chk4.isSelected() && !chk5.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(1,shre1[i],2,shre2[i],3,shre3[i]));
		   }
	  }
	  else if(chk1.isSelected() && chk2.isSelected() && chk4.isSelected() && !chk3.isSelected() && !chk5.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(1,shre1[i],2,shre2[i],4,shre4[i]));		   
		   }
	  }
	  else if(chk1.isSelected() && chk2.isSelected() && chk5.isSelected() && !chk3.isSelected() && !chk4.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(1,shre1[i],2,shre2[i],5,shre5[i]));		   
		   }
	  }
	  else if(chk1.isSelected() && chk3.isSelected() && chk4.isSelected() && !chk2.isSelected() && !chk5.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(1,shre1[i],3,shre3[i],4,shre4[i]));		   
		   }
	  }
	  else if(chk1.isSelected() && chk3.isSelected() && chk5.isSelected() && !chk2.isSelected() && !chk4.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(1,shre1[i],3,shre3[i],5,shre5[i]));		   
		   }
	  }
	  else if(chk1.isSelected() && chk4.isSelected() && chk5.isSelected() && !chk2.isSelected() && !chk3.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(1,shre1[i],4,shre4[i],5,shre5[i]));		   
		   }
	  }
	  else if(chk2.isSelected() && chk3.isSelected() && chk4.isSelected() && !chk1.isSelected() && !chk5.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(2,shre2[i],3,shre3[i],4,shre4[i]));		   
		   }
	  }
	  else if(chk2.isSelected() && chk3.isSelected() && chk5.isSelected() && !chk1.isSelected() && !chk4.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(2,shre2[i],3,shre3[i],5,shre5[i]));		   
		   }
	  }
	  else if(chk2.isSelected() && chk4.isSelected() && chk5.isSelected() && !chk1.isSelected() && !chk3.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(2,shre2[i],4,shre4[i],5,shre5[i]));
		   }
	  }
	  else if(chk3.isSelected() && chk4.isSelected() && chk5.isSelected() && !chk1.isSelected() && !chk2.isSelected()) 
	  {	 
		  for(int i = 0;i<strln;i++)
		   {
			  sb.append(reConst(3,shre3[i],4,shre4[i],5,shre5[i]));
		   }
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null, "Please select only 3", "Error", JOptionPane.ERROR_MESSAGE);
	  }	 
	  String outputText = sb.toString();
	  retxt.setText(outputText);
	  end_time1 = System.currentTimeMillis();
	  textrecon_Time = end_time1 - start_time1;
	  jTextField3.setText(Long.toString(textrecon_Time));
  }

  private String reConst(int x1, int y1, int x2, int y2, int x3, int y3) 
  {
	
	  int test = (y1 * (-x2 * -x3) * inverse(((x1-x2)*(x1-x3)),prim) + y2 * (-x1 * -x3) * inverse(((x2-x1)*(x2-x3)),prim) + y3 * (-x1 * -x2) * inverse(((x3-x1)*(x3-x2)),prim)) % prim;
	  return Character.toString((char) test);
	
  }
  public int inverse(int num, int pr) {
	  BigInteger n = new BigInteger(String.valueOf(num));
	  BigInteger p = new BigInteger(String.valueOf(pr));
	  BigInteger temp;
	  temp = n.modInverse(p);	  
	  return Integer.valueOf(temp.toString());
  }

//////////////////////////////////////////////////////
  //Basic Program Functions for Input/Output Ends Here// 
  //////////////////////////////////////////////////////
  

  //this determines what button has been pressed on the GUI
  public void actionPerformed(ActionEvent aE) {
    if (aE.getSource() == bttLoad)    {txtRead(SelectFile());}
    if (aE.getSource() == bttCreate)  {txtShare();}
    if (aE.getSource() == bttRecon)   {txtRecon();}
    if (aE.getSource() == bttDisplay) {JOptionPane.showMessageDialog(null,instructTxt);}
    if (aE.getSource() == bttAbout)   {JOptionPane.showMessageDialog(null,aboutTxt);}
    if (aE.getSource() == bttQuit)    {System.exit(0);}
  }
  
  //this is the program's main method, which creates a new application with title, then checks if closes
  public static void main(String args[]) {
     SwingUtilities.invokeLater(new Runnable() {public void run() {Share gui = new Share(); gui.setVisible(true);}});
  }
}