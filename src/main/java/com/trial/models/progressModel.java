package com.trial.models;

import java.util.ArrayList;
import java.util.List;

public class progressModel {
	public int videoProgress;
	public int pdfProgress;
	public int package_id;
	public int exam_id;
	public static List<String> response=new ArrayList<>();
	
	public int getVideoProgress() {
		return videoProgress;
	}
	public void setVideoProgress(int videoProgress) {
		this.videoProgress = videoProgress;
	}
	public int getPdfProgress() {
		return pdfProgress;
	}
	public void setPdfProgress(int pdfProgress) {
		this.pdfProgress = pdfProgress;
	}
	public int getPackage_id() {
		return package_id;
	}
	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public List<String> getResponse() {
		return response;
	}
	public void setResponse(List<String> response) {
		this.response = response;
	}
	
}