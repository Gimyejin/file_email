package com.care.root.mybatis;

import java.util.List;

import com.care.root.dto.ShoesDTO;

public interface FileMapper {

	void saveData(ShoesDTO dto);

	List<ShoesDTO> getShoesImage();

}
