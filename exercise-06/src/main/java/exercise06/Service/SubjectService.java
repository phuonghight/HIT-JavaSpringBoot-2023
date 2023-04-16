package exercise06.Service;

import exercise06.Entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjectsByStudentId(int id);
    Subject createNewSubject(Subject subject);
    List<Subject> getAllSubjects();
    List<Subject> getSubjetcs(int page, int limit);
}
