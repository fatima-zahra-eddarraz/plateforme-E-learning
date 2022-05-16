package learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static learn.Mysqlconnect.connectdb;

public abstract class Enseignant extends User {
	public abstract Cours newcourse(String n,String m);
	public void lancementCreationCours(String n,String m) {
		Cours crs = newcourse(n, m);
		crs.creationCours(n,m);
	}
	public void lancementCreationExamQcm(String qst,String repjust,String repFalse) {
		ExamFactory examFactory = new QcmFactory();
		Exam qcdm= examFactory.createExam(qst,repjust,repFalse);
		qcdm.create(qst,repjust,repFalse);

	}
	public void lancementCreationExamInput(String qst,String repjust,String repFalse) {
		ExamFactory examFactory = new InputExamFactory();
		Exam inputExm= examFactory.createExam(qst,repjust,repFalse);
		inputExm.create(qst,repjust,repFalse);

	}

	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Enseignant(Mediateur mediateur, String username) {
		super(mediateur, username);
	}


	public void envoyer(Message m) {
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
