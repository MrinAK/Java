package org.bookshop.system2018.bookshopsystem2018.services;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Category;
import org.bookshop.system2018.bookshopsystem2018.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    @Override
//    public void saveCategoryIntoDb(Category category) {
//        this.categoryRepository.saveAndFlush(category);
//    }

    @Override
    public void saveCategoryIntoDb(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }
}
