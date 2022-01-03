package com.kh.spring06.product.model.service;

import java.util.List;
import java.util.Map;

import com.kh.spring06.product.model.vo.Product;

public interface ProductService {
	
	// 상품 등록용 메소드 틀
	int insertProduct(Product product);
	
	// 상품 전체 조회 메소드 틀
	List<Product> selectProductList();
	
	// 상품 전체 조회 (정렬추가) 메소드 틀
	List<Product> productOrderList(Map<String, String> param);
	
	// 상품 상세 조회용 메소드 틀
	Product detailProduct(int pno);
	
	// 상품 삭제 메소드틀
	int deleteProduct(int pno);
}
