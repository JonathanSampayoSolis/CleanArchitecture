package architecture.com.mavi.cleanarchitecture.sys.di.modules;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
	
	private FragmentActivity fragmentActivity;
	
	private Fragment fragment;
	
	private Context context;
	
	public ContextModule(FragmentActivity fragmentActivity) {
		this.fragmentActivity = fragmentActivity;
	}
	
	public ContextModule(Fragment fragment) {
		this.fragment = fragment;
	}
	
	public ContextModule(Context context) {
		this.context = context;
	}
	
	@Singleton
	@Provides
	public FragmentActivity provideFragmentActivity() {
		return this.fragmentActivity;
	}
	
	@Singleton
	@Provides
	public Fragment provideFragment() {
		return this.fragment;
	}
	
	@Singleton
	@Provides
	public Context provideContext() {
		return this.context;
	}
	
}
