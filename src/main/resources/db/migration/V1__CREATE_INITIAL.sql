CREATE TABLE IF NOT EXISTS application_central_bin (
    application_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mobile_no BIGINT,
    name VARCHAR(255),
    dob DATE,
    gender VARCHAR(10),
    residential_pincode VARCHAR(20),
    residential_address VARCHAR(255),
    pan VARCHAR(20),
    annual_turnover VARCHAR(20),
    years_in_current_business VARCHAR(10),
    business_pincode VARCHAR(20),
    business_address VARCHAR(255),
    business_registered_as VARCHAR(255),
    product_category VARCHAR(255),
    nature_of_business VARCHAR(255),
    business_run_by VARCHAR(255),
    requested_loan_amount DOUBLE,
    loan_duration_in_months INT,
    pan_card_url VARCHAR(255),
    bank_statement_url_one VARCHAR(255),
    bank_info_one VARCHAR(255),
    bank_statement_one_doc_format VARCHAR(50),
    bank_statement_url_two VARCHAR(255),
    bank_info_two VARCHAR(255),
    bank_statement_two_doc_format VARCHAR(50),
    bank_statement_url_three VARCHAR(255),
    bank_info_three VARCHAR(255),
    bank_statement_three_doc_format VARCHAR(50),
    bank_statement_url_four VARCHAR(255),
    bank_info_four VARCHAR(255),
    bank_statement_four_doc_format VARCHAR(50),
    bank_statement_url_five VARCHAR(255),
    bank_info_five VARCHAR(255),
    bank_statement_five_doc_format VARCHAR(50),
    business_registration_proof_url VARCHAR(255),
    business_address_proof_url VARCHAR(255),
    id_proof_of_guarantor_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS document_inf (
    mobile_no BIGINT PRIMARY KEY,
    pan_card_url VARCHAR(255),
    bank_statement_url_one VARCHAR(255),
    bank_info_one VARCHAR(255),
    bank_statement_one_doc_format VARCHAR(50),
    bank_statement_url_two VARCHAR(255),
    bank_info_two VARCHAR(255),
    bank_statement_two_doc_format VARCHAR(50),
    bank_statement_url_three VARCHAR(255),
    bank_info_three VARCHAR(255),
    bank_statement_three_doc_format VARCHAR(50),
    bank_statement_url_four VARCHAR(255),
    bank_info_four VARCHAR(255),
    bank_statement_four_doc_format VARCHAR(50),
    bank_statement_url_five VARCHAR(255),
    bank_info_five VARCHAR(255),
    bank_statement_five_doc_format VARCHAR(50),
    business_registration_proof_url VARCHAR(255),
    business_address_proof_url VARCHAR(255),
    id_proof_of_guarantor_url VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS lending_inf (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    mobile_number BIGINT,
    name VARCHAR(255),
    mpin INT,
    email VARCHAR(255),
    pan VARCHAR(20),
    referral VARCHAR(255),
    lk_tnc VARCHAR(255),
    cibil_tnc VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS loan_inf (
    mobile_no BIGINT PRIMARY KEY,
    name VARCHAR(255),
    dob DATE,
    gender VARCHAR(10),
    residential_pincode VARCHAR(20),
    residential_address VARCHAR(255),
    pan VARCHAR(20),
    annual_turnover VARCHAR(20),
    years_in_current_business VARCHAR(10),
    business_pincode VARCHAR(20),
    business_address VARCHAR(255),
    business_registered_as VARCHAR(255),
    product_category VARCHAR(255),
    nature_of_business VARCHAR(255),
    business_run_by VARCHAR(255),
    requested_loan_amount DOUBLE,
    loan_duration_in_months INT
);
CREATE TABLE IF NOT EXISTS lp_form_tbl (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    business_name VARCHAR(255),
    email VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS on_salary_info_tbl (
    mobile_no BIGINT PRIMARY KEY,
    hr_name VARCHAR(255),
    hr_email VARCHAR(255),
    hr_mobile BIGINT
);
