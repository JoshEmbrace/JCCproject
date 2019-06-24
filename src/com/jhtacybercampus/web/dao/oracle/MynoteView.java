package com.jhtacybercampus.web.dao.oracle;


import java.util.Date;

import com.jhtacybercampus.web.entity.Mynote;

public class MynoteView extends Mynote{

	private String fileName;
	private int fileId;
	
	
	public MynoteView() {

	}

	public MynoteView(int id, String content, Date reg_date, int writer_id) {
		super(id, content, reg_date, writer_id);
	}

	public MynoteView(int id, String content, Date reg_date, String fileName, int fileId) {
		super(id, content, reg_date);
		this.fileName = fileName;
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}


}
