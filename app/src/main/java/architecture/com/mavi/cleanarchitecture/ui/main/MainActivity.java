package architecture.com.mavi.cleanarchitecture.ui.main;

import android.annotation.SuppressLint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import architecture.com.mavi.cleanarchitecture.R;
import architecture.com.mavi.cleanarchitecture.data.entities.Name;
import architecture.com.mavi.cleanarchitecture.sys.di.components.DaggerViewModelComponent;
import architecture.com.mavi.cleanarchitecture.sys.di.modules.ContextModule;

public class MainActivity extends AppCompatActivity {
	
	@Inject
	MainViewModel viewModel;
	
	private EditText editText;
	
	private LinearLayout linearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// init dagger
		DaggerViewModelComponent.builder()
				.contextModule(new ContextModule(this))
				.build().inject(this);
		
		// init view
		editText = findViewById(R.id.act_main_edittext);
		linearLayout = findViewById(R.id.act_main_layout);
		FloatingActionButton fab = findViewById(R.id.act_main_fab);
		
		// view behavior
		fab.setOnClickListener(v -> viewModel.insertNewName(editText.getText().toString().trim()));
		
		// observe steams
		observeStreams();
		
		// request names
		viewModel.requestNames();
	}
	
	//region:: PRIVATE METHODS
	
	
	private void observeStreams() {
		viewModel.onSetSuccessful.observe(this, this::newNameSuccess);
		
		viewModel.onSetFailure.observe(this, this::newNameFailure);
		
		viewModel.onNameError.observe(this, this::newNameFailure);
		
		viewModel.onRequestNamesSuccessful.observe(this, this::populateLayout);
		
		viewModel.onRequestNamesFailure.observe(this, this::newNameFailure);
		
	}
	
	private View buildNameView(String name) {
		@SuppressLint("InflateParams")
		View view = LayoutInflater.from(this).inflate(R.layout.item_act_main_name, null, false);
		((TextView) view.findViewById(R.id.item_name)).setText(name);
		
		return view;
	}
	
	//endregion
	
	//region:: REFERENCE METHODS
	
	private void newNameSuccess(@SuppressWarnings("unused") Object object) {
		editText.setText("");
		viewModel.refreshNames();
		Toast.makeText(this, getString(R.string.si_se_pudo), Toast.LENGTH_SHORT).show();
	}
	
	private void newNameFailure(Object s) {
		Toast.makeText(this, (CharSequence) s, Toast.LENGTH_SHORT).show();
	}
	
	private void populateLayout(List<Name> names) {
		linearLayout.removeAllViews();
		for (Name n: names) {
			linearLayout.addView(buildNameView(n.getName()));
		}
	}
	
	//endregion
	
}
