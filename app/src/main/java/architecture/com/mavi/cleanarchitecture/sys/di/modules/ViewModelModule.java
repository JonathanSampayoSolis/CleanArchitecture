package architecture.com.mavi.cleanarchitecture.sys.di.modules;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import architecture.com.mavi.cleanarchitecture.ui.main.MainViewModel;
import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class ViewModelModule {
	
	@Provides
	public MainViewModel provideMainViewModel(FragmentActivity fragmentActivity) {
		return ViewModelProviders.of(fragmentActivity).get(MainViewModel.class);
	}
	
}
