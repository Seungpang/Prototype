package com.example.withplaceprototype.domain.match.client;

import com.example.withplaceprototype.domain.match.client.ResponseAddress.Document;
import com.example.withplaceprototype.domain.match.exception.ClientAuthRuntimeException;
import com.example.withplaceprototype.domain.match.exception.ClientBadRequestRuntimeException;
import com.example.withplaceprototype.domain.match.exception.ClientRuntimeException;
import com.example.withplaceprototype.domain.user.domain.entity.Location;
import com.example.withplaceprototype.global.common.error.ErrorCode;
import com.example.withplaceprototype.global.config.KakaoProperties;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class AddressRepositoryImpl implements AddressRepository {

    private final RestTemplate restTemplate;
    private final KakaoProperties kakaoProperties;
    private HttpHeaders httpHeaders = new HttpHeaders();

    public AddressRepositoryImpl(RestTemplate restTemplate,
        KakaoProperties kakaoProperties) {
        this.restTemplate = restTemplate;
        this.kakaoProperties = kakaoProperties;
        this.httpHeaders.add("Authorization", "KakaoAK " + kakaoProperties.getClientSecret());
    }

    @Override
    public String findByQuery(final Location location) {

        var url = kakaoProperties.getPointAddressUrl() + "?x=" + location.getLongitude()+ "&y="
            + location.getLatitued();
        
        log.info(url);
        try {
            log.info("start api call");
            Document document = Objects.requireNonNull(restTemplate.exchange(url, HttpMethod.GET,
                        new HttpEntity(httpHeaders),
                        ResponseAddress.class)
                    .getBody())
                .getDocuments()
                .get(0);

            log.info("document={}", document);

            return document.getAddress_name();
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.UNAUTHORIZED.equals(ex.getStatusCode())) {
                throw new ClientAuthRuntimeException(ErrorCode.KAKAO_API_UNAUTHORIZED);
            } else if (HttpStatus.BAD_REQUEST.equals(ex.getStatusCode())) {
                throw new ClientBadRequestRuntimeException(ErrorCode.KAKAO_API_BAD_REQUEST);
            } else {
                throw new ClientRuntimeException(ErrorCode.KAKAO_API_ERROR);
            }
        } catch (RuntimeException ex) {
            throw new ClientRuntimeException(ErrorCode.KAKAO_API_ERROR);
        }
    }
}
