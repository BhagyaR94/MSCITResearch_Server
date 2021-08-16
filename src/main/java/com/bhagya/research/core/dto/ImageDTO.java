package com.bhagya.research.core.dto;

public class ImageDTO {
    String encodedBase64;
    String fileName;
    String fileExtension;

    public String getEncodedBase64() {
        return encodedBase64;
    }

    public void setEncodedBase64(String encodedBase64) {
        this.encodedBase64 = encodedBase64;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}

