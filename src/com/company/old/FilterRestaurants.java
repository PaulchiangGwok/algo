package com.company.old;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 */
public class FilterRestaurants {
    public static void main(String[] args) {

        System.out.println();
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Restaurant> list = new ArrayList<>(restaurants.length);
        for (int[] restaurant : restaurants) {
            list.add(new Restaurant(restaurant[0], restaurant[1], restaurant[2], restaurant[3], restaurant[4]));
        }

        return list.stream().filter(r -> r.veganFriendly >= veganFriendly && r.price <= maxPrice && r.distance <= maxDistance)
            .sorted((o1, o2) -> o1.rating == o2.rating ? o2.id - o1.id : o2.rating - o1.rating)
            .map(r -> r.id)
            .collect(Collectors.toList());
    }

    class Restaurant {
        int id;
        int rating;
        int veganFriendly;
        int price;
        int distance;

        public Restaurant(int id, int rating, int veganFriendly, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.veganFriendly = veganFriendly;
            this.price = price;
            this.distance = distance;
        }
    }
}
