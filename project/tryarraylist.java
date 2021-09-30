package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;



public class tryarraylist extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Shape> shapes= new ArrayList<Shape>();
	private static ArrayList<Stroke> strokes=new ArrayList<Stroke>();
	private static ArrayList<Color> colors=new ArrayList<Color>();						
	private static ArrayList<Label> labels=new ArrayList<Label>();
	private static ArrayList<Label> tflabels=new ArrayList<Label>();
	private static ArrayList<Integer> trackfill=new ArrayList<Integer>();
	private static ArrayList<Color> labcolor=new ArrayList<Color>();
	private static ArrayList<Color> tflabcolor=new ArrayList<Color>();
	private static ArrayList<Integer> delete=new ArrayList<Integer>();
	private static ArrayList<Integer> undodraw=new ArrayList<Integer>();
	private static ArrayList<Integer> undodrawshape=new ArrayList<Integer>();
	private static ArrayList<String> trackaction=new ArrayList<String>();
	private static ArrayList<Boolean> twoshapes=new ArrayList<Boolean>();
	private static ArrayList<Integer> ispen=new ArrayList<Integer>();
	private static ArrayList<Integer> trackshapes=new ArrayList<Integer>();
	private static ArrayList<Shape> trackshapename=new ArrayList<Shape>();
	
	private  static  ArrayList<Shape> delshapes= new ArrayList<Shape>();
	private  static  ArrayList<Stroke> delstrokes=new ArrayList<Stroke>();
	private  static  ArrayList<Color> delcolors=new ArrayList<Color>();						
	private  static  ArrayList<Label> dellabels=new ArrayList<Label>();
	private  static  ArrayList<Label> deltflabels=new ArrayList<Label>();
	private  static ArrayList<Integer> deltrackfill=new ArrayList<Integer>();
	private  static ArrayList<Color> dellabcolor=new ArrayList<Color>();
	private  static ArrayList<Color> deltflabcolor=new ArrayList<Color>();
	private  static  ArrayList<Shape> delshapes2= new ArrayList<Shape>();
	private  static  ArrayList<Color> delcolors2=new ArrayList<Color>();	
	private static ArrayList<Stroke> delstrokes2=new ArrayList<Stroke>();
	private static ArrayList<Integer> deltrackfill2=new ArrayList<Integer>();
	private static ArrayList<Integer> deltrackshapes=new ArrayList<Integer>();
	private static ArrayList<Shape> deltrackshapename=new ArrayList<Shape>();

	
	private  static  ArrayList<Shape> shapes2= new ArrayList<Shape>();
	private  static  ArrayList<Color> colors2=new ArrayList<Color>();	
	private static ArrayList<Stroke> strokes2=new ArrayList<Stroke>();
	private static ArrayList<Integer> trackfill2=new ArrayList<Integer>();
	


	private static JFileChooser open,save;
	private static File file;
	private static String fname,fname1;
	private static BufferedImage img;
	

	static paintsurface ps;

	private static int key=100,ii;
	private JScrollPane sp;
	private static JCheckBox cb ,filling;
	private static boolean saved=true,opened=false,resize=false;
	private static JTextField WID=new JTextField(5),HEI=new JTextField(5);
	private JPanel panelpanel = new JPanel();
	private static Color colorname=  Color.BLUE,c;
	
	private static final float pattern2[]= {9f,9f};
	private static final BasicStroke str2=new BasicStroke(1.5f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0f,pattern2,0f);
	private static final  BasicStroke str1=new BasicStroke(1.5f);
	private static final  BasicStroke str3=new BasicStroke(20.0f);
	private static final  BasicStroke str4=new BasicStroke(8.0f);
	private static final  BasicStroke str5=new BasicStroke(2.8f);
	private static Shape s;
	private static GeneralPath path;
	
	private  static Stroke st;
	private  static int min,max,oldx,oldy,op,currentx,currenty,h,x,y,width,height,ax,ay,bx,by,cx,cy,dx,dy,tx1,tx2,ty1,ty2,j,i,li=0,tfi=0,count=0,trackf;
	private static boolean selected=false,started,welcomepage=false,uptheta=true,upgama=true,upalpha=true,labselected, tfselected, set ,lableadded,arrowon,labtostr=false,movingon=false,twoshapesbool=false,selected2=false;
	private static Label labarray[]=new Label[1000],label , tflabarray[]=new Label[1000],tflab ,tflab1,l,lab;
	private static Point2D clicked;
	private static Component comp;
	
	private static Cursor cur,precursor;
	private static Image curimage;
	private static Point po=new Point(0,0);
	
	private static JPopupMenu pm1;
	private static JMenuItem mi,mii,miii;

	private static JTextField tfarray[]=new JTextField[1000],tf=null;
	private static ArrayList<Image> backimage=new ArrayList<Image>(); 
	private  Timer tm;
	int counttime=0;
	private static JPanel mainpanel;

	private JPanel actualpanel,p1,p2;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,m8,b21,b22,b23,b24;

	private static JPanel welcome;
	private CardLayout cl;
	private static JLabel welcomeLabel,pl1,pl2;
	static float alpha=0.0f,theta=0.0f ,gama=0.0f;
	static int countalpha=0 , countgama=0 , counttheta=0;
	static boolean thetaon=false , gamaon=false , alphaon=true;
	static boolean openpage, backpage , newpage , clearpage;
	static int traverse , traverse2;

	
	public static void main(String args[])
	{
		new tryarraylist();
	}
	

	public tryarraylist()    //constructor
	{
		super("EasyUMLdraw");
		this.setSize(1300,700);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.DARK_GRAY);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
			{
				if(started)
					ps.confirmsaved();
				if(op!=JOptionPane.CANCEL_OPTION)
					System.exit(0);
				if(saved)
					System.exit(0);
			}
		});
			
		HEI.setText("3508");
		WID.setText("2480");
		
		ImageIcon img = new ImageIcon(getClass().getResource("/resourses/skyleft.jpg"));
		final Image img2 = img.getImage();
		p1=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img2, 0, 0,80,750,null);
			}
		};//panel p1
		
	
	
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
	
				
		img=new ImageIcon(getClass().getResource("/resourses/uppersky.jpg"));
		final Image img3=img.getImage();
		p2=new JPanel(new FlowLayout(FlowLayout.LEFT)) 
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img3, 0, 0, 1400,50,null);
			}
		};//panel p2
		
			
			
		mainpanel=new JPanel();
		cl=new CardLayout();
		mainpanel.setLayout(cl);
		
		panelpanel.add(new JLabel("HEIGHT"));
		panelpanel.add(HEI);
		panelpanel.add(Box.createVerticalStrut(25));
		panelpanel.add(new JLabel("WIDTH"));
		panelpanel.add(WID);
		
		//create WELCOME page
		
		
		img=new ImageIcon(getClass().getResource("/resourses/earthback.jpg")); //back2
		final Image img4=img.getImage();
		
		final Image img5=new ImageIcon(getClass().getResource("/resourses/welcomenote.png")).getImage();
		final Image img6=new ImageIcon(getClass().getResource("/resourses/usecase.png")).getImage();
		final Image img7=new ImageIcon(getClass().getResource("/resourses/class1.png")).getImage();
		final Image img8=new ImageIcon(getClass().getResource("/resourses/er1.png")).getImage();
		final Image img9=new ImageIcon(getClass().getResource("/resourses/sequence.png")).getImage();
		final Image img10=new ImageIcon(getClass().getResource("/resourses/activity.png")).getImage();
		final Image img12=new ImageIcon(getClass().getResource("/resourses/class2.png")).getImage();
		final Image img13=new ImageIcon(getClass().getResource("/resourses/newicon.png")).getImage();

		 tm = new Timer(10, new ActionListener()
		{	
			
			public void actionPerformed(ActionEvent e)
			{
				
				welcome.repaint();
				
			}
			
		});
				welcome=new JPanel() 
				{
					
					protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						g.drawImage(img4, 0, 0, null);
	
		
						//make transperent
					
						Graphics2D g2= (Graphics2D)g;
						AlphaComposite transp;
							
					
					if(alphaon)
					{	
				
						
						transp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , alpha);
						g2.setComposite(transp);
						
						
						if(upalpha)
							alpha=(alpha+0.005f);
						if(alpha<0.005f )
						{
							upalpha=true;
							thetaon=true;
							alphaon=false;
							gamaon=false;
						
						}
						if(!upalpha)
							alpha=alpha-0.005f;
						if(alpha>0.9f)
						{	
							upalpha=false;
							thetaon=true;
							alphaon=false;
							gamaon=false;
						}
								
						
						g2.drawImage(img7 ,150 ,200 ,null);
						g2.drawImage(img6 , 950,320 ,null);
						
					}
						
					
					if(thetaon)
					{
					
						
						transp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , theta);
						g2.setComposite(transp);
							
						if(uptheta)
							theta=(theta+0.005f);
						if(theta<0.005f )
						{
							uptheta=true;
							gamaon=true;
							thetaon=false;
							alphaon=false;
						
						}
						if(!uptheta)
							theta=theta-0.005f;
						if(theta>0.9f)
						{
							uptheta=false;
							gamaon=true;
							thetaon=false;
							alphaon=false;
						
						}	
						g2.drawImage(img9 , 100,280 ,null);
						g2.drawImage(img8 ,950 ,50 ,null);
						
					
					}	
					
					if(gamaon)	
					{
						transp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , gama);
						g2.setComposite(transp);
							
					
						
						if(upgama)
							gama=(gama+0.005f);
						if(gama<0.005f )
						{
							upgama=true;
							alphaon=true;
							thetaon=false;
							gamaon=false;
					
						}
						if(!upgama)
							gama=gama-0.005f;
						if(gama>0.9f)
						{	
							upgama=false;
							alphaon=true;
							thetaon=false;
							gamaon=false;
					
						}	
						g2.drawImage(img10 , 700,200 ,null);
						g2.drawImage(img12 , 0,0 ,null);
						
					}
						
						transp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , 0.4f);
						g2.setComposite(transp);
						g2.setColor(Color.WHITE);
						g2.fillRect(220, 420, 850, 200);
					//	g2.setColor(Color.YELLOW);
					//	g2.fillRect(575, 25, 150, 157);
						
						AlphaComposite trans = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , 1.0f);
						g2.setComposite(trans);
						
						g2.drawImage(img5 ,475 ,200 ,null);
						g2.drawImage(img13,575,35,null );
					}//paintComponent
					
					
				};//welcome page panel

				welcome.setLayout(null);
		

		
		tm.start();
		

		actualpanel=new JPanel();	//add panel
		actualpanel.setLayout(new BorderLayout());
		
	


		final JLabel lab=new JLabel("Chooes UML Diagram Type");
		lab.setForeground(Color.BLUE);
		lab.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 25));
		lab.setBounds(470,300,400,300);
		
		curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/hand.png"));
		cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
		
		final JRadioButton r1=new JRadioButton("ERD Diagram");
		c= new Color(221,0,75);
		r1.setBounds(225, 480, 180, 50);
		r1.setForeground(c);
		r1.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r1.setOpaque(false);
		r1.setCursor(cur);
		
		final JRadioButton r2=new JRadioButton("Use-Case Diagram");
		r2.setForeground(c);
		r2.setBounds(415, 480, 220, 50);
		r2.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r2.setOpaque(false);
		r2.setCursor(cur);
		r2.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent ee)
			{
				curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/hand.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
		
			}
			public void mouseExited(MouseEvent ee)
			{
				curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/curser.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
		
			}
		});
		
		
		final JRadioButton r3=new JRadioButton("Activity Diagram");
		r3.setForeground(c);
		r3.setBounds(645, 480, 220, 50);
		r3.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r3.setOpaque(false);
		r3.setCursor(cur);
		r3.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e)
			{
				
		    	curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/hand.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
				
			}

			
			public void mouseExited(MouseEvent arg0) {
		    	curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/curser.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
		
			}

			
		});
		
		final JRadioButton r4=new JRadioButton("Flowchart Diagram");
		r4.setForeground(c);
		r4.setBounds(265, 530, 230, 50);
		r4.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r4.setOpaque(false);
		r4.setCursor(cur);
		
		final JRadioButton r5=new JRadioButton("State Diagram");
		r5.setForeground(c);
		r5.setBounds(870, 480, 230, 50);
		r5.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r5.setOpaque(false);
		r5.setCursor(cur);
		
		final JRadioButton r6=new JRadioButton("Sequence Diagram");
		r6.setForeground(c);
		r6.setBounds(520, 530, 230, 50);
		r6.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r6.setOpaque(false);
		r6.setCursor(cur);
		r6.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e)
			{
				
		    	curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/hand.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
				
			}

			
			public void mouseExited(MouseEvent arg0) {
		    	curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/curser.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
		
			}

			
		});
		
		final JRadioButton r7=new JRadioButton("Collaboration Diagram");
		r7.setForeground(c);
		r7.setBounds(780, 530, 300, 50);
		r7.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 20));
		r7.setOpaque(false);
		r7.setCursor(cur);
		
				
		ButtonGroup gr=new ButtonGroup();
		gr.add(r3);
		gr.add(r2);
		gr.add(r1);
		gr.add(r7);
		gr.add(r6);
		gr.add(r5);
		gr.add(r4);
		
		final JButton chooes=new JButton("<<== GoTo Draw ==>>");
		chooes.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 25));
		chooes.setForeground(Color.BLUE);
		chooes.setBounds(450,580,350,40);
		chooes.setOpaque(false);
		chooes.setBorderPainted(false);
		chooes.setContentAreaFilled(false);
		
		chooes.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e)
			{
				
		    	curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/hand.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
				
			}

			
			public void mouseExited(MouseEvent arg0) {
		    	curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/curser.png"));
				cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
				welcome.setCursor(cur);
		
			}

			
		});
		chooes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				p1.removeAll();
				p2.removeAll();
				
				if(r1.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b2);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b4);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b12);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b15);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b16);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b17);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b5);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
					
				}
				
				if(r2.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b2);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b6);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b9);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b5);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b10);
					p2.add(b11);
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
					
				}
				
				if(r3.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b4);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b19);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b20);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b21);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b23);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b24);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
				}
				
				if(r4.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b4);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b19);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b24);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
				}
				
				if(r5.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b19);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b20);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b21);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b23);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
				}
				
				if(r6.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b9);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b22);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b5);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
				}
				
				if(r7.isSelected())
				{
					p1.add(Box.createVerticalStrut(10));
					p1.add(b1);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b7);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b9);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b18);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b14);
					p1.add(Box.createVerticalStrut(10));
					p1.add(b3);
					p1.add(Box.createVerticalStrut(10));
					p1.add(cb);
					
					p2.add(Box.createHorizontalStrut(10));
					p2.add(b8);
					p2.add(filling);
					p2.add(b13);
					p2.add(m8);
				}
				
				if(r1.isSelected()==false && r2.isSelected()==false  && r3.isSelected()==false && r4.isSelected()==false && r5.isSelected()==false && r6.isSelected()==false && r7.isSelected()==false)
				{
					JOptionPane.showMessageDialog(null,"choose diagram type");
				}
				else
				{
					cl.show(mainpanel, "2");
					started=true;
				}
			}
		});
	
	
		welcome.add(lab);
	    welcome.add(r1);
	    welcome.add(r2);
	    welcome.add(r3);
	    welcome.add(r4);
	    welcome.add(r5);
	    welcome.add(r6);
	    welcome.add(r7);
	    welcome.add(chooes);
		
		ps=new paintsurface();
		
		JMenuBar mb=new JMenuBar();
		mb.setBackground(Color.DARK_GRAY);
		
		JMenu jm1=new JMenu("File");
		jm1.setForeground(Color.WHITE);
		jm1.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 17));
		
		JMenu jm3=new JMenu("Edit");
		jm3.setForeground(Color.WHITE);
		jm3.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 17));
		
		
		JMenu jm2=new JMenu("Help");
		jm2.setForeground(Color.WHITE);
		jm2.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 17));
		
		JMenuItem m1=new JMenuItem("New",new ImageIcon(getClass().getResource("/resourses/new1.png")));
		m1.setBackground(Color.DARK_GRAY);
		m1.setForeground(Color.WHITE);
		m1.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
	
				ps.confirmsaved();
			
						if(op==JOptionPane.YES_OPTION || op==JOptionPane.NO_OPTION || saved)
						{	
							HEI.setText("3508");
							WID.setText("2480");
							resizeFunction();
						
							cleararraylist();
						
							cl.show(mainpanel,"2");
						}
			
				saved=true;
				labtostr=false;
				opened=false;
				fname=null;
			}
		});
		
		JMenuItem m2=new JMenuItem("Open",new ImageIcon(getClass().getResource("/resourses/open.png")));
		m2.setBackground(Color.DARK_GRAY);
		m2.setForeground(Color.WHITE);
		m2.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				ps.confirmsaved();
	
				if(op!=JOptionPane.CANCEL_OPTION || saved)
			
					ps.open();
	
			}
		});

		
		JMenuItem m3=new JMenuItem("Save As",new ImageIcon(getClass().getResource("/resourses/saveas.png")));
		m3.setBackground(Color.DARK_GRAY);
		m3.setForeground(Color.WHITE);
		m3.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				save=new JFileChooser();
				
				save.addChoosableFileFilter(new FileNameExtensionFilter("png","jpg"));	
						 
						save.showSaveDialog(null);
						file = save.getSelectedFile();
						
					
						
						try {
								fname=file.getPath().toString();
								ps.labletostring();
								ps.save();
							}
						catch(Exception eee) 
						{
							JOptionPane.showMessageDialog(null, "No file choosen");
						}
						
			}
		});
		
		
		JMenuItem m4=new JMenuItem("Save",new ImageIcon(getClass().getResource("/resourses/save.png")));
		m4.setBackground(Color.DARK_GRAY);
		m4.setForeground(Color.WHITE);
		m4.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				if(fname!=null)
				{
					ps.labletostring();
					ps.save();
				}//if
				
				else
				{
					open=new JFileChooser();
					
					open.addChoosableFileFilter(new FileNameExtensionFilter("png","jpg"));	
							 
							open.showSaveDialog(null);
							file = open.getSelectedFile();
							
						
							
							try {
									fname=file.getPath().toString();
									ps.labletostring();
									ps.save();
								}
							catch(Exception eee) 
							{
								JOptionPane.showMessageDialog(null, "No file choosen");
							}
							
				}//else
			}
		});
		
		
		JMenuItem m5=new JMenuItem("EXIT                                       ",new ImageIcon(getClass().getResource("/resourses/x-button.png")));
		m5.setBackground(Color.DARK_GRAY);
		m5.setForeground(Color.WHITE);
		m5.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				if(started)
					ps.confirmsaved();
				if(op!=JOptionPane.CANCEL_OPTION)
					System.exit(0);
				if(saved)
					System.exit(0);
			}
		});
		
		
		JMenuItem m6=new JMenuItem("Help Me                           ",new ImageIcon(getClass().getResource("/resourses/helpme.png")));
		m6.setBackground(Color.DARK_GRAY);
		m6.setForeground(Color.WHITE);
		m6.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				try 
				{
					Path chmpath = Files.createTempFile(null,".pdf");
					
					try(InputStream chmResource = getClass().getResourceAsStream("/resourses/main_help.pdf"))
					{
						Files.copy(chmResource, chmpath , StandardCopyOption.REPLACE_EXISTING);
					}
							
					Desktop.getDesktop().open(chmpath.toFile());					
					
				}
				catch(Exception ee) 
				{
					
						JOptionPane.showMessageDialog(null, "Help File Not Available");
				
				}
	
			}
		});
		
		JMenuItem m11=new JMenuItem("About UML                             ",new ImageIcon(getClass().getResource("/resourses/helpme.png")));
		m11.setBackground(Color.DARK_GRAY);
		m11.setForeground(Color.WHITE);
		m11.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				
			
				
				try 
				{
					Path chmpath = Files.createTempFile(null,".pdf");
					
					try(InputStream chmResource = getClass().getResourceAsStream("/resourses/UML_HELP.pdf"))
					{
						Files.copy(chmResource, chmpath , StandardCopyOption.REPLACE_EXISTING);
					}
							
					Desktop.getDesktop().open(chmpath.toFile());
				}
				catch(Exception ee) 
				{
				
						JOptionPane.showMessageDialog(null, "Help File Not Available");
					
					
				}
	
			}
		});
		
		JMenuItem m12=new JMenuItem("Sequence Diagram                            ",new ImageIcon(getClass().getResource("/resourses/helpme.png")));
		m12.setBackground(Color.DARK_GRAY);
		m12.setForeground(Color.WHITE);
		m12.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				try 
				
				{

					Path chmpath = Files.createTempFile(null,".pdf");
					
					try(InputStream chmResource = getClass().getResourceAsStream("/resourses/SEQUENCE_HELP.pdf"))
					{
						Files.copy(chmResource, chmpath , StandardCopyOption.REPLACE_EXISTING);
					}
							
					Desktop.getDesktop().open(chmpath.toFile());					
					
			
				}
				catch(Exception ee) 
				{
				
						JOptionPane.showMessageDialog(null, "Help File Not Available");
										
				}
	
			}
		});
		
	
		
		JMenuItem m14=new JMenuItem("ER Diagram                            ",new ImageIcon(getClass().getResource("/resourses/helpme.png")));
		m14.setBackground(Color.DARK_GRAY);
		m14.setForeground(Color.WHITE);
		m14.setFont(new Font("Nimbus Sans L", Font.BOLD, 15));
		m14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				try 
				{

					Path chmpath = Files.createTempFile(null,".pdf");
					
					try(InputStream chmResource = getClass().getResourceAsStream("/resourses/ERD_HELP.pdf"))
					{
						Files.copy(chmResource, chmpath , StandardCopyOption.REPLACE_EXISTING);
					}
							
					Desktop.getDesktop().open(chmpath.toFile());					
					
			
				}
			catch(Exception ee) 
				{
					
						JOptionPane.showMessageDialog(null, "Help File Not Available");
					
					
				}
		
			}
		});
		
		JMenuItem m7=new JMenuItem("Undo Delete",new ImageIcon(getClass().getResource("/resourses/undo.png")));
		m7.setBackground(Color.DARK_GRAY);
		m7.setForeground(Color.WHITE);
		m7.setFont(new Font("Gargi", Font.BOLD, 15));
		m7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					setlabel();
				try {
					
					if((delshapes.size()-1>=0) && ((delete.get(delete.size()-1))==1))
					{
						//add to original arraylist
						shapes.add(delshapes.get(delshapes.size()-1));
						colors.add(delcolors.get(delcolors.size()-1));
						strokes.add(delstrokes.get(delstrokes.size()-1));
						trackfill.add(deltrackfill.get(deltrackfill.size()-1));
						trackshapes.add(deltrackshapes.get(deltrackshapes.size()-1));
						trackshapename.add(deltrackshapename.get(deltrackshapename.size()-1));
						
						//delete from delete arraylist
						delshapes.remove(delshapes.size()-1);
						delcolors.remove(delcolors.size()-1);
						delstrokes.remove(delstrokes.size()-1);
						ispen.remove(deltrackfill.size()-1);
						deltrackfill.remove(deltrackfill.size()-1);
						delete.remove(delete.size()-1);
					
						
				
						deltrackshapes.remove(deltrackshapes.size()-1);
						deltrackshapename.remove(deltrackshapename.size()-1);
						
						repaint();
					}//if delshapes
					
					else if((dellabels.size()-1>=0)  && ((delete.get(delete.size()-1))==2))
					{
						labels.add(dellabels.get(dellabels.size()-1));
						labcolor.add(dellabcolor.get(dellabcolor.size()-1));
						
						ps.add(dellabels.get(dellabels.size()-1));
						
						dellabels.remove(dellabels.size()-1);
						dellabcolor.remove(dellabcolor.size()-1);
						
						delete.remove(delete.size()-1);
						
					}//if dellabels
					
					else if((deltflabels.size()-1>=0)  && ((delete.get(delete.size()-1))==3))
					{
						tflabels.add(deltflabels.get(deltflabels.size()-1));
						tflabcolor.add(deltflabcolor.get(deltflabcolor.size()-1));
						
						ps.add(deltflabels.get(deltflabels.size()-1));
						
						deltflabels.remove(deltflabels.size()-1);
						deltflabcolor.remove(deltflabcolor.size()-1);
						
						delete.remove(delete.size()-1);
					}
					
					else if((delshapes2.size()-1>=0) && ((delete.get(delete.size()-1))==4))
						{
							
							//add to original arraylist
							shapes2.add(delshapes2.get(delshapes2.size()-1));
							delshapes2.remove(delshapes2.size()-1);
							
							colors2.add(delcolors2.get(delcolors2.size()-1));
							delcolors2.remove(delcolors2.size()-1);
							
							strokes2.add(delstrokes2.get(delstrokes2.size()-1));
							delstrokes2.remove(delstrokes2.size()-1);
							
							trackfill2.add(deltrackfill2.get(deltrackfill2.size()-1));
							deltrackfill2.remove(deltrackfill2.size()-1);
							
							trackshapes.add(deltrackshapes.get(deltrackshapes.size()-1));
							trackshapename.add(deltrackshapename.get(deltrackshapename.size()-1));
							deltrackshapes.remove(deltrackshapes.size()-1);
							deltrackshapename.remove(deltrackshapename.size()-1);
							
							shapes2.add(delshapes2.get(delshapes2.size()-1));
							delshapes2.remove(delshapes2.size()-1);
							
							colors2.add(delcolors2.get(delcolors2.size()-1));
							delcolors2.remove(delcolors2.size()-1);				
					
								strokes2.add(delstrokes2.get(delstrokes2.size()-1));
								delstrokes2.remove(delstrokes2.size()-1);
								
								trackfill2.add(deltrackfill2.get(deltrackfill2.size()-1));
								deltrackfill2.remove(deltrackfill2.size()-1);
								
								trackshapes.add(deltrackshapes.get(deltrackshapes.size()-1));
								trackshapename.add(deltrackshapename.get(deltrackshapename.size()-1));
								deltrackshapes.remove(deltrackshapes.size()-1);
								deltrackshapename.remove(deltrackshapename.size()-1);
								
							delete.remove(delete.size()-1);
							
							repaint();
						}//if delshapes	
			
				}//try
				
					catch(Exception ee) 
					{
						
						JOptionPane.showMessageDialog(null, "No more elements to Undo Delete");
					}
				}//action preformed
				});
		
		JMenuItem m20=new JMenuItem("Undo Draw",new ImageIcon(getClass().getResource("/resourses/redarrow2.png")));
		m20.setBackground(Color.DARK_GRAY);
		m20.setForeground(Color.WHITE);
		m20.setFont(new Font("Gargi", Font.BOLD, 15));
			m20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					setlabel();
				try
				{
					count=0;
					undodrawshape.clear();
					for(int i=0;i<trackshapes.size();i++)
					{
						int n= trackshapes.get(i);
						if(n==1)
						{
							undodrawshape.add(1);
						}//if
						
						else if(n==4 && count==0)
						{
							undodrawshape.add(2);
							count++;
						}//else if
						
						else if(n==4 && count!=0)
						{
							count=0;
						}
						
					}//for
					
				
				if((undodraw.size()-1>=0) && (undodraw.get(undodraw.size()-1))==1)	
				{
				
					  if((undodrawshape.size()-1>=0) && (undodrawshape.get(undodrawshape.size()-1))==1)
					{
									
						 if(ispen.get(ispen.size()-1)==0 )
							{
					
								int index=trackshapename.indexOf(s);	
								shapes.remove((shapes.size()-1));
								
								colors.remove((colors.size()-1));
						
								strokes.remove(strokes.size()-1);
								
								ispen.remove(ispen.size()-1);
								trackfill.remove((trackfill.size()-1));
					
								trackshapes.remove(((trackshapes.size()-1)));
								trackshapename.remove(((trackshapename.size()-1)));
						
							}//if
						else if(ispen.get(ispen.size()-1)==1 ||ispen.get(ispen.size()-1)==5)
						{
							
							int n=ispen.get(ispen.size()-1);
							if(n==5)
							{
						
								ispen.remove((ispen.size()-1));
								n=ispen.get(ispen.size()-1);
											
							}
							while( n==1  && ispen.size()-1!=0 )
							{	
							Shape s=shapes.get(shapes.size()-1);	
							int index=trackshapename.indexOf(s);
							
							shapes.remove(shapes.size()-1);
				
							colors.remove(colors.size()-1);
					
							strokes.remove((strokes.size()-1));
					
							trackfill.remove((trackfill.size()-1));
							trackshapes.remove((index));
							trackshapename.remove((index));
					
				
							if(ispen.size()-1<0)
								break;
							else
							{
							
								ispen.remove((ispen.size()-1));
								n=ispen.get(ispen.size()-1);
							
							}
							repaint();
							}//while
							
				
						}
					
						 repaint();
					}// if undodraw=1---shapes
					
					
						 else if((undodrawshape.size()-1>=0) && (undodrawshape.get(undodrawshape.size()-1))==2)
								
							{   
			
								
								Shape s1=shapes2.get((shapes2.size()-1));
								int index1=trackshapename.indexOf(s1);
								shapes2.remove((shapes2.size()-1));
								
								Shape s2=shapes2.get((shapes2.size()-1));
								int index2=trackshapename.indexOf(s2);
								shapes2.remove((shapes2.size()-1));
								
								colors2.remove((colors2.size()-1));
								colors2.remove((colors2.size()-1));
							
								trackfill2.remove((trackfill2.size()-1));
								trackfill2.remove((trackfill2.size()-1));
							
													
								strokes2.remove((strokes2.size()-1));
								strokes2.remove((strokes2.size()-1));
								
			
						
								trackshapes.remove((index1));
								trackshapename.remove((index1));
								
								trackshapes.remove((index2));
								trackshapename.remove((index2));
								
								undodrawshape.remove(undodrawshape.size()-1);
					
								ispen.remove(ispen.size()-1);
								repaint();
							}// 4---shapes2  
					  
					  undodraw.remove(undodraw.size()-1);
			
				
				}//if undodraw ==1 
					  
					  
		
					  
					  
					else if((undodraw.size()-1>=0) && (undodraw.get(undodraw.size()-1))==2)
				
					{
					
						ps.remove(tflabels.get(tflabels.size()-1));
						tflabels.remove(tflabels.get(tflabels.size()-1));
						undodraw.remove(undodraw.size()-1);
						ispen.remove(ispen.size()-1);
						
					}//if 2---tflab
					
					 else if((undodraw.size()-1>=0) && (undodraw.get(undodraw.size()-1))==3)
					
					{  
						ps.remove(labels.get(labels.size()-1));
						labels.remove(labels.get(labels.size()-1));
						undodraw.remove(undodraw.size()-1);
						ispen.remove(ispen.size()-1);
					}// if 3---<< >>
	
		
				}//try
				
				catch(Exception ee) 
				{
						JOptionPane.showMessageDialog(null, "No more elements to Undo Draw");
				}
			}//action performed
		});
		
		
		m8=new JButton("Back",new ImageIcon(getClass().getResource("/resourses/back.jpg")));

		m8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setlabel();
				ps.confirmsaved();
	
				if(op==JOptionPane.YES_OPTION || op==JOptionPane.NO_OPTION ||saved)
				{	
					HEI.setText("3508");
					WID.setText("2480");
					cleararraylist();
					resizeFunction();
										
					saved=true;
					fname=null;
					cl.show(mainpanel, "1");
					
					
				}
	
			}
		});
		
		JMenuItem m9=new JMenuItem("Resize Page                          ",new ImageIcon(getClass().getResource("/resourses/shrink.png")));
		m9.setBackground(Color.DARK_GRAY);
		m9.setForeground(Color.WHITE);
		m9.setFont(new Font("Gargi", Font.BOLD, 15));
		m9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					

				int result=JOptionPane.showConfirmDialog(null, panelpanel ,"Enter HEIGHT and WIDTH in PIXEL" , JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION)
				{
				
					resize = true;
					resizeFunction();
					
				}//if
		
			}
		});
		jm1.add(m1);
		jm1.add(m2);
		jm1.addSeparator();
		jm1.add(m3);
		jm1.add(m4);
		jm1.addSeparator();
		jm1.add(m5);
		
		jm2.add(m6);
		jm2.add(m11);
		jm2.add(m12);
		jm2.add(m14);
		
		jm3.add(m7);
		jm3.add(m20);
		jm3.addSeparator();
		jm3.add(m9);
		
		mb.add(jm1);
		mb.add(jm3);
		mb.add(jm2);
		
		this.setJMenuBar(mb);
	
		

		b1=new JButton(new ImageIcon(getClass().getResource("/resourses/rectangle.png")));
		b1.setToolTipText("Rectangle");

		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				key=1;
			
					setlabel();
				
				changecurser("rectCur.png");
			
			}
		});

		
		b2=new JButton(new ImageIcon(getClass().getResource("/resourses/ellipse.png")));
		b2.setToolTipText("Elipse");

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=2;
	
					setlabel();
				
				changecurser("ellipseCur.png");
		
			}
		});

		
		b3=new JButton(new ImageIcon(getClass().getResource("/resourses/line.png")));
		b3.setToolTipText("Line");

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=3;
		
					setlabel();
				
				changecurser("lineCur.png");
	
				
			}
		});

		
		b4=new JButton(new ImageIcon(getClass().getResource("/resourses/kite1.png")));
		b4.setToolTipText("Diamond / Rhombus");

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=4;
		
					setlabel();
				
				changecurser("kiteCur.png");

			}
		});
	
		
		b5=new JButton(new ImageIcon(getClass().getResource("/resourses/dline3.png")));
		b5.setToolTipText("Dotted Line");

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=5;
		
					setlabel();
			
				changecurser("dottedlineCur.png");

			}
		});
		
		
		b6=new JButton(new ImageIcon(getClass().getResource("/resourses/dottedcircle.png")));
		b6.setToolTipText("Dotted Circle");

		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key=6;
		
					setlabel();
				
				changecurser("dotcircleCur.png");

			}
		});
		
		
		b7=new JButton(new ImageIcon(getClass().getResource("/resourses/textbox .png")));
		b7.setToolTipText("Text-Box");

		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=7;
		
					setlabel();
				
				changecurser("textCur.png");

			}
		});
		
		
	    b12=new JButton(new ImageIcon(getClass().getResource("/resourses/curdelipse.png")));
		b12.setToolTipText("double circle");

		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=12;
		
					setlabel();
				
				changecurser("doublecircleCur.png");

			}
		});
		
		b10=new JButton("<<include>>");
		b10.setToolTipText("include");

		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=10;
	
					setlabel();
				
				changecurser("curser.png");

			}
		});
		
		b11=new JButton("<<extend>>");
		b11.setToolTipText("extend");

		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=11;
	
					setlabel();
				changecurser("curser.png");

			}
		});
		
		b9=new JButton(new ImageIcon(getClass().getResource("/resourses/actor1.png")));
		b9.setToolTipText("Actor");

		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=9;
		
					setlabel();
				
				changecurser("actorCur.png");

			}
		});
		
		b13=new JButton("Clear");
		b13.setToolTipText("Clear Screen");

		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cleararraylist();
	
			}
		});
		
		b8=new JButton(new ImageIcon(getClass().getResource("/resourses/color.png")));
		b8.setToolTipText("choose a Color");
		b8.setPreferredSize(new Dimension(150,27));
		b8.setBackground(colorname);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					setlabel();
				
				 colorname=JColorChooser.showDialog(null," Pick a Color", colorname);
				 b8.setBackground(colorname);
			
			}		
		});
		
		b14=new JButton(new ImageIcon(getClass().getResource("/resourses/eraser.png")));
		b14.setToolTipText("Eraser");

		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=14;
		
					setlabel();
				
				changecurser("eraser.png");

			}
		});
		
		
		b15=new JButton(new ImageIcon(getClass().getResource("/resourses/triangle.png")));
		b15.setToolTipText("Triangle");

		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=15;
		
					setlabel();
				
				changecurser("triangleCur.png");

			}
		});
		
		b16=new JButton(new ImageIcon(getClass().getResource("/resourses/doublerect.png")));
		b16.setToolTipText("double Rectangle \n used for Week Entity Class");

		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=16;
			
					setlabel();
				
				changecurser("doublerectCur.png");

			}
		});
		
		b17=new JButton(new ImageIcon(getClass().getResource("/resourses/doublekite.png")));
		b17.setToolTipText("double diamond \n used for Identifying Relationship Type");

		b17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=17;
			
					setlabel();
				changecurser("doublekiteCur.png");

			}
		});
		
		b18=new JButton(new ImageIcon(getClass().getResource("/resourses/pen.png")));

		b18.setToolTipText("pen");
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=18;
		
					setlabel();
				changecurser("pencil.png");

			}
		});
		
		
		b19=new JButton(new ImageIcon(getClass().getResource("/resourses/roundrect.png")));

		b19.setToolTipText("Round Rectangle");
		b19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=19;
		
					setlabel();
				changecurser("roundrectCur.png");

			}
		});
		
		
		b20=new JButton(new ImageIcon(getClass().getResource("/resourses/filledcircle.png")));

		b20.setToolTipText("Filled Circle");
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=20;
		
					setlabel();
				changecurser("filledcircleCur.png");

			}
		});
		
		b24=new JButton(new ImageIcon(getClass().getResource("/resourses/rhoumbus.png")));

		b24.setToolTipText("rhoumbus");
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=24;
	
					setlabel();
				changecurser("rhoumbusCur.png");

			}
		});
		
		b22=new JButton(new ImageIcon(getClass().getResource("/resourses/scope.png")));

		b22.setToolTipText("Scope Symbol");
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=22;
		
					setlabel();
				changecurser("scopeCur.png");

			}
		});
		
		b23=new JButton(new ImageIcon(getClass().getResource("/resourses/join.png")));

		b23.setToolTipText("Fork and Join");
		b23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=23;
		
					setlabel();
				changecurser("scopeCur.png");

			}
		});
		
		b21=new JButton(new ImageIcon(getClass().getResource("/resourses/filleddoublecircle.png")));
//		b20.setOpaque(false);
//		b20.setContentAreaFilled(false);
//		b20.setBorderPainted(false);
		b21.setToolTipText("End state Circle");
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				key=21;
		
					setlabel();
				changecurser("doublefilledCur.png");

			}
		});
		
		 cb=new JCheckBox("Arrow");
		 cb.setOpaque(false);
		 cb.setContentAreaFilled(false);
		 cb.setBorderPainted(false);
		 cb.setForeground(Color.WHITE);
		 cb.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent e)
			 {
				 arrowCursor();
			 }
		 });
		
		 filling=new JCheckBox("Fill Shapes");
		 filling.setOpaque(false);
		 filling.setContentAreaFilled(false);
		 filling.setBorderPainted(false);
		 filling.setForeground(Color.WHITE);


		actualpanel.add(p1,BorderLayout.WEST);
		actualpanel.add(p2,BorderLayout.NORTH);
		
			
		if(!resize)
		{
		JPanel panel=new JPanel();
		c=new Color(194,194,185);
		panel.setBackground(c);
		ps.setPreferredSize(new Dimension(2480,3508));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(ps);
				
		sp=new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		actualpanel.add(sp,BorderLayout.CENTER);
	
		mainpanel.add(welcome,"1");
		mainpanel.add(actualpanel,"2");
		
		cl.show(mainpanel,"1");
		this.add(mainpanel);
		
		this.setVisible(true);
	
		}
	
		
		
	}// end of tryarraylist constructor

	
	public void cleararraylist()
	{

		 shapes.clear();
		 strokes.clear();
		 colors.clear();		
		 labels.clear();
		 tflabels.clear();
		 trackfill.clear();
		 labcolor.clear();
		 tflabcolor.clear();
		 delete.clear();
		 undodraw.clear();
		 undodrawshape.clear();
		trackaction.clear();
		 twoshapes.clear();
		 ispen.clear();
		 trackshapes.clear();
		 trackshapename.clear();
		
		 delshapes.clear();
		 delstrokes.clear();
		 delcolors.clear();					
		 dellabels.clear();
		 deltflabels.clear();
		 deltrackfill.clear();
		 dellabcolor.clear();
		deltflabcolor.clear();
		 delshapes2.clear();
		 delcolors2.clear();
		 delstrokes2.clear();
		 deltrackfill2.clear();
		 deltrackshapes.clear();
		 deltrackshapename.clear();

		
		 shapes2.clear();
		 colors2.clear();
		 strokes2.clear();
		 trackfill2.clear();
		
		
		ps.removeAll();
		clearpage=true;
		saved=false;
		opened=false;
		labtostr=false;
		repaint();
	}
	
	 public void arrowCursor()
	 {
		
		
		  if(key==5)
			 changecurser("dottedlineCur.png");
		 
		  if(key==3)
			 changecurser("lineCur.png");
		 
		  if(key==1)
			 changecurser("rectCur.png");
		 
		  if(key==2)
			 changecurser("ellipseCur.png");
		 
		  if(key==4)
			 changecurser("kiteCur.png");
		 
		  if(key==6)
			 changecurser("dotcircleCur.png");
		  
		  if(key==7)
				 changecurser("textCur.png");
		 
		  if( key==10 || key==11 )
			 changecurser("curser.png");
		 
			 
		  if(key==9)
			 changecurser("actorCur.png");
		 
		  if(key==12)
			 changecurser("doublecircleCur.png");
		 
		  if(key==14)
			 changecurser("eraser.png");
		 
		  if(key==15)
			 changecurser("triangleCur.png");
		 
		  if(key==16)
			 changecurser("doublerectCur.png");
		 
		  if(key==17)
			 changecurser("doublekiteCur.png");
		 
		  if(key==18)
			 changecurser("pencil.png");
		 
		  if(key==19)
			 changecurser("roundrectCur.png");
		 
		  if(key==20)
			 changecurser("filledcircleCur.png");
		
		  if(movingon)
			 changecurser("hand.png");
		 
		 if(!cb.isSelected() && key!=1 && key!=2  && key!=3 && key!=4 && key!=5 && key!=6 && key!=7 && key!=8 && key!=9 && key!=10 && key!=11 && key!=12 && key!=13 && key!=14 && key!=15 && key!=16 && key!=17 && key!=18 && key!=19 && key!=20)
		 {
			 changecurser("curser.png");
			
		 }
		
		 
		 if(cb.isSelected() && key==3)
			 changecurser("arrow.png");
		
		 if(cb.isSelected() && key==5)
			 changecurser("dotarrow.png");
	 } 

	
	public void resizeFunction()
	{
	
	
		actualpanel.remove(sp);
		JPanel panel=new JPanel();
		c=new Color(194,194,185);
		panel.setBackground(c);
		try {
				ps.setPreferredSize(new Dimension(Integer.parseInt(WID.getText()),Integer.parseInt(HEI.getText())));
			}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "enter valid size");
			
		}
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(ps);
				
		sp=new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		actualpanel.add(sp,BorderLayout.CENTER);

		
		mainpanel.add(actualpanel,"2");
		
		cl.show(mainpanel,"2");
	
		
	}//resizeFunction
	
	public void changecurser(String curname)
	{
			curimage=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resourses/"+curname));
			cur=Toolkit.getDefaultToolkit().createCustomCursor(curimage, po, "");
	
			ps.setCursor(cur);
			
		
	}//changecurser

	public static void setlabel()
	{
	
	if(tf!=null )
	{
		if( !tf.getText().equals("") )
		{
			String content=tf.getText();
	
		if(lableadded==false)
		{	
			
			tflab= new Label(content,Label.CENTER);
			Font f=tf.getFont();
			tflab.setFont(f.deriveFont(f.getStyle()| Font.BOLD));
			tflab.setAlignment(Label.CENTER);
			
		
			tflab.setForeground(colorname);
			tflabcolor.add(colorname);
			tflab.setBounds(tf.getBounds());
			
	
			ps.remove(tf);  //remove textfield
			tflabels.add(tflab); //add to arraylist
			tflabarray[tfi]=tflab;//add to array
			ps.add(tflab); //add to panel
			
		
			trackaction.add("draw");
			undodraw.add(2);
	
			ispen.add(0);
		

		lableadded=true;

			
			tflab.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e)
				{
					
					if(e.getButton()==MouseEvent.BUTTON3)		
					{
						if(set==false)
						{
						
							pm1.add(mii);
							set=true;
						}
						pm1.show(e.getComponent(), e.getX(), e.getY()+18);	//show popup menu on mouse right click
						tflab=tflabarray[tfi]; //save right ckicked element in lab
						
						for(int i=tflabels.size()-1 ; i>=0 ;i-- )
						{
							tflab1= tflabels.get(i);    //traverse lable array
							
							 comp=ps.getComponentAt(ps.getMousePosition());// find component at (x y) position
						
							if(comp==tflab1) //when  position component on screen == arraylist element 
							{
								
								labselected=false;
								tfselected=true;
								selected=false;
								break;
							}
						}
						
						
					}//if
					
				}//mouse clicked
				
			});//mouse listener
		
		}//if	
		}		
	
		else if( tf.getText().equals(""))
		{
		
			ps.remove(tf);
		
		}
	}//if
	}//setlabel 	

	
private class paintsurface extends JPanel  
{
	
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public paintsurface()    //constructor
	{
		
		
		this.setBackground(Color.WHITE);
		this.setOpaque(true);     //non-transparency
		this.setLayout(null);
		
		mi=new JMenuItem("Delete                  " , new ImageIcon(getClass().getResource("/resourses/delete.png")));
		mi.setBackground(Color.DARK_GRAY);
		mi.setForeground(Color.WHITE);
		mi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				arrowCursor();
		
				trackaction.add("delete");
				
				if( selected )
				{
			
					
						delshapes.add(shapes.get(j));
						int i=trackshapename.indexOf(shapes.get(j));
				
						shapes.remove(j);
						
						delcolors.add(colors.get(j));
						colors.remove(j);
		
						delstrokes.add(strokes.get(j));
						strokes.remove(j);
						
						deltrackfill.add(trackfill.get(j));
						trackfill.remove(j);
						
						deltrackshapes.add(trackshapes.get(i));
						trackshapes.remove(i);
						
						deltrackshapename.add(trackshapename.get(i));
						trackshapename.remove(i);
						delete.add(1);
					
					selected=false;
					repaint();
				}
				
				if(labselected )//when label is selected
				{
						dellabels.add(labels.get(i));
						dellabcolor.add(labcolor.get(i));
						labels.remove(i);
						remove(label);
						labselected=false;
						delete.add(2);
				
					
				}
				
				if( tfselected )
				{
					
			
					int i= tflabels.indexOf(tflab1);
				
					deltflabcolor.add(tflabcolor.get(i));
					deltflabels.add(tflabels.get(i));
					remove(tflab1);
					tflabels.remove(tflab1);
					tfselected=false;
					delete.add(3);
				}
				
				if(selected2)
					
				{
					try {
							s=shapes2.get(j);
							int no=shapes2.indexOf(s);
						
							if(no%2 !=0)
							{
									delshapes2.add(shapes2.get(j));
									int p=trackshapename.indexOf(shapes2.get(j));
									delshapes2.add(shapes2.get(j-1));
								
									shapes2.remove(j);
									shapes2.remove(j-1);
									
									deltrackfill2.add(trackfill2.get(j));
									deltrackfill2.add(trackfill2.get(j-1));
									
									trackfill2.remove(j);
									trackfill2.remove(j-1);
									
									delstrokes2.add(strokes2.get(j));
									delstrokes2.add(strokes2.get(j-1));
									
									strokes2.remove(j);
									strokes2.remove(j-1);
																	
									delcolors2.add(colors2.get(j));
									delcolors2.add(colors2.get(j-1));
									
									colors2.remove(j);
									colors2.remove(j-1);
									
									deltrackshapename.add(trackshapename.get(p));
									trackshapename.remove(p);
									
									deltrackshapename.add(trackshapename.get(p-1));
									trackshapename.remove(p-1);
									
									deltrackshapes.add(trackshapes.get(p));
									trackshapes.remove(p);
									
									deltrackshapes.add(trackshapes.get(p-1));
									trackshapes.remove(p-1);
									
									delete.add(4);
									
								selected2=false;
								repaint();
							}
							
							else if(no%2 ==0)
							{
								delshapes2.add(shapes2.get(j));
					
								delshapes2.add(shapes2.get(j+1));
								int q=trackshapename.indexOf(shapes2.get(j+1));
								
					
								
								shapes2.remove((j));
								shapes2.remove((j));
								
								
								deltrackfill2.add(trackfill2.get(j));
								deltrackfill2.add(trackfill2.get(j+1));
								
								trackfill2.remove(j);
								trackfill2.remove(j);
								
								delstrokes2.add(strokes2.get(j));
								delstrokes2.add(strokes2.get(j+1));
								
								strokes2.remove(j);
								strokes2.remove(j);
								
								delcolors2.add(colors2.get(j));
								delcolors2.add(colors2.get(j+1));
								
								colors2.remove(j);
								colors2.remove(j);
							
								deltrackshapename.add(trackshapename.get(q-1));
								trackshapename.remove(q-1);
								
								deltrackshapename.add(trackshapename.get(q-1));
								trackshapename.remove(q-1);
								
								deltrackshapes.add(trackshapes.get(q-1));
								trackshapes.remove(q-1);
								
								deltrackshapes.add(trackshapes.get(q-1));
								trackshapes.remove(q-1);
								
								delete.add(4);
								
								selected2=false;
								repaint();
							}
					}
					catch(Exception ee)
					{
					
						JOptionPane.showMessageDialog(null,"chooes inner shape");
					}
					
				}
				
				
			}
		}); //delete shape after clicking popup menu 
		
		
		miii=new JMenuItem("Move                    " , new ImageIcon(getClass().getResource("/resourses/hand.png")));
		miii.setBackground(Color.DARK_GRAY);
		miii.setForeground(Color.WHITE);
		miii.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				movingon=true;
				changecurser("hand.png");
			
			}//action performed
		});
		
		 mii=new JMenuItem("Edit Text                  ", new ImageIcon(getClass().getResource("/resourses/textbox .png")));
		 mii.setBackground(Color.DARK_GRAY);
		 mii.setForeground(Color.WHITE);
		mii.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				arrowCursor();
				
				tf=new JTextField();
				String text= tflab1.getText();
				tf.setColumns(15);
				Font f=tf.getFont();
				tf.setFont(f.deriveFont(f.getStyle()| Font.BOLD));
				tf.setText(text);
				tf.setBounds(tflab1.getBounds());
				
	
				remove(tflab1);
				add(tf);
				lableadded=false;
			}//action performed
			
		});		//action listener
		
		

		pm1=new JPopupMenu();
		pm1.add(mi);
		pm1.add(miii);
		set=false;
	
		
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				arrowCursor();
			}
			
			public void mouseDragged(MouseEvent e)
			{
		
				saved=false;
				currentx=e.getX();
				currenty=e.getY();
				
			
				calculate();
				  if(key==1)
				    {
				    	tfselected=false;
				    	selected=false;
				
				    	rectangle();
				    	trackaction.add("draw");
				     
				    }
				  
					if(key==2)
					{
						tfselected=false;
						selected=false;
				
						circle();
						trackaction.add("draw");
					
				    }
					
					if(key==3)
					{
						tfselected=false;
						selected=false;
				
				    	line();
				    	trackaction.add("draw");
				  
					}
					
					if(key==4)
					{	
						tfselected=false;
						selected=false;
				
						kite();
						trackaction.add("draw");
					
					
				    }
						
					if(key==5)
					{
						tfselected=false;
						selected=false;
				
						dottedLine();
						trackaction.add("draw");
				
				    }
					
					if(key==6)
					{
						tfselected=false;
						selected=false;
				
						dottedCircle();
						trackaction.add("draw");
					
				    
					}	
				  
					if(key==9)
					{
						tfselected=false;
						selected=false;
				
						actor();
						trackaction.add("draw");
					
					
				    }
					
					if(key==12)
					{
						tfselected=false;
						selected=false;
				
						doublecircle();
						trackaction.add("draw");
				
						
					}
					
					if(key==15)
					{
						tfselected=false;
						selected=false;
				
						triangle();
						trackaction.add("draw");
					
						
				    }
					

					if(key==16)
					{
						tfselected=false;
						selected=false;
				
						drectangle();
						trackaction.add("draw");
				
						
				    }
					

					if(key==17)
					{
						tfselected=false;
						selected=false;
				
						ddiamond();
						trackaction.add("draw");
					
					
				    }
			
					
				if(key==14)
				{
			
						setlabel();
					
					erasor();
					
				}
				
				if(key==18)
				{
			
						setlabel();
				
					pen();
				}
				
				if(key==19)
				{
			
						setlabel();
					
					tfselected=false;
					selected=false;
			
					roundrectangle();
					trackaction.add("draw");
					
					
				}
				
				
				if(key==20)
				{
		
						setlabel();
				
					tfselected=false;
					selected=false;
			
					filledcircle();
					trackaction.add("draw");
				
					
				}
				
				if(key==21)
				{
		
						setlabel();
				
					tfselected=false;
					selected=false;
			
					doublefilledcircle();
					trackaction.add("draw");
				
					
				}
				
				if(key==22 || key==23)
				{
		
						setlabel();
				
					tfselected=false;
					selected=false;
			
					join();
					trackaction.add("draw");
				
					
				}
			
				
				if(key==24)
				{
			
						setlabel();
				
					tfselected=false;
					selected=false;
					rhoumbus();
					trackaction.add("draw");
				
					
				}
				
				if(movingon==true)
				{
					key=100;
			
						
					if(labselected ==true)
					{
						comp=labels.get(i);
						comp.setLocation(oldx+(currentx-oldx) , oldy+(currenty-oldy));
					}
				
					else if(tfselected ==true)
					{
						int i= tflabels.indexOf(tflab1);
						comp=tflabels.get(i);
						comp.setLocation(oldx+(currentx-oldx) , oldy+(currenty-oldy));
					}
					
					
					else if(selected ==true)
					{
				
						s=shapes.get(j);
						shapes.remove(j);
						
						int index=trackshapename.indexOf(s);
					
						trackshapes.remove(index);
						trackshapename.remove(index);
					
									
						x=s.getBounds().x;
						y=s.getBounds().y;
						
						double xshare=currentx-x;
						double yshare=currenty-y;
						
						AffineTransform at= new AffineTransform();
						at.setToTranslation(xshare , yshare);
			
						Shape tshape = 	at.createTransformedShape(s);
					
						x=tshape.getBounds().x ;
						y=tshape.getBounds().y ;
						
						shapes.add(j, tshape);
						
						trackshapes.add(index , 1);
												
						trackshapename.add(index , tshape);
			
					}
					
					else if(selected2 ==true)
					{
						try {
												
								s=shapes2.get(j-1);
								shapes2.remove(j-1);
								
								int fill= trackfill2.get(j-1);
								trackfill2.remove(j-1);
								
								int index=trackshapename.indexOf(s);
									
				
								trackshapes.remove(index );
								trackshapename.remove(index );
				
								x=s.getBounds().x;
								y=s.getBounds().y;
								
								Shape s2=shapes2.get(j-1);
								shapes2.remove(j-1);
								int fill2= trackfill2.get(j-1);
								trackfill2.remove(j-1);
								
								
								int index2=trackshapename.indexOf(s2);
							
							
								trackshapes.remove(index2 );
								trackshapename.remove(index2 );
					
													
								double xshare=currentx-x;
								double yshare=currenty-y;
														
								AffineTransform at= new AffineTransform();
								at.setToTranslation(xshare , yshare);
					
								Shape tshape = 	at.createTransformedShape(s);
								Shape tshape2 = at.createTransformedShape(s2);
								
								
				
								shapes2.add(j-1 , tshape);
								shapes2.add(j-1 ,tshape2);
								
								trackshapes.add(index, 4);
								trackshapes.add(index2, 4);
								
								trackshapename.add(index, tshape);
								trackshapename.add(index2, tshape2);
							
								trackfill2.add(j-1 , fill);
								trackfill2.add(j-1 , fill2);
								
												
					
						}
						catch(Exception ee)
						{
						
							JOptionPane.showMessageDialog(null,"chooes inner shape");
						}
					}
					
				}//if movingon
				
				repaint();
				
			}
			
			
		});
		
		

		this.addMouseListener(new MouseAdapter() {
		
		
			
			public void mouseClicked(MouseEvent e)
			{
		
				saved=false;
				if(key==14)
				{
			
						setlabel();
					erasor();
					
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					key=100;
				
			
				if(e.getButton()==MouseEvent.BUTTON1 || e.getButton()==MouseEvent.BUTTON2 )	
				{
					
					setlabel();
				}
				
				clicked=new Point2D.Double(e.getX(),e.getY());
			
				for(i=shapes2.size()-1 ; i>=0 ;i--)
				{
					s=shapes2.get(i);
					c=colors2.get(i);
					
					if(s.contains(clicked))
					{
						
			
						if(e.getButton()==MouseEvent.BUTTON3)		
						{
							if(set==true)
							{
								pm1.remove(mii);
								set=false;
							}
							pm1.show(e.getComponent(), e.getX(), e.getY());	//show popup menu on mouse right click
					
							j=i;
							selected2=true;
							selected=false;
							labselected=false;
							tfselected=false;
						
						break;
						}
					}//if
					
				}// for loop for search double shapes
				
				
				for( i=shapes.size()-1 ; i>=0 ; i--)	//for deleting shapes
				{
					 s = shapes.get(i);
					 c = colors.get(i);
					 st = strokes.get(i);
					 trackf =trackfill.get(i);
					
					if(s.contains(clicked))
					{
						
			
						if(e.getButton()==MouseEvent.BUTTON3)		
						{
							if(set==true)
							{
								pm1.remove(mii);
								set=false;
							}
							pm1.show(e.getComponent(), e.getX(), e.getY());	//show popup menu on mouse right click
					
							j=i;
							selected=true;
							selected2=false;
							labselected=false;
							tfselected=false;
						
						break;
						}
					}//if
					
					
				}//for
			
					
			}//mouse clicked
			
			
			public void mousePressed(MouseEvent e) {
			
			
				oldx=e.getX();
				oldy= e.getY();
			
				count=1;
			
	
				
			}//mouse pressed
			
			public void mouseReleased(MouseEvent e) {
				
		
				if(movingon)
				{
				
					movingon=false;
					
				}
				arrowCursor();
				
				currentx=e.getX();
			    currenty= e.getY();
				
			    calculate();
			    
			    if(key==17 || key==16 ||key==12||key==21)
			    {
			    	undodraw.add(1);
			 
			    	ispen.add(0);
			    }
			    
			    if(key==1||key==2||key==4||key==6||key==9||key==15||key==20||key==19||key==22||key==23||key==24)
			    {
			    	undodraw.add(1);
			
			    	ispen.add(0);
			    }
			    if(key==18||key==14)
			    {
			    	undodraw.add(1);
			 
			    	ispen.add(5);
			    	
			
			    }
			 
			    if(key==3  || key==5)
			    {
			    	undodraw.add(1);
			
			    	ispen.add(0);
			    	if(cb.isSelected())
					{
						arrow();
						arrowCursor();
			
						ispen.remove(ispen.size()-1);
						ispen.add(0);
						cb.setSelected(false);
					}
			    }
		
			    
				if(key==7)
				{
					selected=false;
					tfselected=true;
					
					tf=new JTextField();
					Font f=tf.getFont();
					tf.setFont(f.deriveFont(f.getStyle()| Font.BOLD));
					tf.setHorizontalAlignment(JTextField.CENTER);
		
					tf.setForeground(colorname);
					tf.setBounds(x,y,width,20);
					
					add(tf);//add to panel
					key=0;			
					lableadded=false;
			
										
				}	//key ==7
					
		
				if(key==10)
				{
					tfselected=false;
					selected=false;
			
				
					
					l=new Label("<<include>>");
					l.setForeground(colorname);
					l.setBounds(oldx,oldy,85,20);
			
				

					if(e.getButton()==MouseEvent.BUTTON1)//for deleting <<exclude>>  lable
					{
						labcolor.add(colorname);
						add(l);//add to panel
						trackaction.add("draw");
						undodraw.add(3);
				
						ispen.add(0);
					
						labarray[li]=l;  //add to array
						labels.add(labarray[li]); //add to arraylist
						
						labarray[li].addMouseListener(new MouseAdapter() {
							
							public void mouseClicked(MouseEvent e)
							{
								if(e.getButton()==MouseEvent.BUTTON3)		
								{
									if(set==true)
									{
										pm1.remove(mii);
									
										set=false;
									}
									pm1.show(e.getComponent(), e.getX(), e.getY()+18);	//show popup menu on mouse right click
									lab=labarray[li]; //save right ckicked element in lab
									
									
									for(i=labels.size()-1 ; i>=0 ;i-- )
									{
										label= labels.get(i);    //traverse lable array
										
										 comp=getComponentAt(getMousePosition());// find component at (x y) position
									
										if(comp==label) //when  position component on screen == arraylist element 
										{
											labselected=true;
											tfselected=false;
											selected=false;
									
											break;
										}
									}
									
								}
							}	
							
						});
						li++;
				}
					
				}
				
				if(key==11)
				{
					tfselected=false;
					selected=false;
				
			
					
					l=new Label("<<extend>>");
					l.setForeground(colorname);
					l.setBounds(oldx,oldy,85,20);
				
					

					if(e.getButton()==MouseEvent.BUTTON1)//for deleting <<exclude>>  lable
					{
						labcolor.add(colorname);
						add(l);//add to panel
						trackaction.add("draw");
						undodraw.add(3);
				
						ispen.add(0);
					
						labarray[li]=l;  //add to array
						labels.add(labarray[li]); //add to arraylist
						
						labarray[li].addMouseListener(new MouseAdapter() {
							
							public void mouseClicked(MouseEvent e)
							{
								if(e.getButton()==MouseEvent.BUTTON3)		
								{
									if(set==true)
									{
										pm1.remove(mii);
										set=false;
									}
									pm1.show(e.getComponent(), e.getX(), e.getY()+18);	//show popup menu on mouse right click
									lab=labarray[li]; //save right ckicked element in lab
									
									
									for(i=labels.size()-1 ; i>=0 ;i-- )
									{
										label= labels.get(i);    //traverse lable array
										
										 comp=getComponentAt(getMousePosition());// find component at (x y) position
									
										if(comp==label) //when  position component on screen == arraylist element 
										{
											labselected=true;
											tfselected=false;
											selected=false;
									
											break;
										}
									}
									
								}
							}	
							
						});
						li++;
				}
			  
			    
				}
				
		
				repaint();

			}//mouse released
		});//mouse listener
				
		
	}//end of constructor (panel)

	 public void filledcircle()
	 {
			s=new  Ellipse2D.Float(x,y,width,h);
			removePrevious();
			shapes.add(s);
			strokes.add(str1);
			colors.add(colorname);
			trackfill.add(1);
			twoshapes.add(false);
			trackshapes.add(1);
			trackshapename.add(s);
	
	 }//filled circle
	 
	 public void roundrectangle()
	 {
			s=new  RoundRectangle2D.Double(x,y,width,h,40,40);
			removePrevious();
			shapes.add(s);
			strokes.add(str1);
			colors.add(colorname);
			if(filling.isSelected())
				trackfill.add(1);
			else
				trackfill.add(0);
			twoshapes.add(false);
			trackshapes.add(1);
			trackshapename.add(s);
		
	 }//roundrectangle
	 
	public void  arrow()
	{
			
		path=new GeneralPath();

		
		double D=Math.sqrt(((currentx-oldx)*(currentx-oldx))+((currenty-oldy)*(currenty-oldy)));  //length of line

		double xe= currentx-(9*(currentx-oldx)/D);
		double ye= currenty-(9*(currenty-oldy)/D);
	
		path.moveTo(xe, ye);
		
		xe=currentx-xe;
		ye=currenty-ye;
				
		double matx=((Math.cos((150*Math.PI)/180)*xe ) + (-Math.sin((150*Math.PI)/180)*ye));
		double maty=((Math.sin((150*Math.PI)/180)*xe ) + (Math.cos((150*Math.PI)/180)*ye));
		
		matx=currentx+matx;
		maty=currenty+maty;
		
		path.lineTo(matx, maty);
		path.lineTo(currentx, currenty);
		
		matx=((Math.cos((-150*Math.PI)/180)*xe ) + (-Math.sin((-150*Math.PI)/180)*ye));
		maty=((Math.sin((-150*Math.PI)/180)*xe ) + (Math.cos((-150*Math.PI)/180)*ye));
		
		matx=currentx+matx;
		maty=currenty+maty;

	//	count++;
		
		path.lineTo(matx, maty);
		path.closePath();
	
	
		shapes2.add(shapes.get(shapes.size()-1));
		strokes2.add(strokes.get(strokes.size()-1));
		colors2.add(colorname);
		trackfill2.add(0);
		trackshapes.add(4);
		trackshapename.add(shapes.get(shapes.size()-1));
		
		undodraw.remove(undodraw.size()-1);
		undodraw.add(1);

		shapes.remove((shapes.size()-1));
		strokes.remove((strokes.size()-1));
		colors.remove((colors.size()-1));
		trackfill.remove(trackfill.size()-1);
		trackshapes.remove((trackshapes.size()-2));
		trackshapename.remove((trackshapename.size()-2));
		
		shapes2.add(path);
		strokes2.add(str1);
		colors2.add(colorname);
		trackfill2.add(1);
		twoshapesbool=true;
		twoshapes.add(true);
		

		trackshapes.add(4);
		trackshapename.add(path);
	}//line	

	public void pen()
	{
		s=new Line2D.Float(oldx, oldy, currentx, currenty);
		shapes.add(s);
		oldx=currentx;
		oldy=currenty;
		strokes.add(str1);
		colors.add(colorname);
		trackfill.add(0);
		twoshapes.add(false);
		ispen.add(1);
		trackshapes.add(1);
		trackshapename.add(s);
	}//pen

	public void erasor()
	{
	
		
		s=new  Rectangle2D.Float(currentx,currenty,24,24);
		shapes.add(s);
		strokes.add(str1);
		colors.add(Color.WHITE);
		trackfill.add(1);
		twoshapes.add(false);
		ispen.add(1);
		trackshapes.add(1);
		trackshapename.add(s);
	}//eresor
	
	
	public void ddiamond()
	{
		ax=x;
		ay=(Math.abs(max/2))+y;
		bx=Math.abs(max/2)+x;
		by=y;
		cx=ax+max;
		cy=ay;
		dx=bx;
		dy=by+max;
		twoshapesbool=true;
	
		
		path=new GeneralPath();
		path.moveTo(ax, ay);
		path.lineTo(bx, by);
		path.lineTo(cx, cy);
		path.lineTo(dx, dy);
		path.lineTo(ax, ay);
		
		count++;
		shapes2.add(path);
		colors2.add(colorname);
		twoshapes.add(true);
		strokes2.add(str1);
		trackfill2.add(0);
		trackshapes.add(4);
		trackshapename.add(path);
		
		path=new GeneralPath();
		path.moveTo(ax+5, ay);
		path.lineTo(bx, by+5);
		path.lineTo(cx-5, cy);
		path.lineTo(dx, dy-5);
		path.lineTo(ax+5, ay);
		
		removePrevious2();
		
		shapes2.add(path);
		colors2.add(colorname);
		
		if(filling.isSelected())
			trackfill2.add(1);
		else
			trackfill2.add(0);

		strokes2.add(str1);
		trackshapes.add(4);
		trackshapename.add(path);
	
	}//ddiamond
	
	
	public void drectangle()
	{

		s=new Rectangle2D.Float(x,y,width,h);
		count++;
		shapes2.add(s);
		colors2.add(colorname);
		strokes2.add(str1);
		trackfill2.add(0);
		trackshapes.add(4);	
		trackshapename.add(s);

		s=new Rectangle2D.Float(x+4,y+4,width-8,h-8);

		removePrevious2();

		shapes2.add(s);
		strokes2.add(str1);
		colors2.add(colorname);
		if(filling.isSelected())
			trackfill2.add(1);
		else
			trackfill2.add(0);

		twoshapes.add(true);
		twoshapesbool=true;
		trackshapes.add(4);
		trackshapename.add(s);
	}//drectangle
	
	public void doublecircle()
	{
		s=new Ellipse2D.Float(x, y, width ,h);
		count++;
		shapes2.add(s);
		strokes2.add(str1);
		colors2.add(colorname);
		trackfill2.add(0);
		trackshapes.add(4);
		trackshapename.add(s);
	
		s=new Ellipse2D.Float(x+4, y+4, width-8 ,h-8);
		removePrevious2();
		shapes2.add(s);
		strokes2.add(str1);
		colors2.add(colorname);
		if(filling.isSelected())
			trackfill2.add(1);
		else
			trackfill2.add(0);
		
		twoshapesbool=true;
		twoshapes.add(true);
		trackshapes.add(4);
		trackshapename.add(s);
	}//doublecircle
	
	public void doublefilledcircle()
	{
		s=new Ellipse2D.Float(x, y, width ,h);
		count++;
		shapes2.add(s);
		strokes2.add(str1);
		colors2.add(colorname);
		trackfill2.add(0);
		trackshapes.add(4);
		trackshapename.add(s);
	
		s=new Ellipse2D.Float(x+6, y+6, width-12 ,h-12);
		removePrevious2();
		shapes2.add(s);
		strokes2.add(str1);
		colors2.add(colorname);
		trackfill2.add(1);
		twoshapesbool=true;
		twoshapes.add(true);
		trackshapes.add(4);
		trackshapename.add(s);
	}//doublefilledcircle
	
	public void triangle()
	{

		path=new GeneralPath();
		
		path.moveTo(x , y+max);
		path.lineTo(x+max , y+max);
		path.lineTo(x+max/2, y);
		path.closePath();
		removePrevious();	
	
		shapes.add(path);
		strokes.add(str1);
		colors.add(colorname);
		if(filling.isSelected())
			trackfill.add(1);
		else
			trackfill.add(0);
	
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(path);
	}//end of triangle
	
	public void calculate()
	{
		x=Math.min(oldx,currentx);
		y=Math.min(oldy,currenty);
		
		width=Math.abs(oldx-currentx);
		height=Math.abs(oldy-currenty);
		
		
		h=height-(height/25);
		
		max=Math.max(height, width);
		min=Math.min(height, width);
		
		tx2=oldx;
		ty2=oldy+max;
		tx1=currentx;
		ty1=currenty-max;
		
	}//calculate
	
	public void actor()
	{
		
		//DRAW ACTOR
		
				//HEAD (CIRCLE)
		
				
				double radius=(max/3)/2;
				double a=((360*Math.PI)/180)/100;
				double ang=a;
				double xx,yy;
				
				yy=y+(max/3);
				xx=x+(max/2);
				
				double oldxx=xx , oldyy=yy;
				
				path=new GeneralPath();
				
	
				for(int i=0 ; i<100 ; i++)
				{
				
					xx=oldxx+Math.cos(a)*radius;
					yy=oldyy+Math.sin(a)*radius;
		
					if(i==0)
					{
						//rotate 90 degree because  
						a=(90*Math.PI)/180;
						xx=oldxx+Math.cos(a)*radius;
						yy=oldyy+Math.sin(a)*radius;
			
						path.moveTo(xx,yy);
						
					}
					
					else
						path.lineTo(xx,yy);
					
					a=a+ang;
				}//head is drawn
				
			
				double endbodyy=yy+(max/3);
				path.lineTo(xx, endbodyy);//end of body
				
				path.lineTo( xx-max/3, endbodyy+(max/3) );//end of left leg
					
				path.lineTo(xx, endbodyy);//back to end of body 
			
				path.lineTo(xx+max/3, endbodyy+(max/3));//end of right leg
				
				path.lineTo(xx, endbodyy);//back to end of body
				
				double mby=(yy+endbodyy)/2;//find middle of body
				
				path.lineTo(xx, mby);//go to middle of body
				
				path.lineTo(xx-max/3, mby);//left hand
				
				path.lineTo(xx+max/3 , mby);//right hand
			
		
				
				removePrevious();
				
				shapes.add(path);
				trackfill.add(0);	
				strokes.add(str5);
				colors.add(colorname);
				twoshapes.add(false);
				trackshapes.add(1);
				trackshapename.add(path);
		
		
	}//actor
	
	public void dottedCircle()
	{
		s=new Ellipse2D.Float(x, y, width ,height);
		removePrevious();
		shapes.add(s);
		strokes.add(str2);
		trackfill.add(0);

		colors.add(colorname);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(s);

	}//dotted circle
	
	public void dottedLine()
	{

		s=new Line2D.Float(oldx, oldy, currentx, currenty);
		removePrevious();
		shapes.add(s);
		strokes.add(str2);
		colors.add(colorname);
		trackfill.add(0);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(s);
	}//dottedline
	
	public void line()
	{

		s=new Line2D.Float(oldx, oldy, currentx, currenty);
		removePrevious();
		shapes.add(s);
		strokes.add(str1);
		colors.add(colorname);
		trackfill.add(0);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(s);
	}//line
	
	
	public void join()
	{
	
		s=new Line2D.Float(oldx, oldy, currentx, currenty);
		removePrevious();
		shapes.add(s);
		if(key==22)
			strokes.add(str3);
		if(key==23)
			strokes.add(str4);
		colors.add(colorname);
		trackfill.add(0);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(s);
	}//line
	
	public void kite()
	{	

		ax=x;
		ay=(Math.abs(max/2))+y;
		bx=Math.abs(max/2)+x;
		by=y;
		cx=ax+max;
		cy=ay;
		dx=bx;
		dy=by+max;
		
		
		path=new GeneralPath();
		path.moveTo(ax, ay);
		path.lineTo(bx, by);
		path.lineTo(cx, cy);
		path.lineTo(dx, dy);
		path.lineTo(ax, ay);
		
		removePrevious();
		shapes.add(path);
		strokes.add(str1);

		if(filling.isSelected())
			trackfill.add(1);
		else
			trackfill.add(0);
		colors.add(colorname);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(path);
	
		
	}//kite
	
	public void rectangle()
	{

		s=new Rectangle2D.Float(x,y,width,h);
		removePrevious();
		shapes.add(s);
		strokes.add(str1);

		if(filling.isSelected())
			trackfill.add(1);
		else
			trackfill.add(0);
		colors.add(colorname);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(s);
	
		
	}//rectangle
	
	public void rhoumbus()
	{
	
		path=new GeneralPath();
	
		path.moveTo(x ,y+h);
		path.lineTo(x+(width/3) , y);
		path.lineTo(x+width , y);
		path.lineTo(x+(width-(width/3)) , y+h);
		path.closePath();
		removePrevious();	
	
		shapes.add(path);
		strokes.add(str1);
		colors.add(colorname);
		if(filling.isSelected())
			trackfill.add(1);
		else
			trackfill.add(0);

		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(path);
		
	}//rectangle
	
	public void circle()
	{
	
		s=new Ellipse2D.Float(x,y,width,h);
		removePrevious();
		shapes.add(s);

		if(filling.isSelected())
			trackfill.add(1);
		else
			trackfill.add(0);
		strokes.add(str1);
		colors.add(colorname);
		twoshapes.add(false);
		trackshapes.add(1);
		trackshapename.add(s);
	

	}//circle
	
	public void removePrevious()
	{
		if(count>1)
		{
			shapes.remove(shapes.size()-1);
			strokes.remove(strokes.size()-1);
			trackfill.remove(trackfill.size()-1);
			colors.remove(colors.size()-1);
			trackshapes.remove(trackshapes.size()-1);
			trackshapename.remove(trackshapename.size()-1);
		}
		count++;
		
	}//removePrevious
	
	
	public void removePrevious2()
	{
		if(count>2)
		{
			shapes2.remove(shapes2.size()-2);
			shapes2.remove(shapes2.size()-2);
			
			strokes2.remove(strokes2.size()-2);
			strokes2.remove(strokes2.size()-2);
			
			trackfill2.remove(trackfill2.size()-1);
			trackfill2.remove(trackfill2.size()-1);
		
			colors2.remove(colors2.size()-2);
			colors2.remove(colors2.size()-2);
			
			trackshapes.remove(trackshapes.size()-2);
			trackshapes.remove(trackshapes.size()-2);
			
			trackshapename.remove(trackshapename.size()-2);
			trackshapename.remove(trackshapename.size()-2);
		}
		count++;
		
	}//removePrevious
	
	public void paintComponent(Graphics g)
	{
				
		super.paintComponent(g);
		
			Graphics2D g2 = (Graphics2D)g;
			
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);

		if(opened==true)
		{
			g2.drawImage(img, 0,0,null);
		}//if
		



	
		int index;
		
		for(int i=0; i<trackshapes.size() ; i++)
		{	
	
			if(trackshapes.get(i)==4)
			{
	
				Shape sh=trackshapename.get(i);
				index=shapes2.indexOf(sh);
				
	
				int count=0;
				
				while(count<=1)
				{
																//shape2
					g2.setStroke(strokes2.get(index));
					g2.setColor(colors2.get(index));
					if(trackfill2.get(index)==0)
						g2.draw(shapes2.get(index));
					else
						g2.fill(shapes2.get(index));
					
				count++;
		
			
				}
			
				
	
			}
			
	
			else if(trackshapes.get(i)==1)
			{
		
				Shape s= trackshapename.get(i);
				index=shapes.indexOf(s);
				 

		
			if(trackfill.get(index)==1)
				{												//shape1
					g2.setColor(colors.get(index));
					g2.setStroke(strokes.get(index));
					g2.fill(shapes.get(index));
					
				
					
				
				}//if 1
			else if(trackfill.get(index)==0)
				{
					if(shapes.size()>0)					//shape1
					{
						g2.setColor(colors.get(index));
						g2.setStroke(strokes.get(index));
						g2.draw(shapes.get(index));
						
									
					}
				}//if 2
			
	
			}//else
	
			
		}//for


		if(labtostr==true)
		{
			for(int ii=labels.size()-1 ; ii>=0 ; ii--)
			{
				Label l= labels.get(ii);
				String str= l.getText();
				
				g2.setColor(labcolor.get(ii));
				g2.drawString(str, l.getX(), l.getY()+15);
				repaint();
				remove(l);
				repaint();

			}//for2
		
			for(int ii=tflabels.size()-1 ; ii>=0;  ii--)
			{
				Label l= tflabels.get(ii);
				String str= l.getText();
				
				Font f=tf.getFont();
				g2.setFont(f.deriveFont(f.getStyle()| Font.BOLD));
				g2.setColor(tflabcolor.get(ii));
				g2.drawString(str, l.getX()+(l.getWidth()/5), l.getY()+15);
				remove(l);
				repaint();

			}//for3
		
			
		}//if 3 

	}//end of paint

	
	public void confirmsaved()
	{
		if(!saved)
		{
			 op =JOptionPane.showConfirmDialog(null, "Current File not saved. Do you want to Save ? ");
			if(op==JOptionPane.YES_OPTION)
			{
				labletostring();
				if(fname==null)
				{
					
					open=new JFileChooser();
					
					open.addChoosableFileFilter(new FileNameExtensionFilter("png","jpg"));	
							 
							open.showSaveDialog(null);
							file = open.getSelectedFile();
							
												
							try {
									fname=file.getPath().toString();
									labletostring();
									save();
								}
							catch(Exception eee) 
							{
								JOptionPane.showMessageDialog(null, "No file choosen");
							}
				}//if	
		
			}
			
		
		
			if(op==JOptionPane.NO_OPTION)
			{
			
				cleararraylist();
				saved=false;
			}
		}
	}//confirmsaved
	
	
	public void labletostring()
	{
		labtostr=true;
		repaint();
	
	}//labletostring
	
	
	public void save()
	{
		
		BufferedImage image=new BufferedImage(getWidth(), getHeight() , BufferedImage.TYPE_INT_ARGB);
		Graphics g=image.getGraphics();
		paint(g);
		
		try 
		{
			ImageIO.write(image , "png" ,new File(fname));
		
			saved=true;
			JOptionPane.showMessageDialog(null, "File saved Succesfully !");
		}	
		catch(Exception e)
		{
	
			JOptionPane.showMessageDialog(null, "can not save Image");
		}
	}//save
	
	public void open()
	{
			open=new JFileChooser();
			open.addChoosableFileFilter(new FileNameExtensionFilter("png","jpg"));	
			 try
				{
				
					open.showOpenDialog(null);
					file = open.getSelectedFile();
					
				
					
					try {
							fname=file.getPath().toString();
					
						}
					catch(Exception eee) 
					{
						JOptionPane.showMessageDialog(null, "No file choosen");
					}
					
						Desktop desktop = Desktop.getDesktop();
						if(desktop.isSupported(Desktop.Action.OPEN)&& (fname!=null))
						{	
							
					
							cleararraylist();
							img = ImageIO.read(new File(fname));
							
								
						
							saved=false;
							opened=true;
					
							repaint();
							
						}
						
					
				}//try
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, "can not open file");
			
				}//catch
	
	}//open
	

	
}//end of panel

}//end of frame

