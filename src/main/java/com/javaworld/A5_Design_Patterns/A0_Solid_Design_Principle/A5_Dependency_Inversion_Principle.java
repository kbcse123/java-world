package com.javaworld.A5_Design_Patterns.A0_Solid_Design_Principle;

/**
 * DIP is a software development concept that helps make code more flexible and maintainable. It states
 * that high-level modules should not depend on low-level modules, and that both should depend on abstractions, that
 * means instead of classes depending directly on other concrete classes, they must depend on interfaces or abstractions.
 */

// Code that violates DIP:
 class Book {

    void seeReviews() {
    }

    void readSample() {
    }
}

 class Shelf {

    Book book;

    void addBook(Book book) {
    }

    void customizeShelf() {
    }
}

/**
 * Everything looks fine, but as the high-level Shelf class depends on the low-level Book, the above code violates the
 * Dependency Inversion Principle. This becomes clear when the store asks us to enable customers to add DVDs to their shelves,
 * too. In order to fulfil the demand, we create a new DVD class.
 * Now, we should modify the Shelf class so that it can accept DVDs, too. However, this would clearly break the
 * Open/Closed Principle too.
 */

 class DVD {

   void seeReviews() {
   }

   void watchSample() {
   }
}

//Code that follows DIP:
/**
 * The solution is to create an abstraction layer for the lower-level classes (Book and DVD). We’ll do so by introducing the
 * Product interface, both classes will implement it. For example, below code demonstrates the concept.
 */

 interface Product {

   void seeReviews();

   void getSample();

}

 class BookNew implements Product {

   @Override
   public void seeReviews() {
   }

   @Override
   public void getSample() {
   }

}

 class DVD_New implements Product {

   @Override
   public void seeReviews() {
   }

   @Override
   public void getSample() {
   }
}

/**
 * Now, Shelf can reference the Product interface instead of its implementations (Book and DVD). The refactored code also
 * allows us to later introduce new product types (for instance, Magazine) that customers can put on their shelves, too.
 */

 class ShelfNew {

   Product product;

   void addProduct(Product product) {
   }

   void customizeShelf() {
   }
}

/**
 * The above code also follows the Liskov Substitution Principle, as the Product type can be substituted with both of
 * its subtypes (Book and DVD) without breaking the program.
 */



public class A5_Dependency_Inversion_Principle {
}
