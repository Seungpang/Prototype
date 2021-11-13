package com.example.withplaceprototype.domain.match.controller.api;

import static com.example.withplaceprototype.domain.match.controller.api.MatchController.MATCH_API_URI;

import com.example.withplaceprototype.domain.match.dto.RequestRandomMatch;
import com.example.withplaceprototype.domain.match.service.MatchService;
import com.example.withplaceprototype.domain.user.domain.entity.Location;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(MATCH_API_URI)
public class MatchController {

    public static final String MATCH_API_URI = "/api/match";

    private final MatchService matchService;

    @PostMapping("/random")
    public ResponseEntity<HttpStatus> randomMatch(@RequestBody @Valid RequestRandomMatch requestMatch) {
        matchService.createRandomMatch(requestMatch);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/test")
    public ResponseEntity<HttpStatus> test(@RequestBody Location location) {
        String test = matchService.addressSearch(location);
        log.info("법정동 코드={}", test);
        String cd = matchService.findByLawdCd(test);
        log.info("lawdCd={}", cd);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
