package com.safetynetalert.apiAlert.Model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ChildAlertDTO {

    private String firstName;

    private String lastName;

    private int age;



    public ChildAlertDTO(int age, String lastName, String firstName) {
        this.age =age;
        this.firstName= firstName;
        this.lastName = lastName;
    }
}
