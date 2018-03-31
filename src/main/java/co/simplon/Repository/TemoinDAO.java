package co.simplon.Repository;

import java.util.List;

import co.simplon.ModelEntity.TemoinJdbc;

public interface TemoinDAO {
	
	public List<TemoinJdbc> getAllTemoin() throws Exception;
	public TemoinJdbc getTemoin(int id) throws Exception; 
	public TemoinJdbc insertTemoin(TemoinJdbc temoin) throws Exception;
	public TemoinJdbc DeleteTemoin(int id) throws Exception;
	public TemoinJdbc UpdateTemoin(TemoinJdbc temoin) throws Exception;

}
