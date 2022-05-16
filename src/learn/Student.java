package learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static learn.Mysqlconnect.connectdb;

public class Student extends User {

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(Mediateur mediateur, String nom) {
		super(mediateur, nom);
		// TODO Auto-generated constructor stub
	}


	public void envoyer(Message m) {
		System.out.println("Envoie Message ");
		mediateur.TransmettreMsg(m);
	}

	
	public ObservableList<Message> recevoir(String m) {
	
        Connection conn = connectdb();
        ObservableList<Message> list3 = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM message WHERE destinataire = ?");
            ps.setString(1, m);
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
		
	

}
