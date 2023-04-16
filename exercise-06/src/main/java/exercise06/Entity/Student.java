package exercise06.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<Subject> subjects;

    @OneToOne(mappedBy = "student", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    protected Phone phone;

    public Student(String name) {
        this.name = name;
    }
}
