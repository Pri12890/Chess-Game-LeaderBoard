package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javafx.scene.image.Image;

public class UserProfile {

	
 final String name;
 final String pwd;
 final String desc;
 final File file;
public UserProfile(String name, String pwd, String desc, File file) {
	this.name = name;
	this.pwd = pwd;
	this.desc = desc;
	this.file = file;
}


public String getName() {
	return name;
}
public String getPwd() {
	return pwd;
}
public String getDesc() {
	return desc;
}

public File getFile() {
	return file;
}
 
}
