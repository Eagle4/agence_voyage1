/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import java.awt.Checkbox;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import outils.ButtonEditor;
import outils.ConnexionBdd;
import outils.TableModel;

/**
 *
 * @author jonathan
 */
public class MainWindow extends javax.swing.JFrame {


    /**
     * Creates new form MainWindow
     */
    public MainWindow() throws ClassNotFoundException {
 
            initComponents();
            remplirJtable();
            System.out.print("nb ligne :"+jTable2.getRowCount());
            System.out.println(" nb col :"+jTable2.getColumnCount()+"__");
            jBtnMaj.setVisible(false); //cache le bouton de validation
            panel1.setVisible(true); //affiche le pannel qui cache la jtable1 pour l'insertion d'une ligne dans la bdd
          

    }
    
    private void remplirJtable(){
        
            try {
                
                System.out.println("ActionListener : action sur " + jComboBox1.getSelectedItem());
                String value = (String) jComboBox1.getSelectedItem();
                ConnexionBdd con = new ConnexionBdd();
                
               
                switch (value)
                {
                    case "Circuit" :             
                        String sql ="select * from circuit";
                        String[] enteteCircuit = { "Id", "Descriptif", "VilleDepart", "VilleDarrive", "PaysArrive","DateDepart","NbPlaceDisponible","Duree","Prix"};
                    
                        TableModel model = new TableModel(con,sql,enteteCircuit);                        
                        jTable2.setModel(model);
                        java.util.Date todayDate = new java.util.Date();
                        //DateFormat todayDate = new SimpleDateFormat("MM-dd-yy");
                        jTable1.setModel(new javax.swing.table.DefaultTableModel( new Object [][] {{null, null, null, null,null,todayDate}},enteteCircuit));
                                                   
                        ; break;
                    case "Réserver" : 
                        String sqlTabReserv ="select * from reserver";
                        String[] enteteReserver = { "Idreserv", "nbplace", "datereserv", "id", "idclient" };
                            
                        TableModel model2 = new TableModel(con,sqlTabReserv,enteteReserver);
                        jTable2.setModel(model2);
                        jTable1.setModel(new javax.swing.table.DefaultTableModel( new Object [][] {{null, null, null, null}},enteteReserver));

                         ; break;
                    
                    case "Etape" : 
                        String sqlTabEtape ="select * from etape";
                        String[] enteteEtape = { "Ordre","pays", "dateetape", "duree","id","nomlieu","ville" };
                    
                        TableModel model3 = new TableModel(con,sqlTabEtape,enteteEtape);
                        jTable2.setModel(model3);
                        jTable1.setModel(new javax.swing.table.DefaultTableModel( new Object [][] {{null, null, null, null}},enteteEtape));
                        
                        ; break;
                     
                    case "Client" : 
                        String sqlTabClient ="select * from client";
                        String[] enteteClient = { "Idclient", "nom", "prenom", "datenaiss", "numtel" };
                    
                        TableModel model4 = new TableModel(con,sqlTabClient,enteteClient);
                        jTable2.setModel(model4); 
                        jTable1.setModel(new javax.swing.table.DefaultTableModel( new Object [][] {{null, null, null, null}},enteteClient));

                        ; break;  
                     
                    case "Lieux à visiter" : 
                        String sqlTabLieux ="select * from lieuxavisiter";
                        String[] enteteLieux = { "nomlieu", "ville", "pays", "descriptif", "prix" };
                    
                        TableModel model5 = new TableModel(con,sqlTabLieux,enteteLieux);
                        jTable2.setModel(model5);
                        jTable1.setModel(new javax.swing.table.DefaultTableModel( new Object [][] {{null, null, null, null}},enteteLieux));
                    
                        ; break;      
                           
                    
                    
                }
            
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBtnMaj = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnModifier = new javax.swing.JButton();
        jBtnSuppr = new javax.swing.JButton();
        jBtnNewRow = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setCellSelectionEnabled(true);
        jTable2.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jTable2AncestorResized(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jScrollPane2.setBounds(10, 10, 660, 270);
        jDesktopPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jBtnMaj.setText("insérer infos");
        jBtnMaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMajActionPerformed(evt);
            }
        });
        jBtnMaj.setBounds(580, 310, 100, 23);
        jDesktopPane1.add(jBtnMaj, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panel1.setEnabled(false);
        panel1.setName(""); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panel1, org.jdesktop.beansbinding.ELProperty.create("false"), panel1, org.jdesktop.beansbinding.BeanProperty.create("visible"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        panel1.setBounds(-150, 290, 850, 130);
        jDesktopPane1.add(panel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setBounds(10, 290, 560, 60);
        jDesktopPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Circuit", "Etape", "Lieux à visiter", "Client", "Réserver" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Choisissez une table :");

        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        jBtnSuppr.setText("Supprimer");
        jBtnSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprActionPerformed(evt);
            }
        });

        jBtnNewRow.setText("ajouter une ligne");
        jBtnNewRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNewRowActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModifier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jBtnNewRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnModifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSuppr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnNewRow)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(jDesktopPane1)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        remplirJtable();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable2AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable2AncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2AncestorResized
    
    public Object[] getRow(JTable nomjTable,int IndexRow){
        Object[] tabObj = new Object[nomjTable.getColumnCount()];
            for(int i = 0;i< nomjTable.getColumnCount();i++){
                //JOptionPane.showMessageDialog(null,"getvalueat("+IndexRow+","+i+")="+jTable2.getModel().getValueAt(IndexRow,i));
                tabObj[i] = nomjTable.getModel().getValueAt(IndexRow,i);
                //System.out.print("getvalueat("+IndexRow+","+i+")");
            }
            String resTab = "[";
            //System.out.print("contenu du tabobj = [");
            for(int i = 0;i< nomjTable.getColumnCount();i++){
                resTab+=tabObj[i]+",";
                //System.out.print(tabObj[i]+",");
            }
            resTab+="]";
            System.out.print(resTab);
            JOptionPane.showMessageDialog(null,resTab);
        return tabObj; 
    }
    
    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        try {
            final ConnexionBdd con2 = new ConnexionBdd();
            
                JOptionPane.showMessageDialog(null,"cliquez sur la ligne à modifier");
          jTable2.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
            int row = jTable2.rowAtPoint(p);
            int col = jTable2.columnAtPoint(p); 
            Object champsTable = jTable2.getModel().getColumnName(col);
            //JOptionPane.showMessageDialog(null,"champ cliké: "+champsTable);
            Object valueId = jTable2.getModel().getValueAt(row, 0);
            String tableSelect = (String) jComboBox1.getSelectedItem();
            //JOptionPane.showMessageDialog(null,"table: "+tableSelect);
            String input = JOptionPane.showInputDialog(null,"Enter Cell Value:");
           
            int nbcolModif =0;
              try {
                  System.out.println("update "+tableSelect+" set "+champsTable+" = '"+input+"' where id="+valueId);
                  nbcolModif = con2.getEtatObjCon().executeUpdate("update "+tableSelect+" set "+champsTable+" = '"+input+"' where id='"+valueId+"'");
                  
              } catch (SQLException ex) {
                  Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
              }
            System.out.println("nb de ligne modifié = "+nbcolModif);
            remplirJtable();
            jTable2.removeMouseListener(this);
            jTable2.removeMouseMotionListener(this);
            
            
            //JOptionPane.showMessageDialog(null,"row: "+row+"col :"+col);
           
          //jTable2.setValueAt(JOptionPane.showInputDialog(null,"Enter Cell Value:"),jTable2.getSelectedRow(),jTable2.getSelectedColumn());
          // System.out.print("iscelleditable:"+jTable2.isCellEditable(row, col));
            if (jTable2.isCellEditable(row, col)) {
                boolean editCellAt = jTable2.editCellAt(row, col);
             // jTable2.getEditorComponent().requestFocus(); 

            }
           
          }
          
        });        // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    private void jBtnSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprActionPerformed
        try {
          final ConnexionBdd con2 = new ConnexionBdd(); 
          JOptionPane.showMessageDialog(null,"cliquez sur la ligne à supprimer");
          jTable2.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
            int row = jTable2.rowAtPoint(p);
            Object tableIdValue = jTable2.getModel().getValueAt(row, 0); //recup valeur de l'id de la table selectionné
            System.out.println("valeur de id :"+tableIdValue);
            int col = jTable2.columnAtPoint(p);
            Object nameOfField = jTable2.getModel().getColumnName(col); //recup le nom du champ dans la bdd (en tete de la table model)
            System.out.println("champs selectioné :"+nameOfField);
            String tableSelected = (String) jComboBox1.getSelectedItem();
            System.out.println("table selectionne :"+tableSelected);
            System.out.println("delete from "+tableSelected+" where "+nameOfField+" = "+tableIdValue);
            int nbcolModif = 0;
              try {
                  nbcolModif = con2.getEtatObjCon().executeUpdate("delete from "+tableSelected+" where "+nameOfField+" = "+tableIdValue);
             
              } catch (SQLException ex) {
                  Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
              }
            //jTextArea1.setText(querySql);
            System.out.println("nb de ligne modifié = "+nbcolModif);
            remplirJtable();
            jTable2.removeMouseListener(this);
            jTable2.removeMouseMotionListener(this);
                      
            //JOptionPane.showMessageDialog(null,"row: "+row+"col :"+col);
           
          //jTable2.setValueAt(JOptionPane.showInputDialog(null,"Enter Cell Value:"),jTable2.getSelectedRow(),jTable2.getSelectedColumn());
          // System.out.print("iscelleditable:"+jTable2.isCellEditable(row, col));
            if (jTable2.isCellEditable(row,row)) { //row,col
                boolean editCellAt = jTable2.editCellAt(row, row);
             // jTable2.getEditorComponent().requestFocus(); 

            }
           
          }
          
        });        // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnSupprActionPerformed

    private void jBtnNewRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNewRowActionPerformed
        jBtnMaj.setVisible(true);
        panel1.setVisible(false);
     
       
    }//GEN-LAST:event_jBtnNewRowActionPerformed

    private void jBtnMajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMajActionPerformed
        try {
            jBtnMaj.setVisible(false);
            panel1.setVisible(true);
            //getRow(jTable1,0);
            int nbColModif = 0;
            final ConnexionBdd con = new ConnexionBdd();
            String tableSelected = (String) jComboBox1.getSelectedItem();
             //jLabel2.setText("table: "+tableSelected);
            //Point p = e.getPoint();
            //int col = jTable1.columnAtPoint(p);
              String querySql = "insert into "+tableSelected+" (";
           // System.out.println("taille"+jTable1.getColumnCount());
            //System.out.println(querySql);
            for(int i=0; i<jTable1.getColumnCount();i++){
                String nameOfField = jTable1.getModel().getColumnName(i);
                if(i!=jTable1.getColumnCount()-1){
                  querySql += nameOfField+"," ;  
                }else{
                  querySql += nameOfField+") values (";
                }
            }
            
            for(int i=0; i<jTable1.getColumnCount();i++){
                Object fieldValue = jTable1.getModel().getValueAt(0,i);
                if (fieldValue == null){
                    System.out.println("vaut null");
                    fieldValue = ""; 
                }
                if(i!=jTable1.getColumnCount()-1){
                  querySql += "'"+fieldValue+"'," ;  
                }else{
                  querySql += fieldValue+")";
                }
                
            }
            
            System.out.println(querySql);
            jTextArea1.setText(querySql);
            nbColModif = con.getEtatObjCon().executeUpdate(querySql);
            remplirJtable();

           //System.out.println(jTable1.getValueAt(0,0)); 
           /* UPDATE table
     SET colonne_1 = 'valeur 1', colonne_2 = 'valeur 2', colonne_3 = 'valeur 3'
     WHERE condition */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            String obj = ex.toString();
            jTextArea1.setText(obj);
            //jLabel2.setText(obj);
            //jTextField1.setText(obj);
            //JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_jBtnMajActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton jBtnMaj;
    private javax.swing.JButton jBtnNewRow;
    private javax.swing.JButton jBtnSuppr;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Panel panel1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void JButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
