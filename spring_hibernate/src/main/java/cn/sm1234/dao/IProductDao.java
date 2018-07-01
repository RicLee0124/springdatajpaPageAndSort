package cn.sm1234.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.sm1234.domain.Product;

public interface IProductDao extends PagingAndSortingRepository<Product, Integer>{

}
