package com.girmiti.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TestProduct {

	Product product = new Product();
	
	@Before
	public void setValues() {
		product.setId(1);
		product.setPrice("100");
		product.setProductName("Moto");
	}
	
	@Test
	public void testProduct() {
		Assert.assertEquals(1, product.getId());
		Assert.assertEquals("100", product.getPrice());
		Assert.assertEquals("Moto", product.getProductName());
	}
	
	@Test
	public void testProductConstructor() {
		Product product = new Product(1,"Moto","100");
		Assert.assertEquals(1, product.getId());
		Assert.assertEquals("100", product.getPrice());
		Assert.assertEquals("Moto", product.getProductName());
	}
}
