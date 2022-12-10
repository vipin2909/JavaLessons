package DesignPatterns.Builder;

class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int servingSize;
        private final int servings;

        // optional paramters
        private  int calories = 0;
        private  int fat = 0;
        private  int sodium = 0;
        private  int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }
        public Builder fat(int val) {
            this.fat = fat;
            return this;
        }

        public Builder sodiumn(int val) {
            this.sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;

        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

        @Override
        public String toString() {
            return new NutritionFacts(this).toString();
        }


    }

    @Override
    public String toString() {
        return "ServingSize is " + this.servingSize + " and servings is " + this.servings;
    }

    private NutritionFacts(Builder builder) {
        this.servings = builder.servings;
        this.servingSize = builder.servingSize;
        this.fat = builder.fat;
        this.calories = builder.calories;
        this.carbohydrate = builder.carbohydrate;
        this.sodium = builder.sodium;
    }


}

public class DemoMain {
    public static void main(String[] args) {
        NutritionFacts.Builder builder = new NutritionFacts.Builder(10, 2);
        builder.calories(400);
        builder.fat(500);
        builder.carbohydrate(200);
        builder.sodiumn(100);
        builder.build();

        System.out.println(builder);

    }
}