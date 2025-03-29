public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        System.out.println(mom.getAge());
        System.out.println(son.getAge());
        System.out.println(mom.getAddress());
        System.out.println();
        System.out.println(son.getAddress());
        System.out.println(son.city);
        son.setAddress("JKL");
        System.out.println("111" + son.getAddress());
        System.out.println(son.city);


/*        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }*/
    }
}