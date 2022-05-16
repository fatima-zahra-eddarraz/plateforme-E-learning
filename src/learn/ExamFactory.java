package learn;

public interface ExamFactory {
    abstract Exam createExam(String qestion, String reponseJuste, String reponsefalse);
  
}
