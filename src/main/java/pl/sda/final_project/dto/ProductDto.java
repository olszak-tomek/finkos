package pl.sda.final_project.dto;

import pl.sda.final_project.model.product.ProductEntity;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {
    private Long id;
    private String productTitle;
    private String productDescription;
    private String productImageUrl;

    private ProductCategoryDto productCategory;
    private BigDecimal productPrice;
    private String productType;
    private String authorName;
    private String authorSurname;

    public static ProductDto apply(ProductEntity productEntity) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setProductCategoryId(productEntity.getCategory().getId());
        productCategoryDto.setProductCategoryTitle(productEntity.getCategory().getTitle());

        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setProductTitle(productEntity.getTitle());
        productDto.setProductDescription(productEntity.getDescription());
        productDto.setProductType(productEntity.getProductType().getPlName());
        productDto.setProductPrice(productEntity.getPrice());
        productDto.setAuthorName(productEntity.getAuthor().getAuthorName());
        productDto.setAuthorSurname((productEntity.getAuthor().getAuthorSurname()));
        productDto.setProductImageUrl(productEntity.getImageUrl());
        productDto.setProductCategory(productCategoryDto);


        return productDto;

    }


    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }


    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }


    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }


    public ProductCategoryDto getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDto productCategory) {
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
