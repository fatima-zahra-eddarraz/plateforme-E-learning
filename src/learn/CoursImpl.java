package learn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author alsakb1
 */
public class CoursImpl extends Cours {
    Connection connect=null;
	ResultSet rslt =null;
	PreparedStatement prep =null;
public CoursImpl(String libelle, String description, String dateCreation) {
		super(libelle, description, dateCreation);
	}
public CoursImpl(String libelle, String description) {
		super(libelle, description);
	}

    /**
     *
     * @param n
     * @param m
     * @param s
     * @throws IOException
     */
     public void creationCours(String n,String m){  
        // System.out.println(n+"    "+m+"      ");
        Proxy p= new Proxy();
        try {
            connect = Mysqlconnect.connectdb();
            String sql = "INSERT INTO `cours` (`libelle`, `description`,`dateCreation`) VALUES (?, ?,?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1, n);
            prep.setString(2, m);
            prep.setString(3, new Date().toString());
            prep.execute();
            this.NotifyStudent(n);
            Proxy.pshowStage.close();
            Main l = new Main();
            l.changeScene("platform.fxml");
            p.UpdateTableCours();
            //search_user();
        } catch (Exception e) {
            System.err.println("ERRRRRR"+e.getMessage());
          }
        
        
        
	}

    
    public void NotifyStudent(String n) {
         try {
            connect = Mysqlconnect.connectdb();
            String sql = "INSERT INTO `notification` (`content`) VALUES (?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1,"Creation d'un nouveau cours, sont Libelle est :"+n+" le :"+ new Date());
            prep.execute();
        } catch (Exception e) {
            System.err.println("ERRRRRR"+e.getMessage());
          }
    }

}

