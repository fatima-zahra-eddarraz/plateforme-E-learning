package learn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class User {

	protected Mediateur mediateur;
	protected String nom;
	public abstract void envoyer(Message m);
	public abstract ObservableList<Message> recevoir(String m);
	public User(Mediateur mediateur, String nom) {
		super();
		this.mediateur = mediateur;
		this.nom = nom;
		mediateur.addColl(nom, this);
	}

    public User(String nom) {
        this.nom = nom;
    }
        
	public ObservableList<Event>  executeMonthlyView() {
               ObservableList<Event> list1 = FXCollections.observableArrayList();
		ViewEventCalendar strategy = new MonthlyView();
		list1 =strategy.SelectEvent();
                return list1;
	}
	public ObservableList<Event>  executeDailyView() {
        ObservableList<Event> list2 = FXCollections.observableArrayList();

		ViewEventCalendar strategy = new DailyView();
		list2=strategy.SelectEvent();
                return list2;
	}
	public ObservableList<Event>  executeWeeklyView() {
               ObservableList<Event> list3 = FXCollections.observableArrayList();
		ViewEventCalendar strategy = new WeeklyView();
		list3 =strategy.SelectEvent();
                return list3;
	}
	public ObservableList<Event> executeAgendaView() {
                ObservableList<Event> list4 = FXCollections.observableArrayList();
		ViewEventCalendar strategy = new AgendaView();
		 list4 =strategy.SelectEvent();
                return list4;
	}

	public User() {
		super();
	}
	public Mediateur getMediateur() {
		return mediateur;
	}
	public void setMediateur(Mediateur mediateur) {
		this.mediateur = mediateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
