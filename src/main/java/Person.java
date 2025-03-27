import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(PersonBuilder builder) throws IllegalAccessException {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.city = builder.city;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}
