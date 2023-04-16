package exercise06.Service;

import exercise06.Entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(int id);
    void updateStudentById(int id, Student student);
    void deleteStudentById(int id);
    List<Student> getAllStudents();
    Student creatNewStudent(Student student);
}
