package java_collection_framework.array_list_linked_list;

import java.util.*;

import static java_collection_framework.array_list_linked_list.MainProduct.mainMenu;
import static java_collection_framework.array_list_linked_list.SortProductDecrease.*;
import static java_collection_framework.array_list_linked_list.SortProductAscending.*;


public class ProductManager {
    static List<Product> productList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void addProduct(Product product) {
        System.out.println("Nhập id sản phẩm");
        product.setIdProduct(input.nextLine());
        System.out.println("Nhập tên sản phẩm");
        product.setNameProduct(input.nextLine());
        System.out.println("Nhập giá sản phẩm");
        product.setPriceProduct(Integer.parseInt(input.nextLine()));
        productList.add(product);
    }

    public static void showProduct() {
        if (productList.isEmpty())
            System.out.println("Danh sách sản phẩm hiện đang trống , hãy thêm vào");
        else {
            System.out.println("Danh sách sản phẩm:");
            for (Product proc : productList) {
                System.out.println(proc);
            }
        }
    }

    public static void fixProduct() {
        showProduct();
        boolean check = true;
        System.out.println("Nhập id sản phẩm cần sửa");
        String idProduct = input.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct().equals(idProduct)) {
                do {
                    System.out.println("1. Sửa id sản phẩm: " + productList.get(i).getIdProduct() +
                            "\n" + "2. Sửa tên sản phẩm: " + productList.get(i).getNameProduct() +
                            "\n" + "3. Sửa giá sản phẩm:" + productList.get(i).getPriceProduct()
                            + "\n" + "4. Exit");
                    int chooseEdit = Integer.parseInt(input.nextLine());
                    switch (chooseEdit) {
                        case 1:
                            System.out.println("Nhập id sản phẩm cần sửa:");
                            productList.get(i).setIdProduct(input.nextLine());
                            System.out.println("Sửa id thành công");
                            break;
                        case 2:
                            System.out.println("Nhập tên sản phẩm cần sửa:");
                            productList.get(i).setNameProduct(input.nextLine());
                            System.out.println("Sửa tên thành công");
                            break;
                        case 3:
                            System.out.println("Nhập giá sản phẩm cần sửa:");
                            productList.get(i).setPriceProduct(Integer.parseInt(input.nextLine()));
                            System.out.println("Sửa giá thành công");
                            break;
                        case 4:
                            mainMenu();
                            break;
                        default:
                            System.out.println("Không tìm thấy lựa chọn");
                    }
                } while (true);
            } else {
                check = false;
            }
        }
        if (!check)
            System.out.println("Không tìm id thấy sản phẩm cần sửa");
    }

    public static void deleteProduct() {
        showProduct();
        boolean check = true;
        String answer;
        System.out.println("Nhập id sản phẩm cần xóa");
        String chooseDelete;
        chooseDelete = input.nextLine().toLowerCase();
        System.out.println(chooseDelete);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct().equals(chooseDelete)) {
                System.out.println("Chắn chắc muốn xóa sản phẩm: " + productList.get(i).getNameProduct() + " chọn y/n");
                answer = input.nextLine();
                if (answer.equals("y")) {
                    productList.remove(i);
                    System.out.println("xóa thành công");
                   mainMenu();
                }else
                    mainMenu();
            } else {
                check = false;
            }
        }
        if (!check)
            System.out.println("Không tìm thấy sản phẩm cần xóa");
    }

    public static void findProduct() {
        boolean check = true;
        showProduct();
        System.out.println("Nhập tên sản phẩm cần tìm:");
        String nameProc = input.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().equals(nameProc)) {
                System.out.println("Thông tin sản phẩm:" + "\n" + productList.get(i));
                break;
            } else
                check = false;
        }
        if (!check)
            System.out.println("Không tìm thấy sản phẩm với tên: " + nameProc);
        mainMenu();
    }

    public static void sortAssending() {
        SortProductAscending productAscending = new SortProductAscending();
        Collections.sort(productList, productAscending);
        showProduct();
    }

    public static void sortDecrease() {
        SortProductDecrease productAscending = new SortProductDecrease();
        Collections.sort(productList, productAscending);
        showProduct();
    }
    public static void sortProduct() {
        System.out.println("1. Tăng dần" + "\n" + "2. Giảm dần");
        String chooseSort = input.nextLine();
        switch (chooseSort) {
            case "1":
                sortAssending();
                break;
            case "2":
                sortDecrease();
                break;
            default:
                System.out.println("Nhập sai rồi bạn ơi TT");
                sortProduct();
        }

    }

}

