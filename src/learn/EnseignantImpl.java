package learn;

import java.util.Date;

public class EnseignantImpl extends Enseignant{

    public Cours newcourse(String n,String m) {
        return new CoursImpl( n, m);
    }

   

   
}
