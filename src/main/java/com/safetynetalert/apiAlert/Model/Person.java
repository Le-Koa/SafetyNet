package com.safetynetalert.apiAlert.Model;


    import lombok.*;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;

    import javax.persistence.*;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.time.LocalDate;
    import java.time.Period;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @Entity
    @Table(name = "persons")


    public class Person {

        private static final Logger logger = LogManager.getLogger(Person.class);


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;

        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String zip;
        private String phone;
        private String email;



        private int age;

        private String medications;
        private String allergies;

        public Person(String firstName, String address, String city, String lastName, String phone, String zip, Integer age, String email) {
            this.firstName = firstName;
            this.address = address;
            this.city = city;
            this.lastName = lastName;
            this.phone = phone;
            this. zip = zip;
            this.age = age;
            this.email = email;
        }

        public void setAge (String birthdate, LocalDate currentDate)  {
            Date dates;
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                dates = simpleDateFormat.parse(birthdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(dates);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;
                int date = cal.get(Calendar.DATE);
                LocalDate l1 = LocalDate.of(year, month, date);
                Period diff1 = Period.between(l1, currentDate);
                this.setAge(diff1.getYears());

            } catch (ParseException e) {
                logger.error("setAge issue :" + e);
            }
        }

        public void setMedicationAndAllergies (MedicalRecord medicalRecord) {
            this.setMedications(medicalRecord.getMedications());
            this.setAllergies(medicalRecord.getAllergies());
        }
    }
