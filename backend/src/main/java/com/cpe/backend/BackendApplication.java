package com.cpe.backend;

import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(FoodImageRepository foodImageRepository,FoodTechinqueRepository foodTechinqueRepository, MenuListRepository menuListRepository) {
		return args -> {
			Object[][] data;

			data = new Object[][]{
				{"ต้มยำกุ้ง","http://www.thaifoodheritage.com/uploads/recipe_list/gallery/e3de5-jpg.jpeg"},
				{"ข้าวผัด","https://food.mthai.com/app/uploads/2019/02/Fried-Rice-with-Shrimp-Fat.jpg"},
				{"ข้าวราดกระเพราหมู","https://image.makewebeasy.net/makeweb/0/zs7gnRKvE/TH/%E0%B8%9C%E0%B8%B1%E0%B8%94%E0%B8%81%E0%B8%A3%E0%B8%B0%E0%B9%80%E0%B8%9E%E0%B8%A3%E0%B8%B2%E0%B9%84%E0%B8%81%E0%B9%88.jpg"},
				{"ปลานึ่งมะนาว","https://food.mthai.com/app/uploads/2017/02/Spicy-fish-2.jpg"},
				{"ผัดไทย","https://img.kapook.com/u/2015/surauch/cook2/PT1.jpg"},
			};

			for(int i= 0 ;i<data.length;i++){
				FoodImage image = new FoodImage();
				image.setNameImage((String)data[i][0]);
				image.setUrlImage((String)data[i][1]);
				foodImageRepository.save(image);
			}

			data = new Object[][]{
				{"ทอด"},
				{"ต้ม"},
				{"นิ่ง"},
				{"ผัด"},
				{"ตุ๋น"},
			};

			for(int i= 0 ;i<data.length;i++){
				FoodTechinque foodTechinque = new FoodTechinque();
				foodTechinque.setNameTechinques((String)data[i][0]);
				foodTechinqueRepository.save(foodTechinque);
			}

			data = new Object[][]{
				{"ต้มยำกุ้ง",70,5},
				{"ข้าวผัด",50,5},
				{"ปลานิ่งมะนาว",80,2},
				{"ข้าวราดกระเพราหมู",50,2},
				{"ผัดไทย",50,2},
			};

			for(int i= 0 ;i<data.length;i++){
				MenuList menuList = new MenuList();
				menuList.setName((String)data[i][0]);
				menuList.setPrice((Integer)data[i][1]);
				menuList.setUnits((Integer)data[i][2]);
				menuListRepository.save(menuList);
			}

			// Stream.of("Takoonkan", "Sitthichai", "Somchai", "Tanapon").forEach(name -> {
			// 	 customer = new Customer(); // สร้าง Object Customer
			// 	customer.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
			// 	customerRepository.save(customer); // บันทึก Objcet ชื่อ Customer
			// });
		};

		
	}

	// Fix the CORS errors
	@Bean
	public FilterRegistrationBean simpleCorsFilter() {  
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
			CorsConfiguration config = new CorsConfiguration();  
			config.setAllowCredentials(true); 
			// *** URL below needs to match the Vue client URL and port ***
			config.setAllowedOrigins(Collections.singletonList("http://localhost:8080")); 
			config.setAllowedMethods(Collections.singletonList("*"));  
			config.setAllowedHeaders(Collections.singletonList("*"));  
			source.registerCorsConfiguration("/**", config);  
			FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
			return bean;  
	} 

}
