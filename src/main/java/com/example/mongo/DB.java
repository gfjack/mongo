package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DB implements CommandLineRunner {

    private HotelRepo repo;

    public DB(HotelRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("jack", 8, false),
                        new Review("simon", 9, true)
                )
        );
        Hotel ibis = new Hotel(
                "ibis",
                100,
                new Address("cq", "china"),
                Arrays.asList(
                        new Review("jack", 2, false)
                )
        );

        // drop all hotels
        this.repo.deleteAll();

        // add hotels
        List<Hotel> hotels = Arrays.asList(marriot, ibis);
        this.repo.save(marriot);

    }
}
