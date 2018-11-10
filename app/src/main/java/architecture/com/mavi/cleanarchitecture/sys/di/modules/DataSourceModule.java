package architecture.com.mavi.cleanarchitecture.sys.di.modules;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.data.datasource.db.AppDataBase;
import architecture.com.mavi.cleanarchitecture.data.datasource.db.dao.NameDaoDS;
import architecture.com.mavi.cleanarchitecture.data.datasource.memory.NameMemoryDS;
import architecture.com.mavi.cleanarchitecture.data.datasource.web.NameWebDS;
import dagger.Module;
import dagger.Provides;

@Module(includes = FrameWorkModule.class)
public class DataSourceModule {
	
	@Singleton
	@Provides
	public NameMemoryDS provideNameMemoryDS() {
		return new NameMemoryDS();
	}
	
	@Singleton
	@Provides
	public NameDaoDS provideNameDaoDS(AppDataBase appDataBase) {
		return appDataBase.getNameDao();
	}
	
	@Singleton
	@Provides
	public NameWebDS provideNameWebDS() {
		return new NameWebDS();
	}
	
}
