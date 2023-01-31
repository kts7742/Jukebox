package com.example.demo.repositories;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public class PlayListRepository implements IPlaylistRepository{
    private final Map<String,Playlist> playlistMap;
    private SongRepository songRepository = new SongRepository();
    private Long autoIncrement = 1L;

    public PlayListRepository(){
        playlistMap = new HashMap<String,Playlist>();
    }
    @Override
    public Playlist save(Playlist playlist) {
            Playlist p = new Playlist(autoIncrement, playlist.getName(), playlist.getsongs());
            playlistMap.put(playlist.getName(),p);
            autoIncrement++;
            return p;
    }
   @Override
   public List<Playlist> findAll(){
    return playlistMap.values().stream().collect(Collectors.toList());
   }
   @Override
   public Playlist findById(String name){
    return playlistMap.get(name);
   }
   
   public String delete(String name){
    playlistMap.remove(name);
    return  "Playlist " +name+ " is deleted!";
   }
   public String addSong(String name, Long id){
    Playlist p = playlistMap.get(name);
    List<Long> songs = p.getsongs();
    songs.add(id);
    int idx = 0;
    String ans = "Playlist " + name + " is revised with [";
    while(idx < songs.size()){
        if(idx == songs.size()-1){
            ans += "Song [id=" + songs.get(idx) + "]";
            break;
        }
        ans += "Song [id=" + songs.get(idx) + "], ";
        idx++;
    }
    ans += "]";
    return ans;
   }

   public String deleteSong(String name, Long id){
    Playlist p = playlistMap.get(name);
    List<Long> songs = p.getsongs();
    songs.remove(id);
    int idx = 0;
    String ans = "Playlist " + name + " is revised with [";
    while(idx < songs.size()){
        if(idx == songs.size()-1){
            ans += "Song [id=" + songs.get(idx) + "]";
            break;
        }
        ans += "Song [id=" + songs.get(idx) + "], ";
        idx++;
    }
    ans += "]";
    return ans;
   }
}
