package stepDefinition;

import io.cucumber.java.Before;

import static util.ApiResources.ADD_PLACE_API;
import static util.ApiResources.GET_PLACE_API;

public class Hooks {

    @Before("@DeletePlace")
    public void beforScenario() {

        ApiStepImpl m = new ApiStepImpl();

        if (ApiStepImpl.placeId == null) {
            m.addPlacePayload("Serge", "Ukr", "Moldova");
            m.userCallsAddPlaceAPIWithPostHttpRequest(String.valueOf(ADD_PLACE_API), "POST");
            m.verifyPlaceIdCreatedMapsToUsing("Serge", String.valueOf(GET_PLACE_API));
        }
    }
}