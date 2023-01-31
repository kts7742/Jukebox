package com.example.demo.repositories;

import com.example.demo.entities.Playlist;

import java.util.*;
public interface IPlaylistRepository {
    Playlist save(Playlist playlist);
    List<Playlist> findAll();
    Playlist findById(String name);
    String delete(String name);
    String addSong(String name, Long id);
    String deleteSong(String name, Long id);
}
