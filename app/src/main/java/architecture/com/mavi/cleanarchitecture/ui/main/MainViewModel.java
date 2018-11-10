package architecture.com.mavi.cleanarchitecture.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import architecture.com.mavi.cleanarchitecture.MainApp;
import architecture.com.mavi.cleanarchitecture.R;
import architecture.com.mavi.cleanarchitecture.data.entities.Name;
import architecture.com.mavi.cleanarchitecture.domain.NameRepository;
import architecture.com.mavi.cleanarchitecture.sys.di.components.DaggerRepositoryComponent;
import architecture.com.mavi.cleanarchitecture.sys.util.ReactiveEvent;
import architecture.com.mavi.cleanarchitecture.sys.util.ResourceProvider;

public class MainViewModel extends ViewModel {
	
	@Inject
	NameRepository nameRepository;
	
	private ResourceProvider resourceProvider;
	
	ReactiveEvent<String> onNameError;
	
	ReactiveEvent<Boolean> onSetSuccessful;
	ReactiveEvent<String> onSetFailure;
	
	MutableLiveData<List<Name>> onRequestNamesSuccessful;
	ReactiveEvent<String> onRequestNamesFailure;
	
	private List<Name> names;
	
	public MainViewModel() {
		DaggerRepositoryComponent.builder()
				.build().inject(this);
		
		resourceProvider = MainApp.utilComponent.getResourceProvider();
		
		onRequestNamesSuccessful = new MutableLiveData<>();
		
		onNameError = new ReactiveEvent<>();
		
		onSetSuccessful = new ReactiveEvent<>();
		onSetFailure = new ReactiveEvent<>();
		onRequestNamesFailure = new ReactiveEvent<>();
	}
	
	void insertNewName(String name) {
		
		if (name.length() <= 0) {
			onNameError.setValue(resourceProvider.getString(R.string.name_error));
			return;
		}
		
		nameRepository.setName(name, this::onSetName);
		
	}
	
	void requestNames() {
		nameRepository.getNames(this::onRequestNames);
	}
	
	void refreshNames() {
		nameRepository.getNames(this::onRefreshNames);
	}
	
	//region:: REFERENCE METHODS
	
	private void onSetName(Boolean result) {
		if (result)
			onSetSuccessful.callOnThread();
		else
			onSetFailure.postValue(resourceProvider.getString(R.string.error));
		
	}
	
	private void onRequestNames(Object o) {
		if (o instanceof String) {
			onRequestNamesFailure.postValue((String) o);
		} else {
			if (names == null)
				//noinspection unchecked
				names = (List<Name>) o;
			onRequestNamesSuccessful.postValue(names);
		}
	}
	
	private void onRefreshNames(Object o) {
		if (o instanceof String) {
			onRequestNamesFailure.postValue((String) o);
		} else {
			//noinspection unchecked
			onRequestNamesSuccessful.postValue((List<Name>) o);
		}
	}
	
	//endregion
	
}
