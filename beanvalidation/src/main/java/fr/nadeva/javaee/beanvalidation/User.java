package fr.nadeva.javaee.beanvalidation;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    private String email;


    @NotNull
    private LocalDate birthDate;

    private LocalDate beginWorkingDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBeginWorkingDate(LocalDate beginWorkingDate) {
        this.beginWorkingDate = beginWorkingDate;
    }

    public LocalDate getBeginWorkingDate() {
        return beginWorkingDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", beginWorkingDate=" + beginWorkingDate +
                '}';
    }
}
