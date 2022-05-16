package learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Qcm implements Exam{
    String idQcm;
    String Qcmqestion;
    String QcmreponseJuste;
    String QcmreponseFause;

    public String getQcmqestion() {
        return Qcmqestion;
    }

    public void setQcmqestion(String Qcmqestion) {
        this.Qcmqestion = Qcmqestion;
    }

    public String getQcmreponseJuste() {
        return QcmreponseJuste;
    }

    public void setQcmreponseJuste(String QcmreponseJuste) {
        this.QcmreponseJuste = QcmreponseJuste;
    }

    public String getQcmreponseFause() {
        return QcmreponseFause;
    }

    public void setQcmreponseFause(String QcmreponseFause) {
        this.QcmreponseFause = QcmreponseFause;
    }

    public Qcm(String Qcmqestion, String QcmreponseJuste, String QcmreponseFause) {
        this.Qcmqestion = Qcmqestion;
        this.QcmreponseJuste = QcmreponseJuste;
        this.QcmreponseFause = QcmreponseFause;
    }

    

    public void create(String qst,String repjust,String repFalse) {
         Proxy p= new Proxy();
        try {
            connect = Mysqlconnect.connectdb();
            String sql = "INSERT INTO `qcm` (`question`, `reponseJuste`,`reponseFause`) VALUES (?, ?,?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1, qst);
            prep.setString(2, repjust);
            prep.setString(3, repFalse);
            prep.execute();
            this.NotifyStudent();
            Proxy.pshowStageQcm.close();
            Main l = new Main();
            l.changeScene("platformExam.fxml");
            p.UpdateTableCours();
            //search_user();
        } catch (Exception e) {
            System.err.println("ERRRRRR"+e.getMessage());
          }
    }

    @Override
    public void NotifyStudent() {
        try {
            connect = Mysqlconnect.connectdb();
            String sql = "INSERT INTO `notification` (`content`) VALUES (?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1,"Creation d'un nouveau exam Qcm le "+ new Date());
            prep.execute();
        } catch (Exception e) {
            System.err.println("ERRRRRR"+e.getMessage());
          }
    }
    
     Connection connect=null;
	ResultSet rslt =null;
	PreparedStatement prep =null;
}
