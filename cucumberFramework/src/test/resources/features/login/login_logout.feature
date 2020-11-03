Feature: As a Demoblaze user I should be able to login and purchase products from the App

  Scenario Outline: Login into the application and purchase products
  
  Given I am on the Login page URL "https://www.demoblaze.com/index.html" 
  Then I click on sign in button and wait for sign in page
  Then I should see Sign In Page
  When I enter username as "Bharat"
  And I enter password as "15063660"
  And click on login button
  Then I am logged in
  And I clear cart items if any
  Then I click home button from menu bar to continue shopping    
  Then I navigate to different product categories from left menu
  Then I choose laptop Sony vaio i5 and added to the cart 
  Then I choose laptop Dell i7 8gb and added to the cart  
  Then  I opt to delete laptop Dell i7 8gb from the cart 
  Then  I capture amount to be paid      
  And click on place order button   
  Then I enter Name as "<name>" and Country as "<country>" and City as "<city>" and Card as "<card>" and Month as "<month>" and Year as "<year>"  
  And   I click on purchase order button   
  Then I capture Order details and verify with expected amount     
  And I Click on Ok button      
  
     Examples:
     | name  | country  | | city | card  | | month  | year | 
     | Tom   | Denmark  | | xyza | 1234  | | Nov    | 2020 |

 

   
   
  
  
   
