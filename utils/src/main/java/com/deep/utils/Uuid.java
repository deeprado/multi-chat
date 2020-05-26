package com.deep.utils;

import java.util.UUID;

public class Uuid {

	public static String create() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
	}
}
