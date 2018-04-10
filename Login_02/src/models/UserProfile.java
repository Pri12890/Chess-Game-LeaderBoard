package models;

import javafx.scene.image.Image;

public class UserProfile {

	
 final String name;
 final String pwd;
 final String desc;
 final Image image;
public UserProfile(String name, String pwd, String desc, Image image) {
	this.name = name;
	this.pwd = pwd;
	this.desc = desc;
	this.image = image;
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
public Image getImage() {
	return image;
}
 
}
