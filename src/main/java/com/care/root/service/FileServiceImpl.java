package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	FileMapper fm;

	@Override
	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));

		MultipartFile file = mul.getFile("file");

		// 현재 파일이름이 같으면 덮어쓰여지는 문제가 나옴
		// File saveFile = new File(IMAGE_REPO + "/" + file.getOriginalFilename());
		if (file.getSize() != 0) {// !file.isEmpty()
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calender = Calendar.getInstance();
			String sysFileName = format.format(calender.getTime());
			// ->2021111541-파일이름
			sysFileName += file.getOriginalFilename();
			dto.setImgName(sysFileName);
			
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);

			try {
				file.transferTo(saveFile);
				//업로드한 파일 데이터를 지정한 파일에 저장한다.->그러니 c:~경로에 파일이 저장된것
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setImgName("nan");
		}
		fm.saveData(dto);
	}

	@Override
	public void getShoesImage(Model model) {
		model.addAttribute("list", fm.getShoesImage());

	}

}
