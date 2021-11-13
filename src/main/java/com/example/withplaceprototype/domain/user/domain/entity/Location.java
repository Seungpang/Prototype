package com.example.withplaceprototype.domain.user.domain.entity;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Location {

    private Double longitude; //경도

    private Double latitued; //위도

    //Haversine 공식을 이용한 거리계산
}
