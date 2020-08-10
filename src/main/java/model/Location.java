package model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lng")
    private double longitude;
}
