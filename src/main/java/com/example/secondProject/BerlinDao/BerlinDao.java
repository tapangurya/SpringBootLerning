package com.example.secondProject.BerlinDao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.secondProject.BerlinDto.BerlinDto;
import com.example.secondProject.BerlioneRepository.BerlinRepository;

@Repository
public class BerlinDao {
	@Autowired
	BerlinRepository br;

	public String inset(BerlinDto bd) {
		br.save(bd);
		return "Record Inserted";

	}

	public BerlinDto fetchbyid(int id) {
		Optional<BerlinDto> op=br.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}

	}

	public String deleteById(int id) {
		Optional<BerlinDto> optionalDummy = br.findById(id);
		if (optionalDummy.isPresent()) {
			br.deleteById(id);
			return "Data deleted Successfully";
		}
		return "Data Not Found";
	}

	public List<BerlinDto> findall() {

		List<BerlinDto> b = br.findAll();
		if (b != null && !b.isEmpty()) {
			return b;
		}
		return null;

	}

	public String deleteAll() {
		List<BerlinDto> b = br.findAll();
		if (b.isEmpty()) {	
			return "Data is Not present";
		}
		else{
			br.deleteAll();
			return "Data All deleted";
			
		}

	}
	
	public BerlinDto update(int id) {
		Optional<BerlinDto> op=br.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
	
	public String update ( BerlinDto berlinDto) {
		br.save(berlinDto);
		return "Data Updated";
	}
}
