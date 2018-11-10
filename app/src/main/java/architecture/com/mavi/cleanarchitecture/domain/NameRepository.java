package architecture.com.mavi.cleanarchitecture.domain;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import architecture.com.mavi.cleanarchitecture.MainApp;
import architecture.com.mavi.cleanarchitecture.data.datasource.db.dao.NameDaoDS;
import architecture.com.mavi.cleanarchitecture.data.datasource.memory.NameMemoryDS;
import architecture.com.mavi.cleanarchitecture.data.datasource.web.NameWebDS;
import architecture.com.mavi.cleanarchitecture.data.entities.Name;
import architecture.com.mavi.cleanarchitecture.sys.di.components.DaggerDataSourceComponent;
import architecture.com.mavi.cleanarchitecture.sys.di.modules.ContextModule;
import architecture.com.mavi.cleanarchitecture.sys.util.AppExecutors;

public class NameRepository {
	
	@Inject
	NameDaoDS daoDS;
	
	@Inject
	NameMemoryDS memoryDS;
	
	@Inject
	NameWebDS webDS;
	
	private AppExecutors executors;
	
	public NameRepository() {
		DaggerDataSourceComponent.builder()
				.contextModule(new ContextModule(MainApp.utilComponent.getContext()))
				.build().inject(this);
		
		executors = MainApp.utilComponent.getAppExecutors();
	}
	
	public void setName(String text, Observer<Boolean> observer) {
		executors.diskIO().execute(() -> observer.onChanged(daoDS.insertName(new Name(text)) > 0));
	}
	
	public void getNames(Observer<Object> observer) {
		executors.diskIO().execute(() -> {
			try {
			observer.onChanged(daoDS.getAllNames());
			} catch (Exception e) {
				observer.onChanged(e.getMessage());
			}
		});
	}
	
}
