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

## Query Creation trong Spring Data JPA

**Query Creation** là một cách để **Spring Data JPA** tạo câu truy vấn SQL dựa trên tên phương thức và các thông số đầu vào của phương thức. Với **Query Creation**, chúng ta có thể viết nhanh các truy vấn cơ bản mà không cần phải viết lại câu truy vấn SQL.

Các quy tăc đặt tên phương thức để sử dụng Query Creation trong Spring Data JPA như sau:

1. Tìm theo thuộc tính: **`findBy{PropertyName}`**, ví dụ: **`findByLastName(String lastName)`**. Đây là quy tắc đó đơn giản nhất. Chỉ cần chỉ định tên thuộc tính và kiểu dữ liệu của thuộc tính, **Spring Data** sẽ tạo ra truy vấn theo tên phương thức này.

2. Tìm theo nhiều thuộc tính: **`findBy{PropertyName1}And{PropertyName2}`**, ví dụ: **`findByFirstNameAndLastName(String firstName, String lastName)`**. Quy tắc này được sử dụng khi muốn tìm kiếm dữ liệu dựa trên nhiều thuộc tính của đối tượng.

3. Tìm kiếm theo một thuộc tính, với giá trị được so sánh lớn hơn hoặc bằng: **`findBy{PropertyName}GreaterThanEqual`**, ví dụ: **`findByAgeGreaterThanEqual(int age)`**. Có nghĩa là **Spring Data JPA** sẽ tạo ra truy vấn để tìm các đối tượng có thuộc tính **"age"** lớn hơn hoặc bằng giá trị đầu vào trong phương thức.

4. Tìm kiếm theo một thuộc tính, với giá trị được so sánh nhỏ hơn hoặc bằng: **`findBy{PropertyName}LessThanEqual`**, ví dụ: **`findByAgeLessThanEqual(int age)`**. Tương tự như trường hợp #3, tuy nhiên lọc các đối tượng có giá trị thuộc tính **"age"** thỏa mãn điều kiện giá trị truyền vào phương thức nhỏ hơn hoặc bằng giá trị này.

5. Tìm kiếm theo một thuộc tính, với giá trị được so sánh giữa hai giá trị: **`findBy{PropertyName}Between`**, ví dụ: **`findByAgeBetween(int start, int end)`**. Lấy các đối tượng có giá trị thuộc tính **"age"** nằm giữa hai giá trị được truyền vào trong phương thức.

6. Tìm kiếm theo một thuộc tính, với giá trị bắt đầu bằng một chuỗi: **`findBy{PropertyName}StartingWith`**, ví dụ: **`findByFirstNameStartingWith(String prefix)`**. Lấy các đối tượng có thuộc tính **"firstName"** bắt đầu bằng chuỗi được truyền vào trong phương thức.

7. Tìm kiếm theo một thuộc tính, với giá trị có chứa một chuỗi: **`findBy{PropertyName}Containing`**, ví dụ: **`findByFirstNameContaining(String infix)`**. Lấy các đối tượng có thuộc tính **"firstName"** chứa chuỗi được truyền vào trong phương thức.

## @Query (Native Query và JPQL Query)

Trong **Spring Data JPA**, chúng ta có thể sử dụng annotation `@Query` để chỉ định câu truy vấn một cách rõ ràng cho phương thức trong `Repository` của chúng ta. Câu truy vấn có thể là **Native Query** (truy vấn SQL thuần) hoặc **JPQL Query** (truy vấn được định nghĩa bằng ngôn ngữ JPQL).

1. Về **Native Query**, chúng ta có thể sử dụng annotation `@Query` với thuộc tính value để định nghĩa câu truy vấn. Ví dụ:

```
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee e WHERE e.department_id = ?1", nativeQuery = true)
    List<Employee> findByDepartment(Long departmentId);   
}
```

Ở ví dụ trên, chúng ta đã định nghĩa một câu truy vấn SQL thuần `(SELECT * FROM employee e WHERE e.department_id = ?1)` để tìm kiếm danh sách các bản ghi nhân viên theo id của phòng ban. Lưu ý rằng chúng ta phải sử dụng thuộc tính **Native Query** và gán giá trị true để chỉ định rằng câu truy vấn được đưa ra là **Native Query**.

2. Về **JPQL Query**, chúng ta có thể sử dụng annotation `@Query` với thuộc tính value để định nghĩa câu truy vấn. Ví dụ:

```
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
    List<Employee> findByDepartment(Long departmentId);
}
```

Ở ví dụ trên, chúng ta đã định nghĩa một câu truy vấn JPQL `(SELECT e FROM Employee e WHERE e.department.id = ?1)` để tìm kiếm danh sách các bản ghi nhân viên theo id của phòng ban. Khác với **Native Query**, chúng ta không cần thiết lập thuộc tính **Native Query** và giá trị tương ứng của nó.

**Khi sử dụng `@Query`, chúng ta có thể tận dụng được giảm thiểu số lượng bytecode và tăng hiệu suất của ứng dụng. Tuy nhiên, việc sử dụng `@Query` cũng có thể làm cho mã nguồn của chúng ta trở nên khó đọc và hardcode hơn.**