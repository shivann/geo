package za.co.mmiholdings.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import za.co.mmiholdings.geo.Region;

import java.util.List;

@Component("default")
public class RegionMappingImpl implements RegionMapping {

    private static final Logger log = LoggerFactory.getLogger(Region.class);

    @Autowired
    @Qualifier("allPfaProvinces")
    List<Region> allPfaProvinces;

    @Autowired
    @Qualifier("allPfaProvinceRegions")
    List<Region> allPfaProvinceRegions;

    @Override
    public String getPfaProvinceForCoordinate(String latitude, String longitude) {
        log.debug(" -- getPfaProvinceForCoordinate() for {} , {}", new Object[]{ latitude, longitude });
        for (Region region : allPfaProvinces) {
            if (region.containsPoint(latitude, longitude)) return region.getRegionName();
        }

        return "";
    }

    @Override
    public String getPfaRegionForCoordinate(String latitude, String longitude) {
        log.debug(" -- getPfaRegionForCoordinate() for {} , {}", new Object[]{ latitude, longitude });
        for (Region region : allPfaProvinceRegions) {
            if (region.containsPoint(latitude, longitude)) return region.getRegionName();
        }

        return "";
    }

    @Override
    public String getRsaRegionForCoordinate(String latitude, String longitude) {
        return " -- Not implemented --";
    }

}
