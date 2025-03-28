import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonBuilderTest {

    @Test
    void buildValidTest() throws IllegalAccessException {

        // when
        Person person = new PersonBuilder()
                .setName("Евгения")
                .setSurname("Иванова")
                .setAge(40)
                .setAddress("Гусь-Хрустальный")
                .build();

        //then
        assertEquals("Евгения", person.getName());
        assertEquals("Иванова", person.getSurname());
        assertEquals(40, person.getAge());
        assertEquals("Гусь-Хрустальный", person.getAddress());

    }

    @Test
    void throwsExceptions() {
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().build());
        assertThrows(IllegalArgumentException.class, () -> new PersonBuilder().setAge(-20));
    }

    @Test
    void doesNotThrowsAnyException() {
        assertDoesNotThrow(() -> new PersonBuilder().setName("Евгения"));
        assertDoesNotThrow(() -> new PersonBuilder().setSurname("Иванова"));
        assertDoesNotThrow(() -> new PersonBuilder().setAge(40));
        assertDoesNotThrow(() -> new PersonBuilder().setAddress(null));
    }


}