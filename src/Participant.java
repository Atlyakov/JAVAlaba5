public class Participant {
    String surname;
    String name;

    public Participant(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}