package com.abogomazov.injectemall.blacklist;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.order.core.services.BuyersBlackList;

public class PretentiousFilmmakersList implements BuyersBlackList {

    private static final List<String> names = List.of(
            "Andrei Tarkovsky", "Federico Fellini", "Kazimierz Kutz"
    );

    @Override
    public boolean contains(Buyer buyer) {
        return names.contains(buyer.name());
    }

    public static int counter = 0;
    public PretentiousFilmmakersList() { counter++; }
    public static void resetCounter() {
        counter = 0;
    }
}
