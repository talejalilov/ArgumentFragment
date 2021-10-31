package com.emrebaglayici.lab6.model;

public class MailModel {
    public String companyName;
    public String subject;
    public String message;

    public MailModel(String sendTo, String subject, String message) {
        this.companyName = sendTo;
        this.subject = subject;
        this.message = message;
    }
}
