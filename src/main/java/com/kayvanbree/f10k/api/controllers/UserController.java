package com.kayvanbree.f10k.api.controllers;

import com.kayvanbree.f10k.api.models.Collection;
import com.kayvanbree.f10k.api.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
    @Autowired
    private CollectionRepository collectionRepository;

    @GetMapping("/{id}/collection")
    public Collection getCollection(String id) {
        return collectionRepository.getOne(id);
    }

    @GetMapping("/{id}/collection/tracks")
    public List<String> getTrackCollection(String id) {
        return collectionRepository.getOne(id).getTracks();
    }

    @GetMapping("/{id}/collection/albums")
    public List<String> getAlbumCollection(String id) {
        return collectionRepository.getOne(id).getAlbums();
    }

    @GetMapping("/{id}/collection/artists")
    public List<String> getArtistCollection(String id) {
        return collectionRepository.getOne(id).getArtists();
    }
}
