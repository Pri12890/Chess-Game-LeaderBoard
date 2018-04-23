package models;

import java.io.File;

public class UpdatedUserProfile {
	final String desc;
	final File file;

	public UpdatedUserProfile(String desc, File file) {
		this.desc = desc;
		this.file = file;
	}

	public String getDesc() {
		return desc;
	}

	public File getFile() {
		return file;
	}
}
