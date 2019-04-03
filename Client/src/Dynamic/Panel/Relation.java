/**
 *
 * C'est la classe qui permet de voir la relation existe entre destinataire
 */
package Dynamic.Panel;

import Base.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;

public class Relation extends javax.swing.JPanel {

     Connection conn = null;
     ResultSet rs=null;
     PreparedStatement pst=null;  
    /**
     * Creates new form Relation
     */
    public Relation() {
        initComponents();
        FillListeDest();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Dest = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        relation = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel1.setText("Relation Entre Destinataire");

        Dest.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                DestPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jScrollPane1.setViewportView(relation);

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Choisisez un destinataire pour voir ses amis communs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addComponent(Dest, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addContainerGap(97, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(Dest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DestPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_DestPopupMenuWillBecomeInvisible
        AffMembre();
    }//GEN-LAST:event_DestPopupMenuWillBecomeInvisible

    private void AffMembre(){ //Affichage de nom dans list
        conn = connect.getConnect(); //connection base
        try{
            DefaultListModel list = new DefaultListModel(); 
            String qui=String.valueOf(Dest.getSelectedItem());
            String sql2 =   "SELECT destinataire.nom, groupe.nomGroupe\n" +
                            "FROM destinataire, groupe\n" +
                            "WHERE destinataire.id = groupe.idDest\n" +
                            "AND nom != '" +qui +"'\n"+
                            "AND nomGroupe IN \n" +
                            "(SELECT groupe.nomGroupe \n" +
                            " FROM destinataire\n" +
                            " INNER JOIN groupe ON destinataire.id = groupe.idDest\n" +
                            " WHERE nom = '" +qui +"')\n" +
                            " ORDER BY groupe.nomGroupe ASC\n" ;
            pst=conn.prepareStatement(sql2);
            rs=pst.executeQuery();
            System.out.println("OK");
            while(rs.next()){
                String nom=rs.getString("nom") + " - "+ rs.getString("nomGroupe");
                list.addElement(nom); 
            }relation.setModel(list); //affiche dans liste
            if(list.isEmpty()){list.addElement("Pas de relation");}
        }catch(Exception e){
            System.out.println("KO nom membre de groupe");
            e.printStackTrace();
        } 
    }

    private void FillListeDest(){
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        conn = connect.getConnect();
        
        try{
            String sql="select nom,prenom from DESTINATAIRE";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            System.out.println("OK");
            
            while(rs.next()){
            String dest=rs.getString("nom");
            Dest.addItem(dest);        
            }
        }catch(Exception e){
            System.out.println("KO");
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Dest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> relation;
    // End of variables declaration//GEN-END:variables
}