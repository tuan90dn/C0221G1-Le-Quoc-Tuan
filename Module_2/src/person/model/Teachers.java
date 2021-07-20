package person.model;

public  class Teachers extends Person {
    private String subject;

    public Teachers() {
    }

    public Teachers(String subject) {
        this.subject = subject;
    }

    public Teachers(String name, int age, String address, String subject) {
        super(name, age, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + subject;
    }
}
