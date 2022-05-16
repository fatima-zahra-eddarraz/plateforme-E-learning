package learn;

public class QcmFactory implements ExamFactory {

    @Override
    public Exam createExam(String qestion, String reponseJuste, String reponsefalse) {
        return new Qcm(qestion,reponseJuste,reponsefalse);
    }

   

}
