package com.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ec.entity.AdmCategory;
import com.ec.entity.AdmProduct;
import com.ec.service.AdmCategoryService;
import com.ec.service.AdmProductService;

import java.io.IOException;
import java.nio.file.*;

@Controller
@RequestMapping("/admin")
public class AdmnController {

    @Autowired
    private AdmCategoryService categoryService;

    @Autowired
    private AdmProductService productService;

    // ✅ Display all categories and products
    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProducts());
        return "manage-products-categories";
    }

    // ✅ Show Add Category Form
    @GetMapping("/categories/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new AdmCategory());
        return "add-category";
    }

    // ✅ Save new category
    @PostMapping("/categories/add")
    public String saveCategory(@ModelAttribute AdmCategory category) {
        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    // ✅ Show Add Product Form
    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new AdmProduct());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add-product";  // HTML filename must be add-products.html
    }

    // ✅ Save new product (with image upload)
    @PostMapping("/products/add")
    public String saveProduct(@ModelAttribute AdmProduct product,
                              @RequestParam("image") MultipartFile file) throws IOException {

        // Folder for storing images (under static)
        String uploadDir = "src/main/resources/static/product-images/";

        // Create folder if not exists
        Files.createDirectories(Paths.get(uploadDir));

        // Generate unique file name
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);
        Files.write(filePath, file.getBytes());

        // Set relative image path for HTML display
        product.setImagePath("/product-images/" + fileName);

        // Save to DB
        productService.saveProduct(product);

        // Redirect back to category/product management page
        return "redirect:/admin/categories";
    }

    // ✅ Delete category
    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }

    // ✅ Delete product
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/categories";
    }
}
