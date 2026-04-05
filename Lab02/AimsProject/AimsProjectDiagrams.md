# AimsProject UML Diagrams

## Class Diagram

```mermaid
classDiagram
    class DigitalVideoDisc {
        - String title
        - String category
        - String director
        - int length
        - float cost
        + DigitalVideoDisc(String title, String category, String director, int length, float cost)
        + getTitle(): String
        + getCategory(): String
        + getDirector(): String
        + getLength(): int
        + getCost(): float
    }

    class Cart {
        + static final int MAX_NUMBERS_ORDERED = 20
        - DigitalVideoDisc[] itemsOrdered
        - int qtyOrdered
        + addDigitalVideoDisc(DigitalVideoDisc disc): void
        + removeDigitalVideoDisc(DigitalVideoDisc disc): void
        + totalCost(): float
    }

    class Aims {
        + main(String[] args): void
    }

    Cart --> DigitalVideoDisc : contains 0..20
    Aims --> Cart : creates
    Aims --> DigitalVideoDisc : creates
```

## Use Case Diagram

```mermaid
usecaseDiagram
    actor User
    User --> (Add DVD to Cart)
    User --> (Remove DVD from Cart)
    User --> (View Total Cost)
    (Add DVD to Cart) .> (View Total Cost) : includes
    (Remove DVD from Cart) .> (View Total Cost) : includes
```

## Summary

- `DigitalVideoDisc.java`: represents a DVD item and exposes getter methods.
- `Cart.java`: stores DVDs, supports adding/removing discs, and calculates total cost.
- `Aims.java`: application entry point that creates DVDs, adds them to the cart, and prints the total.
