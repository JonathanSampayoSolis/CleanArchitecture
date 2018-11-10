package architecture.com.mavi.cleanarchitecture.data.datasource.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import architecture.com.mavi.cleanarchitecture.data.datasource.db.dao.NameDaoDS;
import architecture.com.mavi.cleanarchitecture.data.entities.Name;

@Database(entities = {Name.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
	
	public static final String DB_NAME = "my_db";
	
	public abstract NameDaoDS getNameDao();
	
}
