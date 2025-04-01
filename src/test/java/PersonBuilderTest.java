import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

public class PersonBuilderTest {

    @Test
    void buildValidTest() throws IllegalAccessException {

        // when
        Person mom = new PersonBuilder()
                .setName("Евгения")
                .setSurname("Иванов(a)")
                .setAge(40)
                .setAddress("Гусь-Хрустальный")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Николай")
                .build();

        //then
        assertEquals("Евгения", mom.getName());
        assertEquals("Иванов(a)", mom.getSurname());
        assertEquals(OptionalInt.of(40), mom.getAge());
        assertEquals("Гусь-Хрустальный", mom.getAddress());

        assertEquals("Николай", son.getName());
        assertEquals("Иванов(a)", son.getSurname());
        assertTrue(son.getAge().getAsInt() <= mom.getAge().getAsInt() - 18);
        assertEquals("Гусь-Хрустальный", son.getAddress());

    }

    @Test
    void throwsExceptions() {
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setName("Евгения").build());
        assertThrows(IllegalStateException.class, () -> new PersonBuilder().setSurname("Евгения").build());
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