package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepo;
	
	@Override
	public void addPlaylist(Playlist playlist) 
	{
		playlistRepo.save(playlist);	
	}
	
	@Override
	public List<Playlist> fetchAllPalylists()
	{
		return playlistRepo.findAll();
	}

}
