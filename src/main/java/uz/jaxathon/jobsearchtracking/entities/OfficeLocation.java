package uz.jaxathon.jobsearchtracking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Data
@Entity
public class OfficeLocation {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue
    private Long id;
    private String city;
    private String state;

    @JsonIgnore
    @Version
    private int version;
    public OfficeLocation() {
    }

    public OfficeLocation(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
