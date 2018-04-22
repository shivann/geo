package za.co.mmiholdings.geo;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.ClassPathResource;
import za.co.mmiholdings.exception.GeoException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;

public class Region {

    private static final Logger log = LoggerFactory.getLogger(Region.class);

    private RegionType regionType;

    private String regionName;

    private List<Double> latitudes;

    private List<Double> longitudes;

    private Region() {}

    public Region(String regionName, RegionType regionType, String kmlDataFile) {
        log.debug(" -- Kml Data for {}", kmlDataFile);

        this.regionType = regionType;
        this.regionName = regionName;
        latitudes = new ArrayList<>();
        longitudes = new ArrayList<>();

        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(new ClassPathResource(kmlDataFile).getInputStream(), writer);
            parseKmlData(writer.toString());
        } catch (IOException e) {
            log.error(" -- error loading kml data file {}", kmlDataFile, e);
            throw new GeoException("Error initialising Region");
        }

    }

    public RegionType getRegionType() {
        return regionType;
    }

    public String getRegionName() {
        return regionName;
    }

    /**
     *  grab  points between <coordinates>...</coordinates> xml element in kml file
     *  add all latitudes to latitude array
     *  add all longitudes to longitude array
     */
    private void parseKmlData(String data) {
        String start = "<coordinates>";
        String end = "</coordinates>";

        int startIndex = data.indexOf(start) + start.length();
        int endIndex = data.indexOf(end);

        //grab xml element containing coordinates - space separated list of comma separated points
        String points = data.substring(startIndex, endIndex);

        String[] pairs = points.split(" ");//split coord pairs on space char

        for (int i=0; i < pairs.length; i++) {
            String[] point = pairs[i].split(","); //split point on ',' char

            Double latitude = Double.parseDouble(point[0]);
            Double longitude = Double.parseDouble(point[1]);

            if (validLatitude(latitude) && validLongitude(longitude)) {
                latitudes.add(latitude);
                longitudes.add(longitude);
            } else {
                log.error(" -- Invalid coordinates {} , {}", new Object[]{latitude, longitude});
                throw new GeoException("Invalid coordinates");
            }
        }

    }

    private boolean validLatitude(double latitude) {
        return latitude > -90 && latitude < 90;
    }

    private boolean validLongitude(double longitude) {
        return longitude > -180 && longitude < 180;
    }

    public boolean containsPoint(String latitude, String longitude) {
        return containsPoint(Double.parseDouble(latitude), Double.parseDouble(longitude));
    }

    /**
     * Returns TRUE of point lies within polygon boundary
     * defined in kml file, else FALSE
     */
    public boolean containsPoint(double latitude, double longitude) {
        log.debug(" -- containsPoint() {}, {}", new Object[]{ latitude, longitude });
        double angle=0;

        double point1_lat;
        double point1_long;
        double point2_lat;
        double point2_long;

        for (int i=0; i < latitudes.size(); i++) {
            double lat1 = latitudes.get(i) - latitude;
            double long1 = longitudes.get(i) - longitude;
            double lat2 = latitudes.get((i+1) % latitudes.size()) - latitude;
            double long2 = longitudes.get((i+1) % latitudes.size()) - longitude;

            angle += angle(lat1, long1, lat2, long2);
        }

        return Math.abs(angle) > Math.PI;
    }

    private double angle(double lat1, double long1, double lat2, double long2) {

        double theta1 = Math.atan2(lat1,long1);
        double theta2 = Math.atan2(lat2,long2);

        double dTheta = theta2 - theta1;

        while (dTheta > PI) {
            dTheta -= Math.PI * 2;
        }

        while (dTheta < -PI) {
            dTheta += Math.PI * 2;
        }

        return dTheta;
    }

    public List<Double> getLatitudes() {
        return latitudes;
    }

    public List<Double> getLongitudes() {
        return longitudes;
    }

}
