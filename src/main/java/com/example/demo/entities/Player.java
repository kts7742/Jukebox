package com.example.demo.entities;
import java.util.*;
import com.example.demo.repositories.PlayListRepository;

public class Player {
    private List<Long> songs;
    private Playlist playlist;
    private int status;
    private int idx;
    // PlayListRepository playListRepository = new PlayListRepository();  

    public Player(List<Long> songs){
        this.songs = songs;
        status = 0;
        idx = 0;
    }
    public String play(){
        if(status == 0){
            status = 1;
            Long id = songs.get(idx);
            return "Song [id=" + id +"] is playing!";
        }else{
            status = 0;
            Long id = songs.get(idx);
            return "Song [id=" + id +"] is paused!";
        }
    }
    public String next(){
        idx++;
        if(idx > songs.size()-1){
            idx = 0;
        }
        status = 1;
        Long id = songs.get(idx);
        return "Song [id=" + id +"] is playing!";
    }
    public String previous(){
        idx--;
        if(idx < 0){
            idx = songs.size()-1;
        }
        status = 1;
        Long id = songs.get(idx);
        return "Song [id=" + id +"] is playing!";
    }
    public String stop(){
        status = 0;
        Long id = songs.get(idx);
        return "Song [id=" + id +"] is stopped!";
    }

}
