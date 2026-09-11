package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;

public class ProductApiTest {

    @Test(groups = "smoke")
    public void getProductTest() {

        Response response =
                RestAssured
                        .given()
                        .spec(ApiUtils.getRequestSpecification())
                        .log()
                        .all()
                        .when()
                        .get("/products/1");

        System.out.println(
                "Response Status Code: "
                + response.getStatusCode()
        );

        response.then()
                .log()
                .all();

        // Validate HTTP status code
        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        // Validate Product ID
        int productId =
                response.jsonPath().getInt("id");

        Assert.assertEquals(
                productId,
                1,
                "Product ID is incorrect"
        );

        // Validate Product Title
        String productTitle =
                response.jsonPath().getString("title");

        Assert.assertEquals(
                productTitle,
                "Essence Mascara Lash Princess",
                "Product title is incorrect"
        );

        // Validate Product Price
        double productPrice =
                response.jsonPath().getDouble("price");

        Assert.assertEquals(
                productPrice,
                9.99,
                "Product price is incorrect"
        );

        // Validate Product Stock
        int productStock =
                response.jsonPath().getInt("stock");

        Assert.assertEquals(
                productStock,
                99,
                "Product stock is incorrect"
        );

        System.out.println(
                "All API response validations passed successfully."
        );
    }

    @Test(groups = "regression")
    public void createProductTest() {

        String requestBody =
                "{"
                + "\"title\":\"Test Automation Product\","
                + "\"price\":29.99,"
                + "\"stock\":50"
                + "}";

        Response response =
                RestAssured
                        .given()
                        .spec(ApiUtils.getRequestSpecification())
                        .body(requestBody)
                        .log()
                        .all()
                        .when()
                        .post("/products/add");

        System.out.println(
                "POST Response Status Code: "
                + response.getStatusCode()
        );

        response.then()
                .log()
                .all();

        Assert.assertEquals(
                response.getStatusCode(),
                201,
                "Expected HTTP status code 201"
        );

        String productTitle =
                response.jsonPath().getString("title");

        Assert.assertEquals(
                productTitle,
                "Test Automation Product",
                "Created product title is incorrect"
        );

        double productPrice =
                response.jsonPath().getDouble("price");

        Assert.assertEquals(
                productPrice,
                29.99,
                "Created product price is incorrect"
        );

        System.out.println(
                "POST API test passed successfully."
        );
    }

    @Test(groups = "regression")
    public void deleteProductTest() {

        Response response =
                RestAssured
                        .given()
                        .spec(ApiUtils.getRequestSpecification())
                        .log()
                        .all()
                        .when()
                        .delete("/products/1");

        System.out.println(
                "DELETE Response Status Code: "
                + response.getStatusCode()
        );

        response.then()
                .log()
                .all();

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        boolean isDeleted =
                response.jsonPath().getBoolean("isDeleted");

        Assert.assertTrue(
                isDeleted,
                "Product was not deleted successfully"
        );

        System.out.println(
                "DELETE API test passed successfully."
        );
    }

    @Test(groups = "regression")
    public void updateProductTest() {

        String requestBody =
                "{"
                + "\"title\":\"Updated Automation Product\","
                + "\"price\":39.99"
                + "}";

        Response response =
                RestAssured
                        .given()
                        .spec(ApiUtils.getRequestSpecification())
                        .body(requestBody)
                        .log()
                        .all()
                        .when()
                        .put("/products/1");

        System.out.println(
                "PUT Response Status Code: "
                + response.getStatusCode()
        );

        response.then()
                .log()
                .all();

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected HTTP status code 200"
        );

        String updatedTitle =
                response.jsonPath().getString("title");

        Assert.assertEquals(
                updatedTitle,
                "Updated Automation Product",
                "Updated product title is incorrect"
        );

        double updatedPrice =
                response.jsonPath().getDouble("price");

        Assert.assertEquals(
                updatedPrice,
                39.99,
                "Updated product price is incorrect"
        );

        System.out.println(
                "PUT API test passed successfully."
        );
    }
}