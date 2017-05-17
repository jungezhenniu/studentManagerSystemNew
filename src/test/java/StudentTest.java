import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.HashSet;
import java.util.Set;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveTest(){
        Student student = new Student();
        Set<Subject> subjectSet = new HashSet<Subject>();
        Subject subject = new Subject();
        subjectSet.add(subject);
        subject.setName("java");

        student.setSubjectSet(subjectSet);
        studentRepository.save(student);
    }
}

