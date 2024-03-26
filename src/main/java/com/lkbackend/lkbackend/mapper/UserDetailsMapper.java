package com.lkbackend.lkbackend.mapper;

import com.lkbackend.lkbackend.Entity.UserDetailsDTO;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public UserDetailsDTO mapUserDetailsToDTO(ApplicationCentralBin applicationCentralBin, LendingInfo lendingInfo) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setMobileNumber(applicationCentralBin.getMobileNo());
        userDetailsDTO.setName(applicationCentralBin.getName());
        userDetailsDTO.setDob(applicationCentralBin.getDob());
        userDetailsDTO.setGender(applicationCentralBin.getGender());
        userDetailsDTO.setResidentialPincode(applicationCentralBin.getResidentialPincode());
        userDetailsDTO.setResidentialAddress(applicationCentralBin.getResidentialAddress());
        userDetailsDTO.setPan(applicationCentralBin.getPan());
        userDetailsDTO.setAnnualTurnover(applicationCentralBin.getAnnualTurnover());
        userDetailsDTO.setYearsInCurrentBusiness(applicationCentralBin.getYearsInCurrentBusiness());
        userDetailsDTO.setBusinessPincode(applicationCentralBin.getBusinessPincode());
        userDetailsDTO.setBusinessAddress(applicationCentralBin.getBusinessAddress());
        userDetailsDTO.setBusinessRegisteredAs(applicationCentralBin.getBusinessRegisteredAs());
        userDetailsDTO.setProductCategory(applicationCentralBin.getProductCategory());
        userDetailsDTO.setNatureOfBusiness(applicationCentralBin.getNatureOfBusiness());
        userDetailsDTO.setBusinessRunBy(applicationCentralBin.getBusinessRunBy());
        userDetailsDTO.setRequestedLoanAmount(applicationCentralBin.getRequestedLoanAmount());
        userDetailsDTO.setLoanDurationInMonths(applicationCentralBin.getLoanDurationInMonths());
        userDetailsDTO.setName(applicationCentralBin.getName());
        userDetailsDTO.setPan(applicationCentralBin.getPan());
        if (lendingInfo != null) {
            userDetailsDTO.setEmail(lendingInfo.getEmail());
        }

        return userDetailsDTO;
    }
}
