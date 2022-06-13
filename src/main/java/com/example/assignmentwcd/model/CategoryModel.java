package com.example.assignmentwcd.model;

import com.example.assignmentwcd.entity.Account;
import com.example.assignmentwcd.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean Save(Category category);

    List<Category> getAll();

    Category findById(int id);


    boolean Update(int id, Category updateCategory);

    boolean Delete(int id);
}
