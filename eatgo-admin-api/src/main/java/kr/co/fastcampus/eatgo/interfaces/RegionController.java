package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RegionService;
import kr.co.fastcampus.eatgo.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> list() {
        List<Region> regions = regionService.getRegions();

        return regions;
    }
    @PostMapping("/regions")
    public ResponseEntity<?> create(
            @RequestBody Region resource
    ) throws URISyntaxException {
        //TODO: 지역 생성
        String name = resource.getName();

        Region region = regionService.addRegion(name);

        String url = "/regions/"+region.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
