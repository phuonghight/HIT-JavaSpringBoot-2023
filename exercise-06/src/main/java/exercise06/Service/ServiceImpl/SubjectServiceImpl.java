package exercise06.Service.ServiceImpl;

import exercise06.Entity.Subject;
import exercise06.Repository.StudentRepository;
import exercise06.Repository.SubjectRepository;
import exercise06.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjectsByStudentId(int id) {
        List<Subject> subjects = subjectRepository.getAllSubjectsByStudentId(id);
        if(!subjects.isEmpty()) return subjects;
        else return null;
    }

    @Override
    public Subject createNewSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> getSubjetcs(int page, int limit) {
        if (page >= 0){
            Page<Subject> subjects = subjectRepository.findAll(PageRequest.of(page, limit));
            return subjects.getContent();
        }
        return subjectRepository.findAll();
    }
}
