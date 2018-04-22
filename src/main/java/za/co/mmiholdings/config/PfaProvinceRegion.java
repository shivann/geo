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
public class PfaProvinceRegion {

    private static final Logger log = LoggerFactory.getLogger(PfaProvinceRegion.class);

    @Value("${application.kml.pfa_province_region.South_Coast}")
    private String SOUTH_COAST;

    @Value("${application.kml.pfa_province_region.Port_Elizabeth}")
    private String PORT_ELIZABETH;

    @Value("${application.kml.pfa_province_region.Cape_CBD_South}")
    private String CAPE_CBD_SOUTH;

    @Value("${application.kml.pfa_province_region.Dr_Segomotsi}")
    private String DR_SEGOMOTSI;

    @Value("${application.kml.pfa_province_region.Peninsula}")
    private String PENINSULA;

    @Value("${application.kml.pfa_province_region.Central_Free_State}")
    private String CENTRAL_FREE_STATE;

    @Value("${application.kml.pfa_province_region.Boland}")
    private String BOLAND;

    @Value("${application.kml.pfa_province_region.North_Eastern_Free_State}")
    private String NORTH_EASTERN_FREE_STATE;

    @Value("${application.kml.pfa_province_region.Northern_Cape}")
    private String NORTHERN_CAPE;

    @Value("${application.kml.pfa_province_region.Cape_West_Coast_Excl_Islands}")
    private String CAPE_WEST_COAST_EXCL_ISLANDS;

    @Value("${application.kml.pfa_province_region.Mount_Frere}")
    private String MOUNT_FRERE;

    @Value("${application.kml.pfa_province_region.East_London}")
    private String EAST_LONDON;

    @Value("${application.kml.pfa_province_region.Mthatha}")
    private String MTHATHA;

    @Value("${application.kml.pfa_province_region.Queenstown}")
    private String QUEENSTOWN;

    @Value("${application.kml.pfa_province_region.Ugu}")
    private String UGU;

    @Value("${application.kml.pfa_province_region.Illembe}")
    private String ILLEMBE;

    @Value("${application.kml.pfa_province_region.Ethekwini}")
    private String ETHEKWINI;

    @Value("${application.kml.pfa_province_region.Uthungulu}")
    private String UTHUNGULU;

    @Value("${application.kml.pfa_province_region.Umgungundlovu}")
    private String UMGUNGUNDLOVU;

    @Value("${application.kml.pfa_province_region.Northern_Zululand}")
    private String NORTHERN_ZULULAND;

    @Value("${application.kml.pfa_province_region.Tshwane_Central}")
    private String TSHWANE_CENTRAL;

    @Value("${application.kml.pfa_province_region.Tshwane_North}")
    private String TSHWANE_NORTH;

    @Value("${application.kml.pfa_province_region.Platinum_Belt_v2}")
    private String PLATINUM_BELT_V2;

    @Value("${application.kml.pfa_province_region.Ekurhuleni_North_Midrand_v2}")
    private String EKURHULENI_NORTH_MIDRAND_V2;

    @Value("${application.kml.pfa_province_region.Ekurhuleni_South}")
    private String EKURHULENI_SOUTH;

    @Value("${application.kml.pfa_province_region.Mpumalanga_Central}")
    private String MPUMALANGA_CENTRAL;

    @Value("${application.kml.pfa_province_region.JHB_Central}")
    private String JHB_CENTRAL;

    @Value("${application.kml.pfa_province_region.West_Rand}")
    private String WEST_RAND;

    @Value("${application.kml.pfa_province_region.Soweto}")
    private String SOWETO;

    @Value("${application.kml.pfa_province_region.Ngaka_Modiri_Molema}")
    private String NGAKA_MODIRI_MOLEMA;

    @Value("${application.kml.pfa_province_region.Dr_K_Kaunda}")
    private String DR_K_KAUNDA;

    @Value("${application.kml.pfa_province_region.Sedibeng}")
    private String SEDIBENG;

    @Value("${application.kml.pfa_province_region.Mbombela}")
    private String MBOMBELA;

    @Value("${application.kml.pfa_province_region.Limpopo_East}")
    private String LIMPOPO_EAST;

    @Value("${application.kml.pfa_province_region.Limpopo_West}")
    private String LIMPOPO_WEST;

    @Value("${application.kml.pfa_province_region.Limpopo_North}")
    private String LIMPOPO_NORTH;

    @Bean
    public Region southCoast() {
        return new Region("South_Coast", RegionType.PFA_PROVINCE_REGION, SOUTH_COAST);
    }

    @Bean
    public Region portElizabeth() {
        return new Region("Port_Elizabeth", RegionType.PFA_PROVINCE_REGION, PORT_ELIZABETH);
    }

    @Bean
    public Region capeCBDSouth() {
        return new Region("Cape_CBD_South", RegionType.PFA_PROVINCE_REGION, CAPE_CBD_SOUTH);
    }

    @Bean
    public Region drSegomotsi() {
        return new Region("Dr_Segomotsi", RegionType.PFA_PROVINCE_REGION, DR_SEGOMOTSI);
    }

    @Bean
    public Region peninsula() {
        return new Region("Peninsula", RegionType.PFA_PROVINCE_REGION, PENINSULA);
    }

    @Bean
    public Region centralFreeState() {
        return new Region("Central_Free_State", RegionType.PFA_PROVINCE_REGION, CENTRAL_FREE_STATE);
    }

    @Bean
    public Region boland() {
        return new Region("Boland", RegionType.PFA_PROVINCE_REGION, BOLAND);
    }

    @Bean
    public Region northEasternFreeState() {
        return new Region("North_Eastern_Free_State", RegionType.PFA_PROVINCE_REGION, NORTH_EASTERN_FREE_STATE);
    }

    @Bean
    public Region northernCape() {
        return new Region("Northern_Cape", RegionType.PFA_PROVINCE_REGION, NORTHERN_CAPE);
    }

    @Bean
    public Region capeWestCoastExclIslands() {
        return new Region("Cape_West_Coast_Excl_Islands", RegionType.PFA_PROVINCE_REGION, CAPE_WEST_COAST_EXCL_ISLANDS);
    }

    @Bean
    public Region mountFrere() {
        return new Region("Mount_Frere", RegionType.PFA_PROVINCE_REGION, MOUNT_FRERE);
    }

    @Bean
    public Region eastLondon() {
        return new Region("East_London", RegionType.PFA_PROVINCE_REGION, EAST_LONDON);
    }

    @Bean
    public Region mthatha() {
        return new Region("Mthatha", RegionType.PFA_PROVINCE_REGION, MTHATHA);
    }

    @Bean
    public Region queenstown() {
        return new Region("Queenstown", RegionType.PFA_PROVINCE_REGION, QUEENSTOWN);
    }

    @Bean
    public Region ugu() {
        return new Region("Ugu", RegionType.PFA_PROVINCE_REGION, UGU);
    }

    @Bean
    public Region illembe() {
        return new Region("Illembe", RegionType.PFA_PROVINCE_REGION, ILLEMBE);
    }

    @Bean
    public Region ethekwini() {
        return new Region("Ethekwini", RegionType.PFA_PROVINCE_REGION, ETHEKWINI);
    }

    @Bean
    public Region uthungulu() {
        return new Region("Uthungulu", RegionType.PFA_PROVINCE_REGION, UTHUNGULU);
    }

    @Bean
    public Region umgungundlovu() {
        return new Region("Umgungundlovu", RegionType.PFA_PROVINCE_REGION, UMGUNGUNDLOVU);
    }

    @Bean
    public Region northernZululand() {
        return new Region("Northern_Zululand", RegionType.PFA_PROVINCE_REGION, NORTHERN_ZULULAND);
    }

    @Bean
    public Region tshwaneCentral() {
        return new Region("Tshwane_Central", RegionType.PFA_PROVINCE_REGION, TSHWANE_CENTRAL);
    }

    @Bean
    public Region tshwaneNorth() {
        return new Region("Tshwane_North", RegionType.PFA_PROVINCE_REGION, TSHWANE_NORTH);
    }

    @Bean
    public Region limpopoEast() {
        return new Region("Limpopo_East", RegionType.PFA_PROVINCE_REGION, LIMPOPO_EAST);
    }

    @Bean
    public Region limpopoWest() {
        return new Region("Limpopo_West", RegionType.PFA_PROVINCE_REGION, LIMPOPO_WEST);
    }

    @Bean
    public Region limpopoNorth() {
        return new Region("Limpopo_North", RegionType.PFA_PROVINCE_REGION, LIMPOPO_NORTH);
    }

    @Bean
    public Region mbombela() {
        return new Region("Mbombela", RegionType.PFA_PROVINCE_REGION, MBOMBELA);
    }

    @Bean
    public Region sedibeng() {
        return new Region("Sedibeng", RegionType.PFA_PROVINCE_REGION, SEDIBENG);
    }

    @Bean
    public Region soweto() {
        return new Region("Soweto", RegionType.PFA_PROVINCE_REGION, SOWETO);
    }

    @Bean
    public Region westRand() {
        return new Region("West_Rand", RegionType.PFA_PROVINCE_REGION, WEST_RAND);
    }

    @Bean
    public Region ekurhuleniSouth() {
        return new Region("Ekurhuleni_South", RegionType.PFA_PROVINCE_REGION, EKURHULENI_SOUTH);
    }

    @Bean
    public Region ekurhuleniNorthMidrandV2() {
        return new Region("Ekurhuleni_North_Midrand_v2", RegionType.PFA_PROVINCE_REGION, EKURHULENI_NORTH_MIDRAND_V2);
    }

    @Bean
    public Region drKKaunda() {
        return new Region("Dr_K_Kaunda", RegionType.PFA_PROVINCE_REGION, DR_K_KAUNDA);
    }

    @Bean
    public Region ngakaModiriMolema() {
        return new Region("Ngaka_Modiri_Molema", RegionType.PFA_PROVINCE_REGION, NGAKA_MODIRI_MOLEMA);
    }

    @Bean
    public Region platinumBeltV2() {
        return new Region("Platinum_Belt_v2", RegionType.PFA_PROVINCE_REGION, PLATINUM_BELT_V2);
    }

    @Bean
    public Region mpumalangaCentral() {
        return new Region("Mpumalanga_Central", RegionType.PFA_PROVINCE_REGION, MPUMALANGA_CENTRAL);
    }

    @Bean
    public Region jhbCentral() {
        return new Region("JHB_Central", RegionType.PFA_PROVINCE_REGION, JHB_CENTRAL);
    }

    @Bean("allPfaProvinceRegions")
    public List<Region> allPfaProvinceRegions() {
        List<Region> allRegions = new ArrayList<>();

        allRegions.add(southCoast());
        allRegions.add(portElizabeth());
        allRegions.add(capeCBDSouth());
        allRegions.add(drSegomotsi());
        allRegions.add(peninsula());
        allRegions.add(centralFreeState());
        allRegions.add(boland());
        allRegions.add(northEasternFreeState());
        allRegions.add(northernCape());
        allRegions.add(capeWestCoastExclIslands());
        allRegions.add(mountFrere());
        allRegions.add(eastLondon());
        allRegions.add(mthatha());
        allRegions.add(queenstown());
        allRegions.add(ugu());
        allRegions.add(illembe());
        allRegions.add(ethekwini());
        allRegions.add(uthungulu());
        allRegions.add(umgungundlovu());
        allRegions.add(northernZululand());
        allRegions.add(tshwaneCentral());
        allRegions.add(tshwaneNorth());
        allRegions.add(limpopoEast());
        allRegions.add(limpopoWest());
        allRegions.add(limpopoNorth());
        allRegions.add(sedibeng());
        allRegions.add(mbombela());
        allRegions.add(soweto());
        allRegions.add(westRand());
        allRegions.add(ekurhuleniSouth());
        allRegions.add(ekurhuleniNorthMidrandV2());
        allRegions.add(drKKaunda());
        allRegions.add(ngakaModiriMolema());
        allRegions.add(platinumBeltV2());
        allRegions.add(mpumalangaCentral());
        allRegions.add(jhbCentral());

        log.debug(" -- Loaded province regions {}", allRegions.size());

        return allRegions;
    }

}
