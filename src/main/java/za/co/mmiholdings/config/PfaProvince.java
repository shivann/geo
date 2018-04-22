package za.co.mmiholdings.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import za.co.mmiholdings.geo.Region;
import za.co.mmiholdings.geo.RegionType;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PfaProvince {

    private static final Logger log = LoggerFactory.getLogger(PfaProvince.class);

    @Value("${application.kml.pfa_province.Cape_Free_State_Excl_Islands}")
    private String CAPE_FREE_STATE_EXCL_ISLANDS;

    @Value("${application.kml.pfa_province.KwaZulu_Natal}")
    private String KWAZULU_NATAL;

    @Value("${application.kml.pfa_province.Gauteng_South_West}")
    private String GAUTENG_SOUTH_WEST;

    @Value("${application.kml.pfa_province.Eastern_Cape}")
    private String EASTERN_CAPE;

    @Value("${application.kml.pfa_province.Gauteng_North_East}")
    private String GAUTENG_NORTH_EAST;

    @Value("${application.kml.pfa_province.Limpopo_Mpumalanga}")
    private String LIMPOPO_MPUMALANGA;

    @Bean
    public Region  capeFreeStateExclIslands() {
        return new Region("Cape_Free_State_Excl_Islands", RegionType.PFA_PROVINCE, CAPE_FREE_STATE_EXCL_ISLANDS);
    }

    @Bean
    public Region kwazuluNatal() {
        return new Region("KwaZulu_Natal", RegionType.PFA_PROVINCE, KWAZULU_NATAL);
    }

    @Bean
    public Region gautengSouthWest() {
        return new Region("Gauteng_South_West", RegionType.PFA_PROVINCE, GAUTENG_SOUTH_WEST);
    }

    @Bean
    public Region gautengNorthEast() {
        return new Region("Gauteng_North_East", RegionType.PFA_PROVINCE, GAUTENG_NORTH_EAST);
    }

    @Bean
    public Region easternCape() {
        return new Region("Eastern_Cape", RegionType.PFA_PROVINCE, EASTERN_CAPE);
    }

    @Bean
    public Region limpopoMpumalanga() {
        return new Region("Limpopo_Mpumalanga", RegionType.PFA_PROVINCE, LIMPOPO_MPUMALANGA);
    }

    @Bean("allPfaProvinces")
    public List<Region> allPfaProvinces() {
        List<Region> allRegions = new ArrayList<>();

        allRegions.add(capeFreeStateExclIslands());
        allRegions.add(kwazuluNatal());
        allRegions.add(gautengSouthWest());
        allRegions.add(gautengNorthEast());
        allRegions.add(easternCape());
        allRegions.add(limpopoMpumalanga());

        log.debug(" -- Loaded provinces {}", allRegions.size());

        return allRegions;
    }

}
