package architecture.com.mavi.cleanarchitecture.sys.util;

import android.content.Context;

import javax.inject.Inject;

public class ResourceProvider {
	
	private Context context;
	
	@Inject
	public ResourceProvider(Context context) {
		this.context = context;
	}
	
	public String getString(int id) {
		return context.getString(id);
	}
	
	public int getColor(int id) {
		return context.getResources().getColor(id);
	}
	
}
