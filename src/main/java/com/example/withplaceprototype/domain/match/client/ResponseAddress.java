package com.example.withplaceprototype.domain.match.client;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseAddress {

    private List<Document> documents;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Document {
        private String region_type;
        private String code;
        private String address_name; //경기도 성남시 수정구 태평동
        private String region_1depth_name; //4자리
        private String region_2depth_name; //3자리
        private String region_3depth_name; //3자리
        private String region_4depth_name;
        private Double x;
        private Double y;
    }
}
