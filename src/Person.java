public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String surname, int age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
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

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return String.format("Имя(%s) Фамилия(%s) Возраст(%d)"
                        + " Гендер(%s) Образование(%s).",
                name,
                surname,
                age,
                sex,
                education);
    }
}
