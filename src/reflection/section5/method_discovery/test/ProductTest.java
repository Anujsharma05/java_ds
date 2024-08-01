package reflection.section5.method_discovery.test;

import reflection.section5.method_discovery.api.ClothingProduct;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ProductTest {
    public static void main(String[] args) {
        ProductTest test = new ProductTest();
        test.testGetters(ClothingProduct.class);
        test.testSetters(ClothingProduct.class);
    }
    private void testSetters(Class<?> dataClass) {

//        Field[] fields = dataClass.getDeclaredFields();
        List<Field> fields = getAllFields(dataClass);

        for(Field field: fields) {
            String setterName = "set" + capitalizeFirstLetter(field.getName());

            Method setterMethod = null;
            try {
                /**
                 * getMethod from current and superclasses
                 */
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch(NoSuchMethodException ex) {
                throw new IllegalStateException(String.format("Setter: %s not found", setterName));
            }

            if(!setterMethod.getReturnType().equals(void.class)) {
                throw new IllegalStateException(String.format("Setter method %s has to return void", setterMethod.getName()));
            }
        }
    }
    private void testGetters(Class<?> dataClass) {

        Map<String, Method> methodNameToMethod = mapMethodNameToMethod(dataClass);

//        Field[] fields = dataClass.getDeclaredFields();
        List<Field> fields = getAllFields(dataClass);

        for(Field field: fields) {
            String getterName = "get" + capitalizeFirstLetter(field.getName());

            if(!methodNameToMethod.containsKey(getterName)) {
                throw new IllegalStateException(String.format("Field: %s does not have a getter method", field.getName()));
            }

            Method getter = methodNameToMethod.get(getterName);
            if(!getter.getReturnType().equals(field.getType())) {
                throw new IllegalStateException(String.format("Getter method %s has return type %s but expected %s",
                        getter.getName(), getter.getReturnType().getTypeName(), field.getType().getTypeName()));
            }

            if(getter.getParameterCount() > 0) {
                throw new IllegalStateException(String.format("Getter %s has %d arguments", getter.getName(), getter.getParameterCount()));
            }
        }
    }

    /**
     * Current class as well as inherited fields
     */
    private List<Field> getAllFields(Class<?> clazz) {

        if(clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }
        Field[] currentClassFields = clazz.getDeclaredFields();

        List<Field> fields = new ArrayList<>();

        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());

        fields.addAll(Arrays.asList(currentClassFields));
        fields.addAll(inheritedFields);

        return fields;

    }
    private Map<String, Method> mapMethodNameToMethod(Class<?> dataClass) {

        Map<String, Method> methodMap = new HashMap<>();

        Method[] methods = dataClass.getMethods();

        for(Method method: methods) {
            methodMap.put(method.getName(), method);
        }

        return methodMap;
    }
    private String capitalizeFirstLetter(String fieldName) {
        return String.valueOf(fieldName.charAt(0)).toUpperCase().concat(fieldName.substring(1));
    }
}
