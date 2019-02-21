package fr.nadeva.javaee.beanvalidation;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@UserValid
public class User {

//new constraints from Bean validation 2.0
//    @NotEmpty
//    @NotBlank
//    @Email
//    @Positive
//    @PositiveOrZero
//    @Negative
//    @NegativeOrZero
//    @PastOrPresent
//    @FutureOrPresent


    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @NoYopmail
    private String email;

    @NotNull
    @Past
    private LocalDate birthDate;


//    @NotEmpty
//    private List<String> hobbies;

    private LocalDate beginWorkingDate;


    private String twitter;


    @NotEmpty
    @Size(min = 3)
    private List<@NotEmpty String> hobbies;


    private Map<@Min(14) Integer, String> keymap;

    private Integer experienceAge;


    public void setExperienceAge(@Min(2) Integer experienceAge) {
        this.experienceAge = experienceAge;
        hobbies.clear();
        keymap.clear();
//        twitter = Optional.empty();
//        twitter.get();
    }

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

    public String toString() {
        return (
                "name: [" + name + "] email: [" + email + "] birthDate ["
                        + birthDate.toString() + "]");
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


    public void setHobbies(List<String> qualities2) {
        this.hobbies = qualities2;
    }

    public void setKeymap(Map<Integer, String> keymap) {
        this.keymap = keymap;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Optional<@Pattern(regexp = "@.*") String> getTwitter() {
        return Optional.ofNullable(twitter);
    }


    //    public void setQualities(List<String> qualities) {
//        this.qualities = qualities;
//    }
}
