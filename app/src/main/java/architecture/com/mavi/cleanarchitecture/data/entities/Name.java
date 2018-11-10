package architecture.com.mavi.cleanarchitecture.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Name {
	
	@NonNull
	@PrimaryKey(autoGenerate = true)
	private int id;
	
	private String name;
	
	public Name() {
	}
	
	@Ignore
	public Name(String name) {
		this.name = name;
	}
	
	@NonNull
	public int getId() {
		return id;
	}
	
	public void setId(@NonNull int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
