package learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MediateurImpl1 extends Mediateur{
	
 Connection connect=null;
	ResultSet rslt =null;
	PreparedStatement prep =null;
	@Override
	public void TransmettreMsg(Message m) {
		Proxy p= new Proxy();
        try {
            connect = Mysqlconnect.connectdb();
            String sql = "INSERT INTO `message` (`contenu`, `expediteur`, `destinataire`) VALUES (?, ?,?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1, m.getContent());
            prep.setString(2, m.getExpediteur());
            prep.setString(3, m.getDestinataire());
            prep.execute();
            Proxy.pshowStageMessageProf.close();
            if(m.getExpediteur()=="student"){
                Main l = new Main();
            l.changeScene("pltstudentMssg.fxml");
            }else if(m.getExpediteur()=="admin"){
                Main l = new Main();
            l.changeScene("platformMssg.fxml");
            }
            p.UpdateTableCours();
        } catch (Exception e) {
            System.err.println("ERRRRRR"+e.getMessage());
          }
	}

}
