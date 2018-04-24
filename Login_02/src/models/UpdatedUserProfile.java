package models;

import java.io.File;

/**
 * This class has the responsibility to store data for update into database.
 */
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
