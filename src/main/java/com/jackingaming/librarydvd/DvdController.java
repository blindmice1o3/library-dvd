package com.jackingaming.librarydvd;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DvdController {

    private List<Dvd> dvds = new ArrayList<Dvd>();

    public DvdController() {
    }

    @PostMapping(path = "/dvds")
    public void addDvd(@RequestBody Dvd dvd) {
        dvds.add(dvd);
    }

    @GetMapping(path = "/dvds/{id}")
    public Dvd getDvd(@PathVariable int id) {
        return dvds.get(id - 1);
    }

}