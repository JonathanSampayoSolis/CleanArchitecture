package architecture.com.mavi.cleanarchitecture.sys.di.components;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.domain.NameRepository;
import architecture.com.mavi.cleanarchitecture.sys.di.modules.DataSourceModule;
import dagger.Component;

@Singleton
@Component(modules = DataSourceModule.class)
public interface DataSourceComponent {
	
	void inject(NameRepository repository);
	
}
