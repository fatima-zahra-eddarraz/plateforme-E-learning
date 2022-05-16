package learn;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static learn.Mysqlconnect.connectdb;

public class WeeklyView implements ViewEventCalendar {

    public ObservableList<Event> SelectEvent() {
		Connection conn = connectdb();
        ObservableList<Event> list3 = FXCollections.observableArrayList();
        try { 
            PreparedStatement ps = conn.prepareStatement("select * from event where yearweek(`date`) = yearweek(now());");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                list3.add(new Event(rs.getString("name"), rs.getDate("date"), rs.getString("startTime"), rs.getString("endTime"), rs.getString("description")));
            }
             System.out.println("SIZE MSSG   "+list3.size());
        } catch (Exception e) {
            System.out.println("erreeer Messg Data    "+e.getMessage());
        }
        return list3;
		
	}
}
