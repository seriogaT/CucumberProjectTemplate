package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class LocationDetails {

    private Location location;
    private int accuracy;
    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
    private List<String> types;
    private String website;
    private String language;

}
