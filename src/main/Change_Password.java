/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Window.Type;

/**
 *
 * @author Hemaa
 */
public class Change_Password extends javax.swing.JFrame {
Connection con = null;
PreparedStatement pre = null;
ResultSet res= null;
    public Change_Password() {
    	setType(Type.POPUP);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Change_Password.class.getResource("/img/Untitled.png")));
        initComponents();
        con=Connect.connect();
        log_usr_nm.setText(User_login.Username.getText());
        confirmed.setVisible(false);
        we_st.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_chang = new javax.swing.JPanel();
        heading_pnl = new javax.swing.JPanel();
        heading_lbl = new javax.swing.JLabel();
        heading_lbl.setForeground(Color.WHITE);
        background = new javax.swing.JLabel();
        background.setBackground(Color.WHITE);
        jPanel3 = new javax.swing.JPanel();
        confirm = new javax.swing.JPasswordField();
        confirm.setToolTipText("Confirm Your Password");
        new_pass = new javax.swing.JPasswordField();
        new_pass.setToolTipText("Type New Password");
        javax.swing.JLabel new_passwd_lbl = new javax.swing.JLabel();
        Userid_lbl = new javax.swing.JLabel();
        cnf_passwd_lbl = new javax.swing.JLabel();
        old_pass = new javax.swing.JPasswordField();
        old_pass.setToolTipText("Enter Ur old Password");
        log_usr_nm = new javax.swing.JTextField();
        old_passwd_lbl = new javax.swing.JLabel();
        confirmed = new javax.swing.JLabel();

        we_st = new javax.swing.JLabel();
        btn_pnl = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        updatepassword = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change_Password");
        setResizable(false);

        main_chang.setBackground(new java.awt.Color(51, 51, 51));

        heading_pnl.setBackground(new java.awt.Color(14,34,71));
        
        
       // heading_lbl.setBackground(new java.awt.Color(14,34,71));
        heading_lbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        heading_lbl.setText("Change_Password_Form");

        javax.swing.GroupLayout gl_heading_pnl = new javax.swing.GroupLayout(heading_pnl);
        heading_pnl.setLayout(gl_heading_pnl);
        gl_heading_pnl.setHorizontalGroup(
            gl_heading_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_heading_pnl.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(heading_lbl)
                .addGap(84, 84, 84))
        );
        gl_heading_pnl.setVerticalGroup(
            gl_heading_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_heading_pnl.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(heading_lbl)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Your Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        confirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmKeyReleased(evt);
            }
        });

        new_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                new_passKeyReleased(evt);
            }
        });

        new_passwd_lbl.setText("New_Password : ");

        Userid_lbl.setText("User_Id : ");

        cnf_passwd_lbl.setText("Confirm_New_Password : ");

        log_usr_nm.setEditable(false);

        old_passwd_lbl.setText("Old_Password : ");

        confirmed.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        confirmed.setForeground(new java.awt.Color(102, 204, 0));
        confirmed.setText("Confirmed");

        we_st.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        we_st.setText("very weak ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Userid_lbl)
                    .addComponent(old_passwd_lbl)
                    .addComponent(new_passwd_lbl)
                    .addComponent(cnf_passwd_lbl))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(new_pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(log_usr_nm, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(old_pass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(we_st)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Userid_lbl)
                    .addComponent(log_usr_nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(old_passwd_lbl)
                    .addComponent(old_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_passwd_lbl)
                    .addComponent(new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(we_st))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnf_passwd_lbl)
                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmed))
                .addContainerGap())
        );

        btn_pnl.setBackground(new java.awt.Color(51, 51, 51));
        btn_pnl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        cancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        updatepassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updatepassword.setText("Update_Password");
        updatepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gl_btn_pnl = new javax.swing.GroupLayout(btn_pnl);
        btn_pnl.setLayout(gl_btn_pnl);
        gl_btn_pnl.setHorizontalGroup(
            gl_btn_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_btn_pnl.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updatepassword)
                .addGap(18, 18, 18)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        gl_btn_pnl.setVerticalGroup(
            gl_btn_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_btn_pnl.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_btn_pnl.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatepassword)
                    .addComponent(cancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout gl_main_chang = new javax.swing.GroupLayout(main_chang);
        main_chang.setLayout(gl_main_chang);
        gl_main_chang.setHorizontalGroup(
            gl_main_chang.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(heading_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gl_main_chang.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_main_chang.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        gl_main_chang.setVerticalGroup(
            gl_main_chang.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_main_chang.createSequentialGroup()
                .addComponent(heading_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_chang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_chang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homebgimg.jpg"))); // NOI18N
        main_chang.add(background);
        background.setBounds(0, 74, 1220, 520);
        setSize(new java.awt.Dimension(484, 395));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void confirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmKeyReleased
        if(confirm.getText().equals("")){
         confirmed.setVisible(false);   
        }
        else if(confirm.getText().equals(new_pass.getText())){
          confirmed.setVisible(true);
          confirmed.setText("Confirmed");
          confirmed.setForeground(Color.GREEN);
}else {
    confirmed.setVisible(true);
    confirmed.setText("Wrong Password");
    confirmed.setForeground(Color.RED);
}
    }//GEN-LAST:event_confirmKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(old_pass.getText().equals("")||new_pass.getText().equals("")||confirm.getText().equals("")){
JOptionPane.showMessageDialog(null,"Complete Your Inforamtion","Missing Information",2);
  }     
   else {
    if(check_pass()){
        
        String sql = "update users set PASSWORD = '"+new_pass.getText()+"' where Id='"+User_login.Userid+"' ";
        try {
          pre=con.prepareStatement(sql);
          pre.execute();
          JOptionPane.showMessageDialog(null,"Password has been updated Successfully","Success O peration",1);
       clear(); }catch (Exception e) {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);
        }
        }else {
          JOptionPane.showMessageDialog(null,"Please Check Your Old_Password","Wrong Password",2);          
        }}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void new_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_passKeyReleased
        if(new_pass.getText().length()==0){
         we_st.setVisible(false);   
        }
        else if(new_pass.getText().length()<6){
    we_st.setVisible(true);
    we_st.setText("Very Weak");
    we_st.setForeground(Color.RED);
}else {
    we_st.setVisible(true);
    we_st.setText("Very Good");
    we_st.setForeground(Color.GREEN);
}
    }//GEN-LAST:event_new_passKeyReleased

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
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm;
    private javax.swing.JLabel confirmed;
    private javax.swing.JTextField log_usr_nm;
    private javax.swing.JButton updatepassword;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel Userid_lbl;
    private javax.swing.JLabel old_passwd_lbl;
    private javax.swing.JLabel cnf_passwd_lbl;
    private javax.swing.JLabel heading_lbl;
    private javax.swing.JPanel main_chang;
    private javax.swing.JPanel heading_pnl;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel btn_pnl;
    private javax.swing.JLabel background;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField new_pass;
    private javax.swing.JPasswordField old_pass;
    private javax.swing.JLabel we_st;
    // End of variables declaration//GEN-END:variables
    private boolean check_pass(){
        boolean check = false;
        String sql = "select PASSWORD from users where ID='"+User_login.Userid+"' ";
        try {
         pre=con.prepareStatement(sql);
         res=pre.executeQuery();
         if(res.next()){
             if(res.getString("PASSWORD").equals(old_pass.getText())){
                
                check=true;
                 
             }
         }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",2);
        }return check;
    }
    private void clear(){
        old_pass.setText("");
        new_pass.setText("");
        confirm.setText("");
        confirmed.setVisible(false);
        we_st.setVisible(false);
    }
   
}