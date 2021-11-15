package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.FileService;

@Controller
public class FileDownloadController {
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName, HttpServletResponse response) throws Exception {
		/*
		 * Content-disposition : 파일을 다운로드하겠다는 의미 
		 * attachment : 파일을 다운로드하여 브라우저로 표현하겠다.
		 */
		//지정된 헤더 및 값을 이 응답에 대한 HTTP 헤더에 추가
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
										//변수명, 값
		File file = new File(FileService.IMAGE_REPO + "/" + fileName);
		FileInputStream in = new FileInputStream(file);
		// 해당하는 경로에서 데이터를 가져오겠습니다(인풋스트림)
		// in -> out -> 사용자
		FileCopyUtils.copy(in, response.getOutputStream());// 왼쪽에 있는 데이터를 오른쪽으로 보내줘라
	}
}
