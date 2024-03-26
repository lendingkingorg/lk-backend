package com.lkbackend.lkbackend.mapper;

import com.lkbackend.lkbackend.Entity.LendingInfoDTO;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.stereotype.Component;

@Component
public class LendingInfoMapper {

    public LendingInfo updateLendingInfoDTOToLendingInfo(LendingInfoDTO lendingInfoDTO){
        LendingInfo lendingInfo = new LendingInfo();
        lendingInfo.setCibilTnC(lendingInfoDTO.getCibilTnC());
        lendingInfo.setEmail(lendingInfoDTO.getEmail());
        lendingInfo.setLkTnC(lendingInfoDTO.getLkTnC());
        lendingInfo.setName(lendingInfoDTO.getName());
        lendingInfo.setPan(lendingInfoDTO.getPan());
        lendingInfo.setReferral(lendingInfoDTO.getReferral());
        lendingInfo.setMobileNumber(lendingInfoDTO.getMobileNumber());
        return lendingInfo;
    }

    public LendingInfoDTO updateLendingInfoToLendingInfoDTO(LendingInfo lendingInfo){
        LendingInfoDTO lendingInfoDTO = new LendingInfoDTO();
        lendingInfoDTO.setCibilTnC(lendingInfo.getCibilTnC());
        lendingInfoDTO.setEmail(lendingInfo.getEmail());
        lendingInfoDTO.setPan(lendingInfo.getPan());
        lendingInfoDTO.setName(lendingInfo.getName());
        lendingInfoDTO.setReferral(lendingInfo.getReferral());
        lendingInfoDTO.setMobileNumber(lendingInfo.getMobileNumber());
        lendingInfoDTO.setLkTnC(lendingInfo.getLkTnC());
        lendingInfoDTO.setUserId(lendingInfo.getUserId());
        return lendingInfoDTO;
    }
}
