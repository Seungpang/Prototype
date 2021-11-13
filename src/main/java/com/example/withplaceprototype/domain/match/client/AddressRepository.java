package com.example.withplaceprototype.domain.match.client;

import com.example.withplaceprototype.domain.user.domain.entity.Location;

public interface AddressRepository {

    String findByQuery(Location location);
}
