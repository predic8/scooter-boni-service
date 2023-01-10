package com.predic8.scooter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class BonusAPI {

    @Autowired
    BonusService bonusService;

    @GetMapping("/user/{id}/bonus")
    public ResponseEntity<Integer> getBonusPointsForUser(@PathVariable String id) {
        return ResponseEntity.ok(bonusService.getcurrentBonus(id));
    }

}
