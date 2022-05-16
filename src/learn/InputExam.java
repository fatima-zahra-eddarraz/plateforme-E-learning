package learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class InputExam implements Exam{
    String idInputExam;
    String InputExamqestion;
    String InputExamreponseJuste;
 Connection connect=null;
	ResultSet rslt =null;
	PreparedStatement prep =null;
    

    public void create(String qst,String repjust,String repFalse) {
         Proxy p= new Proxy();
        try {
            connect = Mysqlconnect.connectdb();
            String sql = "INSERT INTO `examinput` ( `question`, `reponseJuste`) VALUES (?, ?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1, qst);
            prep.setString(2, repjust);
            prep.execute();
            this.NotifyStudent();
            Proxy.pshowStageExam.close();
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
            prep.setString(1,"Creation d'un nouveau exam Reel le "+ new Date());
            prep.execute();
        } catch (Exception e) {
            System.err.println("ERRRRRR"+e.getMessage());
          }
    }

    public String getIdInputExam() {
        return idInputExam;
    }

    public void setIdInputExam(String idInputExam) {
        this.idInputExam = idInputExam;
    }

    public String getInputExamqestion() {
        return InputExamqestion;
    }

    public void setInputExamqestion(String InputExamqestion) {
        this.InputExamqestion = InputExamqestion;
    }

    public String getInputExamreponseJuste() {
        return InputExamreponseJuste;
    }

    public void setInputExamreponseJuste(String InputExamreponseJuste) {
        this.InputExamreponseJuste = InputExamreponseJuste;
    }

    public InputExam(String InputExamqestion, String InputExamreponseJuste) {
        this.InputExamqestion = InputExamqestion;
        this.InputExamreponseJuste = InputExamreponseJuste;
    }

   
    
    
}
