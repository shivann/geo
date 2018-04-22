package za.co.mmiholdings.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.mmiholdings.config.PfaProvince;
import za.co.mmiholdings.config.PfaProvinceRegion;
import za.co.mmiholdings.geo.Region;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import({PfaProvince.class, PfaProvinceRegion.class})
public class RegionMappingTest {

    private static final Logger log = LoggerFactory.getLogger(RegionMappingTest.class);

    @Autowired
    List<Region> allPfaProvinces;

    // PFA Region
    @Autowired
    Region capeFreeStateExclIslands;
    @Autowired
    Region easternCape;

    //PFA PVC Region
    @Autowired
    Region southCoast;
    @Autowired
    Region portElizabeth;

    @Autowired
    List<Region> allPfaProvinceRegions;


    @Test
    public void test_pfa_region_returns_true_for_valid_point() {
        //coords randomly chosen from kml file
        double latitude = 29.76552;
        double longitude = -27.536659;

        boolean valid  = capeFreeStateExclIslands.containsPoint(latitude, longitude);

        assertThat(valid).isTrue().withFailMessage("should return TRUE for coordinate inside region");
    }

    @Test
    public void test_pfa_region_returns_false_for_other_region() {
        //coords randomly chosen from kml file
        double latitude = 29.783791;
        double longitude = -27.57354;

        boolean valid  = easternCape.containsPoint(latitude, longitude);

        assertThat(valid).isFalse().withFailMessage("should return FALSE for coordinate outside region");
    }

    @Test
    public void test_pfa_pvc_true_for_valid_point() {
        //coords randomly chosen from kml file
        double latitude = 24.38763;
        double longitude = -31.387011;

        boolean valid  = southCoast.containsPoint(latitude, longitude);

        assertThat(valid).isTrue().withFailMessage("should return TRUE for coordinate inside region");
    }

    @Test
    public void test_pfa_pvc_returns_false_for_other_region() {
        //coords randomly chosen from kml file
        double latitude = 24.38763;
        double longitude = -31.387011;

        boolean valid  = portElizabeth.containsPoint(latitude, longitude);

        assertThat(valid).isFalse().withFailMessage("should return FALSE for coordinate outside region");
    }

//    @Test // longrunning
    public void for_each_pfa_region_boundary_points_should_return_true_for_that_region() {
        boolean valid = true;

        for (Region region : allPfaProvinces) {
            valid &= containsAllBoundaryPoints(region);
            if (!valid) break; //fail fast;
        }

        assertThat(valid).isTrue().withFailMessage("Should return TRUE for all boundary points for a region");
    }

    //returns TRUE if containsPoint() returns TRUE for all boundary points
    //for the region
    private boolean containsAllBoundaryPoints(Region region) {
        boolean containsAllPoints = true;

        log.debug(" -- Testing region " + region.getRegionName());

        List<Double> latitudes = region.getLatitudes();
        List<Double> longitudes = region.getLongitudes();

        log.debug(" -- Boundary points : {}", latitudes.size());

        for (int i = 0; i < latitudes.size(); i++) {
            containsAllPoints = containsAllPoints && region.containsPoint(latitudes.get(i), longitudes.get(i));
            if (!containsAllPoints) break; // fail fast
        }

        return containsAllPoints;
    }

//    @Test //longrunning
    public void for_each_pfa_pvc_region_boundary_points_should_return_true_for_that_region() {
        boolean valid = true;

        for (Region region : allPfaProvinceRegions) {
            valid = valid && containsAllBoundaryPoints(region);
            if (!valid) break; //fail fast;
        }

        assertThat(valid).isTrue().withFailMessage("Should return TRUE for all boundary points for a region");
    }

}
