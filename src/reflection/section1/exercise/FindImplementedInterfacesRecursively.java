package reflection.section1.exercise;

import java.util.HashSet;
import java.util.Set;

interface intOne {

}
interface intTwo extends intThree {

}
interface intThree {

}
class IntClass implements intOne, intTwo {

}
public class FindImplementedInterfacesRecursively {
    public static void main(String[] args) {

        Set<Class<?>> interfaces = findAllImplementedInterfaces(HashSet.class);

        for(Class<?> interf: interfaces) {
            System.out.println(interf.getSimpleName());
        }

    }

    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {

        Set<Class<?>> set = new HashSet<>();

        Class<?>[] implementedInterfaces = input.getInterfaces();

        for(Class<?> implementedInterface: implementedInterfaces) {
            set.add(implementedInterface);
            Set<Class<?>> parentInterfaces = findAllImplementedInterfaces(implementedInterface);
            set.addAll(parentInterfaces);
        }

        return set;
    }
}
