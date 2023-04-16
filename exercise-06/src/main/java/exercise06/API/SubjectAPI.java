package exercise06.API;

import exercise06.DTO.SubjectDTO;
import exercise06.Entity.Student;
import exercise06.Entity.Subject;
import exercise06.Service.ServiceImpl.StudentServiceImpl;
import exercise06.Service.ServiceImpl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject/api")
public class SubjectAPI {
    @Autowired
    private StudentServiceImpl studentServiceImpl;
    @Autowired
    private SubjectServiceImpl subjectServiceImpl;

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
        Student student = studentServiceImpl.getStudentById(subjectDTO.getStudent_id());
        Subject subject = new Subject(subjectDTO.getName(), student);

        return ResponseEntity.ok(subjectServiceImpl.createNewSubject(subject));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllSubjects(@RequestParam(name = "page", required = false) int page,
                                            @RequestParam(name = "limit", required = false) int limit) {
        return ResponseEntity.ok().body(subjectServiceImpl.getSubjetcs(page, limit));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getAllSubjectsByUserId(@RequestParam(name = "user_id") int id) {
        return ResponseEntity.ok().body(subjectServiceImpl.getAllSubjectsByStudentId(id));
    }
}
