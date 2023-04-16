package exercise06.Service.ServiceImpl;

import exercise06.Entity.Student;
import exercise06.Repository.StudentRepository;
import exercise06.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> {
            throw new Error("Not found student has id: " + id);
        });
    }

    @Override
    public void updateStudentById(int id, Student student) {
        Student studentTarget = studentRepository.findById(id).orElseThrow(() -> {
            throw new Error("Not found student has id: " + id);
        });
        studentRepository.updateStudentById(id, student.getName());
    }

    @Override
    public void deleteStudentById(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> {
            throw new Error("Not found student has id: " + id);
        });
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student creatNewStudent(Student student) {
        return studentRepository.save(student);
    }
}
