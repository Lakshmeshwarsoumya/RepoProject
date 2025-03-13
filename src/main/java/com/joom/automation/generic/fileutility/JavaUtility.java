package com.joom.automation.generic.fileutility;

import java.time.LocalDateTime;

public class JavaUtility {
	public String captureTimeStamp() {
		//String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String time = LocalDateTime.now().toString().replace(":", "_");

		return time;

	}


}
