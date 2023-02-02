package com.hhiephk.baitap.service;

public interface EmailSenderService {

	void sendEmail(String toEmail, String subject, String body);

}
