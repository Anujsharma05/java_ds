package reflection.section4.dynamic_config_loader.src.configLoader;

import reflection.section4.dynamic_config_loader.src.data.GameConfig;
import reflection.section4.dynamic_config_loader.src.data.UserInterfaceConfig;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final Path GAME_CONFIG_PATH = Path.of("reflection/section4/dynamic_config_loader/resources/game-properties.cfg");
    private static final Path UI_CONFIG_PATH = Path.of("reflection/section4/dynamic_config_loader/resources/user-interface.cfg");
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        GameConfig gameConfig = createConfigObject(GameConfig.class, GAME_CONFIG_PATH);
        UserInterfaceConfig uiConfig = createConfigObject(UserInterfaceConfig.class, UI_CONFIG_PATH);

        System.out.println(gameConfig);
        System.out.println(uiConfig);
    }

    static <T> T createConfigObject(Class<T> clazz, Path filePath) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        T object = constructor.newInstance();

        Scanner scanner = new Scanner(filePath);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] nameValuePair = line.split("=");
            String propertyName = nameValuePair[0];
            String propertyValue = nameValuePair[1];

            Field field;
            try {
                field = clazz.getDeclaredField(propertyName);
            } catch(NoSuchFieldException ex) {
                System.out.println(String.format("Unsupported filed: %s for class %s", propertyName, clazz.getSimpleName()));
                continue;
            }

            field.setAccessible(true);

            /**
             * Setting value of field using object instance
             * NOTE: We cannot use constructor for setting values because after compilation,
             * constructor argument names are no longer retained
             *
             * Also, We must not set value of final field because it leads to unexpected behaviors
             */

            if(field.getType().isArray()) {
                field.set(object, parseArray(field.getType(), propertyValue));
            } else {
                field.set(object, parseValue(field.getType(), propertyValue));
            }
        }
        return object;
    }

    static Object parseArray(Class<?> fieldType, String value) {
        String[] arrayValues = value.split(",");
        Object array = Array.newInstance(fieldType.getComponentType(), arrayValues.length);

        for(int index=0; index<arrayValues.length; index++) {
            Array.set(array, index, parseValue(fieldType.getComponentType(), arrayValues[index]));
        }
        return array;
    }
    static Object parseValue(Class<?> fieldType, String value) {
        if(fieldType.equals(int.class)) {
            return Integer.parseInt(value);
        } else if(fieldType.equals(short.class)) {
            return Short.parseShort(value);
        } else if(fieldType.equals(long.class)) {
            return Long.parseLong(value);
        } else if(fieldType.equals(double.class)) {
            return Double.parseDouble(value);
        } else if(fieldType.equals(float.class)) {
            return Float.parseFloat(value);
        } else if(fieldType.equals(String.class)) {
            return value;
        }
        throw new RuntimeException(String.format("Type %s unsupported", fieldType.getTypeName()));
    }
}
