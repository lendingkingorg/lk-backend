package com.lkbackend.lkbackend.mapper;

import com.lkbackend.lkbackend.Entity.DetailedInfoDTO;
import com.lkbackend.lkbackend.model.LendingInfo;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import org.springframework.stereotype.Component;

@Component
public class DetailedInfoMapper {

    public DetailedInfoDTO fullDetailedMapper(LendingInfo lendingInfo, LoanApplicationDetails loanApplicationDetails) {
        DetailedInfoDTO detailedInfoDTO = new DetailedInfoDTO();

        // Mapping LendingInfo fields
        detailedInfoDTO.setMobileNumber(lendingInfo.getMobileNumber());
        detailedInfoDTO.setName(lendingInfo.getName());
        detailedInfoDTO.setMPin(lendingInfo.getmPin());
        detailedInfoDTO.setEmail(lendingInfo.getEmail());
        detailedInfoDTO.setPan(lendingInfo.getPan());
        detailedInfoDTO.setReferral(lendingInfo.getReferral());
        detailedInfoDTO.setLk_TnC(lendingInfo.getLk_TnC());
        detailedInfoDTO.setCibil_TnC(lendingInfo.getCibil_TnC());

        // Mapping LoanApplicationDetails fields
        detailedInfoDTO.setDob(loanApplicationDetails.getDob());
        detailedInfoDTO.setGender(loanApplicationDetails.getGender());
        detailedInfoDTO.setResidentialPincode(loanApplicationDetails.getResidentialPincode());
        detailedInfoDTO.setResidentialAddress(loanApplicationDetails.getResidentialAddress());
        detailedInfoDTO.setPan(loanApplicationDetails.getPan());
        detailedInfoDTO.setAnnualTurnover(loanApplicationDetails.getAnnualTurnover());
        detailedInfoDTO.setYearsInCurrentBusiness(loanApplicationDetails.getYearsInCurrentBusiness());
        detailedInfoDTO.setBusinessPincode(loanApplicationDetails.getBusinessPincode());
        detailedInfoDTO.setBusinessAddress(loanApplicationDetails.getBusinessAddress());
        detailedInfoDTO.setBusinessRegisteredAs(loanApplicationDetails.getBusinessRegisteredAs());
        detailedInfoDTO.setProductCategory(loanApplicationDetails.getProductCategory());
        detailedInfoDTO.setNatureOfBusiness(loanApplicationDetails.getNatureOfBusiness());
        detailedInfoDTO.setBusinessRunBy(loanApplicationDetails.getBusinessRunBy());
        detailedInfoDTO.setRequestedLoanAmount(loanApplicationDetails.getRequestedLoanAmount());
        detailedInfoDTO.setLoanDurationInMonths(loanApplicationDetails.getLoanDurationInMonths());

        return detailedInfoDTO;
    }
}
