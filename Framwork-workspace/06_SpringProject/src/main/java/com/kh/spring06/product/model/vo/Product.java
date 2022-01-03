package com.kh.spring06.product.model.vo;

import lombok.Data;

@Data
public class Product {

	private int productNo; // PRODUCT_NO NUMBER PRIMARY KEY,  -- 제품번호
	private String productName; // PRODUCT_NAME VARCHAR2(30) NOT NULL,  -- 제품명
	private int price; // PRICE NUMBER DEFAULT 0 NOT NULL, -- 가격
	private String type; // TYPE VARCHAR2(12) NOT NULL,  -- 제품 분류
	private String enrollDate; // ENROLL_DATE DATE DEFAULT SYSDATE -- 제품등록일
	
}
