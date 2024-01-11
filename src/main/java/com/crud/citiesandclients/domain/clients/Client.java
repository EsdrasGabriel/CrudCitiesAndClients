package com.crud.citiesandclients.domain.clients;

import com.crud.citiesandclients.domain.cities.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "clients")
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private GenderEnum gender;
    private Date dateOfBirth;
    private Integer age;
    @ManyToOne
    private City cityWhereYouLive;
}
