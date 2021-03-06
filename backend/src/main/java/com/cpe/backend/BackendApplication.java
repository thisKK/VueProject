package com.cpe.backend;

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

import com.cpe.backend.menu.entity.Appropriate;
import com.cpe.backend.menu.entity.Menu;
import com.cpe.backend.menu.entity.MenuType;
import com.cpe.backend.menu.entity.Nation;
import com.cpe.backend.menu.repository.AppropriateRepository;
import com.cpe.backend.menu.repository.MenuRepository;
import com.cpe.backend.menu.repository.MenuTypeRepository;
import com.cpe.backend.menu.repository.NationRepository;

import com.cpe.backend.menudesign.entity.FoodImage;
import com.cpe.backend.menudesign.entity.FoodTechinque;
import com.cpe.backend.menudesign.repository.FoodImageRepository;
import com.cpe.backend.menudesign.repository.FoodTechinqueRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(FoodImageRepository foodImageRepository, FoodTechinqueRepository foodTechinqueRepository,
			MenuRepository menuRepository,AppropriateRepository appropriateRepository,MenuTypeRepository menuTypeRepository,NationRepository nationRepository) {
		return args -> {
			Object[][] data;

			data = new Object[][] {
					{ "ต้มยำกุ้ง", "http://www.thaifoodheritage.com/uploads/recipe_list/gallery/e3de5-jpg.jpeg" },
					{ "ข้าวผัด", "https://food.mthai.com/app/uploads/2019/02/Fried-Rice-with-Shrimp-Fat.jpg" },
					{ "ข้าวราดกระเพราหมู",
							"https://image.makewebeasy.net/makeweb/0/zs7gnRKvE/TH/%E0%B8%9C%E0%B8%B1%E0%B8%94%E0%B8%81%E0%B8%A3%E0%B8%B0%E0%B9%80%E0%B8%9E%E0%B8%A3%E0%B8%B2%E0%B9%84%E0%B8%81%E0%B9%88.jpg" },
					{ "ปลานึ่งมะนาว", "https://food.mthai.com/app/uploads/2017/02/Spicy-fish-2.jpg" },
					{ "ผัดไทย", "https://img.kapook.com/u/2015/surauch/cook2/PT1.jpg" }, };

			for (int i = 0; i < data.length; i++) {
				FoodImage image = new FoodImage();
				image.setNameImage((String) data[i][0]);
				image.setUrlImage((String) data[i][1]);
				foodImageRepository.save(image);
			}

			data = new Object[][] { { "ทอด" }, { "ต้ม" }, { "นิ่ง" }, { "ผัด" }, { "ตุ๋น" }, };

			for (int i = 0; i < data.length; i++) {
				FoodTechinque foodTechinque = new FoodTechinque();
				foodTechinque.setNameTechinques((String) data[i][0]);
				foodTechinqueRepository.save(foodTechinque);
			}

			data = new Object[][] { { "ต้มยำกุ้ง", 70, 5 }, { "ข้าวผัด", 50, 5 }, { "ปลานิ่งมะนาว", 80, 2 },
					{ "ข้าวราดกระเพราหมู", 50, 2 }, { "ผัดไทย", 50, 2 }, };

			for (int i = 0; i < data.length; i++) {
				Menu menu = new Menu();
				menu.setMenuName((String) data[i][0]);
				menu.setMenuPrice((Integer) data[i][1]);
				menu.setMenuUnits((Integer) data[i][2]);
				menuRepository.save(menu);
			}


			data = new Object[][] { { "55" }, { "66" }, { "77" }, { "88" }, { "99" }, };
			for (int i = 0; i < data.length; i++) {
				Appropriate appropriate = new Appropriate();
				appropriate.setAppropriationName((String) data[i][0]);
				appropriateRepository.save(appropriate);
			}

			data = new Object[][] { { "sada" }, { "asd" }, { "sad" }, { "sad" }, { "asd" }, };
			for (int i = 0; i < data.length; i++) {
				MenuType menuType = new MenuType();
				menuType.setTypeName((String) data[i][0]);
				menuTypeRepository.save(menuType);
			}

			data = new Object[][] { { "sada" }, { "asd" }, { "sad" }, { "sad" }, { "asd" }, };
			for (int i = 0; i < data.length; i++) {
				Nation nation = new Nation();
				nation.setNationName((String) data[i][0]);
				nationRepository.save(nation);
			}


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
