package architecture.com.mavi.cleanarchitecture.sys.di.modules;

import javax.inject.Singleton;

import architecture.com.mavi.cleanarchitecture.domain.NameRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
	
	@Provides
	@Singleton
	public NameRepository provideNameRepository() {
		return new NameRepository();
	}
	
}
