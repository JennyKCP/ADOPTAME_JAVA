import java.util.ArrayList;
import java.util.List;

/**
 * Base de datos inicial de ADOPTAME.
 * Contiene los animales de ejemplo que se cargan al iniciar el sistema.
 */
public class BaseDatos {

    public static List<Adoptame.Animal> cargarAnimales() {
        List<Adoptame.Animal> datos = new ArrayList<>();

        datos.add(new Adoptame.Animal(1, "Luna", "Gato", "Mestiza", 1, "Pequeño", "Cariñosa, tranquila y acostumbrada a interiores", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(2, "Max", "Perro", "Labrador", 3, "Grande", "Juguetón, sociable y le encanta caminar", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(3, "Milo", "Gato", "Común europeo", 2, "Pequeño", "Curioso, afectuoso y se lleva bien con otros gatos", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(4, "Rocky", "Perro", "Mestizo", 4, "Mediano", "Activo, protector y obediente", "En tratamiento", "En observación", null));
        datos.add(new Adoptame.Animal(5, "Nala", "Perro", "Golden Retriever", 2, "Grande", "Dulce, paciente y buena con niños", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(6, "Coco", "Perro", "Caniche", 1, "Pequeño", "Inteligente, alegre y muy sociable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(7, "Simba", "Gato", "Atigrado", 3, "Mediano", "Independiente, curioso y juguetón", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(8, "Bella", "Perro", "Chihuahua", 5, "Pequeño", "Leal, alerta y disfruta estar acompañada", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(9, "Toby", "Perro", "Beagle", 2, "Mediano", "Amigable, activo y de buen olfato", "Vacunación pendiente", "En observación", null));
        datos.add(new Adoptame.Animal(10, "Misha", "Gato", "Persa", 4, "Pequeño", "Tranquila, delicada y cariñosa", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(11, "Thor", "Perro", "Pastor alemán", 3, "Grande", "Inteligente, atento y necesita espacio", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(12, "Pelusa", "Gato", "Mestiza", 6, "Pequeño", "Dócil, dormilona y disfruta las caricias", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(13, "Doki", "Perro", "Mestizo", 1, "Mediano", "Juguetón, sociable y aprende rápido", "Desparasitación pendiente", "Disponible", null));
        datos.add(new Adoptame.Animal(14, "Mora", "Perro", "Cocker spaniel", 4, "Mediano", "Afectuosa, tranquila y familiar", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(15, "Oliver", "Gato", "Naranja", 2, "Pequeño", "Travieso, activo y muy curioso", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(16, "Kira", "Perro", "Husky siberiano", 2, "Grande", "Enérgica, amistosa y necesita ejercicio", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(17, "Manchas", "Perro", "Dálmata", 3, "Grande", "Activo, cariñoso y sociable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(18, "Nube", "Gato", "Angora", 1, "Pequeño", "Suave, juguetona y algo tímida", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(19, "Bobby", "Perro", "Mestizo", 7, "Mediano", "Noble, calmado y acostumbrado a personas", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(20, "Lola", "Perro", "Pug", 5, "Pequeño", "Simpática, tranquila y compañera", "Control veterinario pendiente", "En observación", null));
        datos.add(new Adoptame.Animal(21, "Tom", "Gato", "Mestizo", 3, "Pequeño", "Independiente, limpio y juguetón", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(22, "Rex", "Perro", "Boxer", 2, "Grande", "Enérgico, protector y afectuoso", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(23, "Canela", "Perro", "Mestiza", 2, "Mediano", "Dulce, obediente y sociable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(24, "Peluchín", "Conejo", "Cabeza de león", 1, "Pequeño", "Manso, curioso y acostumbrado a humanos", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(25, "Pipo", "Ave", "Periquito", 1, "Pequeño", "Activo, canta por las mañanas y es sociable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(26, "Kiwi", "Conejo", "Holandés", 2, "Pequeño", "Tranquilo, dócil y disfruta verduras", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(27, "Bambi", "Perro", "Mestiza", 1, "Pequeño", "Tierna, juguetona y algo tímida", "Vacunación pendiente", "Disponible", null));
        datos.add(new Adoptame.Animal(28, "Ginger", "Gato", "Mestiza", 5, "Mediano", "Cariñosa, independiente y tranquila", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(29, "Duque", "Perro", "Rottweiler", 4, "Grande", "Leal, obediente y necesita tutor responsable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(30, "Chispa", "Perro", "Jack Russell", 2, "Pequeño", "Muy activa, curiosa y juguetona", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(31, "Michi", "Gato", "Siamés", 3, "Pequeño", "Comunicativo, afectuoso y sociable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(32, "Bubu", "Hámster", "Sirio", 1, "Pequeño", "Tranquilo, nocturno y fácil de cuidar", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(33, "Daisy", "Perro", "Mestiza", 6, "Mediano", "Amable, paciente y disfruta paseos cortos", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(34, "Felix", "Gato", "Negro", 2, "Pequeño", "Juguetón, curioso y cariñoso", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(35, "Apolo", "Perro", "Dóberman", 3, "Grande", "Inteligente, activo y protector", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(36, "Lili", "Conejo", "Mestiza", 1, "Pequeño", "Dócil, limpia y tranquila", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(37, "Pecas", "Perro", "Mestizo", 2, "Mediano", "Sociable, alegre y le gusta jugar", "En recuperación", "En observación", null));
        datos.add(new Adoptame.Animal(38, "Mimi", "Gato", "Calicó", 4, "Pequeño", "Afectuosa, calmada y hogareña", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(39, "Zeus", "Perro", "Gran danés", 5, "Grande", "Gentil, tranquilo y necesita espacio", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(40, "Frida", "Gato", "Mestiza", 1, "Pequeño", "Juguetona, dulce y se adapta rápido", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(41, "Tita", "Perro", "Schnauzer", 7, "Pequeño", "Alerta, cariñosa y de carácter tranquilo", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(42, "Cleo", "Gato", "Mestiza", 8, "Mediano", "Serena, independiente y busca un hogar calmado", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(43, "Rocky Jr.", "Perro", "Mestizo", 1, "Mediano", "Juguetón, curioso y sociable", "Desparasitación pendiente", "Disponible", null));
        datos.add(new Adoptame.Animal(44, "Panda", "Conejo", "Mestizo", 2, "Pequeño", "Manso, curioso y se deja acariciar", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(45, "Sol", "Ave", "Canario", 2, "Pequeño", "Canta con frecuencia y requiere ambiente tranquilo", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(46, "Atena", "Perro", "Pastor belga", 3, "Grande", "Inteligente, activa y obediente", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(47, "Gala", "Gato", "Mestiza", 2, "Pequeño", "Cariñosa, juguetona y sociable", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(48, "Tango", "Perro", "Mestizo", 9, "Mediano", "Muy tranquilo, noble y acostumbrado a convivir", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(49, "Choco", "Perro", "Labrador mestizo", 2, "Grande", "Amigable, juguetón y amante del agua", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(50, "Nina", "Gato", "Mestiza", 1, "Pequeño", "Tímida al principio, luego muy afectuosa", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(51, "Copito", "Conejo", "Angora", 3, "Pequeño", "Tranquilo, dócil y necesita cepillado", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(52, "Baco", "Perro", "Mestizo", 4, "Mediano", "Leal, calmado y buen compañero", "Tratamiento finalizado", "Disponible", null));
        datos.add(new Adoptame.Animal(53, "Arya", "Gato", "Siamés", 1, "Pequeño", "Activa, curiosa y muy comunicativa", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(54, "Ringo", "Perro", "Bulldog francés", 3, "Pequeño", "Sociable, divertido y cariñoso", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(55, "Maya", "Perro", "Mestiza", 5, "Mediano", "Paciente, dulce y disfruta la compañía", "Saludable", "Disponible", null));
        datos.add(new Adoptame.Animal(56, "Toby Jr.", "Gato", "Mestizo", 1, "Pequeño", "Juguetón, curioso y se adapta a familias", "Saludable", "Disponible", null));

        return datos;
    }
}