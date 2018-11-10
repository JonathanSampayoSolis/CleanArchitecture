package architecture.com.mavi.cleanarchitecture.data.datasource.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import architecture.com.mavi.cleanarchitecture.data.entities.Name;

@Dao
public interface NameDaoDS {
	
	@Insert
	long insertName(Name name);
	
	@Query("SELECT * FROM name")
	List<Name> getAllNames();
	
}
