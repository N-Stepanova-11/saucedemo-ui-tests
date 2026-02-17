# Автотесты для демо-сайта https://www.saucedemo.com/
Проект создан в учебных целях для практики UI-автоматизации. 

**Стек технологий:**
- Java
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager

**Текущая структура проекта:** <br> 
* src <br>
  * test <br>
    * java <br> 
        * сom.saucedemo <br>
          * pages <br> 
             * BasePage.java <br> 
             * LoginPage.java <br> 
             * InventoryPage.java <br> 
             * CartPage.java <br> 
             * CheckoutInfoPage.java <br> 
            * ProductPage.java <br> 
          * tests <br>
             * BaseTest.java <br> 
             * LoginTest.java <br> 
             * InventoryTest.java <br> 
             * CartTest.java <br> 
  
**Реализованные тесты:** <br> 
*Login tests* <br>
- Авторизация стандартного пользователя <br>
- Проверка ошибки для заблокированного пользователя <br>
  
*Inventory tests* <br>
- Добавление товара в корзину <br>
- Удаление товара из корзины <br>
- Открытие корзины <br>
- Проверка кнопок Add to cart / Remove <br>
 
*Cart tests* <br>
- Проверка наличия товара в корзине <br>
- Удаление товара из корзины <br>
- Переход на страницу товара из корзины <br>
- Переход к оформлению заказа (Checkout) <br>
- Возврат на страницу товаров (Continue Shopping) <br>

**Архитектура** <br>
*Проект ориентирован на применение паттерна Page Object Model:* <br>
- каждая страница представлена отдельным классом <br>
- локаторы инкапсулированы внутри PageObject <br>
- тесты не содержат Selenium-логики <br>
- тесты независимы друг от друга <br> 
- браузер запускается перед каждым тестом <br>

*Также реализован базовый класс BaseTest, который:* <br>
- инициализирует WebDriver <br>
- выполняет авторизацию (при необходимости) <br>
- закрывает браузер после теста <br>

**Примечания**
- Используется Chrome driver <br>
- Версия драйвера управляется через WebDriverManager <br>
- Локаторы построены на id, data-test и относительных XPath <br>

**Планы по развитию проекта:** <br>
- Добавление Allure Report <br>
- Расширение покрытия тестами <br>
