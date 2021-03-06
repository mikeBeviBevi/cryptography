/*
 * A GUI to handle I/O between a user and various Crypto Machines
 * see package CryptoMachines 
 */
package GUI;

import CryptoMachines.VigenereMachine;
import java.awt.Color;

/**
 *
 * @author Michael Bevilacqua (Bevi)
 */
public class CryptoPanel extends javax.swing.JPanel {

    /**
     * Creates new form CryptoPanel
     */
    public CryptoPanel() {

        initComponents();
        //hide error message
        jLabelErrorKeyWord.setVisible(false);
        jLabelErrorMessageInput.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupVigenere = new javax.swing.ButtonGroup();
        jTabbedPaneCiphers = new javax.swing.JTabbedPane();
        jPanelVigenere = new javax.swing.JPanel();
        jTextFieldPlainText = new javax.swing.JTextField();
        jLabelKeyWord = new javax.swing.JLabel();
        jTextFieldKeyWord = new javax.swing.JTextField();
        jTextFieldCipherText = new javax.swing.JTextField();
        jRadioButtonPlainText = new javax.swing.JRadioButton();
        jRadioButtonCipherText = new javax.swing.JRadioButton();
        jButtonEncryptDecrypt = new javax.swing.JButton();
        jPanelError = new javax.swing.JPanel();
        jLabelErrorKeyWord = new javax.swing.JLabel();
        jLabelErrorMessageInput = new javax.swing.JLabel();

        jTabbedPaneCiphers.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldPlainText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlainTextActionPerformed(evt);
            }
        });

        jLabelKeyWord.setText("Key Word:");

        buttonGroupVigenere.add(jRadioButtonPlainText);
        jRadioButtonPlainText.setText("Plain Text:");

        buttonGroupVigenere.add(jRadioButtonCipherText);
        jRadioButtonCipherText.setText("Cipher Text:");
        jRadioButtonCipherText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCipherTextActionPerformed(evt);
            }
        });

        jButtonEncryptDecrypt.setText("Encrypt/Decrypt");
        jButtonEncryptDecrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEncryptDecryptMouseClicked(evt);
            }
        });

        jPanelError.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelError.setMinimumSize(new java.awt.Dimension(148, 62));

        jLabelErrorKeyWord.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorKeyWord.setText("• Please Enter a Keyword");

        jLabelErrorMessageInput.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorMessageInput.setText("• Please Enter a Message");

        javax.swing.GroupLayout jPanelErrorLayout = new javax.swing.GroupLayout(jPanelError);
        jPanelError.setLayout(jPanelErrorLayout);
        jPanelErrorLayout.setHorizontalGroup(
            jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelErrorMessageInput)
                    .addComponent(jLabelErrorKeyWord))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelErrorLayout.setVerticalGroup(
            jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErrorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabelErrorKeyWord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelErrorMessageInput)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelVigenereLayout = new javax.swing.GroupLayout(jPanelVigenere);
        jPanelVigenere.setLayout(jPanelVigenereLayout);
        jPanelVigenereLayout.setHorizontalGroup(
            jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVigenereLayout.createSequentialGroup()
                .addGroup(jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVigenereLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelKeyWord, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonCipherText, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKeyWord)
                            .addComponent(jTextFieldCipherText, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVigenereLayout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jRadioButtonPlainText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVigenereLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEncryptDecrypt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelVigenereLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelVigenereLayout.setVerticalGroup(
            jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVigenereLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonPlainText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKeyWord)
                    .addComponent(jTextFieldKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonCipherText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEncryptDecrypt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPaneCiphers.addTab("Vigenére Cipher", jPanelVigenere);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneCiphers, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jTabbedPaneCiphers, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonCipherTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCipherTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCipherTextActionPerformed

    private void jTextFieldPlainTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlainTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlainTextActionPerformed

    private void jButtonEncryptDecryptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEncryptDecryptMouseClicked


        //user has not entered keyword
        if (jTextFieldKeyWord.getText().equals("")) {
            jLabelErrorKeyWord.setVisible(true);
            jLabelKeyWord.setForeground(Color.red);
        }
        // user has selected to decrypt but has not entered cipher text
        if (jRadioButtonCipherText.isSelected() && jTextFieldCipherText.getText().equals("")) {
         jLabelErrorMessageInput.setVisible(true);
            jRadioButtonCipherText.setForeground(Color.red);
        }
        // user has selected to encrypt but has not entered plain text
        if (jRadioButtonPlainText.isSelected() && jTextFieldPlainText.getText().equals("")) {
         jLabelErrorMessageInput.setVisible(true);
            jRadioButtonPlainText.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButtonEncryptDecryptMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupVigenere;
    private javax.swing.JButton jButtonEncryptDecrypt;
    private javax.swing.JLabel jLabelErrorKeyWord;
    private javax.swing.JLabel jLabelErrorMessageInput;
    private javax.swing.JLabel jLabelKeyWord;
    private javax.swing.JPanel jPanelError;
    private javax.swing.JPanel jPanelVigenere;
    private javax.swing.JRadioButton jRadioButtonCipherText;
    private javax.swing.JRadioButton jRadioButtonPlainText;
    private javax.swing.JTabbedPane jTabbedPaneCiphers;
    private javax.swing.JTextField jTextFieldCipherText;
    private javax.swing.JTextField jTextFieldKeyWord;
    private javax.swing.JTextField jTextFieldPlainText;
    // End of variables declaration//GEN-END:variables
}
