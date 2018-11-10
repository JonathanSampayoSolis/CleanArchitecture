package architecture.com.mavi.cleanarchitecture;

import android.app.Application;

import architecture.com.mavi.cleanarchitecture.sys.di.components.DaggerUtilComponent;
import architecture.com.mavi.cleanarchitecture.sys.di.components.UtilComponent;
import architecture.com.mavi.cleanarchitecture.sys.di.modules.ContextModule;

public class MainApp extends Application {
	
	public static UtilComponent utilComponent;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		utilComponent = DaggerUtilComponent.builder()
				.contextModule(new ContextModule(getApplicationContext()))
				.build();
	}
}
