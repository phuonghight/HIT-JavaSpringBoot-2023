package exercise06.API;

import exercise06.DTO.StudentDTO;
import exercise06.Entity.Student;
import exercise06.Service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student/api")
public class StudentAPI {
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(studentServiceImpl.getAllStudents());
    }

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName());
        return ResponseEntity.ok(studentServiceImpl.creatNewStudent(student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        studentServiceImpl.deleteStudentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName());
        studentServiceImpl.updateStudentById(id, student);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
