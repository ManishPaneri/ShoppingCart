Shopping Cart

Please make sure you read this document in it’s entirety.

Overview

Please write code delivering the requirements of the steps that follow.

The problem

As you work through the steps, you’ll create code to allow a user to add products to a shopping cart, calculate the total price and then the sales tax the items contained in the cart. As mentioned we are not looking for a command line or a web application, so please just use your tests to drive the code.

Please Note: All totals should be formatted to 2 decimal places, rounded up i.e. 0.567 should result in 0.57 but 0.564 should result in 0.56; this is known as Round Half-Up or Arithmetic Rounding.

Step 1: Add products to the shopping cart.

Given:

An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
When:

The user adds 5 Dove Soaps to the shopping cart
Then:

The shopping cart should contain 5 Dove Soaps each with a unit price of 39.99
And the shopping cart’s total price should equal 199.95
Archive this as a separate .zip file named step1.zip then continue on to step two.

Step 2: Add additional products of the same type to the shopping cart.

Given:

An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
When:

The user adds 5 Dove Soaps to the shopping cart
And then adds another 3 Dove Soaps to the shopping cart
Then:

The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99
And the shopping cart’s total price should equal 319.92
Archive this as a separate .zip file named step2.zip then continue on to step three.

Step 3: Calculate the tax rate of the shopping cart with multiple items

Given:

An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
And another product, Axe Deo with a unit price of 99.99
And a sales tax rate of 12.5%
When:

The user adds 2 Dove Soaps to the shopping cart
And then adds 2 Axe Deos to the shopping cart
Then:

The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99
And the shopping cart should contain 2 Axe Deos each with a unit price of 99.99
And the total sales tax amount for the shopping cart should equal 35.00
And the shopping cart’s total price should equal 314.96