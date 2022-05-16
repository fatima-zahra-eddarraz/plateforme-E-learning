package learn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;





public class Proxy implements Initializable,Plateform{
    
    
 ObservableList<Cours> dataCours= FXCollections.observableArrayList();
 ObservableList<Qcm> dataQcm= FXCollections.observableArrayList();
 ObservableList<InputExam> dataInputExam= FXCollections.observableArrayList();
 ObservableList<Message> dataMessage= FXCollections.observableArrayList();
 ObservableList<Message> dataMessageStudent= FXCollections.observableArrayList();
   ObservableList<Event> dataEventDay= FXCollections.observableArrayList();
 ObservableList<Event> dataEventWeek= FXCollections.observableArrayList();
 ObservableList<Event> dataEventMonth= FXCollections.observableArrayList();
 ObservableList<Event> dataEventAgenda= FXCollections.observableArrayList();
ObservableList<Notif> dataNotif= FXCollections.observableArrayList();

    
 


   
 
        @FXML
        private AnchorPane paneNewCours;

        @FXML
        private TextField addNameCourse;

        @FXML
        private TextArea AddContentCourse;

        @FXML
        private Button ButtAjouterCours;

   
	@FXML
	private Button stdlogout;

	@FXML
	private Button stdCourse;

	@FXML
	private Button stdbuttonMsg;

	@FXML
	private Button stdbuttonCald;

	@FXML
	private Button stdbuttonNotif;

	@FXML
	private AnchorPane stdCoursePanel;

	@FXML
	private AnchorPane stdCalendarPanel;

	@FXML
	private AnchorPane stdMessagePanel;

	@FXML
	private AnchorPane NotifPanel;


	@FXML
	private Button buttonMsg;

	@FXML
	private Button buttonCald;
	@FXML
	private AnchorPane in;
	@FXML
	private AnchorPane up;
	@FXML
	private PasswordField password;

	@FXML
	private TextField username;
        @FXML
        private Button ButtonCreatepopupCours;

	@FXML
	private Button loginButtonStudent;

	@FXML
	private Button loginButtonAdmin;

	@FXML
	private Button signUp;

	@FXML
	private Label wrongLogIn;

	@FXML
	private TextField FirstName;

	@FXML
	private TextField LastName;

	@FXML
	private TextField UsernameSignup;

	@FXML
	private PasswordField PasswordSignup;

	@FXML
	private TextField Email;
	@FXML
	private Button logout;
	@FXML
	private Button CourseNew;

	@FXML
	private Button NewExam;

	@FXML
	private AnchorPane CoursePanel;

	@FXML
	private AnchorPane ExamPanel;
	@FXML
	private AnchorPane CalendarPanel;

	@FXML
	private AnchorPane MessagePanel;
        @FXML
        private AnchorPane paneCours;

    

         @FXML
        private TableView<Cours> tableViewCours = new TableView<>();

        @FXML
        private TableColumn<Cours, String> colCourseLibelle= new TableColumn<>("libelle");

         @FXML
        private TableColumn<Cours, String> colCourseContent=new TableColumn<>("description");

        @FXML
        private TableColumn<Cours, String> colCourseDate=new TableColumn<>("dateCreation");

        @FXML
        private TableView<Cours> tableViewCoursStudent = new TableView<>();

        @FXML
        private TableColumn<Cours, String> colCourseLibelleStudent= new TableColumn<>("libelle");

         @FXML
        private TableColumn<Cours, String> colCourseContentStudent=new TableColumn<>("description");

        @FXML
        private TableColumn<Cours, String> colCourseDateStudent=new TableColumn<>("dateCreation");

        
  
 
    @FXML
    private TableView<Qcm> tableViewQcm= new TableView<>();
    @FXML
    private TableColumn<Qcm, String> qcmQst= new TableColumn<Qcm,String>("qestion");

    @FXML
    private TableColumn<Qcm, String> qcmRepJuste= new TableColumn<Qcm,String>("reponseJuste");

    @FXML
    private TableColumn<Qcm, String> qcmRepFauss= new TableColumn<Qcm,String>("reponseFause");

   

    @FXML
    private TableView<InputExam> tableViewExam = new TableView<>();
    @FXML
    private TableColumn<InputExam, String> ExamQst = new TableColumn<InputExam,String>("qestion");

    @FXML
    private TableColumn<InputExam, String> ExamReponse= new TableColumn<InputExam,String>("reponseJuste");

   
    @FXML
    private TableView<Event> tableViewDayEvent= new TableView<Event>();
   
    @FXML
    private TableColumn<Event, String> ColNameDayEvent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescDayEvent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateDayEvent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeDayEvent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeDayEvent=new TableColumn<Event, String>("endTime");

    
    @FXML
    private TableView<Event> tableViewWeekEvent= new TableView<Event>();
    
    @FXML
    private TableColumn<Event, String> ColNameWeekEvent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescWeekEvent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateWeekEvent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeWeekEvent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeWeekEvent=new TableColumn<Event, String>("endTime");

    @FXML
    private TableView<Event> tableViewMonthEvent= new TableView<Event>();
    
    @FXML
    private TableColumn<Event, String> ColNameMonthEvent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescMonthEvent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateMonthEvent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeMonthEvent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeMonthEvent=new TableColumn<Event, String>("endTime");

    
     @FXML
    private TableView<Event> tableViewAgendaEvent= new TableView<Event>();

   @FXML
    private TableColumn<Event, String> ColNameAgendaEvent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescAgendaEvent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateAgendaEvent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeAgendaEvent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeAgendaEvent=new TableColumn<Event, String>("endTime");


    
   
    @FXML
    private TableView<Event> tableViewDayEventStudent= new TableView<Event>();
   
    @FXML
    private TableColumn<Event, String> ColNameDayEventStudent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescDayEventStudent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateDayEventStudent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeDayEventStudent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeDayEventStudent=new TableColumn<Event, String>("endTime");

    
    @FXML
    private TableView<Event> tableViewWeekEventStudent= new TableView<Event>();
    
    @FXML
    private TableColumn<Event, String> ColNameWeekEventStudent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescWeekEventStudent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateWeekEventStudent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeWeekEventStudent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeWeekEventStudent=new TableColumn<Event, String>("endTime");

    @FXML
    private TableView<Event> tableViewMonthEventStudent= new TableView<Event>();
    
    @FXML
    private TableColumn<Event, String> ColNameMonthEventStudent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescMonthEventStudent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateMonthEventStudent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeMonthEventStudent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeMonthEventStudent=new TableColumn<Event, String>("endTime");

    
     @FXML
    private TableView<Event> tableViewAgendaEventStudent= new TableView<Event>();

   @FXML
    private TableColumn<Event, String> ColNameAgendaEventStudent=new TableColumn<Event, String>("name");

    @FXML
    private TableColumn<Event, String> ColDescAgendaEventStudent=new TableColumn<Event, String>("description");

    @FXML
    private TableColumn<Event, Date> ColDateAgendaEventStudent=new TableColumn<Event, Date>("date");

    @FXML
    private TableColumn<Event, String> ColStartTimeAgendaEventStudent=new TableColumn<Event, String>("startTime");

    @FXML
    private TableColumn<Event, String> ColEndTimeAgendaEventStudent=new TableColumn<Event, String>("endTime");

    @FXML
    private TableView<Message> tableViewMessage = new TableView<Message>();

    @FXML
    private TableColumn<Message, String> colviewMessgSenderProf=new TableColumn<Message, String>("expediteur");

    @FXML
    private TableColumn<Message, String> colviewMessgContentProf=new TableColumn<Message, String>("contenu");
    
    @FXML
    private TableView<Message> tableViewMessageStudent = new TableView<Message>();

    @FXML
    private TableColumn<Message, String> colviewMessgSenderStudent=new TableColumn<Message, String>("expediteur");

    @FXML
    private TableColumn<Message, String> colviewMessgContentStudent=new TableColumn<Message, String>("contenu");
    
    @FXML
    private TableView<Notif> TableNotif=new TableView<Notif>();

    @FXML
    private TableColumn<Notif, String> CollNotif= new TableColumn<Notif, String>("content");

    
    
    
    @FXML
    private TextField AddDestinationUsernameStudent = new TextField();

    @FXML
    private TextArea AddContentMessageStudent = new TextArea();

    @FXML
    private Button ButtSendMssgStudent;

    @FXML
    private TextField addMessExpStudent= new TextField();

    
    
    
    @FXML
    private AnchorPane paneNewExam;

    @FXML
    private TextField addExamQuestion;

    @FXML
    private TextArea AddExamReponse;

    @FXML
    private Button ButtAjouterExam;
    @FXML
    private AnchorPane paneNewQcm;

    @FXML
    private TextField addQcmQuestion;

    @FXML
    private TextArea AddQcmReponseJuste;

    @FXML
    private Button ButtAjouterQcm;

    @FXML
    private TextArea AddQcmReponseFalse;
 

    @FXML
    private TextField AddDestinationUsernameProf;

    @FXML
    private TextArea AddContentMessageProf;
    @FXML
    private TextField addMessExpProf = new TextField();
    @FXML
    private Button ButtSendMssg;
    User us=new Enseignant() {
     @Override
     public Cours newcourse(String n, String m) {
         return new CoursImpl(n,m);
     }
     public void NotifyStudent() {
     }
 };
    Message msg = new Message("", "", "");

    
    
    
    
    public static Stage pStage;
    public static Stage pshowStage;
    public static Stage pshowStageExam;
    public static Stage pshowStageQcm;
    public static Stage pshowStageMessageProf;


String libelle,content,usernme;
	Connection conn=null;
	ResultSet rs =null;
        	ResultSet rs2 =null;
	PreparedStatement pst =null;


public InternetImpl imp = new InternetImpl();
	@FXML
	void SignUpStudent(ActionEvent event) {
	in.setVisible(false);
	up.setVisible(true);
	}
	@FXML
	void SignupAction(ActionEvent event) throws IOException{
		RegistreStudent();
	}
	@FXML
	void Retour(ActionEvent event) throws IOException{
		in.setVisible(true);
		up.setVisible(false);
	}
	@FXML
	void StudentLogin(ActionEvent event) throws IOException {
		CheckStudentLogin();
	}
	@FXML
	void adminLogin(ActionEvent event) throws IOException {
		CheckadminLogin();
	}
	
        @FXML
    void createpopupCours(ActionEvent event) throws IOException{
            this.showCreateCourse();

    }
        @FXML
    void createpopupExam(ActionEvent event) throws IOException{
        this.showCreateExam();
    }
     @FXML
    void createpopupQcm(ActionEvent event) throws IOException{
        this.showCreateQcm();
    }
    @FXML
    void createpopupMessageProf(ActionEvent event) throws IOException{
        this.showCreateMessageProf();
    }
       @FXML
    void createpopupMessageStudent(ActionEvent event) throws IOException{
        this.showCreateMessageStudent();
    }
    public void userLogOut(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
    
    int index = -1; 
    @FXML
    void getSelected (MouseEvent event){
    index = tableViewCours.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    
    libelle=(colCourseLibelle.getCellData(index).toString());
    content=(colCourseContent.getCellData(index).toString());
    

    }
       public void Delete(){
    conn = Mysqlconnect.connectdb();
    String sql = "DELETE FROM Cours WHERE libelle= ? AND description=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, libelle);
            pst.setString(2, content);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTableCours();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    } 
       public Message username(String nom){
           msg.setExpediteur(nom);
           System.out.println("msg username():" + msg.getExpediteur());
           return msg;
       }
	public void CheckadminLogin() throws IOException {
	conn =Mysqlconnect.connectdb();
	String sql="SELECT * FROM `admin` WHERE `Username`=? AND `Password`=?";
        
		if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "insert username and password");
		}else {
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, username.getText().toString());
				pst.setString(2, password.getText().toString());
				rs = pst.executeQuery();
				if (rs.next()) {
                                    
                                    username(rs.getString("Username"));
                                    addMessExpProf.setText(rs.getString("Username"));
					imp.CheckadminLogin();
				} else {
					JOptionPane.showMessageDialog(null, "invalid Username and password ");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	 public void CheckStudentLogin() throws IOException {
		 conn =Mysqlconnect.connectdb();
		 String sql="SELECT * FROM `student` WHERE `Username`=? AND `Password`=?";
		 if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
			 JOptionPane.showMessageDialog(null, "insert username and password");
		 }else {
			 try {
				 pst = conn.prepareStatement(sql);
				 pst.setString(1, username.getText().toString());
				 pst.setString(2, password.getText().toString());
				 rs = pst.executeQuery();
				 if (rs.next()) {
					 imp.CheckStudentLogin();
				 } else {
					 JOptionPane.showMessageDialog(null, "invalid Username and password ");
				 }
			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(null, e);
			 }
		 }
	}

    public static Stage getPshowStageMessageProf() {
        return pshowStageMessageProf;
    }

    public static void setPshowStageMessageProf(Stage pshowStageMessageProf) {
        Proxy.pshowStageMessageProf = pshowStageMessageProf;
    }

    public static Stage getPshowStageExam() {
        return pshowStageExam;
    }

    public static void setPshowStageExam(Stage pshowStageExam) {
        Proxy.pshowStageExam = pshowStageExam;
    }

    public static Stage getPshowStageQcm() {
        return pshowStageQcm;
    }

    public static void setPshowStageQcm(Stage pshowStageQcm) {
        Proxy.pshowStageQcm = pshowStageQcm;
    }

    public static Stage getPshowStage() {
        return pshowStage;
    }

    public static void setPshowStage(Stage pshowStage) {
        Proxy.pshowStage = pshowStage;
    }

    public static Stage getpStage() {
        return pStage;
    }

    public static void setpStage(Stage pStage) {
        Proxy.pStage = pStage;
    }

	public void RegistreStudent() throws IOException {
		conn = Mysqlconnect.connectdb();
		String sql = "INSERT INTO `student` (`FirstName`, `LastName`, `Username`, `Password`, `Email`) VALUES (?, ?, ?, ?, ?)";
		if(UsernameSignup.getText().toString().isEmpty() || PasswordSignup.getText().toString().isEmpty() || FirstName.getText().toString().isEmpty() || LastName.getText().toString().isEmpty() || Email.getText().toString().isEmpty()  ){
			JOptionPane.showMessageDialog(null, "insert data");
		}else {
			try {
				String test = "SELECT * FROM `student` WHERE `Username`=? AND `Password`=?";
				try {
					pst = conn.prepareStatement(test);
					pst.setString(1, UsernameSignup.getText().toString());
					pst.setString(2, PasswordSignup.getText().toString());
					rs = pst.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "user exist");
					} else {
						pst = conn.prepareStatement(sql);
						pst.setString(1, FirstName.getText().toString());
						pst.setString(2, LastName.getText().toString());
						pst.setString(3, UsernameSignup.getText().toString());
						pst.setString(4, PasswordSignup.getText().toString());
						pst.setString(5, Email.getText().toString());
						pst.execute();
						imp.RegistreStudent();
						up.setVisible(false);
						in.setVisible(true);

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}


			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	@FXML
	void FormCours(ActionEvent event) {
		CoursePanel.setVisible(true);
		ExamPanel.setVisible(false);
                MessagePanel.setVisible(false);
		CalendarPanel.setVisible(false);
	}

    public AnchorPane getCoursePanel() {
        return CoursePanel;
    }

    public void setCoursePanel(AnchorPane CoursePanel) {
        this.CoursePanel = CoursePanel;
    }

    public AnchorPane getExamPanel() {
        return ExamPanel;
    }

    public void setExamPanel(AnchorPane ExamPanel) {
        this.ExamPanel = ExamPanel;
    }

    public AnchorPane getCalendarPanel() {
        return CalendarPanel;
    }

    public void setCalendarPanel(AnchorPane CalendarPanel) {
        this.CalendarPanel = CalendarPanel;
    }

    public AnchorPane getMessagePanel() {
        return MessagePanel;
    }

    public void setMessagePanel(AnchorPane MessagePanel) {
        this.MessagePanel = MessagePanel;
    }

	@FXML
	void FormExam(ActionEvent event) {
		ExamPanel.setVisible(true);
		CoursePanel.setVisible(false);
		MessagePanel.setVisible(false);
		CalendarPanel.setVisible(false);
	}
	@FXML
	void pageCld(ActionEvent event) {
		CalendarPanel.setVisible(true);
		CoursePanel.setVisible(false);
		ExamPanel.setVisible(false);
		MessagePanel.setVisible(false);

	}

	@FXML
	void pageMsg(ActionEvent event) {
		MessagePanel.setVisible(true);
		CoursePanel.setVisible(false);
		ExamPanel.setVisible(false);
		CalendarPanel.setVisible(false);
	}
	@FXML
	void StdLogOut(ActionEvent event) throws IOException{
		Main n = new Main();
		n.changeScene("Login.fxml");
	}

	@FXML
	void stdPageCours(ActionEvent event) {
		stdCoursePanel.setVisible(true);
		stdCalendarPanel.setVisible(false);
		stdMessagePanel.setVisible(false);
		NotifPanel.setVisible(false);
	}

	@FXML
	void stdpageCld(ActionEvent event) {
		stdCalendarPanel.setVisible(true);
		stdCoursePanel.setVisible(false);
		stdMessagePanel.setVisible(false);
		NotifPanel.setVisible(false);

	}

	@FXML
	void stdpageCldNotif(ActionEvent event) {
		NotifPanel.setVisible(true);
		stdCalendarPanel.setVisible(false);
		stdCoursePanel.setVisible(false);
		stdMessagePanel.setVisible(false);

	}
	@FXML
	void stdpageMsg(ActionEvent event) {
		stdMessagePanel.setVisible(true);
		NotifPanel.setVisible(false);
		stdCalendarPanel.setVisible(false);
		stdCoursePanel.setVisible(false);
	}

         
         @FXML
        void AjouterCours(ActionEvent event)  throws IOException{
          Enseignant ensg= new EnseignantImpl();
          ensg.lancementCreationCours(addNameCourse.getText().toString(), AddContentCourse.getText().toString());
          addNameCourse.setText(" ");
          AddContentCourse.setText(" ");            
        }
        
        
public void UpdateTableCours(){   
    dataCours = Mysqlconnect.getDataCours();
      
    try {
         colCourseDate.setCellValueFactory(new PropertyValueFactory<Cours,String>("dateCreation"));
         colCourseContent.setCellValueFactory(new PropertyValueFactory<Cours,String>("description"));
         colCourseLibelle.setCellValueFactory(new PropertyValueFactory<Cours,String>("libelle"));
         tableViewCours.setItems(dataCours);
    } catch (Exception e) {
      System.out.println("erreeeeur cours     "+e.getMessage());
    }
   
}
public void UpdateTableCoursStudent(){   
    dataCours = Mysqlconnect.getDataCours();
      
    try {
         colCourseDateStudent.setCellValueFactory(new PropertyValueFactory<Cours,String>("dateCreation"));
         colCourseContentStudent.setCellValueFactory(new PropertyValueFactory<Cours,String>("description"));
         colCourseLibelleStudent.setCellValueFactory(new PropertyValueFactory<Cours,String>("libelle"));
         tableViewCoursStudent.setItems(dataCours);
    } catch (Exception e) {
      System.out.println("erreeeeur cours     "+e.getMessage());
    }
   
}
public void UpdateTableQcm(){   
    dataQcm = Mysqlconnect.getDataQcm();
    try {
         qcmQst.setCellValueFactory(new PropertyValueFactory<Qcm,String>("Qcmqestion"));
         qcmRepJuste.setCellValueFactory(new PropertyValueFactory<Qcm,String>("QcmreponseJuste"));
         qcmRepFauss.setCellValueFactory(new PropertyValueFactory<Qcm,String>("QcmreponseFause"));
         System.out.println("data qst :"+qcmQst.getCellData(1));
       
         tableViewQcm.setItems(dataQcm);
    } catch (Exception e) {
      System.out.println("erreeeeur Qcm     "+e.getMessage());
    }
   
}
public void UpdateTableNotif(){   
    dataNotif = Mysqlconnect.getDataNotif();
    try {
         CollNotif.setCellValueFactory(new PropertyValueFactory<Notif,String>("content"));       
         TableNotif.setItems(dataNotif);
    } catch (Exception e) {
      System.out.println("erreeeeur NOTIF     "+e.getMessage());
    }
   
}

public void UpdateTableExamInput(){   
    dataInputExam = Mysqlconnect.getDataExam();
      
    try {
         ExamQst.setCellValueFactory(new PropertyValueFactory<InputExam,String>("InputExamqestion"));
         ExamReponse.setCellValueFactory(new PropertyValueFactory<InputExam,String>("InputExamreponseJuste"));
         tableViewExam.setItems(dataInputExam);
    } catch (Exception e) {
      System.out.println("erreeeeur Exam     "+e.getMessage());
    }
   
}
   public void UpdateTableMessage(){ 
       Mediateur med=new MediateurImpl1();
        User prof = new Enseignant(med, usernme) {
            @Override
            public Cours newcourse(String n, String m) { 
                return new CoursImpl(n,m);
              }
           
        };
       dataMessage = prof.recevoir("admin");      
    try {
         colviewMessgSenderProf.setCellValueFactory(new PropertyValueFactory<Message,String>("expediteur"));
         colviewMessgContentProf.setCellValueFactory(new PropertyValueFactory<Message,String>("content"));
         tableViewMessage.setItems(dataMessage);
    } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
   
} 
   public void UpdateTableMessageStudent(){ 
       Mediateur med=new MediateurImpl1();
        User prof = new Student(med, usernme);
       dataMessageStudent = prof.recevoir("student");      
    try {
         colviewMessgSenderStudent.setCellValueFactory(new PropertyValueFactory<Message,String>("expediteur"));
         colviewMessgContentStudent.setCellValueFactory(new PropertyValueFactory<Message,String>("content"));
         tableViewMessageStudent.setItems(dataMessageStudent);
    } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   }
        public void showCreateCourse() throws IOException{
            try {
                    Stage primaryStage = new Stage(); 
            Parent loader = FXMLLoader.load(getClass().getResource("PopnewCourse.fxml"));
        primaryStage.setTitle("e-learning");
        primaryStage.setScene(new Scene(loader));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setX(pStage.getX()+250);
        primaryStage.setY(pStage.getY()+60);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
        pshowStage=primaryStage;
            } catch (IOException e) {
                System.out.println("showCreateCourse()");
                e.printStackTrace();
            }
         
        }
        
        
        @FXML
         void SendMssgStudent(ActionEvent event) throws SQLException {
         
        Mediateur med=new MediateurImpl1();
        User prof = new Student(med, usernme) ;
        prof.envoyer(new Message(AddContentMessageStudent.getText().toString(), "student", AddDestinationUsernameStudent.getText().toString()));
        }
      @FXML
    void SendMssg(ActionEvent event) throws SQLException {
         
        Mediateur med=new MediateurImpl1();
        User prof = new Enseignant(med, usernme) {
            @Override
            public Cours newcourse(String n, String m) { 
                return new CoursImpl(n,m);
              }
        };
        prof.envoyer(new Message(AddContentMessageProf.getText().toString(), "admin", AddDestinationUsernameProf.getText().toString()));
    }
        
    @FXML
    void AjouterExam(ActionEvent event) {
         Enseignant ensg= new EnseignantImpl();
         ensg.lancementCreationExamInput(addExamQuestion.getText().toString(), AddExamReponse.getText().toString(),"");
         
    }
    @FXML
    void AjouterQcm(ActionEvent event) {
          Enseignant ensg= new EnseignantImpl();
          System.out.println("qcm qst  ()"+addQcmQuestion.getText().toString());
          System.out.println("qcm repjust  ()"+AddQcmReponseJuste.getText().toString());
          System.out.println("qcm repfalse  ()"+AddQcmReponseFalse.getText().toString());
          ensg.lancementCreationExamQcm(addQcmQuestion.getText().toString(), AddQcmReponseJuste.getText().toString(),AddQcmReponseFalse.getText().toString());
    }
      public void showCreateExam() throws IOException{
            try {
        Stage primaryStage = new Stage(); 
        Parent loader = FXMLLoader.load(getClass().getResource("PopnewExamInput.fxml"));
        primaryStage.setTitle("e-learning");
        primaryStage.setScene(new Scene(loader));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setX(pStage.getX()+250);
        primaryStage.setY(pStage.getY()+60);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
        pshowStageExam=primaryStage;
            } catch (IOException e) {
                System.out.println("PopnewExamInput()");
                e.printStackTrace();
            }
         
        }   
        public void showCreateQcm() throws IOException{
            try {
        Stage primaryStage = new Stage(); 
        Parent loader = FXMLLoader.load(getClass().getResource("PopnewQcm.fxml"));
        primaryStage.setTitle("e-learning");
        primaryStage.setScene(new Scene(loader));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setX(pStage.getX()+250);
        primaryStage.setY(pStage.getY()+60);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
        pshowStageQcm=primaryStage;
            } catch (IOException e) {
                System.out.println("PopnewQcm()");
                e.printStackTrace();
            }
         
        }   
        public void showCreateMessageStudent() throws IOException{
            try {
        Stage primaryStage = new Stage(); 
        Parent loader = FXMLLoader.load(getClass().getResource("PopnewMessageStudent.fxml"));
        primaryStage.setTitle("e-learning");
        primaryStage.setScene(new Scene(loader));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setX(pStage.getX()+250);
        primaryStage.setY(pStage.getY()+60);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
        pshowStageMessageProf=primaryStage;
            } catch (IOException e) {
                System.out.println("showCreateMessageProf()");
                e.printStackTrace();
            }
         
        } 
     public void showCreateMessageProf() throws IOException{
            try {
        Stage primaryStage = new Stage(); 
        Parent loader = FXMLLoader.load(getClass().getResource("PopnewMessageProf.fxml"));
        primaryStage.setTitle("e-learning");
        primaryStage.setScene(new Scene(loader));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setX(pStage.getX()+250);
        primaryStage.setY(pStage.getY()+60);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
        pshowStageMessageProf=primaryStage;
            } catch (IOException e) {
                System.out.println("showCreateMessageProf()");
                e.printStackTrace();
            }
         
        }   
     public void UpdateTableEventDay(){   
         User prof = new EnseignantImpl(); 
       dataEventDay = prof.executeDailyView();   
    try {
         ColNameDayEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescDayEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateDayEvent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeDayEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeDayEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewDayEvent.setItems(dataEventDay);
    } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
      public void UpdateTableEventWeek(){   
           User prof = new EnseignantImpl(); 
       dataEventWeek = prof.executeWeeklyView();   
    try {
        ColNameWeekEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescWeekEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateWeekEvent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeWeekEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeWeekEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewWeekEvent.setItems(dataEventWeek);
   } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
       public void UpdateTableEventMonth(){   
         User prof = new EnseignantImpl(); 
       dataEventMonth = prof.executeMonthlyView();      
    try {
         ColNameMonthEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescMonthEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateMonthEvent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeMonthEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeMonthEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewMonthEvent.setItems(dataEventMonth);
   } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
         public void UpdateTableEventAgenda(){  
        User prof = new EnseignantImpl(); 
       dataEventAgenda = prof.executeAgendaView(); 
    try {
        ColNameAgendaEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescAgendaEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateAgendaEvent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeAgendaEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeAgendaEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewAgendaEvent.setItems(dataEventAgenda);
   } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
         
         
         
         
              public void UpdateTableEventDayStudent(){   
         User std = new Student(); 
       dataEventDay = std.executeDailyView();   
    try {
         ColNameDayEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescDayEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateDayEventStudent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeDayEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeDayEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewDayEventStudent.setItems(dataEventDay);
    } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
      public void UpdateTableEventWeekStudent(){   
          User std = new Student(); 
       dataEventWeek = std.executeWeeklyView();   
    try {
        ColNameWeekEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescWeekEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateWeekEventStudent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeWeekEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeWeekEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewWeekEventStudent.setItems(dataEventWeek);
   } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
       public void UpdateTableEventMonthStudent(){   
         User std = new Student(); 
       dataEventMonth = std.executeMonthlyView();      
    try {
         ColNameMonthEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescMonthEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateMonthEventStudent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeMonthEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeMonthEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewMonthEventStudent.setItems(dataEventMonth);
   } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
         public void UpdateTableEventAgendaStudent(){  
        User std = new Student(); 
       dataEventAgenda = std.executeAgendaView(); 
    try {
        ColNameAgendaEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
         ColDescAgendaEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
         ColDateAgendaEventStudent.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
         ColEndTimeAgendaEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("endTime"));
         ColStartTimeAgendaEventStudent.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
         tableViewAgendaEventStudent.setItems(dataEventAgenda);
   } catch (Exception e) {
      System.out.println("erreeeeur mess   "+e.getMessage());
    }
   
}
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("hada url :"+url + "  "+rb);
        UpdateTableCours();
        UpdateTableExamInput();
        UpdateTableQcm();
        UpdateTableMessage();
        UpdateTableEventAgenda();
        UpdateTableEventDay();
        UpdateTableEventWeek();
        UpdateTableEventMonth();
        UpdateTableCoursStudent();
        UpdateTableEventAgendaStudent();
        UpdateTableEventDayStudent();
        UpdateTableEventMonthStudent();
        UpdateTableEventWeekStudent();
        UpdateTableMessageStudent();
        UpdateTableNotif();
    }  


}
