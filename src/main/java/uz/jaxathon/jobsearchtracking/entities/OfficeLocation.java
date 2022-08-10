package uz.jaxathon.jobsearchtracking.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class OfficeLocation {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String city;
    private String state;

    public OfficeLocation() {
    }

    public OfficeLocation(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
