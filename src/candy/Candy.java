package candy;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 * @author Alex Pumnea
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int candies = 1;
        int up = 1;
        int down = 0;
        int peak = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                candies += up;
            } else if (ratings[i] < ratings[i - 1]) {
                down++;
                up = 1;
                candies += down;
                if (down >= peak) {
                    candies++;
                }
            } else {
                up = 1;
                peak = 1;
                down = 0;
                candies++;
            }
        }
        return candies;
    }
}
