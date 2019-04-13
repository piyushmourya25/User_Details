package com.piyush.bootstrap;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.piyush.entity.Product;
import com.piyush.repository.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;

	private Logger log = LogManager.getLogger(ProductLoader.class);

	@Autowired
	public void setProductLoader(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Product hat = new Product();
		hat.setDescription("Hat with spring logo");
		hat.setPrice(new BigDecimal("23.75"));
		hat.setImageUrl("/images/Spring_Hat.jpg");
		hat.setProductId("10253041501");
		productRepository.save(hat);
		
		log.info("Saved Hat - ID: " + hat.getId());
		
		Product mug = new Product();
		mug.setDescription("Mug with spring logo");
		mug.setPrice(new BigDecimal("13.75"));
		mug.setImageUrl("/images/Spring_Mugs.jpg");
		mug.setProductId("10253041504");
		productRepository.save(mug);
		
		log.info("Saved Mug - ID: " + mug.getId());
		
	}

}
