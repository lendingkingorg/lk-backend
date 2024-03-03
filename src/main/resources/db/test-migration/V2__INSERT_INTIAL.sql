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
    created_at
)
VALUES (
    '1234567890',
    'John Doe',
    '1990-01-01',
    'Male',
    '123456',
    '123 Street, City',
    'ABCDE1234F',
    '1000000',
    '5',
    '654321',
    '456 Avenue, Town',
    'Sole Proprietorship',
    'Retail',
    'E-commerce',
    'Self',
    10000,
    12,
    'https://example.com/pan_card.jpg',
    'https://example.com/bank_statement_one.jpg',
    'Bank One',
    'PDF',
    'https://example.com/bank_statement_two.jpg',
    'Bank Two',
    'PDF',
    'https://example.com/bank_statement_three.jpg',
    'Bank Three',
    'PDF',
    'https://example.com/bank_statement_four.jpg',
    'Bank Four',
    'PDF',
    'https://example.com/bank_statement_five.jpg',
    'Bank Five',
    'PDF',
    'https://example.com/business_registration_proof.jpg',
    'https://example.com/business_address_proof.jpg',
    'https://example.com/id_proof_of_guarantor.jpg',
    NOW()
);

-- Insert data into document_inf table
INSERT INTO document_inf (
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
)
VALUES (
    1234567890,
    'https://example.com/pan_card.jpg',
    'https://example.com/bank_statement_one.jpg',
    'Bank One',
    'PDF',
    'https://example.com/bank_statement_two.jpg',
    'Bank Two',
    'PDF',
    'https://example.com/bank_statement_three.jpg',
    'Bank Three',
    'PDF',
    'https://example.com/bank_statement_four.jpg',
    'Bank Four',
    'PDF',
    'https://example.com/bank_statement_five.jpg',
    'Bank Five',
    'PDF',
    'https://example.com/business_registration_proof.jpg',
    'https://example.com/business_address_proof.jpg',
    'https://example.com/id_proof_of_guarantor.jpg'
);

-- Insert data into lending_inf table
INSERT INTO lending_inf (
    user_id,
    mobile_number,
    name,
    mpin,
    email,
    pan,
    referral,
    lk_tnc,
    cibil_tnc
)
VALUES (
    1,
    1234567890,
    'John Doe',
    1234,
    'john.doe@example.com',
    'ABCDE1234F',
    'REF123',
    'Terms and conditions for LK',
    'Terms and conditions for CIBIL'
);

-- Insert data into loan_inf table
INSERT INTO loan_inf (
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
)
VALUES (
    1234567890,
    'John Doe',
    '1990-01-01',
    'Male',
    '123456',
    '123 Street, City',
    'ABCDE1234F',
    '1000000',
    '5',
    '654321',
    '456 Avenue, Town',
    'Sole Proprietorship',
    'Retail',
    'E-commerce',
    'Self',
    10000,
    12
);
-- Insert data into lp_form_tbl table
INSERT INTO lp_form_tbl (
    business_name,
    email
)
VALUES (
    'ABC Company',
    'abc@example.com'
);
-- Insert data into on_salary_info_tbl table
INSERT INTO on_salary_info_tbl (
    mobile_no,
    hr_name,
    hr_email,
    hr_mobile
)
VALUES (
    1234567890,
    'John Smith',
    'john@example.com',
    9876543210
);

