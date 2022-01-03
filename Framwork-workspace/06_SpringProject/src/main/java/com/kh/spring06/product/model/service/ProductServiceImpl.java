package com.kh.spring06.product.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring06.product.model.dao.ProductDao;
import com.kh.spring06.product.model.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	// 상품 추가용 메소드
	@Override
	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	// 상품 전체 조회용 메소드
	@Override
	public List<Product> selectProductList() {
		return productDao.selectProductList();
	}

	// 상품 전체 조회용 (정렬 기능 추가) 메소드
	@Override
	public List<Product> productOrderList(Map<String, String> param) {
		return productDao.ProductOrderList(param);
	}

	// 상품 상세 조회용
	@Override
	public Product detailProduct(int pno) {
		return productDao.detailProduct(pno);
	}

	// 상품 삭제 
	@Override
	public int deleteProduct(int pno) {
		return productDao.deleteProduct(pno);
	}
}
