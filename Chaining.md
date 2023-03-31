# Spring Data JPA

##  Hibernate

`Hibernate` là một framework ORM (Object-Relational Mapping) trong Java. Nó được sử dụng để tương tác với cơ sở dữ liệu quan hệ (RDBMS), định nghĩa các đối tượng Java và ánh xạ chúng vào các bảng trong cơ sở dữ liệu, giúp lập trình viên xử lý dữ liệu một cách dễ dàng và hiệu quả hơn.

## JPA

`JPA` (Java Persistence API) trong Java là một tiêu chuẩn API để quản lý truy xuất cơ sở dữ liệu, được định nghĩa bởi Java Community Process. Nó cho phép lập trình viên tạo ra các ứng dụng Java giao tiếp với cơ sở dữ liệu quan hệ (RDBMS) và đối tượng trong Java thông qua các layer phía dưới.

## Spring Data JPA

`Spring Data JPA` là một thư viện của Spring Framework cung cấp các chức năng cho phép tương tác với CSDL quan hệ (Relational Database) thông qua cơ chế ORM (Object-Relational Mapping). Nó giúp giảm thiểu lượng code tiêu chuẩn khi làm việc với CSDL và tăng hiệu suất trong phát triển ứng dụng.

1. Định nghĩa một `Entity` tương ứng với một bảng trong CSDL. Ví dụ: định nghĩa một entity `User` cho bảng user.

```
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    // constructors, getters/setters, ...
}
```

2. Định nghĩa **interface** `Repository` để thực hiện các hoạt động truy vấn dữ liệu từ bảng tương ứng. Khi bạn extends các **interface** như `JpaRepository` hay `CrudRepository` Spring Boot sẽ tự động tạo implementation cho các hàm cơ bản.

```
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
```

3. Sử dụng **repository** trong **service** hoặc **controller** để truy vấn dữ liệu.

```
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElse(null);
    }
}
```

```
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
```

**Tóm lại, Spring Data JPA giúp tương tác với CSDL một cách đơn giản và hiệu quả, giảm thiểu lượng code tiêu chuẩn và tăng hiệu suất phát triển ứng dụng.**