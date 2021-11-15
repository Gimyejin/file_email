package com.care.root.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	public static final String IMAGE_REPO ="C:/spring/image_repo";
										//이미지 저장소(서버가 있으면 url경로를 쓰면됨)
	void fileProcess(MultipartHttpServletRequest mul);
	void getShoesImage(Model model);
	
}
