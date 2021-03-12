package com.reds.service.cassandraloader.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;

public class FileWrite {
	BufferedWriter buffer;

	public void write(List<String> data) {
		try {
			for (String line : data) {

				buffer.write(line);
				buffer.newLine();

			}
		} catch (IOException e) {
			CassandraloaderTrack.me.error("Unable to write to File", e);
		}
		data.clear();
	}

	public void createFile(String filePath) {
		try {
			this.buffer = new BufferedWriter(new FileWriter(filePath));
		} catch (IOException e) {
			filePath = filePath.replaceAll("//", "\\\\");
			try {
				this.buffer = new BufferedWriter(new FileWriter(filePath));
			} catch (IOException e1) {
				CassandraloaderTrack.me.error("Unable to create File {}", filePath, e1);
			}

		}
	}

	public void close() {
		try {
			this.buffer.close();
		} catch (IOException e) {
			CassandraloaderTrack.me.error("Unable to close File {}", e);
		}
	}
}
