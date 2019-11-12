package com.kimyunjae.member.vo;

public class MemberFile {
	private int fileno;
	private String email;
	private String originname;
	private String filename;
	private String mimetype;
	private String filepath;
	private int filesize;
	private String date;

	public MemberFile() {};
	public MemberFile(int fileno, String email, String originname, String filename, String mimetype, String filepath,
			int filesize, String date) {
		super();
		this.fileno = fileno;
		this.email = email;
		this.originname = originname;
		this.filename = filename;
		this.mimetype = mimetype;
		this.filepath = filepath;
		this.filesize = filesize;
		this.date = date;
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOriginname() {
		return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MemberFile [fileno=" + fileno + ", email=" + email + ", originname=" + originname + ", filename="
				+ filename + ", mimetype=" + mimetype + ", filepath=" + filepath + ", filesize=" + filesize + ", date="
				+ date + "]";
	}
	
	
}
