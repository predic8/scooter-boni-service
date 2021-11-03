package com.predic8.scooter;

import com.predic8.scooter.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BonusService {

    @Autowired
    KundenRepository kundenRepo;

    public void addBonusForUser(String kundenId) {
        Optional<Kunde> kunde = kundenRepo.findById(kundenId);

        Kunde k = kunde.orElseGet(() -> new Kunde(kundenId));
        k.setBonuspunkte(k.getBonuspunkte() + 5);
        kundenRepo.save(k);
    }

    public int getcurrentBonus(String kundenId) {
        Optional<Kunde> kunde = kundenRepo.findById(kundenId);
        return kunde.map(value -> (int) value.getBonuspunkte()).orElse(0);
    }
}
