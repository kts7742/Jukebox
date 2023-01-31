package com.example.demo.entities;
import java.util.*;
public class Playlist {
    private String name;
    private List<Long> songs;
    private Long id;

    public Playlist(Long id, String name, List<Long> songs){
        this.id = id;
        this.name = name;
        this.songs = songs;
    }
    public Playlist(String name, List<Long> songs){
        this(null, name, songs);
    }
    public String getName(){
        return name;
    }
    public List<Long> getsongs(){
        return songs;
    }
    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
}
