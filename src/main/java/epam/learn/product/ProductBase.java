package epam.learn.product;

import epam.learn.transaction.SaleTransaction;
import epam.learn.transaction.Transaction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Реалізувати систему Pos за лекційними прикладами
 Розширити Pos до “Автомату з продажу напоїв” за вимогами:
         Приймає монети 1, 5, 10, 25, 50
         Дозволяє обрати товар Чай(25), Кава(35), Сік(45)
         Дозволяє повернути гроші, скасувавши запит
         Видає решту і продукт
         Використовувати лише Java, без жодних фреймворків
         Непотрібно робити UI, достатньо командного рядку з меню
         Непотрібно робити Persistence
 *
 * Created by Mykhailo on 010 10.07.17.
 */
public class ProductBase {

    private static List<ProductDefinition> products;

    public static void main(String[] args) {
        initProducts();

        Transaction transaction = new SaleTransaction();

    }

    public static void initProducts() {
        products = Arrays.asList(new Product("tea", "Green tea with jasmin", new BigDecimal("0.25")),
                new Product("coffee", "Kopi Luwak", new BigDecimal("0.35")),
                new Product("juice", "Fresh seabuckthorn juice", new BigDecimal("0.45")));
    }

    public static ProductDefinition getProduct(String name) {
        return products.stream().filter(product -> name.equalsIgnoreCase(product.getName())).findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no such product in the system: " + name));
    }
}
