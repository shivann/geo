package za.co.mmiholdings.service;

public interface RegionMapping {


    String getPfaProvinceForCoordinate(String latitude, String longitude);

    String getPfaRegionForCoordinate(String latitude, String longitude);

    String getRsaRegionForCoordinate(String latitude, String longitude);

}
