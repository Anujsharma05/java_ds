

package reflection.section2.tictactoe.init;

import reflection.section2.tictactoe.game.Game;
//import reflection.section2.tictactoe.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tic Tac Toe
 * https://www.udemy.com/course/java-reflection-master-class
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
//        Game game = createObjectRecursively(TicTacToeGame.class);

        /**
         * If TicTacToeGame class is package private
         */
        Game game = (Game) createObjectRecursively(Class.forName("reflection.section2.tictactoe.game.internal.TicTacToeGame"));
        game.startGame();
    }

    private static <T> T createObjectRecursively(Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<?> constructor = getFirstConstructor(clazz);

        List<Object> constructorArguments = new ArrayList<>();

        for(Class<?> parameterType: constructor.getParameterTypes()) {
            Object argumentValue = createObjectRecursively(parameterType);
            constructorArguments.add(argumentValue);
        }

        constructor.setAccessible(true);

        return (T) constructor.newInstance(constructorArguments.toArray());
    }
    private static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        if(constructors.length == 0) {
            throw new IllegalStateException(String.format("No constructor has been found for class %s", clazz.getName()));
        }

        return constructors[0];
    }



}
