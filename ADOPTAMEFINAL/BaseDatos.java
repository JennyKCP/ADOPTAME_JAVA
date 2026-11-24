import java.util.ArrayList;
import java.util.List;

/**
 * Base de datos inicial de ADOPTAME.
 * Contiene los animales de ejemplo que se cargan al iniciar el sistema.
 */
public class BaseDatos {

    public static List<Adoptame.Animal> cargarAnimales() {
        List<Adoptame.Animal> datos = new ArrayList<>();

        datos.add(new Adoptame.Animal(1, "Luna", "Gato", "Mestiza", 1, "Pequeño", "Cariñosa, tranquila y acostumbrada a interiores", "Saludable", "Disponible", "imagenes/animal_1795404841159.jpg"));
        datos.add(new Adoptame.Animal(2, "Max", "Perro", "Labrador", 3, "Grande", "Juguetón, sociable y le encanta caminar", "Saludable", "Disponible", "imagenes/animal_1795406078202.jpg"));
        datos.add(new Adoptame.Animal(3, "Milo", "Gato", "Común europeo", 2, "Pequeño", "Curioso, afectuoso y se lleva bien con otros gatos", "Saludable", "Disponible", "imagenes/animal_1795404855529.jpg"));
        datos.add(new Adoptame.Animal(4, "Rocky", "Perro", "Mestizo", 4, "Mediano", "Activo, protector y obediente", "En tratamiento", "En observación", "imagenes/animal_1795406099989.jpg"));
        datos.add(new Adoptame.Animal(5, "Nala", "Perro", "Golden Retriever", 2, "Grande", "Dulce, paciente y buena con niños", "Saludable", "Disponible", "imagenes/animal_1795406114427.jpg"));
        datos.add(new Adoptame.Animal(6, "Coco", "Perro", "Caniche", 1, "Pequeño", "Inteligente, alegre y muy sociable", "Saludable", "Disponible", "imagenes/animal_1795406129610.jpg"));
        datos.add(new Adoptame.Animal(7, "Simba", "Gato", "Atigrado", 3, "Mediano", "Independiente, curioso y juguetón", "Saludable", "Disponible", "imagenes/animal_1795404949240.jpg"));
        datos.add(new Adoptame.Animal(8, "Bella", "Perro", "Chihuahua", 5, "Pequeño", "Leal, alerta y disfruta estar acompañada", "Saludable", "Disponible", "imagenes/animal_1795406143155.jpg"));
        datos.add(new Adoptame.Animal(9, "Toby", "Perro", "Beagle", 2, "Mediano", "Amigable, activo y de buen olfato", "Vacunación pendiente", "En observación", "imagenes/animal_1795406160189.jpg"));
        datos.add(new Adoptame.Animal(10, "Misha", "Gato", "Persa", 4, "Pequeño", "Tranquila, delicada y cariñosa", "Saludable", "Disponible", "imagenes/animal_1795406186184.jpg"));
        datos.add(new Adoptame.Animal(11, "Thor", "Perro", "Pastor alemán", 3, "Grande", "Inteligente, atento y necesita espacio", "Saludable", "Disponible", "imagenes/animal_1795406207762.jpg"));
        datos.add(new Adoptame.Animal(12, "Pelusa", "Gato", "Mestiza", 6, "Pequeño", "Dócil, dormilona y disfruta las caricias", "Saludable", "Disponible", "imagenes/animal_1795405393704.jpg"));
        datos.add(new Adoptame.Animal(13, "Doki", "Perro", "Mestizo", 1, "Mediano", "Juguetón, sociable y aprende rápido", "Desparasitación pendiente", "Disponible", "imagenes/animal_1795406223573.jpg"));
        datos.add(new Adoptame.Animal(14, "Mora", "Perro", "Cocker spaniel", 4, "Mediano", "Afectuosa, tranquila y familiar", "Saludable", "Disponible", "imagenes/animal_1795406237807.jpg"));
        datos.add(new Adoptame.Animal(15, "Oliver", "Gato", "Naranja", 2, "Pequeño", "Travieso, activo y muy curioso", "Saludable", "Disponible", "imagenes/animal_1795405415933.jpg "));
        datos.add(new Adoptame.Animal(16, "Kira", "Perro", "Husky siberiano", 2, "Grande", "Enérgica, amistosa y necesita ejercicio", "Saludable", "Disponible", "imagenes/animal_1795406255391.jpg"));
        datos.add(new Adoptame.Animal(17, "Manchas", "Perro", "Dálmata", 3, "Grande", "Activo, cariñoso y sociable", "Saludable", "Disponible", "imagenes/animal_1795406778795.jpg"));
        datos.add(new Adoptame.Animal(18, "Nube", "Gato", "Angora", 1, "Pequeño", "Suave, juguetona y algo tímida", "Saludable", "Disponible", "imagenes/animal_1795405436214.jpg"));
        datos.add(new Adoptame.Animal(19, "Bobby", "Perro", "Mestizo", 7, "Mediano", "Noble, calmado y acostumbrado a personas", "Saludable", "Disponible", "imagenes/animal_1795406794548.jpg"));
        datos.add(new Adoptame.Animal(20, "Lola", "Perro", "Pug", 5, "Pequeño", "Simpática, tranquila y compañera", "Control veterinario pendiente", "En observación", "imagenes/animal_1795406807737.jpg"));
        datos.add(new Adoptame.Animal(21, "Tom", "Gato", "Mestizo", 3, "Pequeño", "Independiente, limpio y juguetón", "Saludable", "Disponible", "imagenes/animal_1795405456120.jpg"));
        datos.add(new Adoptame.Animal(22, "Rex", "Perro", "Boxer", 2, "Grande", "Enérgico, protector y afectuoso", "Saludable", "Disponible", "imagenes/animal_1795406821070.jpg"));
        datos.add(new Adoptame.Animal(23, "Canela", "Perro", "Mestiza", 2, "Mediano", "Dulce, obediente y sociable", "Saludable", "Disponible", "imagenes/animal_1795406837025.jpg"));
        datos.add(new Adoptame.Animal(24, "Peluchín", "Conejo", "Cabeza de león", 1, "Pequeño", "Manso, curioso y acostumbrado a humanos", "Saludable", "Disponible", "imagenes/animal_1795406850496.jpg"));
        datos.add(new Adoptame.Animal(25, "Pipo", "Ave", "Periquito", 1, "Pequeño", "Activo, canta por las mañanas y es sociable", "Saludable", "Disponible", "imagenes/animal_1795406863389.jpg"));
        datos.add(new Adoptame.Animal(26, "Kiwi", "Conejo", "Holandés", 2, "Pequeño", "Tranquilo, dócil y disfruta verduras", "Saludable", "Disponible", "imagenes/animal_1795406891484.jpg"));
        datos.add(new Adoptame.Animal(27, "Bambi", "Perro", "Mestiza", 1, "Pequeño", "Tierna, juguetona y algo tímida", "Vacunación pendiente", "Disponible", "imagenes/animal_1795406917021.jpg"));
        datos.add(new Adoptame.Animal(28, "Ginger", "Gato", "Mestiza", 5, "Mediano", "Cariñosa, independiente y tranquila", "Saludable", "Disponible", "imagenes/animal_1795405473947.jpg"));
        datos.add(new Adoptame.Animal(29, "Duque", "Perro", "Rottweiler", 4, "Grande", "Leal, obediente y necesita tutor responsable", "Saludable", "Disponible", "imagenes/animal_1795406940445.jpg"));
        datos.add(new Adoptame.Animal(30, "Chispa", "Perro", "Jack Russell", 2, "Pequeño", "Muy activa, curiosa y juguetona", "Saludable", "Disponible", "imagenes/animal_1795406965563.jpg"));
        datos.add(new Adoptame.Animal(31, "Michi", "Gato", "Siamés", 3, "Pequeño", "Comunicativo, afectuoso y sociable", "Saludable", "Disponible", "imagenes/animal_1795405489394.jpg"));
        datos.add(new Adoptame.Animal(32, "Bubu", "Hámster", "Sirio", 1, "Pequeño", "Tranquilo, nocturno y fácil de cuidar", "Saludable", "Disponible", "imagenes/animal_1795407292689.jpg"));
        datos.add(new Adoptame.Animal(33, "Daisy", "Perro", "Mestiza", 6, "Mediano", "Amable, paciente y disfruta paseos cortos", "Saludable", "Disponible", "imagenes/animal_1795407320917.jpg"));
        datos.add(new Adoptame.Animal(34, "Felix", "Gato", "Negro", 2, "Pequeño", "Juguetón, curioso y cariñoso", "Saludable", "Disponible", "imagenes/animal_1795405507253.jpg"));
        datos.add(new Adoptame.Animal(35, "Apolo", "Perro", "Dóberman", 3, "Grande", "Inteligente, activo y protector", "Saludable", "Disponible", "imagenes/animal_1795407347473.jpg"));
        datos.add(new Adoptame.Animal(36, "Lili", "Conejo", "Mestiza", 1, "Pequeño", "Dócil, limpia y tranquila", "Saludable", "Disponible", "imagenes/animal_1795407634822.jpg"));
        datos.add(new Adoptame.Animal(37, "Pecas", "Perro", "Mestizo", 2, "Mediano", "Sociable, alegre y le gusta jugar", "En recuperación", "En observación", "imagenes/animal_1795407650801.jpg"));
        datos.add(new Adoptame.Animal(38, "Mimi", "Gato", "Calicó", 4, "Pequeño", "Afectuosa, calmada y hogareña", "Saludable", "Disponible", "imagenes/animal_1795405522568.jpg"));
        datos.add(new Adoptame.Animal(39, "Zeus", "Perro", "Gran danés", 5, "Grande", "Gentil, tranquilo y necesita espacio", "Saludable", "Disponible", "imagenes/animal_1795407667145.jpg"));
        datos.add(new Adoptame.Animal(40, "Frida", "Gato", "Mestiza", 1, "Pequeño", "Juguetona, dulce y se adapta rápido", "Saludable", "Disponible", "imagenes/animal_1795405537268.jpg"));
        datos.add(new Adoptame.Animal(41, "Tita", "Perro", "Schnauzer", 7, "Pequeño", "Alerta, cariñosa y de carácter tranquilo", "Saludable", "Disponible", "imagenes/animal_1795407685370.jpg"));
        datos.add(new Adoptame.Animal(42, "Cleo", "Gato", "Mestiza", 8, "Mediano", "Serena, independiente y busca un hogar calmado", "Saludable", "Disponible", "imagenes/animal_1795405554517.jpg"));
        datos.add(new Adoptame.Animal(43, "Rocky Jr.", "Perro", "Mestizo", 1, "Mediano", "Juguetón, curioso y sociable", "Desparasitación pendiente", "Disponible", "imagenes/animal_1795407706871.jpg"));
        datos.add(new Adoptame.Animal(44, "Panda", "Conejo", "Mestizo", 2, "Pequeño", "Manso, curioso y se deja acariciar", "Saludable", "Disponible", "imagenes/animal_1795407725954.jpg"));
        datos.add(new Adoptame.Animal(45, "Sol", "Ave", "Canario", 2, "Pequeño", "Canta con frecuencia y requiere ambiente tranquilo", "Saludable", "Disponible", "imagenes/animal_1795434609802.jpg"));
        datos.add(new Adoptame.Animal(46, "Atena", "Perro", "Pastor belga", 3, "Grande", "Inteligente, activa y obediente", "Saludable", "Disponible", "imagenes/animal_1795434863560.jpg"));
        datos.add(new Adoptame.Animal(47, "Gala", "Gato", "Mestiza", 2, "Pequeño", "Cariñosa, juguetona y sociable", "Saludable", "Disponible", "imagenes/animal_1795405573028.jpg"));
        datos.add(new Adoptame.Animal(48, "Tango", "Perro", "Mestizo", 9, "Mediano", "Muy tranquilo, noble y acostumbrado a convivir", "Saludable", "Disponible", "imagenes/animal_1795434887235.jpg"));
        datos.add(new Adoptame.Animal(49, "Choco", "Perro", "Labrador mestizo", 2, "Grande", "Amigable, juguetón y amante del agua", "Saludable", "Disponible", "imagenes/animal_1795434905533.jpg"));
        datos.add(new Adoptame.Animal(50, "Nina", "Gato", "Mestiza", 1, "Pequeño", "Tímida al principio, luego muy afectuosa", "Saludable", "Disponible", "imagenes/animal_1795405588426.jpg"));
        datos.add(new Adoptame.Animal(51, "Copito", "Conejo", "Angora", 3, "Pequeño", "Tranquilo, dócil y necesita cepillado", "Saludable", "Disponible", "imagenes/animal_1795434627810.jpg"));
        datos.add(new Adoptame.Animal(52, "Baco", "Perro", "Mestizo", 4, "Mediano", "Leal, calmado y buen compañero", "Tratamiento finalizado", "Disponible", "imagenes/animal_1795434923414.jpg"));
        datos.add(new Adoptame.Animal(53, "Arya", "Gato", "Siamés", 1, "Pequeño", "Activa, curiosa y muy comunicativa", "Saludable", "Disponible", "imagenes/animal_1795405605132.jpg"));
        datos.add(new Adoptame.Animal(54, "Ringo", "Perro", "Bulldog francés", 3, "Pequeño", "Sociable, divertido y cariñoso", "Saludable", "Disponible", "imagenes/animal_1795434940668.jpg"));
        datos.add(new Adoptame.Animal(55, "Maya", "Perro", "Mestiza", 5, "Mediano", "Paciente, dulce y disfruta la compañía", "Saludable", "Disponible", "imagenes/animal_1795434955738.jpg"));
        datos.add(new Adoptame.Animal(56, "Toby Jr.", "Gato", "Mestizo", 1, "Pequeño", "Juguetón, curioso y se adapta a familias", "Saludable", "Disponible", "imagenes/animal_1795405634472.jpg"));

        return datos;
    }
}
