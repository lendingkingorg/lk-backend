package com.lkbackend.lkbackend.mapper;

import com.lkbackend.lkbackend.Entity.UserDetailsDTO;
import com.lkbackend.lkbackend.model.LendingInfo;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public UserDetailsDTO mapUserDetailsToDTO(LoanApplicationDetails loanApplicationDetails, LendingInfo lendingInfo) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setMobileNumber(loanApplicationDetails.getMobileNo());
        userDetailsDTO.setName(loanApplicationDetails.getName());
        userDetailsDTO.setDob(loanApplicationDetails.getDob());
        userDetailsDTO.setGender(loanApplicationDetails.getGender());
        userDetailsDTO.setResidentialPincode(loanApplicationDetails.getResidentialPincode());
        userDetailsDTO.setResidentialAddress(loanApplicationDetails.getResidentialAddress());
        userDetailsDTO.setPan(loanApplicationDetails.getPan());
        userDetailsDTO.setAnnualTurnover(loanApplicationDetails.getAnnualTurnover());
        userDetailsDTO.setYearsInCurrentBusiness(loanApplicationDetails.getYearsInCurrentBusiness());
        userDetailsDTO.setBusinessPincode(loanApplicationDetails.getBusinessPincode());
        userDetailsDTO.setBusinessAddress(loanApplicationDetails.getBusinessAddress());
        userDetailsDTO.setBusinessRegisteredAs(loanApplicationDetails.getBusinessRegisteredAs());
        userDetailsDTO.setProductCategory(loanApplicationDetails.getProductCategory());
        userDetailsDTO.setNatureOfBusiness(loanApplicationDetails.getNatureOfBusiness());
        userDetailsDTO.setBusinessRunBy(loanApplicationDetails.getBusinessRunBy());
        userDetailsDTO.setRequestedLoanAmount(loanApplicationDetails.getRequestedLoanAmount());
        userDetailsDTO.setLoanDurationInMonths(loanApplicationDetails.getLoanDurationInMonths());
        if (lendingInfo != null) {
            userDetailsDTO.setName(lendingInfo.getName());
            userDetailsDTO.setPan(lendingInfo.getPan());
        }

        return userDetailsDTO;
    }
}
