package architecture.com.mavi.cleanarchitecture.sys.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import architecture.com.mavi.cleanarchitecture.data.datasource.db.AppDataBase;
import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class FrameWorkModule {
	
	@Provides
	public AppDataBase provideAppDatabase(Context context) {
		return Room.databaseBuilder(context, AppDataBase.class, AppDataBase.DB_NAME).build();
	}
	
}
