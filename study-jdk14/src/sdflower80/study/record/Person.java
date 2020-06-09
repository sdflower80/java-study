package sdflower80.study.record;

public record Person(String name, Integer age) {

    public static void main(String[] args) {
        Person p = new Person("sdflower80", 44);
        System.out.println(p);
    }
}
