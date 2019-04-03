/**
 *
 * C'est la classe pour modifier les infos d'une destinataire
 */
package Dynamic.Panel;

import Base.connect;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modifier extends javax.swing.JPanel {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    public Modifier() {
        initComponents();
        FillListe();
    }
    
    private void FillListe(){
        conn = connect.getConnect();
        
        try{
            String sql="select nom from DESTINATAIRE";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            System.out.println("OK FillListe Modif");
            
            while(rs.next()){
            String dest=rs.getString("nom");
            ListDest.addItem(dest);        
            }
        }catch(Exception e){
            System.out.println("KO");
            e.printStackTrace();
        }
    }
    
    private void FillInfo(){
        conn = connect.getConnect();
        
        try{
            String dest = String.valueOf(ListDest.getSelectedItem());
            String sql1 = "SELECT nom,prenom,tel,mail\n" +
                          "FROM DESTINATAIRE \n" +
                          "WHERE nom = '"+dest+"'";
            pst=conn.prepareStatement(sql1);
            rs = pst.executeQuery(sql1);
            
            while(rs.next()) { 
                TxtNom.setText(rs.getString("nom"));
                TxtPrenom.setText(rs.getString("prenom"));
                TxtTel.setText(rs.getString("tel"));
                TxtMail.setText(rs.getString("mail"));
            }
        }catch(Exception e){
            System.out.println("KO");
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtNom = new javax.swing.JTextField();
        TxtPrenom = new javax.swing.JTextField();
        TxtTel = new javax.swing.JTextField();
        TxtMail = new javax.swing.JTextField();
        ListDest = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        Recharger = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel1.setText("Modifier Un Destinataire");

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jLabel2.setText("Qui ");

        jLabel3.setText("Nouveau Nom");

        jLabel4.setText("Nouveau Prenom");

        jLabel5.setText("Nouveau Tel");

        jLabel6.setText("Nouveau Mail");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Recharger.setText("Recharger");
        Recharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechargerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TxtPrenom)
                            .addComponent(TxtTel)
                            .addComponent(TxtMail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ListDest, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(Submit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Recharger)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ListDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TxtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit)
                    .addComponent(Recharger))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        ModifInfo();
    }//GEN-LAST:event_SubmitActionPerformed
    
    private void ModifInfo() {
    //modification de nouveau infos d'un destinataire dans BDD
        conn = connect.getConnect();
        
        try {
            String dest = String.valueOf(ListDest.getSelectedItem());
            String newnom = TxtNom.getText(); 
            String newprenom = TxtPrenom.getText(); 
            String newtel = TxtTel.getText(); 
            String newmail = TxtMail.getText();
            
            String sql2 = "UPDATE DESTINATAIRE  \n" +
                          "SET nom='"+newnom+"', \n" +
                          "prenom='"+newprenom+"', \n" +
                          "tel='"+newtel+"', \n" +
                          "mail='"+newmail+"' \n" +
                          "WHERE nom='"+dest+"'";
            pst=conn.prepareStatement(sql2);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Contact Modifié!");
            String data =  "{\"action\" : \"modify\", \"qui\" : \""+ dest +"\", \"nom\" : \""+newnom+"\", \"prenom\" : \""+newprenom+"\", \"num\" : \""+newtel+"\", \"mail\" : \""+newmail+"\"} " ;
            System.out.println(data); 
            ConnServer(data);
            
        } catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void ConnServer(String msg){
        try{
		Socket s = new Socket("192.168.43.250", 3000);// send connection request to local machine port 3000	

		System.out.println("connection established"); // va etre afficher si la connection est bien établir		
			
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
		DataInputStream in = new DataInputStream(s.getInputStream());
							
		out.writeUTF(msg/*new String(encrypted)*/);
		String reponse = in.readUTF();
			
		System.out.println(reponse);
	}catch(Exception e){
		System.out.println(e);
                System.out.println("connection KO");
	}
    
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Il ya un problem a recharger automatiquement, donc ce button permet a recharger tous les info depuis BDD	
        FillInfo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RechargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechargerActionPerformed
        ListDest.removeAllItems();
        FillListe();
        TxtNom.setText("");
        TxtPrenom.setText("");
        TxtTel.setText("");
        TxtMail.setText("");
    }//GEN-LAST:event_RechargerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListDest;
    private javax.swing.JButton Recharger;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField TxtMail;
    private javax.swing.JTextField TxtNom;
    private javax.swing.JTextField TxtPrenom;
    private javax.swing.JTextField TxtTel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

   
}
