package com.view;

import com.controller.ProductController;
import com.model.Product;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        Scanner sc = new Scanner(System.in);
        int choice;
        int idProduct;
        String productName;
        do {
            ProductView.menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showProductList(productController.getProduct()); break;
                case 2:
                    productController.addProduct(addProductForm(productController.getProduct().size() + 1));break;
                case 3:
                    showProductList(productController.getProduct());
                    System.out.print("Nhập vào id sản phẩm bạn muốn sửa: ");
                    idProduct = sc.nextInt();
                    if(isProductInList(productController.getProduct(),idProduct)) {
                        productController.editProduct(idProduct, editProductForm(idProduct));
                    } else {
                        System.out.println("Không có tìm thấy id trong danh sách");
                    }
                    break;
                case 4:
                    showProductList(productController.getProduct());
                    System.out.print("Nhập vào id sản phẩm bạn muốn xóa: ");
                    idProduct = sc.nextInt();
                    if(isProductInList(productController.getProduct(),idProduct)) {
                        productController.deleteProduct(idProduct);
                    } else {
                        System.out.println("Không có tìm thấy id trong danh sách");
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.print("Nhập tên sản phẩm bạn muốn tìm: ");
                    productName = sc.nextLine();
                    if(isProductInList(productController.getProduct(),productName)) {
                        showProduct(productController.searchProduct(productName));
                    } else {
                        System.out.println("Không có tìm thấy tên sản phẩm trong danh sách");
                    }
                    break;
                case 6:
                    productController.sortByPrice();
                    showProductList(productController.getProduct());
                    break;
                case 0:
                    System.out.println("Thoát");
                    break;
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("------------------------------");
        System.out.println("Quản lý sản phẩm");
        System.out.println("1.Hiển thị danh sách sản phẩm");
        System.out.println("2.Thêm mới sản phẩm");
        System.out.println("3.Sửa thông tin sản phẩm");
        System.out.println("4.Xóa sản phẩm");
        System.out.println("5.Tìm sản phẩm theo tên");
        System.out.println("6.Sắp xếp sản phẩm theo giá");
        System.out.println("0.Thoát");
        System.out.print("Mời nhập lựa chọn: ");
    }

    public static void showProductList(List<Product> list) {
        for(Product item: list) {
            System.out.println("==============================");
            System.out.println("Id: " + item.getId());
            System.out.println("Name: "+ item.getName());
            Locale locale = new Locale("vi","VN");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            System.out.println("Price: " + format.format(item.getPrice()));
            String status = item.isStatus() ? "Trang thái: Còn hàng" : "Status: Hết hàng";
            System.out.println(status);
            System.out.println("Description: " + item.getDescription());
        }
    }

    public static void showProduct(Product product) {
        System.out.println("==============================");
        System.out.println("Id: " + product.getId());
        System.out.println("Name: "+ product.getName());
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Price: " + format.format(product.getPrice()));
        String status = product.isStatus() ? "Trang thái: Còn hàng" : "Status: Hết hàng";
        System.out.println(status);
        System.out.println("Description: " + product.getDescription());
    }

    public static Product addProductForm(int productId) {
        Scanner sc = new Scanner(System.in);
        int id = productId;
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập chi tiết sản phẩm: ");
        String description = sc.nextLine();

        Product product = new Product(id, name, price, true, description);
        return product;
    }

    public static Product editProductForm(int productId) {
        Scanner sc = new Scanner(System.in);
        int id = productId;
        System.out.print("Nhập tên mới: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá mới: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập chi tiết sản phẩm mới: ");
        String description = sc.nextLine();

        Product product = new Product(id, name, price, true, description);
        return product;
    }

    public static boolean isProductInList(List<Product> list, Object o) {
        int id = -1;
        try {
            id = (int) o;
        } catch (Exception e) {

        }
        for(Product item: list) {
            if(item.getId() == id || item.getName().equals(o)) {
                return true;
            }
        }
        return false;
    }

}
