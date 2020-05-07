package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Login_Details extends javax.swing.JFrame {
Connection con = null;
PreparedStatement pre = null;
ResultSet res= null;
    public Login_Details() {
    	setResizable(false);
    	setAlwaysOnTop(true);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Details.class.getResource("/img/Untitled.png")));
        initComponents();
        con=Connect.connect();
        fill_Username();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        login_detail_main = new javax.swing.JPanel();
        heading_lbl = new javax.swing.JPanel();
        lbl_heading = new javax.swing.JLabel();
        data_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();
        User_interact_pnl = new javax.swing.JPanel();
        year = new javax.swing.JComboBox<>();
        Username_lbl = new javax.swing.JLabel();
        Username_lbl.setForeground(Color.WHITE);
        month = new javax.swing.JComboBox<>();
        day = new javax.swing.JComboBox<>();
        Date = new javax.swing.JLabel();
        Date.setForeground(Color.WHITE);
        username = new javax.swing.JComboBox<>();
        username.setToolTipText("Choose User-Name");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login_Details");
        setResizable(false);
        
        login_detail_main.setBackground(new java.awt.Color(51, 51, 51));

        heading_lbl.setBackground(new java.awt.Color(102, 102, 102));

        lbl_heading.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_heading.setText("Login-Details");
        javax.swing.GroupLayout gl_heading_lbl = new javax.swing.GroupLayout(heading_lbl);
        gl_heading_lbl.setHorizontalGroup(
        	gl_heading_lbl.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_heading_lbl.createSequentialGroup()
        			.addContainerGap(235, Short.MAX_VALUE)
        			.addComponent(lbl_heading)
        			.addGap(234))
        );
        gl_heading_lbl.setVerticalGroup(
        	gl_heading_lbl.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_heading_lbl.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbl_heading)
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        heading_lbl.setLayout(gl_heading_lbl);

        data_panel.setBackground(new java.awt.Color(51, 51, 51));
        data_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        data_table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "        Name", "        Type", "        Date", "        Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(data_table);
        if (data_table.getColumnModel().getColumnCount() > 0) {
            data_table.getColumnModel().getColumn(0).setResizable(false);
            data_table.getColumnModel().getColumn(1).setResizable(false);
            data_table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout gl_data_panel = new javax.swing.GroupLayout(data_panel);
        gl_data_panel.setHorizontalGroup(
        	gl_data_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_data_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_data_panel.setVerticalGroup(
        	gl_data_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_data_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        			.addContainerGap())
        );
        data_panel.setLayout(gl_data_panel);

        User_interact_pnl.setBackground(new java.awt.Color(51, 51, 51));
        User_interact_pnl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year : ",  "2020", "2021", "2022"}));
        year.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearItemStateChanged(evt);
            }
        });

        Username_lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Username_lbl.setText("User_Name : ");

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month : ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthItemStateChanged(evt);
            }
        });

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day : ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        day.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dayItemStateChanged(evt);
            }
        });

        Date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Date.setText("Login_Date : ");

        username.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User_Name : " }));
        username.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                usernameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout gl_User_interact_pnl = new javax.swing.GroupLayout(User_interact_pnl);
        User_interact_pnl.setLayout(gl_User_interact_pnl);
        gl_User_interact_pnl.setHorizontalGroup(
            gl_User_interact_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_User_interact_pnl.createSequentialGroup()
                .addContainerGap()
                .addComponent(Username_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Date)
                .addGap(18, 18, 18)
                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        gl_User_interact_pnl.setVerticalGroup(
            gl_User_interact_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_User_interact_pnl.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_User_interact_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username_lbl)
                    .addComponent(Date)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout gl_login_detail_main = new javax.swing.GroupLayout(login_detail_main);
        gl_login_detail_main.setHorizontalGroup(
        	gl_login_detail_main.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_login_detail_main.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_login_detail_main.createParallelGroup(Alignment.LEADING)
        				.addComponent(User_interact_pnl, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        				.addComponent(data_panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        				.addComponent(heading_lbl, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_login_detail_main.setVerticalGroup(
        	gl_login_detail_main.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_login_detail_main.createSequentialGroup()
        			.addComponent(heading_lbl, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
        			.addGap(31)
        			.addComponent(User_interact_pnl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(data_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        login_detail_main.setLayout(gl_login_detail_main);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_detail_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_detail_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        setSize(new Dimension(651, 503));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_usernameItemStateChanged
String sql;
if(day.getSelectedIndex()==0&&month.getSelectedIndex()==0&&year.getSelectedIndex()==0){
sql = "select NAME,TYPE,DATE,TIME from login_details where NAME='"+username.getSelectedItem()+"' ";
      }else {
sql = "select NAME,TYPE,DATE,TIME from login_details where NAME='"+username.getSelectedItem()+"' and DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";
}  try {
       pre=con.prepareStatement(sql);
       res=pre.executeQuery();
       data_table.setModel(DbUtils.resultSetToTableModel(res));
       } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);
        }
    }//GEN-LAST:event_usernameItemStateChanged

    private void dayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dayItemStateChanged
String sql ; 
if(month.getSelectedIndex()!=0&&year.getSelectedIndex()!=0&&username.getSelectedIndex()==0){
  sql = "select NAME,TYPE,DATE,TIME from login_details where DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";
}else {
  sql = "select NAME,TYPE,DATE,TIME from login_details where NAME='"+username.getSelectedItem()+"' and DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";   
}
       try {
       pre=con.prepareStatement(sql);
       res=pre.executeQuery();
       data_table.setModel(DbUtils.resultSetToTableModel(res));
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);
       }
    }//GEN-LAST:event_dayItemStateChanged

    private void monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthItemStateChanged
String sql;
        if(day.getSelectedIndex()!=0&&month.getSelectedIndex()!=0&&year.getSelectedIndex()!=0&&username.getSelectedIndex()==0){
sql = "select NAME,TYPE,DATE,TIME from login_details where DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";
}else {
sql = "select NAME,TYPE,DATE,TIME from login_details where NAME='"+username.getSelectedItem()+"' and DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";
}       
try {
       pre=con.prepareStatement(sql);
       res=pre.executeQuery();
       data_table.setModel(DbUtils.resultSetToTableModel(res));
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);
       }
 
    }//GEN-LAST:event_monthItemStateChanged

    private void yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearItemStateChanged
String sql;
if(month.getSelectedIndex()!=0&&day.getSelectedIndex()!=0&&username.getSelectedIndex()==0){
sql = "select NAME,TYPE,DATE,TIME from login_details where DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";
}else {
sql = "select NAME,TYPE,DATE,TIME from login_details where NAME='"+username.getSelectedItem()+"' and DATE='"+day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem()+"' ";
}
    try {
       pre=con.prepareStatement(sql);
       res=pre.executeQuery();
       data_table.setModel(DbUtils.resultSetToTableModel(res));
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);
       }
 
    }//GEN-LAST:event_yearItemStateChanged

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
            java.util.logging.Logger.getLogger(Login_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> day;
    
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel Username_lbl;
    private javax.swing.JLabel Date;
    private javax.swing.JPanel login_detail_main;
    private javax.swing.JPanel heading_lbl;
    private javax.swing.JPanel data_panel;
    private javax.swing.JPanel User_interact_pnl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable data_table;
    public javax.swing.JComboBox<String> month;
    private javax.swing.JComboBox<String> username;
    public javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
private void fill_Username(){
    String sql = "select NAME from users";
    try {
        pre=con.prepareStatement(sql);
        res=pre.executeQuery();
        while(res.next()){
        username.addItem(res.getString("NAME"));
        }
    } catch (Exception e) {
  JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);      
    }
} 
}
