class ShippableProduct implements ShippingService {
    Product product;

    public ShippableProduct(Product product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.name;
    }

    @Override
    public double getWeight() {
        return product.weight;
    }
}