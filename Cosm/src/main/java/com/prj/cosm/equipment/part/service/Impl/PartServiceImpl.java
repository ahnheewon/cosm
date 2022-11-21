package com.prj.cosm.equipment.part.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.part.mapper.PartMapper;
import com.prj.cosm.equipment.part.service.PartService;
import com.prj.cosm.equipment.part.service.PartVO;

@Service
public class PartServiceImpl implements PartService {

	@Autowired
	PartMapper mapper;
//============================================================================================================================

	@Override
	public List<PartVO> getPartList() {
		
		return mapper.getPartList();
	}

	@Override
	public PartVO getPartInfo(int partNo) {
		return mapper.getPartInfo(partNo);
	}

	@Override
	public int insertPart(PartVO vo) {
		return mapper.insertPart(vo);
	}

	@Override
	public int updatePart(PartVO vo) {
		return mapper.updatePart(vo);
	}

	@Override
	public int deletePart(int partNo) {
		return mapper.deletePart(partNo);
	}


	@Override
	public int updateDeletePartNo(int partNo) {
		return mapper.updateDeletePartNo(partNo);
	}

	@Override
	public PartVO getPartNo() {
		return mapper.getPartNo();
	}

//============================================================================================================================
	
	@Override
	public List<PartVO> getPartIOList() {
		return mapper.getPartIOList();
	}

	@Override
	public int insertPartIO(PartVO vo) {
		return mapper.insertPart(vo);
	}







																	

	
	
}
