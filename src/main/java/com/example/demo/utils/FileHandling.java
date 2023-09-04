package com.example.demo.utils;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provide services related to file handling
 * 
 * @author Rahil_Khan
 */
@Slf4j
public class FileHandling {

	/**
	 * Check and create dir if it does not exist. Read more:
	 * https://www.java67.com/2014/02/how-to-create-file-and-directory-in-java.html#ixzz7ayjYCWr3
	 * 
	 * @return boolean
	 */
	public boolean checkAndCreateDirectory(String dir) {
		boolean success = false;
		File directory = new File(dir);

		if (directory.exists()) {
			log.debug("Directory already exists ...");
			success = true;
		} else {
			log.debug("Directory not exists, creating now");
			success = directory.mkdir();
			if (success) {
				log.debug("Successfully created new directory : %s%n", dir);
			} else {
				log.debug("Failed to create new directory: %s%n", dir);
			}
		}

		return success;
	}

}
