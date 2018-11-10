package architecture.com.mavi.cleanarchitecture.sys.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.sys.util.AppExecutors;
import architecture.com.mavi.cleanarchitecture.sys.util.ResourceProvider;
import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class UtilModule {
	
	@Provides
	@Singleton
	public AppExecutors provideAppExecutors() {
		return new AppExecutors();
	}
	
	@Provides
	public ResourceProvider provideResourceProvider(Context context) {
		return new ResourceProvider(context);
	}
	
}
