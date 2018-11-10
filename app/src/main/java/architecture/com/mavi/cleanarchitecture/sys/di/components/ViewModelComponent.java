package architecture.com.mavi.cleanarchitecture.sys.di.components;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.sys.di.modules.ViewModelModule;
import architecture.com.mavi.cleanarchitecture.ui.main.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = ViewModelModule.class)
public interface ViewModelComponent {
	
	void inject(MainActivity view);
	
}
