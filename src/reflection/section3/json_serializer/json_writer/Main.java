package reflection.section3.json_serializer.json_writer;

import reflection.section3.json_serializer.data.*;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Address address = new Address("Baratie Restaurant", (short)1);
        Company company = new Company("Straw hat pirates", "Water 7", new Address("Grand Line", (short)1));
        Person person = new Person("Sanji", true, 28, 60000.5533f, address, company);

        Actor actor1 = new Actor("Karl Urban", new String[]{"Lord of the Rings", "Star Trek"});
        Actor actor2 = new Actor("Orlando Bloom", new String[] {"Lord of the Rings", "Pirates of the Caribbean"});
        Actor actor3 = new Actor("Ian McKellen", new String[] {"Lord of the Rings", "X-Men"});

        Movie movie = new Movie("Lord of the Rings",
                8.8f, new String[] {"Action", "Adventure", "Fantasy"}, new Actor[] {actor1, actor2, actor3});

        String json = objectToJson(movie, 0);
        System.out.println(json);
    }

    /**
     *
     * @param instance - Object to be converted to json
     * @param indentSize - To format the json with proper indentation
     */
    public static String objectToJson(Object instance, int indentSize) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append(indent(indentSize));
        sb.append("{");
        sb.append("\n");
        for(Field field: fields) {

            /**
             * Make private field accessible
             */
            field.setAccessible(true);

            /**
             * Ignoring compiler generated fields
             */
            if(field.isSynthetic()) continue;

            sb.append(indent(indentSize+1));

            sb.append(formatStringValue(field.getName())).append(":");

            String value;
            if(field.getType().isPrimitive()) {
                value = formatPrimitiveValue(field.get(instance), field.getType());
            } else if(field.getType().equals(String.class)){
                value = formatStringValue(field.get(instance).toString());
            } else if(field.getType().isArray()) {
                value = arrayToJson(field.get(instance), indentSize+1);
            }else {
                /**
                 * Recursive calling to serialize nested objects
                 */
                value = objectToJson(field.get(instance), indentSize+1);
            }
            sb.append(value).append(",");
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.append(indent(indentSize));
        sb.append("}");

        return sb.toString();
    }

    private static String arrayToJson(Object arrayObject, int indentSize) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        int length = Array.getLength(arrayObject);
        Class<?> componentType = arrayObject.getClass().getComponentType();

        sb.append("[");
        sb.append("\n");
        for(int i=0; i<length; i++) {

            Object element = Array.get(arrayObject, i);

            String value;
            if(componentType.isPrimitive()) {
                sb.append(indent(indentSize+1));
                value = formatPrimitiveValue(element, componentType);
            } else if(componentType.equals(String.class)) {
                sb.append(indent(indentSize+1));
                value = formatStringValue(element.toString());
            } else {
                value = objectToJson(element, indentSize + 1);
            }
            sb.append(value);

            if(i != length-1) {
                sb.append(", ");
            }
            sb.append("\n");
        }
        sb.append(indent(indentSize));
        sb.append("]");

        return sb.toString();
    }

    public static String indent(int indentSize) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<indentSize; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
    public static String formatPrimitiveValue(Object value, Class<?> type) throws IllegalAccessException {
        if(type.equals(int.class)
        || type.equals(boolean.class)
        || type.equals(short.class)
        || type.equals(long.class)) {
            return value.toString();
        } else if(type.equals(float.class)
        || type.equals(double.class)) {
            return String.format("%.02f", value);
        }

        throw new RuntimeException(String.format("Type: %s is not supported", type.getName()));
    }
    public static String formatStringValue(String value) {
        return String.format("\"%s\"", value);
    }
}
