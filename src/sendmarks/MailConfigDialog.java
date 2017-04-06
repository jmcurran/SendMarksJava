/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmarks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.prefs.Preferences;
/**
 *
 * @author James M. Curran <j.curran@auckland.ac.nz>
 */
public class MailConfigDialog extends javax.swing.JDialog {

  /**
   * Creates new form MailConfigDialog
   */
  public MailConfigDialog(java.awt.Frame parent, boolean modal) throws IOException {
    super(parent, modal);
    initComponents();
    
     prefs = Preferences.userNodeForPackage(this.getClass());
     
     strFrom = prefs.get("FROM", "someone@somewhere.com");

     strServerName = prefs.get("HOST", "mailhost.mail.com");
     strUser = prefs.get("USER", "someone");
     port = Integer.parseInt(prefs.get("PORT", "25"));
     bTTLS = Boolean.parseBoolean(prefs.get("TTLS", "true"));
     
     jtfServerName.setText(strServerName);
     jtfPort.setText(((Integer)port).toString());
     jtfUser.setText(strUser);
     jtfSender.setText(strFrom);
     jcbTTLS.setSelected(bTTLS);
     
     bSaved = false;
   }
  
  public boolean isSaved(){
    return bSaved;
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jbuttonSave = new javax.swing.JButton();
    jbuttonCancel = new javax.swing.JButton();
    jtfServerName = new javax.swing.JTextField();
    jtfPort = new javax.swing.JTextField();
    jtfSender = new javax.swing.JTextField();
    jtfUser = new javax.swing.JTextField();
    jcbTTLS = new javax.swing.JCheckBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setText("Server:");

    jLabel2.setText("Port:");

    jLabel3.setText("Return address:");

    jLabel4.setText("User Name:");

    jbuttonSave.setText("Save");
    jbuttonSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbuttonSaveActionPerformed(evt);
      }
    });

    jbuttonCancel.setText("Cancel");
    jbuttonCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbuttonCancelActionPerformed(evt);
      }
    });

    jcbTTLS.setSelected(true);
    jcbTTLS.setText("TTLS");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel4)
          .addComponent(jLabel3)
          .addComponent(jLabel1))
        .addGap(25, 25, 25)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jtfSender, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jbuttonSave)
          .addComponent(jbuttonCancel))
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(129, 129, 129)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jcbTTLS)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jtfServerName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jtfPort)
            .addGap(6, 6, 6))))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfSender, jtfServerName, jtfUser});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbuttonCancel, jbuttonSave});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(17, 17, 17)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jtfServerName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(jtfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jcbTTLS)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel4)
            .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jbuttonSave))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(jtfSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jbuttonCancel))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jbuttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonSaveActionPerformed
     prefs.put("HOST", jtfServerName.getText());
     prefs.put("PORT", jtfPort.getText());
     prefs.put("USER", jtfUser.getText());
     prefs.put("FROM",jtfSender.getText());
     prefs.put("TTLS", ((Boolean)jcbTTLS.isSelected()).toString());
     
     bSaved = true;
     
     dispose();
  }//GEN-LAST:event_jbuttonSaveActionPerformed

  private void jbuttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonCancelActionPerformed
    dispose();
  }//GEN-LAST:event_jbuttonCancelActionPerformed

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
      java.util.logging.Logger.getLogger(MailConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MailConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MailConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MailConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        MailConfigDialog dialog;
        try{
          dialog = new MailConfigDialog(new javax.swing.JFrame(), true);
        
          dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
              System.exit(0);
            }
          });
          dialog.setVisible(true);
        }catch(IOException e){
          e.printStackTrace();
        }
        
      }
    });
  }

  private Preferences prefs;
  private String strServerName;
  private String strFrom;
  private String strUser;
  private int port;
  private boolean bTTLS;
  
  private boolean bSaved;
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JButton jbuttonCancel;
  private javax.swing.JButton jbuttonSave;
  private javax.swing.JCheckBox jcbTTLS;
  private javax.swing.JTextField jtfPort;
  private javax.swing.JTextField jtfSender;
  private javax.swing.JTextField jtfServerName;
  private javax.swing.JTextField jtfUser;
  // End of variables declaration//GEN-END:variables
}
