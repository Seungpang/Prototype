package com.example.withplaceprototype.domain.match.service;

import com.example.withplaceprototype.domain.match.client.AddressRepository;
import com.example.withplaceprototype.domain.match.domain.repository.LawdRepository;
import com.example.withplaceprototype.domain.match.domain.repository.MatchRepository;
import com.example.withplaceprototype.domain.match.dto.RequestRandomMatch;
import com.example.withplaceprototype.domain.user.domain.entity.Location;
import com.example.withplaceprototype.domain.user.domain.entity.User;
import com.example.withplaceprototype.domain.user.domain.repository.UserRepository;
import com.example.withplaceprototype.domain.user.exception.UserNotFoundException;
import com.example.withplaceprototype.global.common.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final LawdRepository lawdRepository;

    public String addressSearch(final Location location) {
        return addressRepository.findByQuery(location);
    }

    public void createRandomMatch(RequestRandomMatch requestMatch) {
        User user = findUserById(requestMatch.getUserId());

        getByLawdCd(user);

    }

    private String getByLawdCd(User user) {
        return findByLawdCd(addressSearch(user.getLocation()));
    }

    public String findByLawdCd(String address) {
        return lawdRepository.findLawdCd(address);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
            new UserNotFoundException(ErrorCode.NOT_FOUND_USER));
    }


}
