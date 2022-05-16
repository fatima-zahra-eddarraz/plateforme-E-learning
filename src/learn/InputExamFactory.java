package learn;

public class InputExamFactory implements ExamFactory {
    public Exam createExam(String qestion, String reponseJuste, String reponsefalse) {
        return new InputExam( qestion, reponseJuste);
    }

    
}
