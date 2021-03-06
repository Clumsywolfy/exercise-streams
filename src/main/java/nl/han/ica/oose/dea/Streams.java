package nl.han.ica.oose.dea;


import nl.han.ica.oose.dea.helpers.Product;
import nl.han.ica.oose.dea.helpers.ProductCategory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Streams {

    List<String> filterStringsShorterThanThreeCharacters(List<String> input) {
        var result = input;

        return result.stream()
                .filter(string -> string.length() < 3).collect(Collectors.toList());

    }

    List<String> filterStringsThatContainOnlyNumerals(List<String> input) {
        var result = input;

        return result.stream()
                .filter(string -> string.matches("[\\d]+")).collect(Collectors.toList());
    }

    String findShortestString(List<String> input) {
        var result = input;

        return result.stream()
                .sorted().findFirst().orElse(null);
    }

    String createAFullSentenceFromTheList(List<String> input) {
        var result = input;
        return input.stream()
                .collect(Collectors.joining(" "));
    }

    int calculateTotalCostOfAllProducts(List<Product> products) {
        var result = products;
        return products.stream()
                .map(product -> product.getPrice())
                .reduce((a,b) -> a + b)
                .orElse(0);
    }

    int calculateTotalCostOfAllGadgets(List<Product> products) {
        var result = products;
        return products.stream()
                .filter(product -> product.getCategory().equals(ProductCategory.GADGETS))
                .map(product -> product.getPrice())
                .reduce((a,b) -> a + b)
                .orElse(0);
    }
}
