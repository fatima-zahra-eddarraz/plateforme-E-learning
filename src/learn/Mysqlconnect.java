package learn;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mysqlconnect {
    Connection conn=null;
    public static Connection connectdb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/Design","root","");
            return conn;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
    
    public static ObservableList<Cours> getDataCours(){
        Connection conn = connectdb();
        ObservableList<Cours> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Cours");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list.add(new CoursImpl(rs.getString("libelle"), rs.getString("description"), rs.getString("dateCreation")));
            }
        } catch (Exception e) {
            System.out.println("erreeeeur CoursData     "+e.getMessage());
        }
        return list;
    }
    public static ObservableList<InputExam> getDataExam(){
        Connection conn = connectdb();
        ObservableList<InputExam> list1 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Examinput");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list1.add(new InputExam(rs.getString("question"), rs.getString("reponseJuste")));
            }
        } catch (Exception e) {
            System.out.println("erreeeeur ExamData     "+e.getMessage());
        }
        return list1;
    }
    public static ObservableList<Qcm> getDataQcm(){
        Connection conn = connectdb();
        ObservableList<Qcm> list2 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Qcm");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list2.add(new Qcm(rs.getString("question"), rs.getString("reponseJuste"), rs.getString("reponseFause")));
            }
        } catch (Exception e) {
            System.out.println("erreeeeur QcmData     "+e.getMessage());
        }
        System.out.println(list2.size());
        return list2;
    }
    public static ObservableList<Message> getDataMessage(String Dest){
        Connection conn = connectdb();
        ObservableList<Message> list3 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM message WHERE destinataire = ?");
            ps.setString(1, Dest);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list3.add(new Message(rs.getString("contenu"), rs.getString("expediteur"), rs.getString("destinataire")));
            }
             System.out.println("SIZE MSSG   "+list3.size());
        } catch (Exception e) {
            System.out.println("erreeer Messg Data    "+e.getMessage());
        }
        return list3;
    }
    
    public static ObservableList<Notif> getDataNotif(){
        Connection conn = connectdb();
        ObservableList<Notif> list5 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM notification");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list5.add(new Notif(rs.getString("content")));
            }
             System.out.println("SIZE MSSG   "+list5.size());
        } catch (Exception e) {
            System.out.println("erreeer Messg Data    "+e.getMessage());
        }
        return list5;
    }
}

