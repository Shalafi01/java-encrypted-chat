package GUI;

import java.io.*;
import java.net.*;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author NICOLA
 */
public class ClientGUI extends javax.swing.JFrame {

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    static String lineIn = "";
    static String lineOut = "";

    public ClientGUI() {
        initComponents();
        jOpzioni.setVisible(false);
        super.getRootPane().setDefaultButton(jInvia);        
    }
    
    static methods m=new methods();    

    static String AesKey="";
    static SecretKey DesKey3;
    static String DesKey3E="";
    static String DesKeyE="";
    static SecretKey DesKey;
    static String tipoC="";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jOpzioni = new javax.swing.JPanel();
        jEsci = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jChiave = new javax.swing.JLabel();
        jInserisci = new javax.swing.JButton();
        jGrande1 = new javax.swing.JPanel();
        jSopra1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMessaggi1 = new javax.swing.JTextArea();
        jSotto = new javax.swing.JPanel();
        jInvia = new javax.swing.JButton();
        jScrivi = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENT 1");
        setPreferredSize(new java.awt.Dimension(556, 670));
        setResizable(false);
        setSize(new java.awt.Dimension(945, 700));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(556, 609));

        jEsci.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jEsci.setText("Salva ed esci");
        jEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEsciActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("OPZIONI");

        jLabel3.setText("Tipo di cifratura: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nessuna", "DES", "3DES", "AES" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Chiave: ");

        jChiave.setText("Nessuna");

        jInserisci.setText("Inserisci nuova chiave");
        jInserisci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInserisciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jOpzioniLayout = new javax.swing.GroupLayout(jOpzioni);
        jOpzioni.setLayout(jOpzioniLayout);
        jOpzioniLayout.setHorizontalGroup(
            jOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jOpzioniLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jEsci)
                .addGap(210, 210, 210))
            .addGroup(jOpzioniLayout.createSequentialGroup()
                .addGroup(jOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jOpzioniLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jOpzioniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jOpzioniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChiave))
                    .addGroup(jOpzioniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jInserisci, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jOpzioniLayout.setVerticalGroup(
            jOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jOpzioniLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(jOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jChiave))
                .addGap(18, 18, 18)
                .addComponent(jInserisci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(jEsci)
                .addContainerGap())
        );

        jMessaggi1.setEditable(false);
        jMessaggi1.setColumns(20);
        jMessaggi1.setLineWrap(true);
        jMessaggi1.setRows(5);
        jMessaggi1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jMessaggi1);

        javax.swing.GroupLayout jSopra1Layout = new javax.swing.GroupLayout(jSopra1);
        jSopra1.setLayout(jSopra1Layout);
        jSopra1Layout.setHorizontalGroup(
            jSopra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        jSopra1Layout.setVerticalGroup(
            jSopra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jInvia.setText("Invia");
        jInvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInviaActionPerformed(evt);
            }
        });

        jScrivi.setText("Scrivi un messaggio...");
        jScrivi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScriviFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jScriviFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jSottoLayout = new javax.swing.GroupLayout(jSotto);
        jSotto.setLayout(jSottoLayout);
        jSottoLayout.setHorizontalGroup(
            jSottoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSottoLayout.createSequentialGroup()
                .addComponent(jScrivi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInvia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jSottoLayout.setVerticalGroup(
            jSottoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrivi)
            .addComponent(jInvia, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jGrande1Layout = new javax.swing.GroupLayout(jGrande1);
        jGrande1.setLayout(jGrande1Layout);
        jGrande1Layout.setHorizontalGroup(
            jGrande1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGrande1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGrande1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSopra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSotto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jGrande1Layout.setVerticalGroup(
            jGrande1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGrande1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSopra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSotto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(jOpzioni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jGrande1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jGrande1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jOpzioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jGrande1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jOpzioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Opzioni...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Esci");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jInviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInviaActionPerformed
        lineOut = jScrivi.getText();
        if ((!lineOut.replaceAll(" ", "").equals("")) && (!lineOut.equals("Scrivi un messaggio..."))) {
            jMessaggi1.setText(jMessaggi1.getText() + "Client 1: " + lineOut + "\n");
            jScrivi.setText("Scrivi un messaggio...");
            try {
                if(tipoC.equals("AES")) dout.writeUTF(m.encryptAES(lineOut, AesKey));
                else if(tipoC.equals("DES")) dout.writeUTF(m.encryptDES(lineOut, DesKey));
                else if(tipoC.equals("3DES")) dout.writeUTF(m.encrypt3DES(lineOut, DesKey3));
                else dout.writeUTF(lineOut);
            } catch (Exception e) {
                jMessaggi1.setText(jMessaggi1.getText() + "\n- - - NESSUN SERVER TROVATO - - -\n\n");
            }
        }
        jMessaggi1.requestFocus();
        jScrivi.requestFocus();
    }//GEN-LAST:event_jInviaActionPerformed

    private void jScriviFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScriviFocusGained
        if (jScrivi.getText().equals("Scrivi un messaggio...")) {
            jScrivi.setText("");
        }
    }//GEN-LAST:event_jScriviFocusGained

    private void jScriviFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScriviFocusLost
        if (jScrivi.getText().equals("")) {
            jScrivi.setText("Scrivi un messaggio...");
        }
    }//GEN-LAST:event_jScriviFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jGrande1.setVisible(false);
        jOpzioni.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEsciActionPerformed
        if (tipoC.equals("AES")) {
            if (AesKey.trim().length() == 44) {
                JOptionPane.showMessageDialog(null, "Impostazioni salvate.");
                jGrande1.setVisible(true);
                jOpzioni.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "La chiave inserita non è valida!");
            }
        }
        else if (tipoC.equals("DES")) {
            if (DesKeyE.length() == 12) {
                JOptionPane.showMessageDialog(null, "Impostazioni salvate.");
                jGrande1.setVisible(true);
                jOpzioni.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "La chiave inserita non è valida!");
            }
        } 
        else if (tipoC.equals("3DES")) {
            if (DesKey3E.length() == 32) {
                JOptionPane.showMessageDialog(null, "Impostazioni salvate.");
                jGrande1.setVisible(true);
                jOpzioni.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "La chiave inserita non è valida!");
            }
        }
        else {
            jGrande1.setVisible(true);
            jOpzioni.setVisible(false);
        }
    }//GEN-LAST:event_jEsciActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedIndex() == 0) {tipoC = "Nessuna"; AesKey=""; DesKeyE=""; DesKey3E=""; jChiave.setText("Nessuna");}
        if (jComboBox2.getSelectedIndex() == 1) {tipoC = "DES"; AesKey=""; DesKey3E=""; if(jChiave.getText().length()!=12)jChiave.setText("Nessuna");}
        if (jComboBox2.getSelectedIndex() == 2) {tipoC = "3DES"; AesKey=""; DesKeyE=""; if(jChiave.getText().length()!=32) jChiave.setText("Nessuna");}
        if (jComboBox2.getSelectedIndex() == 3) {tipoC = "AES"; DesKeyE=""; DesKey3E=""; if(jChiave.getText().length()!=44) jChiave.setText("Nessuna");}
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jInserisciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInserisciActionPerformed
        try {
            if (jComboBox2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Nessun algoritmo di cifratura selezionato!");
            } else if (jComboBox2.getSelectedIndex() == 1) {
                DesKeyE = JOptionPane.showInputDialog(null, "Inserisci la nuova chiave: ", null, 1);
                try {
                    byte[] decodedKey = Base64.getDecoder().decode(DesKeyE);
                    DesKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
                    jChiave.setText(DesKeyE);
                } catch (NullPointerException e) {
                }

            } else if (jComboBox2.getSelectedIndex() == 2) {
                DesKey3E = JOptionPane.showInputDialog(null, "Inserisci la nuova chiave: ", null, 1);
                try {
                    byte[] decodedKey = Base64.getDecoder().decode(DesKey3E);
                    DesKey3 = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DESede");
                    jChiave.setText(DesKey3E);
                } catch (NullPointerException e) {
                }
            } else if (jComboBox2.getSelectedIndex() == 3) {
                AesKey = JOptionPane.showInputDialog(null, "Inserisci la nuova chiave: ", null, 1);
                jChiave.setText(AesKey);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jInserisciActionPerformed

    public static void main(String args[]) throws IOException, Exception {
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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClientGUI().setVisible(true);
        });

        jMessaggi1=new JTextArea("- - - CLIENT 1 HA INIZIATO LA RICERCA DI UNA CONNESSIONE - - -\n\n");  
        
        int b = 1;
        while (b >=0) {       
            
            while (b >= 1) {        //continua a cercare una connessione, se esce è perché la trovata
                try {
                    s = new Socket("localhost", 3333);
                    din = new DataInputStream(s.getInputStream());
                    dout = new DataOutputStream(s.getOutputStream());                    
                    dout.writeUTF("!");
                    lineIn=din.readUTF();
                    if(lineIn.equals("!")) jMessaggi1.setText(jMessaggi1.getText() + "- - - SERVER TROVATO - - -\n\n");
                    b = 0;
                } catch (Exception e) {
                    if (b == 1) {
                        jMessaggi1.setText(jMessaggi1.getText() + "- - - NESSUNA CONNESSIONE TROVATA - - -\n\n");
                        b++;
                    }
                }
            }
            
            try {           //se crasha è perchè il server è stato trovato e poi perso, la ricezione termina.
                lineIn = din.readUTF();
            } catch (Exception e) {
                jMessaggi1.setText(jMessaggi1.getText() + "- - - CONNESSIONE PERSA - - -\n\n");
                jMessaggi1.setText(jMessaggi1.getText() + "Errore: " + e.getClass().getSimpleName() + " - " + e.getMessage() + "\n\n");
                b = -1;
            }
     
            if (b >= 0) {                
                if (tipoC.equals("")) {
                    jMessaggi1.setText(jMessaggi1.getText() + "Server 1: " + lineIn + "\n");
                }
                else if (tipoC.equals("AES")) {
                    jMessaggi1.setText(jMessaggi1.getText() + "Server 1: " + m.decryptAES(lineIn, AesKey) + "\n");
                }
                else if (tipoC.equals("DES")) {
                    jMessaggi1.setText(jMessaggi1.getText() + "Server 1: " + m.decryptDES(lineIn, DesKey) + "\n");
                }
                else if (tipoC.equals("3DES")) {
                    jMessaggi1.setText(jMessaggi1.getText() + "Server 1: " + m.decrypt3DES(lineIn, DesKey3) + "\n");
                }
            }
        }
        din.close();
        dout.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jChiave;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JButton jEsci;
    private javax.swing.JPanel jGrande1;
    private javax.swing.JButton jInserisci;
    private javax.swing.JButton jInvia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private static javax.swing.JTextArea jMessaggi1;
    private javax.swing.JPanel jOpzioni;
    private javax.swing.JTextField jScrivi;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jSopra1;
    private javax.swing.JPanel jSotto;
    // End of variables declaration//GEN-END:variables
}
