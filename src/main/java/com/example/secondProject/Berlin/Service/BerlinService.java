package com.example.secondProject.Berlin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.secondProject.BerlinDao.BerlinDao;
import com.example.secondProject.BerlinDto.BerlinDto;


@Service
public class BerlinService {
@Autowired
	BerlinDao berlinDao;
	public String insert(BerlinDto berlinDto) {
		return berlinDao.inset(berlinDto);
	}
	public BerlinDto fetchByid(int id) {
		return berlinDao.fetchbyid(id);
		
	}
	public String deleteById(int id) {
		return berlinDao.deleteById(id);
	}
	
	public String deleteAll() {
		return berlinDao.deleteAll();
	}
	public List<BerlinDto> findAll() {
		
		return berlinDao.findall();
	}
	public BerlinDto update(int id) {
		return berlinDao.update(id);
	}
	
	public String update(BerlinDto bd) {
		return berlinDao.update(bd);
	}
}
