package com.kh.spring06.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring06.product.model.vo.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 상품 추가용 메소드 틀
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return sqlSession.insert("product.insertProduct", product);
	}

	// 상품 전체 조회 메소드 => 알번버전
	@Override
	public List<Product> selectProductList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.productList");
	}

	// 상품 전체 조회 => 정렬 기능 추가
	@Override
	public List<Product> ProductOrderList(Map<String, String> param) {
		return sqlSession.selectList("product.productOrderList", param);
	}

	// 상품 상세 조회 메소드 틀
	@Override
	public Product detailProduct(int pno) {
		return sqlSession.selectOne("product.detailProduct", pno);
	}
	
	// 상품 삭제 메소드
	@Override
	public int deleteProduct(int pno) {
		return sqlSession.delete("product.deleteProduct", pno);
	}
}
