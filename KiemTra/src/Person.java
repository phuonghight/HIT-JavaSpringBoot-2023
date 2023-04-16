public class Person {
    protected String name, gender, phone;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
        // TODO Auto-generated constructor stub
        this.name = "Phuong";
        this.gender = "nam";
        this.phone = "0999";
        this.age = 19;
    }

    public Person(String name, String gender, String phone, int age) {
        super();
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", gender=" + gender + ", phone=" + phone + ", age=" + age + "]";
    }

}
