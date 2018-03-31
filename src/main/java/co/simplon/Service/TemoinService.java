package co.simplon.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.ModelEntity.TemoinJdbc;
import co.simplon.Repository.TemoinDAO;

@Service
public class TemoinService {
	
	@Autowired
	private TemoinDAO dao;
	
	public List<TemoinJdbc> getAllTemoin() throws Exception {
		
		return dao.getAllTemoin();
	}
	
	
}
