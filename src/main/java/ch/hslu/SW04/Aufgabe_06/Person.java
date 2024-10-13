package ch.hslu.SW04.Aufgabe_06;

import java.util.Objects;

public class Person {
    private String vorname;
    private String nachname;
    private String email;
    private int alter;

    public Person(String vorname, String nachname, String email, int alter){
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.alter = alter;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(final String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(final String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(final int alter) {
        this.alter = alter;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Person person)
                && Objects.equals(email, person.email)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
