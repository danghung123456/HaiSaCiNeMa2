package com.Services;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;

@Service
public interface QRCodeService {

	byte[] getQRCodeImage(String text) throws Exception;
	
	void generateQRCodeImage(String text, int width, int height, String filePath) throws Exception;
	
}
