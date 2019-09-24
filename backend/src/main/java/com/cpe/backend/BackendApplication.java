package com.cpe.backend;

import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

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
				{"rice2","www.yahoo.com"},
				{"rice3","www.goo.com"}
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
				{"นิ่ง"}
			};

			for(int i= 0 ;i<data.length;i++){
				FoodTechinque foodTechinque = new FoodTechinque();
				foodTechinque.setNameTechinques((String)data[i][0]);
				foodTechinqueRepository.save(foodTechinque);
			}

			data = new Object[][]{
				{"ทอดมัน",50,1},
				{"ต้มยำ",70,2},
				{"ปลานิ่งมะนาว",1503,2}
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

}
