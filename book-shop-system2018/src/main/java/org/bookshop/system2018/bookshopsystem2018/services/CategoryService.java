package org.bookshop.system2018.bookshopsystem2018.services;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Category;

import java.util.List;

public interface CategoryService {

//    void saveCategoryIntoDb(Category category);

    void saveCategoryIntoDb(List<Category> categories);
}
