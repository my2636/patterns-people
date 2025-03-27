public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String city;

    /*
    Также надо создать класс PersonBuilder для конструирования объектов класса Person.
    - Объекту этого класса (далее - билдер) можно выставлять любые данные для будущего объекта класса Person через методы
    (например, setName(String name)).
    - И в этом объекте будет метод Person build(), возвращающий объект класса Person с указанными билдеру данными.
    - В случае, если мы билдеру не указали достаточное количество данных (например, не указали фамилию),
    то метод build() должен выкинуть IllegalStateException с осмысленным сообщением.
    - Если же мы передали неподходящие данные билдеру (например, некорректный возрст builder.setAge(-100)),
    то именно этот метод должен выкинуть IllegalArgumentException с осмысленным сообщением.
    - Каждый метод добавления данных в билдер должен возвращать самого себя чтобы можно было сделать, например, вот так:

    Person person = new PersonBuilder()
                      .setName("Антошка")
                      .setSurname("Лопатов")
                      .setAge(48)
                      .build();
    - Также в класс Person надо добавить метод PersonBuilder newChildBuilder(),
    который будет возвращать полузаполненный билдер для ребёнка, а именно:
    с уже заполненными фамилией (родительской), возрастом и текущим городом жительства (родительским).

    Продемонстрируйте работу ваших классов в классе Main (необязательно реализовывать ввод данных от пользователя).
    * */



    public PersonBuilder setName(String name) {
        this.age = age;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalAccessException {
        if (age < 0) {
            throw new IllegalAccessException("Возраст не может быть отрицательным");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalAccessException {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Имя или Фамилия не может быть пустым");
        }

        return new Person(this);
    }
        
}
