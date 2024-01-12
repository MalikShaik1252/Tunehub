package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepo;
	@Override
	public void addSong(Song song) {
		songRepo.save(song);
	}
	
	@Override
	public List<Song> fetchAllSongs() {
		return songRepo.findAll();
		
	}

	@Override
	public boolean songExists(String name) {
		Song song = songRepo.findByName(name);
		if(song == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public void updateSong(Song s)
	{
		songRepo.save(s);
		
	}

}
