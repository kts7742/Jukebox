package com.example.demo.repositories;

import com.example.demo.entities.*;
import java.util.*;
public interface ISongRepository {
    Song save(Song song);
    List<Song> findAll();
    Song findById(Long id);
}
