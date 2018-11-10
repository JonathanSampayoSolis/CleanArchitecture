package architecture.com.mavi.cleanarchitecture.sys.di.components;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.sys.di.modules.RepositoryModule;
import architecture.com.mavi.cleanarchitecture.ui.main.MainViewModel;
import dagger.Component;

@Singleton
@Component(modules = RepositoryModule.class)
public interface RepositoryComponent {
	
	void inject(MainViewModel viewModel);
	
}
