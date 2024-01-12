package com.crud.citiesandclients.domain.clients;

import com.crud.citiesandclients.domain.cities.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "clients")
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private GenderEnum gender;
    private LocalDate dateOfBirth;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city_id;
}
