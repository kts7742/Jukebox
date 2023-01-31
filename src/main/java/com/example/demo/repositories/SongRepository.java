package com.example.demo.repositories;
import com.example.demo.entities.*;
import java.util.*;
import java.util.stream.Collectors;

public class SongRepository implements ISongRepository{
    private final Map<Long, Song> songMap;
    private Long autoIncrement = 1L;

    public SongRepository(){
        songMap = new HashMap<>();
    }
    @Override
    public Song save(Song song) {
        // Create a new Question object with all the parameters with an unique ID.
        Song s = new Song(autoIncrement, song.getName(),song.getArtist(),song.getAlbum(), song.getGenre());
        // Store the newly created question object to HashMap.
        songMap.put(autoIncrement,s);
        // Increment the variable which will be used when next question is saved.
        ++autoIncrement;
        return s;
    }
    @Override
    public List<Song> findAll(){
        return songMap.values().stream().collect(Collectors.toList());
    }
    @Override
    public Song findById(Long id){
        return songMap.get(id);
    }
    public List<Song> ffhelp(List<Long> songs){
        List<Song> list = new ArrayList<>();
        int idx = 0;
        while(idx < songs.size()){
            list.add(songMap.get(songs.get(idx)));
            idx++;
        }
        return list;
    }
}
