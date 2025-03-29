import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected Optional<String> city;

    /*
    Возраст (int). Если возраст человека известен, то с момента создания объекта он может быть изменён только увеличением на единицу через вызов метода happyBirthday().
    Возраст человека может быть неизвестен, в этом случае метод boolean hasAge() должен вернуть false, иначе - true.
    Подумайте, как эффективнее хранить в объекте информацию о том, известен ли возраст человека.
    Текущий город жительства (String). Может быть известен (в этом случае метод boolean hasAddress() должен вернуть true,
    иначе - false) и выставлен в любой через setAddress(String city).
    * */

    public Person(PersonBuilder builder) throws IllegalAccessException {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age >= 0 ? OptionalInt.of(builder.age) : OptionalInt.empty();
        this.city = Optional.ofNullable(builder.city);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return city.isPresent();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age.orElse(0);
    }

    String getAddress() {
        return city.orElse(null);
    }

    public void setAddress(String city) {
        this.city = Optional.of(city);
    }

    public void happyBirthday() {
        if (hasAge()) {
            age.ifPresent(a -> age = OptionalInt.of(a + 1));
        }
    }

    public PersonBuilder newChildBuilder() throws IllegalAccessException {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(this.age.isPresent() ? new Random().nextInt(this.age.getAsInt() - 18) : 0)
                .setAddress(this.city.orElse(null));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    public String toString() {
        return "Имя: " + this.name + " " + "Фамилия: " + this.surname + " ";
    }

}
