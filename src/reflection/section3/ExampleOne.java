package reflection.section3;

import java.lang.reflect.Field;

public class ExampleOne {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        printFieldsInfo(Category.class);
        printFieldsInfo(Movie.MovieStats.class);

        Movie movie = new Movie("Lord of the Rings", 2001, 12.99, true, Category.ADVENTURE);
        Movie.MovieStats stats = movie.new MovieStats(3);
        printDeclaredFieldsInfo(stats.getClass(), stats);
        printDeclaredFieldsInfo(movie.getClass(), movie);

        /**
         * We can get value of static field without class instance using field.get(null)
         */
        Field field = Movie.class.getField("MINIMUM_PRICE");
        System.out.println("Static field value: " + field.get(null));
    }

    private static void printFieldsInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields) {
            System.out.println(String.format("Field name: %s, field type: %s", field.getName(), field.getType().getName()));

            if(field.isEnumConstant()) {
                System.out.println(String.format("Field: %s is enum constant value", field.getName()));
            } else if(field.isSynthetic()) {
                System.out.println(String.format("Field: %s is synthetic", field.getName()));
            }
            System.out.println();
        }
    }

    public static <T> void printDeclaredFieldsInfo(Class<? extends T> clazz, T instance) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields) {
            System.out.println(String.format("Field name: %s type:%s", field.getName(), field.getType().getName()));

            System.out.println("Is Synthetic field: " + field.isSynthetic());
            System.out.println("Field value: " + field.get(instance));
            System.out.println();
        }
    }
    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;
        private boolean isReleased;
        private Category category;
        private double actualPrice;
        public Movie(String name, int year, double price, boolean isReleased, Category category ) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = Math.max(price, MINIMUM_PRICE);
        }

        public class MovieStats {
            private double timesWatched;
            public MovieStats(double timesWatched) {
                this.timesWatched = timesWatched;
            }
            public double getRevenue() {
                return timesWatched * actualPrice;
            }
        }
    }
    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;
        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }
    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }
}
