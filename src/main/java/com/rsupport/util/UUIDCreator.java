package com.rsupport.util;

import java.util.UUID;

public class UUIDCreator {
	
	public static String makeUUID() {
		
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
