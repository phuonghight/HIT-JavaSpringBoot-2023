package exercise06.API;

import exercise06.DTO.PhoneDTO;
import exercise06.Entity.Phone;
import exercise06.Entity.Student;
import exercise06.Service.ServiceImpl.PhoneServiceImpl;
import exercise06.Service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phone/api")
public class PhoneAPI {
    @Autowired
    private PhoneServiceImpl phoneServiceImpl;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPhones() {
        return ResponseEntity.ok().body(phoneServiceImpl.getAllPhones());
    }

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewPhone(@RequestBody PhoneDTO phoneDTO) {
        Student student = studentServiceImpl.getStudentById(phoneDTO.getStudent_id());
        Phone phone = new Phone(phoneDTO.getName(), student);
        return ResponseEntity.ok().body(phoneServiceImpl.createNewPhone(phone));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updatePhoneById(@PathVariable int id, @RequestBody PhoneDTO phoneDTO) {
        Student student = studentServiceImpl.getStudentById(phoneDTO.getStudent_id());
        Phone phone = new Phone(phoneDTO.getName(), student);
        phoneServiceImpl.updatePhoneById(id, phone);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
