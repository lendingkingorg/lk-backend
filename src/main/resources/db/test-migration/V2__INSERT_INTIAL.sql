-- Insert data into application_central_bin table
INSERT INTO application_central_bin (
    mobile_no,
    name,
    dob,
    gender,
    residential_pincode,
    residential_address,
    pan,
    annual_turnover,
    years_in_current_business,
    business_pincode,
    business_address,
    business_registered_as,
    product_category,
    nature_of_business,
    business_run_by,
    requested_loan_amount,
    loan_duration_in_months,
    pan_card,
    bank_statement_one,
    bank_info_one,
    bank_statement_one_doc_format,
    bank_statement_two,
    bank_info_two,
    bank_statement_two_doc_format,
    bank_statement_three,
    bank_info_three,
    bank_statement_three_doc_format,
    bank_statement_four,
    bank_info_four,
    bank_statement_four_doc_format,
    bank_statement_five,
    bank_info_five,
    bank_statement_five_doc_format,
    business_registration_proof,
    business_address_proof,
    id_proof_of_guarantor,
    created_at,
    id_proof,
    address_proof,
    application_type,
    employment_type,
    salary_bank_account,
    employment_details,
    resident_type
) VALUES (
    1234567890,
    'John Doe',
    '1990-01-01',
    'Male',
    '123456',
    '123 Main St',
    'ABCDE1234F',
    '1000000',
    '5',
    '654321',
    '456 Elm St',
    'Private Limited Company',
    'Software',
    'Technology',
    'Owner',
    50000.00,
    12,
    'pan_card_url_value',
    'bank_statement_url_one_value',
    'bank_info_one_value',
    'bank_statement_one_doc_format_value',
    'bank_statement_url_two_value',
    'bank_info_two_value',
    'bank_statement_two_doc_format_value',
    'bank_statement_url_three_value',
    'bank_info_three_value',
    'bank_statement_three_doc_format_value',
    'bank_statement_url_four_value',
    'bank_info_four_value',
    'bank_statement_four_doc_format_value',
    'bank_statement_url_five_value',
    'bank_info_five_value',
    'bank_statement_five_doc_format_value',
    'business_registration_proof_url_value',
    'business_address_proof_url_value',
    'id_proof_of_guarantor_url_value',
    NOW(),
    'id_proof_value',
    'address_proof_value',
    'application_type_value',
    'employment_type_value',
    'salary_bank_account_value',
    'employment_details_value',
    'resident_type_value'
);
-- Insert data into BLApplicationDetails table
INSERT INTO bussiness_loan_inf (
    mobile_no,
    name,
    dob,
    gender,
    residential_pincode,
    residential_address,
    pan,
    annual_turnover,
    years_in_current_business,
    business_pincode,
    business_address,
    business_registered_as,
    product_category,
    nature_of_business,
    business_run_by,
    requested_loan_amount,
    loan_duration_in_months
) VALUES (
    1234567890,
    'John Doe',
    '1990-01-01',
    'Male',
    '123456',
    '123 Main St',
    'ABCDE1234F',
    '1000000',
    '5',
    '654321',
    '456 Elm St',
    'Private Limited Company',
    'Software',
    'Technology',
    'Owner',
    50000.00,
    12
);
-- Insert data into BLDocumentUploadDetails table
INSERT INTO bl_document_inf (
    mobile_no,
    pan_card,
    bank_statement_one,
    bank_info_one,
    bank_statement_one_doc_format,
    bank_statement_two,
    bank_info_two,
    bank_statement_two_doc_format,
    bank_statement_three,
    bank_info_three,
    bank_statement_three_doc_format,
    bank_statement_four,
    bank_info_four,
    bank_statement_four_doc_format,
    bank_statement_five,
    bank_info_five,
    bank_statement_five_doc_format,
    business_registration_proof,
    business_address_proof,
    id_proof_of_guarantor
) VALUES (
    1234567890,
    'pan_card_url',
    'bank_statement_one_url',
    'bank_info_one',
    'bank_statement_one_doc_format',
    'bank_statement_two_url',
    'bank_info_two',
    'bank_statement_two_doc_format',
    'bank_statement_three_url',
    'bank_info_three',
    'bank_statement_three_doc_format',
    'bank_statement_four_url',
    'bank_info_four',
    'bank_statement_four_doc_format',
    'bank_statement_five_url',
    'bank_info_five',
    'bank_statement_five_doc_format',
    'business_registration_proof_url',
    'business_address_proof_url',
    'id_proof_of_guarantor_url'
);

-- Insert data into LendingInfo table
INSERT INTO lending_inf (mobile_number, name, mpin, email, pan, referral, lk_tnc, cibil_tnc)
VALUES
    (9876543210, 'Jane Smith', 5678, 'jane.smith@example.com', 'FGHIJ5678G', 'another.referrer@example.com', 'LK Terms and Conditions', 'CIBIL Terms and Conditions');

-- Insert data into LPFormTbl table
INSERT INTO lp_form_tbl (business_name, email)
VALUES
    ('Business 1', 'business1@example.com');

-- V2__insert_into_on_salary_info_tbl.sql

INSERT INTO on_salary_info_tbl (mobile_no, hr_name, hr_email, hr_mobile)
VALUES
    (2345678901, 'HR Name 1', 'hr1@example.com', 8765432109);

-- V2__insert_into_personal_loan_inf.sql

INSERT INTO personal_loan_inf (mobile_no, employment_type, salary_bank_account, employment_details, residential_pincode, residential_address, resident_type, requested_loan_amount, loan_duration_in_months)
VALUES
    (2345678901, 'Part-time', 'SalaryBank456', 'Details2', '456789', 'Address2', 'Non-Resident', 7000.00, 24);

-- V2__insert_into_pl_document_inf.sql

INSERT INTO pl_document_inf (mobile_no, pan_card, id_proof, address_proof, bank_statement_one, bank_info_one, bank_statement_one_doc_format, bank_statement_two, bank_info_two, bank_statement_two_doc_format, bank_statement_three, bank_info_three, bank_statement_three_doc_format, bank_statement_four, bank_info_four, bank_statement_four_doc_format, bank_statement_five, bank_info_five, bank_statement_five_doc_format)
VALUES
    (2345678901, 'FGHIJ5678K', 'IDProof2', 'AddressProof2', 'Statement6', 'Info6', 'Format6', 'Statement7', 'Info7', 'Format7', 'Statement8', 'Info8', 'Format8', 'Statement9', 'Info9', 'Format9', 'Statement10', 'Info10', 'Format10');

