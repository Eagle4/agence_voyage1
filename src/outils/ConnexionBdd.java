package outils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class ConnexionBdd {
    
    private ResultSet rs;
    private Statement stmt;
    
    
public ConnexionBdd() throws ClassNotFoundException, SQLException {
    
           Class.forName("oracle.jdbc.OracleDriver");
           Connection con = (Connection) 
           DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test_2","root");
           int typeCo = ResultSet.TYPE_SCROLL_INSENSITIVE; //Cette valeur indique que le curseur peut être déplacé dans les deux sens, mais aussi arbitrairement
           int modeCo = ResultSet.CONCUR_UPDATABLE; //Cette valeur indique que l'on peut modifier les données de la base via le ResultSet.
           this.stmt=con.createStatement(typeCo,modeCo);//recupere l'état de la connexion
           
}

public ResultSet setResultSet(String querySql) throws SQLException{
    ResultSet Etat = this.stmt.executeQuery(querySql);
    return Etat; //retourne l'état de la connexion. renvoi un objet de type ResultSet. Permet le parcours des résultats de la requete.
}

    
}
