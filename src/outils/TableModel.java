package outils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;




public class TableModel extends AbstractTableModel {
    
    private ConnexionBdd connecter;
    private String[] tabEntete;
    ResultSet rs;
   // Object[] data;
    
    public TableModel(ConnexionBdd conOracle,String querySql,String[] chaineEntete) throws SQLException{
        this.connecter = conOracle;
        this.tabEntete = chaineEntete;
        this.rs = this.connecter.setResultSet(querySql); 
        //this.data = getRow(0);
    }
/*
    public TableModel(Object[] data,String[] chaineEntete){

            this.data = data;
            this.tabEntete = chaineEntete;
        }
 */   
    
    @Override
    public String getColumnName(int columnIndex) {
	return tabEntete[columnIndex];
    }
    
    @Override
    public int getColumnCount() {
	return tabEntete.length;
    }
	
    @Override
    public int getRowCount() {
     int i = 0;
     try 
     {         
         boolean last = this.rs.last();
         i = rs.getRow();
     } 
     catch (SQLException ex) 
     {
           Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
     }
        return i;
            
    }
    
    public Object[] getRow(int Indexrow){
        Object[][] tabObj = new Object[getRowCount()][getColumnCount()];
        for(int i = 0;i< getRowCount();i++){
            for(int j = 0;j< getColumnCount();j++){
                //JOptionPane.showMessageDialog(null,"getvalueat("+i+","+j+")="+jTable2.getModel().getValueAt(IndexRow,i));
                tabObj[i][j] = getValueAt(i,j);
            }
        }
        return tabObj; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj =null;
        try {
            this.rs.absolute(rowIndex+1);
            obj = this.rs.getObject(columnIndex + 1);
            //System.out.println(obj);
        } catch (SQLException ex) {
            Logger.getLogger(TableModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur :"+ex);
        }
       return obj;
             
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
      }
    
    
    /*
    @Override
    public void setValueAt(ResultSet rs, int row, int col){
        this.data[row][col] = obj;
    }
    
    public void setObjectData(Object[] tab){
        this.rs = this.connecter.setResultSet(querySql);
    }
    */
}


    

