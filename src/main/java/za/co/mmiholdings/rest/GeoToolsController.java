package za.co.mmiholdings.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.mmiholdings.service.RegionMapping;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/geo")
public class GeoToolsController implements RegionMapping {

    private static final Logger log = LoggerFactory.getLogger(GeoToolsController.class);

    @Autowired
    @Qualifier("default")
    RegionMapping mapping;

    @Override
    @PostMapping("/pfaprovince")
    public String getPfaProvinceForCoordinate(@PathParam("latitude") String latitude, @PathParam("longitude") String longitude) {
        log.debug(" -- getPfaProvinceForCoordinate() for {} , {}", new Object[]{ latitude, longitude });
        return mapping.getPfaProvinceForCoordinate(latitude, longitude);
    }

    @Override
    @PostMapping("/pfaregion")
    public String getPfaRegionForCoordinate(@PathParam("latitude") String latitude, @PathParam("longitude") String longitude) {
        log.debug(" -- getPfaRegionForCoordinate() for {} , {}", new Object[]{ latitude, longitude });
        return mapping.getPfaRegionForCoordinate(latitude, longitude);
    }

    @Override
    @PostMapping("/rsaregion")
    public String getRsaRegionForCoordinate(@PathParam("latitude") String latitude, @PathParam("longitude") String longitude) {
        log.debug(" -- unimplemented -- ");
        return "Not implemented";
    }

}
