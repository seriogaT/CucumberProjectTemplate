package util;

import model.Location;
import model.LocationDetails;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public LocationDetails addPlacePayload(String name, String language, String address) {
        //serialization of adding a place
        LocationDetails locationDetails = new LocationDetails();

        locationDetails.setAccuracy(50);
        locationDetails.setName(name);
        locationDetails.setPhoneNumber("(+91) 983 893 3937");
        locationDetails.setLanguage(language);
        locationDetails.setAddress(address);
        locationDetails.setWebsite("https://rahulshettyacademy.com");

        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shoe");

        locationDetails.setTypes(myList);

        Location loc = new Location();
        loc.setLatitude(-38.383494);
        loc.setLongitude(33.427362);

        locationDetails.setLocation(loc);

        return locationDetails;
    }


    public String deletePlacePayload(String placeId) {
        return "{\"place_id\":\"" + placeId + "\"}";
    }
}
