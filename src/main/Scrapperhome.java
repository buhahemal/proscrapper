package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class Scrapperhome extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pre= null;
    ResultSet res = null;
    static int ex;
    Date d;
    SimpleDateFormat dd;
    static String to;
    static String from ;
    static String text ;
    Scrapdata Scrp=new Scrapdata();
    get_Teams Team_data=new get_Teams();
    
    public Scrapperhome() {
    	setType(Type.POPUP);
    	try {
    		System.out.println(User_login.Username.getText());
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
        setIconImage(Toolkit.getDefaultToolkit().getImage(Scrapperhome.class.getResource("/img/Untitled.png")));
        initComponents();
        con=Connect.connect();
        showDate();
        buttonvis();
      //  login_as();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	searchbar = new javax.swing.JTextField();
    	searchbar.setText(" Search");
        Main = new javax.swing.JPanel();
        HeadingMenu = new javax.swing.JPanel();
        hm_time = new javax.swing.JLabel();
        hm_today = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        Login_Name = new javax.swing.JLabel();
        Userid = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();
        msgAlertDialog = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnCancle = new javax.swing.JButton();
        setting = new javax.swing.JButton();
        logindetails = new javax.swing.JButton();
        logindetails.setToolTipText("Logged in Details");
        changepass = new javax.swing.JButton();
        changepass.setToolTipText("User Password Change");
        Report = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        logout.setToolTipText("Logout");
        Team = new javax.swing.JButton();
        Player = new javax.swing.JButton();
        Grounds = new javax.swing.JButton();

        Team_name = new javax.swing.JLabel();
        bg_img = new javax.swing.JLabel();
        bg_img.setBackground(Color.WHITE);
        bg_img.setForeground(Color.BLACK);
        Menubar_clg = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProScrapper");
        setPreferredSize(new java.awt.Dimension((int)dim.getWidth(),(int) dim.getHeight()));
        setResizable(false);

        Main.setBackground(new java.awt.Color(51, 51, 51));
        Main.setLayout(null);

        HeadingMenu.setBackground(new java.awt.Color(102, 102, 102));

        hm_time.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        hm_time.setText("Time");

        hm_today.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        hm_today.setText("Today");

        time.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        time.setForeground(SystemColor.desktop);
        time.setText("00:00:00");

        today.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        today.setForeground(SystemColor.desktop);
        today.setText("00-00-0000");

        Logout.setBackground(new java.awt.Color(0, 0, 0));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Apps-session-logout-icon.png"))); // NOI18N
        Logout.setToolTipText("Logout");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

       
        Login_Name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Login_Name.setText("Login As : Hemal Buha");

       // ImageIcon icon = new ImageIcon("img/truepn.png");
        Refresh.setBackground(new java.awt.Color(0, 0, 0));
        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/courses-icon-10.png"))); // NOI18N
        Refresh.setToolTipText("Refresh Data");
        Refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrapsite(evt);
            }

			
			private void scrapsite(ActionEvent evt) {
				//Scrapdata.Gettitle();
				try {
					Scrp.Refreshpage();
					JOptionPane.showMessageDialog(null,"Cache Page updated Successfully","Success Operation",JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,e.getStackTrace()+"Note :\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}

			
        }); Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY);
        
        JLabel Hm_heading_1 = new JLabel();
        Hm_heading_1.setText("Proscrapper");
        Hm_heading_1.setHorizontalAlignment(SwingConstants.CENTER);
        Hm_heading_1.setFont(new Font("Tahoma", Font.BOLD, 24));

      
        javax.swing.GroupLayout gl_HeadingMenu = new javax.swing.GroupLayout(HeadingMenu);
        gl_HeadingMenu.setHorizontalGroup(
        	gl_HeadingMenu.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_HeadingMenu.createSequentialGroup()
        			.addGap(10)
        			.addComponent(Logout, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(Refresh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(57)
        			.addComponent(Login_Name, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.LEADING)
        				.addComponent(username, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Userid, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
        			.addGap(61)
        			.addComponent(Hm_heading_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
        			.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_HeadingMenu.createSequentialGroup()
        					.addComponent(time, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        					.addGap(80))
        				.addGroup(gl_HeadingMenu.createSequentialGroup()
        					.addComponent(hm_time, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        					.addGap(130)))
        			.addGap(10)
        			.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_HeadingMenu.createSequentialGroup()
        					.addComponent(hm_today)
        					.addGap(53))
        				.addComponent(today, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
        );
        gl_HeadingMenu.setVerticalGroup(
        	gl_HeadingMenu.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_HeadingMenu.createSequentialGroup()
        			.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_HeadingMenu.createSequentialGroup()
        					.addGap(20)
        					.addComponent(Login_Name))
        				.addGroup(gl_HeadingMenu.createSequentialGroup()
        					.addGap(10)
        					.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.BASELINE)
        						.addComponent(hm_today)
        						.addComponent(hm_time))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.BASELINE)
        						.addComponent(time)
        						.addComponent(today)))
        				.addGroup(gl_HeadingMenu.createSequentialGroup()
        					.addGap(20)
        					.addGroup(gl_HeadingMenu.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(gl_HeadingMenu.createSequentialGroup()
        							.addComponent(username)
        							.addGap(15)
        							.addComponent(Userid))
        						.addComponent(Logout, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        						.addComponent(Refresh, 0, 0, Short.MAX_VALUE)
        						.addComponent(Hm_heading_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeadingMenu.setLayout(gl_HeadingMenu);

        Main.add(HeadingMenu);
        HeadingMenu.setBounds(0, 0, 1225, 80);

        msgAlertDialog.setBackground(new java.awt.Color(0, 255, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("You have new Message(s)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

       
        btnCancle.setText("Cancel");

       
         // NOI18N
        
        searchbar.setFont(new java.awt.Font("Tahoma", 1, 12));
    	searchbar.setBackground(Color.WHITE);
    	searchbar.setToolTipText("Type Search Word");
        searchbar.setForeground(Color.GRAY);
        searchbar.setBorder(new LineBorder(null, 1, true));
        searchbar.addFocusListener(new FocusAdapter() {
   		 @Override
   		    public void focusGained(FocusEvent e) {
   		        if (searchbar.getText().equals("")) {
   		        	searchbar.setText("");
   		        	searchbar.setForeground(Color.BLACK);
   		        }
   		    }
   		    @Override
   		    public void focusLost(FocusEvent e) {
   		        if (searchbar.getText().isEmpty()) {
   		        	searchbar.setForeground(Color.GRAY);
   		        	searchbar.setText("Search");
   		        }
   		    }
   	});
        Main.add(searchbar);
        searchbar.setBounds(424, 103, 299, 34);
      
        setting.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        setting.setForeground(new java.awt.Color(0, 51, 51));
        setting.setText("Setting");
        setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingActionPerformed(evt);
            }
        });
        Main.add(setting);
        setting.setBounds(1049, 102, 141, 34);
        
        Report.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Report.setForeground(new java.awt.Color(0, 51, 51));
        Report.setText("Report");
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }

			private void ReportActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Report();
			}
        });
        Main.add(Report);
        Report.setBounds(45, 102, 118, 34);
        
        Team.setBounds(45, 150, 118, 31);
        Team.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Team.setText("Team");
        Team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetCategory(evt);
            }

            private void GetCategory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logindetailsActionPerformed

            	Team_data.get_Teams();
            	new team_gui_data().setVisible(true);
            	
            }//GEN-LAST:event_logindetailsActionPerformed
           
        });
        Main.add(Team);
        
        Player.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Player.setText("Player");
        Player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //logindetailsActionPerformed(evt);
            }

            private void logindetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logindetailsActionPerformed
                //new Login_Details().setVisible(true);
            }//GEN-LAST:event_logindetailsActionPerformed
           
        });
        Main.add(Player);
        Player.setBounds(45, 190, 118, 31);
        
        Grounds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Grounds.setText("Grouds");
        Grounds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        Main.add(Grounds);
        Grounds.setBounds(45, 230, 118, 31);
      
        
        logindetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logindetails.setText("Login Details");
        logindetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logindetailsActionPerformed(evt);
            }

            private void logindetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logindetailsActionPerformed
                new Login_Details().setVisible(true);
            }//GEN-LAST:event_logindetailsActionPerformed
           
        });
        Main.add(logindetails);
        logindetails.setBounds(1049, 150, 141, 31);

        changepass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changepass.setText("Change Password");
        changepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepassActionPerformed(evt);
            }
        });
        Main.add(changepass);
        changepass.setBounds(1049, 190, 141, 31);



        logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        Main.add(logout);
        logout.setBounds(1049, 230, 141, 31);
      
      

        Team_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Team_name.setText("Hemal / Akshit / Manish / Milan");
        Main.add(Team_name);
        Team_name.setBounds(424, 562, 316, 22);

   
        bg_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homebgimg.jpg"))); // NOI18N
        Main.add(bg_img);
        bg_img.setBounds(-147, 74, 1372, 521);

        jMenu1.setText("Ajeenkya D.Y. Patil University - Pune / Batch 2019-2020 ");
        Menubar_clg.add(jMenu1);

        setJMenuBar(Menubar_clg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );

      //  setSize(new java.awt.Dimension((int)dim.getWidth(),(int) dim.getHeight()));
        setSize(new java.awt.Dimension(1231, 646));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
   
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
        new User_login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed
    
    
     private void changepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepassActionPerformed
        new Change_Password().setVisible(true);
    }//GEN-LAST:event_changepassActionPerformed
    
    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed
        setting();
    }//GEN-LAST:event_settingActionPerformed
    
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new User_login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
       /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scrapperhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scrapperhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scrapperhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scrapperhome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Scrapperhome().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
 
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton changepass;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Team;
    private javax.swing.JButton Player;
    private javax.swing.JButton Grounds;
    private javax.swing.JButton logindetails;
    private javax.swing.JButton logout;
    private javax.swing.JButton setting;
    private javax.swing.JButton Report;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel bg_img;
    private javax.swing.JLabel hm_time;
    private javax.swing.JLabel hm_today;
    private javax.swing.JLabel Login_Name;
    private javax.swing.JLabel Team_name;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar Menubar_clg;
    private javax.swing.JPanel Main;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel HeadingMenu;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel msgAlertDialog;
    public static javax.swing.JLabel time;
    public static javax.swing.JLabel today;
    private javax.swing.JLabel username;
    public static javax.swing.JLabel Userid;
    // End of variables declaration//GEN-END:variables
    private void showDate(){
        d = new Date();
        dd = new SimpleDateFormat("dd-MM-yyyy");
        today.setText(dd.format(d));
        
        new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat dd = new SimpleDateFormat("hh:mm:ss a");
                time.setText(dd.format(d));
            }
        }).start();
    }
    private void buttonvis(){
        logindetails.setVisible(false);
        changepass.setVisible(false);
        logout.setVisible(false);
        Team.setVisible(false);
        Player.setVisible(false);
        Grounds.setVisible(false);
    }  
    private void setting(){
        setting.setEnabled(false);
        Report.setEnabled(true);
        logindetails.setVisible(true);
        changepass.setVisible(true);
        logout.setVisible(true);
        Team.setVisible(false);
        Player.setVisible(false);
        Grounds.setVisible(false);
    }
    private void Report(){
        Report.setEnabled(false);       
        setting.setEnabled(true);
        Team.setVisible(true);
        Player.setVisible(true);
        Grounds.setVisible(true);
        logindetails.setVisible(false);
        changepass.setVisible(false);
        logout.setVisible(false);
    }
}