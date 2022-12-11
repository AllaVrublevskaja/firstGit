
public class Person {
    private String name;
    private int age;
    private String lastName;
    private String email;



    public Person(String name, String lastName, String email, int age) {
        this.name = name;
        this.age = age;
        this.lastName=lastName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getLastName() {return lastName;}

    public String getEmail() {return email;}
}

