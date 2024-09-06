package com.trial.models;

public class UserModel {
	public int user_id;
	public int videoProgress;
	public int pdfProgress;
	public int package_id;
	public int exam_id;
	public String current_test;
	public int current_ch_count;
	public int ch_th;
	public int media_count;
	public int remaining_count;
	public int skip_count;
	public String current_media_status;
	public  int current_test_score;
	public String response;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
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
	public String getCurrent_test() {
		return current_test;
	}
	public void setCurrent_test(String current_test) {
		this.current_test = current_test;
	}
	public int getCurrent_ch_count() {
		return current_ch_count;
	}
	public void setCurrent_ch_count(int current_ch_count) {
		this.current_ch_count = current_ch_count;
	}
	public int getCh_th() {
		return ch_th;
	}
	public void setCh_th(int ch_th) {
		this.ch_th = ch_th;
	}
	public int getMedia_count() {
		return media_count;
	}
	public void setMedia_count(int media_count) {
		this.media_count = media_count;
	}
	public int getRemaining_count() {
		return remaining_count;
	}
	public void setRemaining_count(int remaining_count) {
		this.remaining_count = remaining_count;
	}
	public int getSkip_count() {
		return skip_count;
	}
	public void setSkip_count(int skip_count) {
		this.skip_count = skip_count;
	}
	public String getCurrent_media_status() {
		return current_media_status;
	}
	public void setCurrent_media_status(String current_media_status) {
		this.current_media_status = current_media_status;
	}
	public int getCurrent_test_score() {
		return current_test_score;
	}
	public void setCurrent_test_score(int current_test_score) {
		this.current_test_score = current_test_score;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
