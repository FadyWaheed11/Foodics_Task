package ui.data_driven;

import org.json.JSONObject;

import static file_handling.FileManager.readJsonFile;

public class ShippingData {
    private final JSONObject jsonData;

    private ShippingData(){
        final String filePath = "src/test/resources/ui-test-data/shippingData.json";
        jsonData = readJsonFile(filePath);
    }

    public static ShippingData getShippingData(){
        return new ShippingData();
    }

    public String getPhoneNumber(){
        return jsonData.getString("phoneNumber");
    }
    public String getPassword(){
        return jsonData.getString("password");
    }
    public String getFullName(){
        return jsonData.getString("fullName");
    }
    public String getStreetName(){
        return jsonData.getString("streetName");
    }
    public String getBuildingName(){
        return jsonData.getString("buildingName");
    }
    public String getCityArea(){
        return jsonData.getString("cityArea");
    }
    public String getDistrict(){
        return jsonData.getString("district");
    }
    public String getLandMark(){
        return jsonData.getString("landMark");
    }
}
