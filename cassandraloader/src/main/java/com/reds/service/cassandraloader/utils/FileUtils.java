package com.reds.service.cassandraloader.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;

public class FileUtils {

	private static FileWrite writer;

	public static List<String> readFile(String filePath) {
		try {
			CassandraloaderTrack.me.info("Opening File {} ", filePath);
			BufferedReader buffer = new BufferedReader(new FileReader(filePath));
			List<String> lines = new ArrayList<String>();
			String line = "";
			while (line != null) {
				line = buffer.readLine();
				if (line == null) {
					break;
				}
				lines.add(line);
			}
			buffer.close();
			return lines;

		} catch (IOException e) {
			CassandraloaderTrack.me.error("Could not open File {} ", filePath);
			return null;
		}
	}

	public static String[] getFilesInFolder(String folderPath) {
		File directory = new File(folderPath);
		return directory.list();
	}

	public static FileWrite getWriter() {
		if (writer == null) {
			writer = new FileWrite();
		}
		return writer;
	}
}
