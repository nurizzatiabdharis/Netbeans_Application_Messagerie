/**
 *
 *  C'est la classe pour la gestion d'un groupe
 * - on peut voir les membres d'un groupe
 * - on peut ajouter un membre dans un groupe
 * - on peut creer un nouveau groupe
 * - on peut supprimer un groupe
 */

package Dynamic.Panel;

import java.sql.*;
import Base.connect;
import java.awt.HeadlessException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Groupe extends javax.swing.JPanel {
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement pst=null;     
    /**
     * Creates new form Groupe
     */
    public Groupe() {
        initComponents();
        FillListe();
        NomDest();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        listgroupe = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        nomMembre = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        creerGroupe = new javax.swing.JCheckBox();
        Creer = new javax.swing.JButton();
        TxtNewGroupe = new javax.swing.JTextField();
        listMembre = new javax.swing.JComboBox<>();
        newGroupe = new javax.swing.JLabel();
        newMembre = new javax.swing.JLabel();
        Ajoute = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deleteGroupe = new javax.swing.JCheckBox();
        delGroupe = new javax.swing.JLabel();
        listgroupedel = new javax.swing.JComboBox<>();
        delgroupe = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setBackground(new java.awt.Color(255, 204, 204));

        listgroupe.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listgroupePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jScrollPane1.setViewportView(nomMembre);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel1.setText("Les Groupes");

        jLabel2.setText("Nom de Groupe");

        jLabel3.setText("List de membre");

        creerGroupe.setText("Creer un nouveau groupe");
        creerGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerGroupeActionPerformed(evt);
            }
        });

        Creer.setText("Creer");
        Creer.setVisible(false);
        Creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreerActionPerformed(evt);
            }
        });

        TxtNewGroupe.setVisible(false);

        newGroupe.setText("Nom de groupe");
        newGroupe.setVisible(false);

        newMembre.setText("Ajoute un membre");

        Ajoute.setText("Ajouter");
        Ajoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouteActionPerformed(evt);
            }
        });

        deleteGroupe.setText("Supprimer un groupe");
        deleteGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGroupeActionPerformed(evt);
            }
        });

        delGroupe.setText("Nom de groupe");
        delGroupe.setVisible(false);

        listgroupedel.setVisible(false);

        delgroupe.setText("Supprimer");
        delgroupe.setVisible(false);
        delgroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delgroupeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(0, 317, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delGroupe)
                    .addComponent(jLabel4)
                    .addComponent(creerGroupe)
                    .addComponent(newGroupe)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(newMembre))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listgroupe, 0, 203, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtNewGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(listgroupedel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ajoute)
                                    .addComponent(Creer)
                                    .addComponent(delgroupe)))))
                    .addComponent(deleteGroupe))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(listgroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newMembre)
                    .addComponent(listMembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ajoute))
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creerGroupe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newGroupe)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtNewGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Creer)))
                .addGap(18, 18, 18)
                .addComponent(deleteGroupe)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(delGroupe)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delgroupe)
                            .addComponent(listgroupedel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listgroupePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listgroupePopupMenuWillBecomeInvisible
        AffMembre();
    }//GEN-LAST:event_listgroupePopupMenuWillBecomeInvisible

    private void creerGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerGroupeActionPerformed
        //quand le champs creation d'un groupe est choisi	
        if (creerGroupe.isSelected()){
            newGroupe.setVisible(true);
            TxtNewGroupe.setVisible(true);
            Creer.setVisible(true);
            this.repaint();
            this.revalidate();
        }else{
            newGroupe.setVisible(false);
            TxtNewGroupe.setVisible(false);
            Creer.setVisible(false);
        }        
    }//GEN-LAST:event_creerGroupeActionPerformed

    private void CreerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreerActionPerformed
        CreerNewGroupe();
    }//GEN-LAST:event_CreerActionPerformed

    private void AjouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouteActionPerformed
        AjouteMemDansGroupe();
    }//GEN-LAST:event_AjouteActionPerformed

    private void deleteGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGroupeActionPerformed
        //quand le champs suppression d'un groupe est choisi
        if (deleteGroupe.isSelected()){
            delGroupe.setVisible(true);
            listgroupedel.setVisible(true);
            delgroupe.setVisible(true);
            this.repaint();
            this.revalidate();
        }else{
            delGroupe.setVisible(false);
            listgroupedel.setVisible(false);
            delgroupe.setVisible(false);
        }        
    }//GEN-LAST:event_deleteGroupeActionPerformed

    private void delgroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delgroupeActionPerformed
        SupprimerGroupe();
    }//GEN-LAST:event_delgroupeActionPerformed

    private void CreerNewGroupe() {
        //Creation d'un nouveau groupe
        String groupe = TxtNewGroupe.getText();
        conn = connect.getConnect(); //connexion base

        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (conn != null) {
                String sql3 = "INSERT INTO GROUPE (idGroupe, nomGroupe) VALUES (NULL, ?)";
                PreparedStatement statement = conn.prepareStatement(sql3);
                statement.setString(1, groupe);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Groupe Creé!" );
                    //Pour mise a jour les infos affiches, on appelle la methode a chaque fois un action se fait
                    listgroupe.removeAllItems();
                    listgroupedel.removeAllItems();
                    FillListe();
                    TxtNewGroupe.setText("");
                    //System.out.println(groupe);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem: database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problem connexion, verifier login/mdp");
            ex.printStackTrace();
        } 
    }
    
    private void AjouteMemDansGroupe() {
        //Ajouter un destinataire dans un groupe
        String newMembre=String.valueOf(listMembre.getSelectedItem());
        String groupe=String.valueOf(listgroupe.getSelectedItem());
        conn = connect.getConnect(); //connection base

        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (conn != null) {
                  //recuperer id membre
                String sql2 = "SELECT id FROM destinataire WHERE nom = " + "'" + newMembre + "'";
                pst=conn.prepareStatement(sql2);
                rs=pst.executeQuery();
                System.out.println("OK");
                while(rs.next()){
                    String id=rs.getString("id");
                    System.out.println(id); 
                    String sql3 = "INSERT INTO GROUPE (idGroupe, nomGroupe, idDest) VALUES (NULL, ?, ?);";
                    PreparedStatement statement = conn.prepareStatement(sql3);
                    statement.setString(1, groupe);
                    statement.setString(2, id);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Membre Ajouté!" );
                        //Pour mise a jour les infos affiches, on appelle la methode a chaque fois un action se fait
                        AffMembre();
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem: database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problem connexion, verifier login/mdp");
            ex.printStackTrace();
        } 
    }
    
    private void SupprimerGroupe() {
        //Suppression d'un groupe
        conn = connect.getConnect(); //connection base
         
        try {
            String groupe=String.valueOf(listgroupedel.getSelectedItem());
            String sql2 = "DELETE FROM GROUPE WHERE nomGroupe ='" + groupe +"'";
            pst=conn.prepareStatement(sql2);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Groupe Supprimé!");
            //Pour mise a jour les infos affiches, on appelle la methode a chaque fois un action se fait
            listgroupe.removeAllItems();
            listgroupedel.removeAllItems();
            FillListe();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void FillListe(){
        //Recuperer le nom de groupe depuis BDD
        conn = connect.getConnect(); //connection base
        try{
            String sql="select DISTINCT nomGroupe from GROUPE";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            System.out.println("OK FillListe Groupe");
            
            while(rs.next()){
                String groupe=rs.getString("nomGroupe");
                listgroupe.addItem(groupe);//la liste déroulante de tous les groupes pour voir ses membres
                listgroupedel.addItem(groupe); //la liste déroulante de tous les groupe pour supprimer
            }
        }catch(Exception e){
            System.out.println("KO FillListe Groupe");
            e.printStackTrace();
        }
    }
  
    private void AffMembre(){ 
        //Affichage dans la list de tous les membres appartient a un groupe 
        conn = connect.getConnect(); //connection base
        try{
            DefaultListModel list = new DefaultListModel(); 
            String groupe=String.valueOf(listgroupe.getSelectedItem());
            String sql2 = " SELECT DISTINCT destinataire.nom, destinataire.prenom, groupe.nomGroupe FROM destinataire, groupe WHERE destinataire.id = groupe.idDest AND nomGroupe = " + "'" + groupe + "'";
            pst=conn.prepareStatement(sql2);
            rs=pst.executeQuery();
            System.out.println("OK AffMembre Groupe");
            while(rs.next()){
                String nom=rs.getString("nom");
                list.addElement(nom); 
            }nomMembre.setModel(list); //affiche dans liste
        }catch(Exception e){
            System.out.println("KO nom membre de groupe");
            e.printStackTrace();
        } 
    }
    
    private void NomDest(){
        //Affichage de tous le destinataire existent dans BDD
        conn = connect.getConnect(); //connection base
        try{
            String sql4="select DISTINCT nom,prenom from DESTINATAIRE";
            pst=conn.prepareStatement(sql4);
            rs=pst.executeQuery();
            System.out.println("OK Nom Groupe");
            
            while(rs.next()){
                String dest=rs.getString("nom");
                listMembre.addItem(dest);        
            }
        }catch(Exception e){
            System.out.println("KO nom membre");
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajoute;
    private javax.swing.JButton Creer;
    private javax.swing.JTextField TxtNewGroupe;
    private javax.swing.JCheckBox creerGroupe;
    private javax.swing.JLabel delGroupe;
    private javax.swing.JCheckBox deleteGroupe;
    private javax.swing.JButton delgroupe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listMembre;
    private javax.swing.JComboBox<String> listgroupe;
    private javax.swing.JComboBox<String> listgroupedel;
    private javax.swing.JLabel newGroupe;
    private javax.swing.JLabel newMembre;
    private javax.swing.JList<String> nomMembre;
    // End of variables declaration//GEN-END:variables

}