package com.safetynetalert.apiAlert.Model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "firestations")

public class Firestation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String station;

    public Firestation(String address, String station) {
        this.address = address;
        this.station = station;
    }



    @Override
    public String toString() {
        return "firestations{" +
                "address='" + address + '\'' +
                "station='" + station + '\'' +
                '}';
    }

}