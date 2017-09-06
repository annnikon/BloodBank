package ua.nure.nikonova.bloodbank.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class MessageSender {
	  // Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "AC4cb79fae0d95fa0bbfb4b4daa9b850e7";
	  public static final String AUTH_TOKEN = "73d53286ae22962854c5a8427c5dd90c";
	  public static final String MY_PHONE = "380990639237";
	String phone;
	String text;
	
	public MessageSender(String phone, String text) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		this.phone="+38"+phone;
		this.text=text;
	}


  public  void send() {
    
    Message message = Message.creator(new PhoneNumber(phone),
        new PhoneNumber(MY_PHONE), 
        text).create();

    System.out.println(message.getSid());
  }
}
