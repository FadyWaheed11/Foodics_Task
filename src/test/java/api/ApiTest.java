package api;


import api.base.Base;
import api.models.CreateUser;
import api.models.RetrieveUser;
import api.models.UpdateUser;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.models.CreateUser.getCreateUser;

import static api.models.RetrieveUser.getRetrieveUser;
import static api.models.UpdateUser.getUpdateUser;
import static file_handling.FileManager.readJsonFile;
import static org.testng.Assert.assertEquals;

public class ApiTest {

    private final String createUserDataPath = "src/test/resources/api-test-data/createUserData.json";
    private final String updateUserDataPath = "src/test/resources/api-test-data/updateUserData.json";
    private final JSONObject createUserPayLoad = readJsonFile(createUserDataPath);
    private final JSONObject updateUserPayLoad = readJsonFile(updateUserDataPath);
    private final SoftAssert softAssert = new SoftAssert();


    //STEP 1 -> Create a User
    @Test
    public void testCreateUser(){
        CreateUser createUser = getCreateUser(createUserPayLoad);
        createUser.sendRequest();
        Base.response.prettyPrint();
        assertEquals(Base.response.statusCode(),201,"Failed to create user!");
    }


    //STEP 2 -> Retrieve a User
    @Test
    public void testRetrieveUser(){
        CreateUser createUser = getCreateUser(createUserPayLoad);
        createUser.sendRequest();
        String userId = Base.response.jsonPath().get("id");

        RetrieveUser retrieveUser;
        retrieveUser = getRetrieveUser(userId);

        retrieveUser.sendRequest();
        assertEquals(Base.response.statusCode(),200,"Failed to retrieve user with id -> " + userId);

        softAssert.assertEquals(Base.response.jsonPath().get("name"), createUserPayLoad.get("name"),
                "The name doesn't match");
        softAssert.assertEquals(Base.response.jsonPath().get("job"), createUserPayLoad.get("job"),
                "The job doesn't match");
        softAssert.assertEquals(Base.response.jsonPath().get("age"), createUserPayLoad.get("age"),
                "The age doesn't match");
        softAssert.assertAll();
    }

    //STEP 3 -> Update a User
    @Test
    public void testUpdateUser(){
        UpdateUser updateUser = getUpdateUser("1",updateUserPayLoad);
        updateUser.sendRequest();

        Base.response.prettyPrint();

        assertEquals(Base.response.statusCode(),200,"Failed to update user with id 1");

        softAssert.assertEquals(Base.response.jsonPath().get("name")
                ,updateUserPayLoad.get("name"),"The name doesn't match");

        softAssert.assertEquals(Base.response.jsonPath().get("job")
                ,updateUserPayLoad.get("job"),"The job doesn't match");

        softAssert.assertEquals(Base.response.jsonPath().get("age")
                ,updateUserPayLoad.get("age"),"The age doesn't match");

        softAssert.assertAll();

    }

}
