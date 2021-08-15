package com.bhagya.research.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	private FileUploadUtil() {

	}

	public static void saveFile(String filePath, String fileName, MultipartFile file) throws IOException {
		Path uploadPath = Paths.get(filePath);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}

	public static String getFileNameWithExtension(String prefix, @NonNull String originalFileName) {
		return prefix + "."
				+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1).trim();
	}
}
