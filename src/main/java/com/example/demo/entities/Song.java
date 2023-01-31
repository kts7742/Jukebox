package com.example.demo.entities;

public class Song {
    private Long id;
    private String name;
    private String artist;
    private String genre;
    private String album;

    public Song(Long id, String name, String artist, String album, String genre){
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }
    public Song(String name, String artist, String album, String genre){
        this(null, name, artist, album, genre);
    }
    public String getName(){
        return name;
    }
    public Long getId(){
        return id;
    }    
    public String getArtist(){
        return artist;
    }
    public String getGenre(){
        return genre;
    }
    public String getAlbum(){
        return album;
    }
    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }
}
