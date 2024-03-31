# API-REST-CRUD

API-REST-CRUD is a RESTful API that provides endpoints for managing categories and products. It supports CRUD (Create, Read, Update, Delete) operations on both categories and products.

## Technologies Used

- Java
- Spring Framework
- Hibernate
- Maven

## Database

- PostgreSQL

## Endpoints

### Category Endpoint

The Category endpoint allows you to manage categories.

#### Endpoint URLs

- GET all categories: http://localhost:8080/api/category/findAll
- GET a specific category by ID: http://localhost:8080/api/category/find/{id}
- POST: Create a new category: http://localhost:8080/api/category/save
- PUT: Update an existing category by ID: http://localhost:8080/api/category/update/{id}
- DELETE: Delete a category by ID: http://localhost:8080/api/category/delete/{id}

### Product Endpoint

The Product endpoint allows you to manage products.

#### Endpoint URLs

- GET all products: http://localhost:8080/api/product/findAll
- GET a specific product by ID: http://localhost:8080/api/product/find/{id}
- POST: Create a new product: http://localhost:8080/api/product/save
- PUT: Update an existing product by ID: http://localhost:8080/api/product/update/{id}
- DELETE: Delete a product by ID: http://localhost:8080/api/product/delete/{id}

## Data Models

### Category

- id: Long (Primary Key)
- name: String

### Product

- id: Long (Primary Key)
- name: String
- price: BigDecimal
- category: Category

## Usage

To interact with these endpoints, you can use tools like cURL or Postman. Here are some example requests:

### Create a new Category or Product

```bash
# Category
{
    "name": "example"
}

# Product
```bash
{
    "name": "example",
    "price": 0.00,
    "category": {
        "id": 1
    }
}