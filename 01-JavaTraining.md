# Java Spring Boot

## Dependency Injection (DI):

Trong class A có class B => A phụ thuộc vào B

Ví dụ:

```
class Person {
    private Moblie phone = new Iphone();
    ....
}
```

Đối tượng Person phụ thuộc vào đối tượng Mobile, cụ thể là IPhone

Nhưng khi ta muốn 1 Person sử Samsung thì ta phải làm lại 1 class Person mới có `Mobile phone = new Samsung()`

Đây gọi là liên kết chặt chẽ `tight-coupling`

_Do đó sử dụng Dependency Injection (DI)_

```
class Person {
    private Moblie phone;

    Person(Moblie phone) {
        this.phone = phone;
    }
}

public static void main(String[] args) {
    Mobile ss = new Samsung();
    Mobile ip = new IPhone();
    Person p1 = new Person(ss);
    Person p2 = new Person(ip);
}
```

**Dependency Injection** là 1 trung gian chịu trách nhiệm tạo ra các loại Mobile khác nhau, rồi cung cấp chúng cho class Person. Việc đó làm cho class Person ko phải phụ thuộc vào Mobile cụ thể nào

Liên kết lỏng lẻo `loosely-coupled`

## IoC

Nếu có nhiều Dependencies, nếu **Dependency Injection** thì mất thời gian. Vì thế sử dụng **IoC**: đảo ngược điều khiển

## Spring Container

Là nơi chứa đựng tất cả các **Bean** chịu trách nhiệm khởi tạo, lắp ráp các **Bean** và quản lý chúng

```
public static void main(String[] args) {
        ApplicationContext contex =
        SpringApplication.run(Week03Application.class, args);
}
```

## @Component

Đánh dấu là 1 bean để **Spring Container** biết để Injection

Spring Framework chọn nó và cấu hình trong **ApplicationContext** như một Spring Bean.

```
@Component
public class Student {
    .......
}
```

## @Autowired

Là 1 anotation của 1 class, biểu thị rằng các thuộc tính sẽ được Sping inject bean tương ứng vào vị trí được đánh dấu.

```
@Component
public class Student {
    private Phone phone;
    @Autowired
    Student(Phone phone) {
        this.phone = phone;
    }
}
```

## @Scope

Là phạm vi **Bean** được sinh ra và bị phá hủy dưới sự quản lí của **Spring Container**

## @Primary, @Qualifier

**@Primary** và **@Qualifier** là 1 tính năng trong Spring để có thể xử lý vấn đề nhiều **Bean** cùng loại trong một Project

1. **@Primary** là annotation đánh dấu trên một **Bean**, giúp nó luôn được ưu tiên lựa chọn trong trường hợp có nhiều **Bean** cùng loại trong Context.

2. **@Qualifier** xác định tên của một **Bean** mà bạn muốn chỉ định inject.

## @Configuration, @Bean

1. **@Configuartion** là một annotation của class. Class được đánh dấu annotaiton này được **Spring Container** sử dụng làm nguồn định nghĩa **Bean**.

```
@Configuartion
public class Student {
    private Phone phone;
    @Bean
    Student...
}
```

2. **@Bean** là một annotation cho method. Nó là sự thay thể của thẻ XML < bean >. Nó cho biết method tạo ra một **Bean** được **Spring Container** quản lý.

## @Controller

**@Controller** là một annotation ở class. Nó đánh dấu class là một class để xử lý request web

Nó thường được sử dụng để phục vụ các request từ UI. Mặc định thì nó trả về một chuỗi cho biết route nào cần redirect. Nó chủ yếu được sử dụng với annotation **@RequestMapping**.

## @RequestMapping

Được sử dụng để map các request. Nó có nhiều phần tử tùy chọn như consumes, header, method, name, params, path, produces, và value

```
@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView index(Model model) {
    ModelAndView view = new ModelAndView("index");
    return view;
}
```

## @GetMapping

Nó map HTTP GET request trên method cụ thể. Nó dùng để tạo một điểm cuối trong web service, và nó được sử dụng thay cho `@RequestMapping(method = RequestMethod.GET)`.

## @ComponentScan

Là annotation khai báo ở cấp độ class, là annotation khai báo ở cấp độ class, mặc định nó sẽ scan tất cả bean trong package ở vị trí đặt class chứa hàm main, ngoài ra chúng ta cũng có thể tùy chỉnh package cần scan

```
@Configuration
@ComponentScan(basePackages = "path.abc")
public class week03Application {
   // ...
}

```

## @PutMapping

`@PutMapping = @RequestMapping(method = RequestMethod.PUT)`

## @PatchMapping

`@PatchMapping = @RequestMapping(method = RequestMethod.PATCH)`

## @PostMapping

`@PostMapping = @RequestMapping(method = RequestMethod.POST)`

_@RequestMapping có thể được sử dụng ở cấp class và cấp method. Trong hầu hết các trường hợp, ở cấp method, các ứng dụng sẽ thích sử dụng một biến thể cụ thể của method HTTP như **@GetMapping**, **@PostMapping**, **@PutMapping**, **@DeleteMapping** hoặc **@PatchMapping**_
