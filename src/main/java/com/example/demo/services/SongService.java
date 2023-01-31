package com.example.demo.services;
import com.example.demo.repositories.*;
import com.example.demo.entities.*;
import java.util.*;

public class SongService {
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song addSong(String name, String artist, String album, String genre) {
        Song song = new Song(name, artist, album, genre);
        return songRepository.save(song);
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }
}
