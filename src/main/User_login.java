package main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;

public class User_login extends javax.swing.JFrame {

	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	static String NAME;

	public static Integer Userid = 0;
	public static javax.swing.JTextField Username;
	private javax.swing.JButton Login_btn;
	private javax.swing.JButton exit_btn;
	private javax.swing.JLabel Login_heading_label;
	private javax.swing.JLabel Side_image;
	private javax.swing.JLabel User_name;
	private javax.swing.JLabel User_password;
	private javax.swing.JLabel Note;
	private javax.swing.JPanel login_main_panel;
	private javax.swing.JPanel login_heading_panel;
	private javax.swing.JPanel Login_information;
	private javax.swing.JPanel btn_panel;
	private javax.swing.JPanel sub_menu;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JPasswordField Userpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {

					User_login window = new User_login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public static void disableWarning() {
	    System.err.close();
	    System.setErr(System.out);
	}
	/**
	 * Create the application.
	 */
	public User_login() {
		disableWarning();
		setIconImage(Toolkit.getDefaultToolkit().getImage(User_login.class.getResource("/img/Untitled.png")));
		initialize();
		con = Connect.connect();
		new changestyle().chabgelock();
		SwingUtilities.updateComponentTreeUI(this);
		// login_Hold();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		login_main_panel = new javax.swing.JPanel();
		login_heading_panel = new javax.swing.JPanel();
		Login_heading_label = new javax.swing.JLabel();
		Side_image = new javax.swing.JLabel();
		Login_information = new javax.swing.JPanel();
		User_name = new javax.swing.JLabel();
		User_password = new javax.swing.JLabel();

		Username = new javax.swing.JTextField();
		Username.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Username.setToolTipText("Enter Your Username");
		Userpassword = new javax.swing.JPasswordField();
		Userpassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Userpassword.setToolTipText("Enter Your Password");
		jSeparator1 = new javax.swing.JSeparator();
		btn_panel = new javax.swing.JPanel();
		Login_btn = new javax.swing.JButton();
		Login_btn.setToolTipText("Login");
		exit_btn = new javax.swing.JButton();
		exit_btn.setToolTipText("Exit");
		sub_menu = new javax.swing.JPanel();
		Note = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Login");
		setResizable(false);

		login_main_panel.setBackground(new java.awt.Color(51, 51, 51));

		login_heading_panel.setBackground(new java.awt.Color(102, 102, 102));

		Login_heading_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		Login_heading_label.setText("User-Login");

		javax.swing.GroupLayout gl_login_heading_panel = new javax.swing.GroupLayout(login_heading_panel);
		gl_login_heading_panel.setHorizontalGroup(
				gl_login_heading_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_login_heading_panel
								.createSequentialGroup().addGap(274).addComponent(Login_heading_label,
										GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(275, Short.MAX_VALUE)));
		gl_login_heading_panel.setVerticalGroup(gl_login_heading_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login_heading_panel.createSequentialGroup().addGap(20).addComponent(Login_heading_label)
						.addContainerGap(19, Short.MAX_VALUE)));
		login_heading_panel.setLayout(gl_login_heading_panel);

		Side_image.setIcon(new ImageIcon(User_login.class.getResource("/img/login.png"))); // NOI18N

		Login_information.setBackground(new java.awt.Color(51, 51, 51));
		Login_information.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login Information",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

		User_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		User_name.setForeground(new java.awt.Color(255, 255, 255));
		User_name.setText("User_ID : ");

		User_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		User_password.setForeground(new java.awt.Color(255, 255, 255));
		User_password.setText("User_Password : ");

		Username.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				idMouseClicked(evt);
			}
		});
		Username.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				idKeyReleased(evt);
			}
		});

		Userpassword.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				passMouseClicked(evt);
			}
		});
		Userpassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				passKeyReleased(evt);
			}
		});

		javax.swing.GroupLayout gl_Login_information = new javax.swing.GroupLayout(Login_information);
		Login_information.setLayout(gl_Login_information);
		gl_Login_information.setHorizontalGroup(gl_Login_information
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_Login_information.createSequentialGroup().addContainerGap()
						.addGroup(gl_Login_information.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(User_name).addComponent(User_password))
						.addGap(19, 19, 19)
						.addGroup(gl_Login_information.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(Userpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(Username))
						.addContainerGap()));
		gl_Login_information.setVerticalGroup(gl_Login_information
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_Login_information.createSequentialGroup().addContainerGap()
						.addGroup(gl_Login_information.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(User_name).addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(25, 25, 25)
						.addGroup(gl_Login_information.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(User_password).addComponent(Userpassword,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		btn_panel.setBackground(new java.awt.Color(51, 51, 51));
		btn_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

		Login_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		Login_btn.setText("Login");
		Login_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		exit_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		exit_btn.setText("Exit");
		exit_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		javax.swing.GroupLayout gl_btn_panel = new javax.swing.GroupLayout(btn_panel);
		btn_panel.setLayout(gl_btn_panel);
		gl_btn_panel.setHorizontalGroup(gl_btn_panel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						gl_btn_panel.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(exit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_btn_panel
				.setVerticalGroup(gl_btn_panel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gl_btn_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_btn_panel.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(Login_btn).addComponent(exit_btn))
								.addContainerGap(21, Short.MAX_VALUE)));

		sub_menu.setBackground(new java.awt.Color(51, 51, 51));
		sub_menu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

		Note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		Note.setForeground(new java.awt.Color(255, 0, 0));
		Note.setText("Note : Password should be at least 4 Characters ");

		javax.swing.GroupLayout gl_sub_menu = new javax.swing.GroupLayout(sub_menu);
		sub_menu.setLayout(gl_sub_menu);
		gl_sub_menu.setHorizontalGroup(gl_sub_menu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_sub_menu.createSequentialGroup().addContainerGap().addComponent(Note)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_sub_menu.setVerticalGroup(gl_sub_menu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_sub_menu.createSequentialGroup().addContainerGap().addComponent(Note).addContainerGap()));

		javax.swing.GroupLayout gl_login_main_panel = new javax.swing.GroupLayout(login_main_panel);
		login_main_panel.setLayout(gl_login_main_panel);
		gl_login_main_panel.setHorizontalGroup(gl_login_main_panel
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(login_heading_panel, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_login_main_panel.createSequentialGroup().addContainerGap()
						.addComponent(Side_image, javax.swing.GroupLayout.PREFERRED_SIZE, 290,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(
								gl_login_main_panel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(Login_information, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jSeparator1)
										.addComponent(btn_panel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(sub_menu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		gl_login_main_panel.setVerticalGroup(gl_login_main_panel
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_login_main_panel.createSequentialGroup()
						.addComponent(login_heading_panel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_login_main_panel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(gl_login_main_panel.createSequentialGroup().addGap(22, 22, 22)
										.addComponent(Login_information, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(8, 8, 8)
										.addComponent(sub_menu, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(22, Short.MAX_VALUE))
								.addGroup(gl_login_main_panel.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(Side_image, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(login_main_panel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(login_main_panel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		setSize(new java.awt.Dimension(693, 380));
		setLocationRelativeTo(null);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		if (Username.getText().equals("") || Userpassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Complete Your Login Information", "Missing Information", 2);
		} else {
			String sql = "select ID,NAME,PASSWORD from users where NAME='" + Username.getText() + "' ";
			// System.out.println(sql);
			try {
				pre = con.prepareStatement(sql);
				res = pre.executeQuery();
				if (res.next()) {
					NAME = res.getString("NAME");

					if (res.getString("PASSWORD").equals(Userpassword.getText())) {
						Userid = Integer.parseInt(res.getString("ID"));
						Scrapperhome scrap = new Scrapperhome();
						this.dispose();
						scrap.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Wrong Password", "Failed Access", 2);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Wrong ID", "Failed Access", 2);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
			}
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void passKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_passKeyReleased
		if (Userpassword.getForeground().equals(Color.GRAY)) {
			char passs = Userpassword.getText().charAt(0);
			Userpassword.setText("");//
			Userpassword.setText(String.valueOf(passs));
			Userpassword.setForeground(Color.BLACK);
			Userpassword.setEchoChar('*');

		}
	}// GEN-LAST:event_passKeyReleased

	private void passMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_passMouseClicked
		if (Userpassword.getForeground().equals(Color.GRAY)) {
			Userpassword.setText("");
			Userpassword.setForeground(Color.BLACK);
			Userpassword.setEchoChar('*');
		}
	}// GEN-LAST:event_passMouseClicked

	private void idKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_idKeyReleased
		if (Username.getForeground().equals(Color.GRAY)) {
			char idd = Username.getText().charAt(0);
			Username.setText("");
			Username.setText(String.valueOf(idd));
			Username.setForeground(Color.BLACK);
		}
	}// GEN-LAST:event_idKeyReleased

	private void idMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_idMouseClicked
		if (Username.getForeground().equals(Color.GRAY)) {
			Username.setText("");
			Username.setForeground(Color.BLACK);
		}
	}// GEN-LAST:event_idMouseClicked

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		System.exit(0);
		this.dispose();

	}// GEN-LAST:event_jButton2ActionPerformed

}
