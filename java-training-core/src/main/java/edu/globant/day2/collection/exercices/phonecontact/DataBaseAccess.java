package edu.globant.day2.collection.exercices.phonecontact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.List;

public class DataBaseAccess {

	public List<Message> recoverMessageData() {
		List<Message> messages = new ArrayList<Message>();

		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formatter.parse("2016/04/13");
			messages.add(new Message("1158812225", "Wanna go out tonight?", date));
			date = formatter.parse("2016/06/14");
			messages.add(new Message("1168892125", "Hi there, how are you?", date));
			date = formatter.parse("2016/05/15");
			messages.add(new Message("1159813125", "I'm coming home!!", date));
			date = formatter.parse("2016/06/12");
			messages.add(new Message("1158812125", "I'll be late", date));
			date = formatter.parse("2016/06/14");
			messages.add(new Message("1158924444", "Are you home?", date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return messages;
	}
	
	public List<PhoneContact> recoverPhoneContactData() {
		List<PhoneContact> contacts = new ArrayList<PhoneContact>();

		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formatter.parse("2016/04/13");
			contacts.add(new PhoneContact("Pablo", "115882225", date));
			date = formatter.parse("2016/06/14");
			contacts.add(new PhoneContact("German", "115781825", date));
			date = formatter.parse("2016/05/15");
			contacts.add(new PhoneContact("Luciana", "1151872225", date));
			date = formatter.parse("2016/06/12");
			contacts.add(new PhoneContact("Carlos", "1155882425", date));
			date = formatter.parse("2016/06/14");
			contacts.add(new PhoneContact("Marina", "1168882225", date));
			date = formatter.parse("2016/03/12");
			contacts.add(new PhoneContact("Mario", "1151872225", date));
			date = formatter.parse("2016/11/11");
			contacts.add(new PhoneContact("Juan Carlos", "1155882425", date));
			date = formatter.parse("2016/08/13");
			contacts.add(new PhoneContact("Alejandro", "1168882225", date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return contacts;
	}
}
