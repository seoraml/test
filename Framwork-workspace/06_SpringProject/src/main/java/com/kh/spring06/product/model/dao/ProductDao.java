package com.kh.spring06.product.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring06.product.model.vo.Product;

public interface ProductDao {

	// 상품 추가용 메소드 틀
	int insertProduct(Product product);

	// 싱픔 전체 조회용 메소드 틀
	List<Product> selectProductList();
	
	// 싱픔 전체 조회용 (정렬 기능 추가) 메소드 틀
	List<Product> ProductOrderList(Map<String, String> param);

	// 상품 상세조회 메소드 틀
	Product detailProduct(int pno);
	
	// 상품 삭제 메소드 틀
	int deleteProduct(int pno);
}
