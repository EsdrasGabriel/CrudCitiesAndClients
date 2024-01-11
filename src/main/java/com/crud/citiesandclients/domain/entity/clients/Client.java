package com.crud.citiesandclients.domain.entity.clients;

import com.crud.citiesandclients.domain.entity.cities.City;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "clients")
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String id;
    private String fullName;
    private String gender;
    private String dateOfBirth;
    private String age;
    private City cityWhereYouLive;
}
