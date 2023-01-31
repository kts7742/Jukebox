package com.example.demo.services;
import java.util.*;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;

public class PlaylistService {
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }
    public Playlist createPlaylist(String name, List<Long> songs){
        Playlist p = new Playlist(name, songs);
        Playlist savedPlaylist = playlistRepository.save(p);
        return savedPlaylist;
    }
    public String deletePlaylist(String name){
        String ans = playlistRepository.delete(name);
        return ans;
    }
    public String addSongPlaylist(String name, Long id){
        String ans = playlistRepository.addSong(name, id);
        return ans;
    }
    public String deleteSongPlaylist(String name, Long id){
        String ans = playlistRepository.deleteSong(name, id);
        return ans;
    }
    Player p;
    public String loadPlaylist(String name){
        Playlist playlist = playlistRepository.findById(name);
        List<Long> songs = playlist.getsongs();
         p = new Player(songs);
        return "Playlist " + name + " is loaded!"; 
    }
    public String playSong(){
        return p.play();
    }
    public String nextSong(){
        return p.next();
    }public String previousSong(){
        return p.previous();
    }
    public String stopSong(){
        return p.stop();
    }
}
