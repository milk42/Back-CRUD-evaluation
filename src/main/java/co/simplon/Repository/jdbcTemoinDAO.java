package co.simplon.Repository;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.TemoinJdbc;

@Repository
public class jdbcTemoinDAO implements TemoinDAO {
	
	private DataSource dataSource;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public jdbcTemoinDAO(JdbcTemplate jdbcTemplate) {
		this.dataSource = jdbcTemplate.getDataSource();
	}

	
	@Override
	public List<TemoinJdbc> getAllTemoin() throws Exception {
		TemoinJdbc temoin;
		PreparedStatement prepstat = null;
		ResultSet rs;
		ArrayList<TemoinJdbc> listeTemoin = new ArrayList<TemoinJdbc>();
		String sql;
		
		
		try {
			
			sql = "SELECT DISTINCT * FROM temoin GROUP BY id";
			prepstat = dataSource.getConnection().prepareStatement(sql);
			
			rs = prepstat.executeQuery();
			
			logSQL(prepstat);
			
			while (rs.next()) {
				temoin = getTemoinFromResultSet(rs);
				listeTemoin.add(temoin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("sqlError !:" + prepstat.toString(), e);
			throw e;
			
		} finally {
			
			prepstat.close();
		}
		
		return listeTemoin;
	}
	
	



	

	@Override
	public TemoinJdbc getTemoin(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemoinJdbc insertTemoin(TemoinJdbc temoin) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemoinJdbc DeleteTemoin(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemoinJdbc UpdateTemoin(TemoinJdbc temoin) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private TemoinJdbc getTemoinFromResultSet(ResultSet rs) throws SQLException {
		TemoinJdbc temoin = new TemoinJdbc();
		temoin.setId(rs.getInt("id"));
		temoin.setNom(rs.getString("nom"));
		temoin.setTemoignage(rs.getString("temoignage"));
		return temoin;
	}
	
	private void logSQL(PreparedStatement prepstat) {
		String sql;
		if (prepstat == null)
			return;
		sql = prepstat.toString().substring(prepstat.toString().indexOf(":") +2);
		log.debug(sql);
	}


}
