package architecture.com.mavi.cleanarchitecture.sys.di.components;

import android.content.Context;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.sys.di.modules.UtilModule;
import architecture.com.mavi.cleanarchitecture.sys.util.AppExecutors;
import architecture.com.mavi.cleanarchitecture.sys.util.ResourceProvider;
import dagger.Component;

@Singleton
@Component(modules = UtilModule.class)
public interface UtilComponent {
	
	AppExecutors getAppExecutors();
	
	ResourceProvider getResourceProvider();
	
	Context getContext();
	
}
