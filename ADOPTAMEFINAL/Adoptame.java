import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.plaf.basic.BasicButtonUI;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ADOPTAME - Sistema de gestión y búsqueda de animales.
 * Aplicación de escritorio desarrollada con Java Swing.
 * Credenciales de demostración: admin / admin123
 */
public class Adoptame extends JFrame {
    // Paleta suave: marfil, salvia y verde bosque.
    private static final Color FONDO = new Color(246, 247, 242);
    private static final Color PANEL = new Color(255, 254, 250);
    private static final Color CAFE = new Color(218, 229, 216);       // Botón principal
    private static final Color CAFE_OSCURO = new Color(53, 73, 60);  // Encabezados
    private static final Color TEXTO = new Color(43, 51, 45);
    private static final Color BLANCO = new Color(255, 255, 255);
    private static final Color ARENA = new Color(235, 238, 229);
    private static final Color VERDE = new Color(73, 112, 80);
    private static final Color BORDE = new Color(222, 227, 217);
    private static final Color TEXTO_SUAVE = new Color(105, 113, 105);

    private final List<Animal> animales = new ArrayList<>();
    private final Map<Integer, Animal> indiceAnimales = new HashMap<>();
    private int siguienteId = 1;

    private CardLayout cardLayout;
    private JPanel contenedorPrincipal;
    private JTextField txtBuscar;
    private JComboBox<String> cbEspecie, cbDisponibilidad, cbOrden;
    private JPanel panelTarjetas;
    private JLabel lblConteo;

    public Adoptame() {
        setTitle("ADÓPTAME | Encuentra un nuevo amigo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setSize(1120, 760);
        setLocationRelativeTo(null);
        setBackground(FONDO);

        cargarDatosIniciales();
        cardLayout = new CardLayout();
        contenedorPrincipal = new JPanel(cardLayout);
        contenedorPrincipal.add(crearLogin(), "LOGIN");
        contenedorPrincipal.add(crearInicio(), "INICIO");
        setContentPane(contenedorPrincipal);
    }

    // --------------------------- MODELO ---------------------------
    static class Animal {
        int id;
        String nombre, especie, raza, tamano, caracteristicas, salud, disponibilidad, rutaImagen;
        int edad;

        Animal(int id, String nombre, String especie, String raza, int edad,
               String tamano, String caracteristicas, String salud,
               String disponibilidad, String rutaImagen) {
            this.id = id;
            this.nombre = nombre;
            this.especie = especie;
            this.raza = raza;
            this.edad = edad;
            this.tamano = tamano;
            this.caracteristicas = caracteristicas;
            this.salud = salud;
            this.disponibilidad = disponibilidad;
            this.rutaImagen = rutaImagen;
        }
    }

    private void cargarDatosIniciales() {
        animales.addAll(BaseDatos.cargarAnimales());
        for (Animal a : animales) {
            indiceAnimales.put(a.id, a);
        }
        siguienteId = animales.size() + 1;
    }

    private void agregarAnimal(String nombre, String especie, String raza, int edad,
                               String tamano, String caracteristicas, String salud,
                               String disponibilidad, String rutaImagen) {
        Animal a = new Animal(siguienteId++, nombre, especie, raza, edad, tamano,
                caracteristicas, salud, disponibilidad, rutaImagen);
        animales.add(a);
        indiceAnimales.put(a.id, a);
    }

    // --------------------------- LOGIN ---------------------------
    private JPanel crearLogin() {
        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(FONDO);

        JPanel tarjeta = new JPanel();
        tarjeta.setBackground(PANEL);
        tarjeta.setPreferredSize(new Dimension(410, 590));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDE, 1, true),
                new EmptyBorder(32, 44, 32, 44)));
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("🐾", SwingConstants.CENTER);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setOpaque(true);
        logo.setBackground(ARENA);
        logo.setForeground(TEXTO);
        logo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 52));
        logo.setPreferredSize(new Dimension(112, 112));
        logo.setMaximumSize(new Dimension(112, 112));
        logo.setMinimumSize(new Dimension(112, 112));
        logo.setBorder(BorderFactory.createLineBorder(ARENA, 2, true));

        JLabel titulo = new JLabel("ADOPTAME");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 30));
        titulo.setForeground(CAFE_OSCURO);

        JLabel subtitulo = new JLabel("Bienvenido de nuevo");
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(TEXTO_SUAVE);

        JTextField usuario = new JTextField();
        JPasswordField clave = new JPasswordField();
        estilizarCampo(usuario);
        estilizarCampo(clave);

        JLabel lblUsuario = etiquetaCampo("E-mail o usuario");
        JLabel lblClave = etiquetaCampo("Contraseña");
        JButton ingresar = botonPrincipal("INICIAR SESIÓN");
        JLabel mensaje = new JLabel(" ", SwingConstants.CENTER);
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        mensaje.setForeground(new Color(150,  70,  60));
        mensaje.setFont(new Font("SansSerif", Font.PLAIN, 11));
        JLabel ayuda = new JLabel("¿Olvidaste tu contraseña?");
        ayuda.setAlignmentX(Component.CENTER_ALIGNMENT);
        ayuda.setFont(new Font("SansSerif", Font.PLAIN, 10));
        ayuda.setForeground(TEXTO);

        tarjeta.add(Box.createVerticalGlue());
        tarjeta.add(logo);
        tarjeta.add(Box.createVerticalStrut(16));
        tarjeta.add(titulo);
        tarjeta.add(Box.createVerticalStrut(7));
        tarjeta.add(subtitulo);
        tarjeta.add(Box.createVerticalStrut(30));
        tarjeta.add(lblUsuario);
        tarjeta.add(Box.createVerticalStrut(5));
        tarjeta.add(usuario);
        tarjeta.add(Box.createVerticalStrut(17));
        tarjeta.add(lblClave);
        tarjeta.add(Box.createVerticalStrut(5));
        tarjeta.add(clave);
        tarjeta.add(Box.createVerticalStrut(27));
        tarjeta.add(ingresar);
        tarjeta.add(Box.createVerticalStrut(8));
        tarjeta.add(mensaje);
        tarjeta.add(ayuda);
        tarjeta.add(Box.createVerticalGlue());

        ingresar.addActionListener(e -> autenticar(usuario.getText().trim(), new String(clave.getPassword()), mensaje));
        clave.addActionListener(e -> autenticar(usuario.getText().trim(), new String(clave.getPassword()), mensaje));

        fondo.add(tarjeta);
        return fondo;
    }

    private void autenticar(String usuario, String password, JLabel mensaje) {
        if (usuario.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!", "ADÓPTAME", JOptionPane.INFORMATION_MESSAGE);
            actualizarGaleria();
            cardLayout.show(contenedorPrincipal, "INICIO");
        } else {
            mensaje.setText("Usuario o contraseña incorrectos.");
        }
    }

    // --------------------------- INICIO / GALERÍA ---------------------------
    private JPanel crearInicio() {
        JPanel pagina = new JPanel(new BorderLayout());
        pagina.setBackground(FONDO);

        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(CAFE_OSCURO);
        barra.setBorder(new EmptyBorder(18, 32, 18, 32));
        JLabel marca = new JLabel("🐾  ADÓPTAME");
        marca.setForeground(Color.WHITE);
        marca.setFont(new Font("SansSerif", Font.BOLD, 22));
        JButton salir = botonBarra("Cerrar sesión");
        JButton administrar = botonBarra("Gestionar animales");
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 9, 0));
        acciones.setOpaque(false);
        acciones.add(administrar);
        acciones.add(salir);
        barra.add(marca, BorderLayout.WEST);
        barra.add(acciones, BorderLayout.EAST);

        JPanel contenido = new JPanel(new BorderLayout(12, 14));
        contenido.setOpaque(false);
        contenido.setBorder(new EmptyBorder(28, 34, 24, 34));

        JPanel encabezado = new JPanel(new BorderLayout(5, 8));
        encabezado.setOpaque(false);
        JLabel titulo = new JLabel("Encuentra a tu nuevo mejor amigo");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 29));
        titulo.setForeground(TEXTO);
        JLabel descripcion = new JLabel("Conoce a los animalitos que esperan una familia.");
        descripcion.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descripcion.setForeground(TEXTO_SUAVE);
        JPanel titulos = new JPanel(new GridLayout(2, 1, 0, 3));
        titulos.setOpaque(false);
        titulos.add(titulo);
        titulos.add(descripcion);

        txtBuscar = new JTextField(19);
        txtBuscar.setToolTipText("Buscar por nombre, especie, raza o características");
        estilizarCampo(txtBuscar);
        cbEspecie = new JComboBox<>(new String[]{"Todas las especies", "Perro", "Gato", "Otro"});
        cbDisponibilidad = new JComboBox<>(new String[]{"Todos los estados", "Disponible", "Adoptado", "En observación"});
        cbOrden = new JComboBox<>(new String[]{"Ordenar: predeterminado", "Nombre A-Z", "Edad: menor a mayor", "Edad: mayor a menor", "Tamaño"});
        estilizarCombo(cbEspecie); estilizarCombo(cbDisponibilidad); estilizarCombo(cbOrden);
        JButton buscar = botonPrincipal("BUSCAR");
        JButton limpiar = botonSecundario("Limpiar");
        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        filtros.setBackground(PANEL);
        filtros.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDE, 1, true),
                new EmptyBorder(8, 10, 8, 10)));
        filtros.add(txtBuscar); filtros.add(cbEspecie); filtros.add(cbDisponibilidad);
        filtros.add(cbOrden); filtros.add(buscar); filtros.add(limpiar);
        JPanel arriba = new JPanel(new BorderLayout(0, 14));
        arriba.setOpaque(false);
        arriba.add(titulos, BorderLayout.NORTH);
        arriba.add(filtros, BorderLayout.CENTER);

        panelTarjetas = new JPanel(new GridLayout(0, 3, 18, 18));
        panelTarjetas.setOpaque(false);
        panelTarjetas.setBorder(new EmptyBorder(10, 4, 16, 4));
        JScrollPane scroll = new JScrollPane(panelTarjetas);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scroll.getViewport().setBackground(FONDO);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        lblConteo = new JLabel();
        lblConteo.setForeground(TEXTO_SUAVE);
        lblConteo.setFont(new Font("SansSerif", Font.BOLD, 12));
        contenido.add(arriba, BorderLayout.NORTH);
        contenido.add(scroll, BorderLayout.CENTER);
        contenido.add(lblConteo, BorderLayout.SOUTH);

        pagina.add(barra, BorderLayout.NORTH);
        pagina.add(contenido, BorderLayout.CENTER);

        buscar.addActionListener(e -> actualizarGaleria());
        txtBuscar.addActionListener(e -> actualizarGaleria());
        cbEspecie.addActionListener(e -> actualizarGaleria());
        cbDisponibilidad.addActionListener(e -> actualizarGaleria());
        cbOrden.addActionListener(e -> actualizarGaleria());
        limpiar.addActionListener(e -> {
            txtBuscar.setText(""); cbEspecie.setSelectedIndex(0);
            cbDisponibilidad.setSelectedIndex(0); cbOrden.setSelectedIndex(0);
            actualizarGaleria();
        });
        administrar.addActionListener(e -> abrirGestion());
        salir.addActionListener(e -> cardLayout.show(contenedorPrincipal, "LOGIN"));
        return pagina;
    }

    private void actualizarGaleria() {
        if (panelTarjetas == null) return;
        String texto = txtBuscar == null ? "" : txtBuscar.getText().trim().toLowerCase();
        String especie = cbEspecie == null ? "Todas las especies" : (String) cbEspecie.getSelectedItem();
        String estado = cbDisponibilidad == null ? "Todos los estados" : (String) cbDisponibilidad.getSelectedItem();
        List<Animal> lista = animales.stream().filter(a -> {
            boolean coincideTexto = texto.isEmpty()
                    || String.valueOf(a.id).contains(texto)
                    || a.nombre.toLowerCase().contains(texto)
                    || a.especie.toLowerCase().contains(texto)
                    || a.raza.toLowerCase().contains(texto)
                    || a.tamano.toLowerCase().contains(texto)
                    || a.caracteristicas.toLowerCase().contains(texto)
                    || a.salud.toLowerCase().contains(texto)
                    || a.disponibilidad.toLowerCase().contains(texto)
                    || String.valueOf(a.edad).contains(texto);
            boolean coincideEspecie = especie.equals("Todas las especies") || a.especie.equalsIgnoreCase(especie);
            boolean coincideEstado = estado.equals("Todos los estados") || a.disponibilidad.equalsIgnoreCase(estado);
            return coincideTexto && coincideEspecie && coincideEstado;
        }).collect(Collectors.toCollection(ArrayList::new));

        if (cbOrden != null) {
            String orden = (String) cbOrden.getSelectedItem();
            if ("Nombre A-Z".equals(orden)) lista.sort(Comparator.comparing(a -> a.nombre.toLowerCase()));
            else if ("Edad: menor a mayor".equals(orden)) lista.sort(Comparator.comparingInt(a -> a.edad));
            else if ("Edad: mayor a menor".equals(orden)) lista.sort((a, b) -> Integer.compare(b.edad, a.edad));
            else if ("Tamaño".equals(orden)) lista.sort(Comparator.comparingInt(a -> pesoTamano(a.tamano)));
        }

        panelTarjetas.removeAll();
        for (Animal a : lista) panelTarjetas.add(crearTarjetaAnimal(a));
        if (lista.isEmpty()) {
            JPanel vacio = new JPanel(new GridBagLayout());
            vacio.setOpaque(false);
            vacio.add(new JLabel("No se encontraron animalitos con esos criterios."));
            panelTarjetas.setLayout(new BorderLayout());
            panelTarjetas.add(vacio, BorderLayout.CENTER);
        } else {
            panelTarjetas.setLayout(new GridLayout(0, 3, 18, 18));
        }
        lblConteo.setText("Mostrando " + lista.size() + " de " + animales.size() + " animales");
        panelTarjetas.revalidate(); panelTarjetas.repaint();
    }

    private int pesoTamano(String t) {
        if (t == null) return 0;
        switch (t.toLowerCase()) { case "pequeño": return 1; case "mediano": return 2; case "grande": return 3; default: return 0; }
    }

    private JPanel crearTarjetaAnimal(Animal a) {
        JPanel tarjeta = new JPanel(new BorderLayout(0, 8));
        tarjeta.setBackground(PANEL);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDE, 1, true),
                new EmptyBorder(14, 14, 15, 14)));
        tarjeta.setPreferredSize(new Dimension(270, 355));

        JLabel foto = new JLabel();
        foto.setHorizontalAlignment(SwingConstants.CENTER);
        foto.setPreferredSize(new Dimension(242, 196));
        foto.setOpaque(true);
        foto.setBackground(ARENA);
        foto.setIcon(cargarImagen(a.rutaImagen, 242, 196));

        JLabel nombre = new JLabel(a.nombre);
        nombre.setFont(new Font("SansSerif", Font.BOLD, 19));
        nombre.setForeground(TEXTO);
        JLabel datos = new JLabel(a.especie + " · " + a.raza + " · " + a.edad + " año(s)");
        datos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        datos.setForeground(TEXTO_SUAVE);
        JLabel estado = new JLabel(a.disponibilidad.toUpperCase());
        estado.setFont(new Font("SansSerif", Font.BOLD, 10));
        estado.setForeground(a.disponibilidad.equals("Disponible") ? VERDE : CAFE_OSCURO);
        JButton ver = botonSecundario("Ver ficha");
        ver.addActionListener(e -> mostrarFicha(a));

        JPanel info = new JPanel(new GridLayout(3, 1, 0, 6));
        info.setOpaque(false);
        info.add(nombre); info.add(datos); info.add(estado);
        tarjeta.add(foto, BorderLayout.NORTH);
        tarjeta.add(info, BorderLayout.CENTER);
        tarjeta.add(ver, BorderLayout.SOUTH);
        return tarjeta;
    }

    private void mostrarFicha(Animal a) {
        JPanel contenido = new JPanel(new BorderLayout(14, 10));
        contenido.setBackground(PANEL);
        contenido.setBorder(new EmptyBorder(12, 12, 12, 12));
        JLabel imagen = new JLabel(cargarImagen(a.rutaImagen, 230, 210));
        imagen.setPreferredSize(new Dimension(230, 210));
        imagen.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel datos = new JPanel(new GridLayout(0, 1, 0, 7));
        datos.setBackground(PANEL);
        datos.setBorder(new EmptyBorder(4, 4, 4, 4));
        datos.add(tituloFicha(a.nombre));
        datos.add(datoFicha("Código", String.valueOf(a.id)));
        datos.add(datoFicha("Especie", a.especie));
        datos.add(datoFicha("Raza", a.raza));
        datos.add(datoFicha("Edad", a.edad + " año(s)"));
        datos.add(datoFicha("Tamaño", a.tamano));
        datos.add(datoFicha("Características", a.caracteristicas));
        datos.add(datoFicha("Estado de salud", a.salud));
        datos.add(datoFicha("Disponibilidad", a.disponibilidad));
        contenido.add(imagen, BorderLayout.WEST);
        contenido.add(datos, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(this, contenido, "Ficha del animal", JOptionPane.PLAIN_MESSAGE);
    }

    private JLabel tituloFicha(String texto) {
        JLabel l = new JLabel(texto);
        l.setFont(new Font("SansSerif", Font.BOLD, 21));
        l.setForeground(CAFE_OSCURO);
        return l;
    }

    private JLabel datoFicha(String etiqueta, String valor) {
        JLabel l = new JLabel("<html><b>" + etiqueta + ":</b> " + valor + "</html>");
        l.setFont(new Font("SansSerif", Font.PLAIN, 13));
        l.setForeground(TEXTO);
        return l;
    }

    // --------------------------- CRUD / GESTIÓN ---------------------------
    private void abrirGestion() {
        JDialog dialogo = new JDialog(this, "Gestión de animales", true);
        dialogo.setSize(1120, 700);
        dialogo.setMinimumSize(new Dimension(900, 600));
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(new BorderLayout(10, 10));
        dialogo.getContentPane().setBackground(FONDO);

        JLabel titulo = new JLabel("GESTIÓN DE ANIMALES");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        titulo.setForeground(TEXTO);
        titulo.setBorder(new EmptyBorder(20, 22, 12, 22));

        String[] columnas = {"ID", "Nombre", "Especie", "Raza", "Edad", "Tamaño", "Salud", "Disponibilidad"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(34);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tabla.setForeground(TEXTO);
        tabla.setBackground(PANEL);
        tabla.setGridColor(BORDE);
        tabla.setSelectionBackground(ARENA);
        tabla.setSelectionForeground(TEXTO);
        tabla.setShowVerticalLines(false);
        tabla.setIntercellSpacing(new Dimension(0, 1));
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        tabla.getTableHeader().setOpaque(true);
        tabla.setFillsViewportHeight(true);
        tabla.getTableHeader().setBackground(ARENA);
        tabla.getTableHeader().setForeground(CAFE_OSCURO);
        tabla.getTableHeader().setPreferredSize(new Dimension(0, 38));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDE, 1, true),
                new EmptyBorder(2, 2, 2, 2)));

        JTextField nombre = campoGestion(), especie = campoGestion(), raza = campoGestion(), edad = campoGestion();
        JTextField tamano = campoGestion(), caracteristicas = campoGestion(), salud = campoGestion();
        JComboBox<String> disponibilidad = new JComboBox<>(new String[]{"Disponible", "Adoptado", "En observación"});
        estilizarCombo(disponibilidad);
        JLabel archivo = new JLabel("Sin imagen seleccionada");
        archivo.setFont(new Font("SansSerif", Font.PLAIN, 11));
        archivo.setForeground(TEXTO_SUAVE);
        final String[] ruta = {null};
        final int[] idActual = {-1};

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBackground(PANEL);
        formulario.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDE, 1, true),
                new EmptyBorder(15, 14, 15, 14)));
        formulario.setPreferredSize(new Dimension(315, 0));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 3, 4, 3); g.fill = GridBagConstraints.HORIZONTAL; g.weightx = 1;
        agregarCampo(formulario, g, 0, "Nombre", nombre);
        agregarCampo(formulario, g, 1, "Especie", especie);
        agregarCampo(formulario, g, 2, "Raza", raza);
        agregarCampo(formulario, g, 3, "Edad (años)", edad);
        agregarCampo(formulario, g, 4, "Tamaño", tamano);
        agregarCampo(formulario, g, 5, "Características", caracteristicas);
        agregarCampo(formulario, g, 6, "Estado de salud", salud);
        agregarCampo(formulario, g, 7, "Disponibilidad", disponibilidad);
        JButton elegirImagen = botonSecundario("Seleccionar imagen");
        g.gridx = 0; g.gridy = 16; g.gridwidth = 2; formulario.add(elegirImagen, g);
        g.gridy = 17; formulario.add(archivo, g);

        JButton registrar = botonPrincipal("REGISTRAR");
        JButton modificar = botonSecundario("MODIFICAR");
        JButton eliminar = botonSecundario("ELIMINAR");
        JButton limpiar = botonSecundario("LIMPIAR");
        JPanel botones = new JPanel(new GridLayout(2, 2, 7, 7));
        botones.setOpaque(false);
        botones.add(registrar); botones.add(modificar); botones.add(eliminar); botones.add(limpiar);
        g.gridy = 18; formulario.add(botones, g);

        JPanel centro = new JPanel(new BorderLayout(12, 0));
        centro.setOpaque(false);
        centro.setBorder(new EmptyBorder(0, 12, 12, 12));
        centro.add(formulario, BorderLayout.WEST);
        centro.add(scroll, BorderLayout.CENTER);
        dialogo.add(titulo, BorderLayout.NORTH);
        dialogo.add(centro, BorderLayout.CENTER);

        Runnable refrescar = () -> {
            modelo.setRowCount(0);
            for (Animal a : animales) modelo.addRow(new Object[]{a.id, a.nombre, a.especie, a.raza, a.edad, a.tamano, a.salud, a.disponibilidad});
        };
        Runnable limpiarFormulario = () -> {
            nombre.setText(""); especie.setText(""); raza.setText(""); edad.setText(""); tamano.setText("");
            caracteristicas.setText(""); salud.setText(""); disponibilidad.setSelectedIndex(0);
            ruta[0] = null; archivo.setText("Sin imagen seleccionada"); idActual[0] = -1; tabla.clearSelection();
        };
        elegirImagen.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Seleccionar fotografía del animal");
            chooser.setFileFilter(new FileNameExtensionFilter("Imágenes (JPG, PNG, GIF)", "jpg", "jpeg", "png", "gif"));
            if (chooser.showOpenDialog(dialogo) == JFileChooser.APPROVE_OPTION) {
                ruta[0] = chooser.getSelectedFile().getAbsolutePath();
                archivo.setText(chooser.getSelectedFile().getName());
            }
        });
        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabla.getSelectedRow() >= 0) {
                int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
                Animal a = indiceAnimales.get(id);
                if (a != null) {
                    idActual[0] = id; nombre.setText(a.nombre); especie.setText(a.especie); raza.setText(a.raza);
                    edad.setText(String.valueOf(a.edad)); tamano.setText(a.tamano); caracteristicas.setText(a.caracteristicas);
                    salud.setText(a.salud); disponibilidad.setSelectedItem(a.disponibilidad); ruta[0] = a.rutaImagen;
                    archivo.setText(ruta[0] == null ? "Sin imagen seleccionada" : new File(ruta[0]).getName());
                }
            }
        });
        registrar.addActionListener(e -> {
            Animal nuevo = validarFormulario(nombre, especie, raza, edad, tamano, caracteristicas, salud, disponibilidad, ruta[0]);
            if (nuevo == null) return;
            agregarAnimal(nuevo.nombre, nuevo.especie, nuevo.raza, nuevo.edad, nuevo.tamano, nuevo.caracteristicas, nuevo.salud, nuevo.disponibilidad, nuevo.rutaImagen);
            refrescar.run(); limpiarFormulario.run(); actualizarGaleria();
            JOptionPane.showMessageDialog(dialogo, "Animal registrado correctamente.");
        });
        modificar.addActionListener(e -> {
            if (idActual[0] == -1) { JOptionPane.showMessageDialog(dialogo, "Seleccione un animal de la tabla."); return; }
            Animal datos = validarFormulario(nombre, especie, raza, edad, tamano, caracteristicas, salud, disponibilidad, ruta[0]);
            if (datos == null) return;
            Animal a = indiceAnimales.get(idActual[0]);
            a.nombre = datos.nombre; a.especie = datos.especie; a.raza = datos.raza; a.edad = datos.edad;
            a.tamano = datos.tamano; a.caracteristicas = datos.caracteristicas; a.salud = datos.salud;
            a.disponibilidad = datos.disponibilidad; a.rutaImagen = datos.rutaImagen;
            refrescar.run(); limpiarFormulario.run(); actualizarGaleria();
            JOptionPane.showMessageDialog(dialogo, "Animal modificado correctamente.");
        });
        eliminar.addActionListener(e -> {
            if (idActual[0] == -1) { JOptionPane.showMessageDialog(dialogo, "Seleccione un animal de la tabla."); return; }
            int confirmar = JOptionPane.showConfirmDialog(dialogo, "¿Está seguro de eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                Animal a = indiceAnimales.remove(idActual[0]);
                animales.remove(a); refrescar.run(); limpiarFormulario.run(); actualizarGaleria();
                JOptionPane.showMessageDialog(dialogo, "Animal eliminado correctamente.");
            }
        });
        limpiar.addActionListener(e -> limpiarFormulario.run());
        refrescar.run();
        dialogo.setVisible(true);
    }

    private Animal validarFormulario(JTextField nombre, JTextField especie, JTextField raza, JTextField edad,
                                     JTextField tamano, JTextField caracteristicas, JTextField salud,
                                     JComboBox<String> disponibilidad, String ruta) {
        String n = nombre.getText().trim(), es = especie.getText().trim(), r = raza.getText().trim();
        String ed = edad.getText().trim(), t = tamano.getText().trim(), c = caracteristicas.getText().trim(), s = salud.getText().trim();
        if (n.isEmpty() || es.isEmpty() || r.isEmpty() || ed.isEmpty() || t.isEmpty() || s.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los campos obligatorios: nombre, especie, raza, edad, tamaño y salud."); return null;
        }
        try {
            int anios = Integer.parseInt(ed);
            if (anios < 0 || anios > 100) throw new NumberFormatException();
            return new Animal(-1, n, es, r, anios, t, c, s, disponibilidad.getSelectedItem().toString(), ruta);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero entre 0 y 100."); return null;
        }
    }

    // --------------------------- COMPONENTES / ESTILOS ---------------------------
    private JLabel etiquetaCampo(String texto) {
        JLabel l = new JLabel(texto); l.setFont(new Font("SansSerif", Font.PLAIN, 11)); l.setForeground(TEXTO); return l;
    }
    private JTextField campoGestion() { JTextField t = new JTextField(16); estilizarCampo(t); return t; }
    private void agregarCampo(JPanel p, GridBagConstraints g, int fila, String titulo, JComponent campo) {
        g.gridx = 0; g.gridy = fila * 2; g.gridwidth = 2; p.add(etiquetaCampo(titulo), g);
        g.gridy = fila * 2 + 1; p.add(campo, g);
    }
    private void estilizarCampo(JTextField campo) {
        campo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        campo.setForeground(TEXTO); campo.setBackground(PANEL);
        campo.setCaretColor(CAFE_OSCURO);
        campo.setSelectionColor(ARENA);
        campo.setSelectedTextColor(TEXTO);
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDE, 1, true),
                new EmptyBorder(8, 11, 8, 11)));
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        campo.setPreferredSize(new Dimension(220, 36));
    }
    private void estilizarCombo(JComboBox<?> combo) {
        combo.setFont(new Font("SansSerif", Font.PLAIN, 12)); combo.setBackground(BLANCO); combo.setForeground(TEXTO);
        combo.setPreferredSize(new Dimension(155, 38));
        combo.setBorder(BorderFactory.createCompoundBorder(new LineBorder(BORDE, 1, true), new EmptyBorder(3, 7, 3, 7)));
    }
    private JButton botonPrincipal(String texto) {
        JButton b = new JButton(texto);
        configurarBoton(b, CAFE, new Color(202, 218, 202), CAFE_OSCURO, 12);
        b.setBorder(new EmptyBorder(10, 19, 10, 19));
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        return b;
    }

    private JButton botonSecundario(String texto) {
        JButton b = new JButton(texto);
        configurarBoton(b, new Color(241, 243, 237), new Color(228, 234, 224), TEXTO, 11);
        b.setBorder(new EmptyBorder(9, 14, 9, 14));
        return b;
    }

    private JButton botonBarra(String texto) {
        JButton b = new JButton(texto);
        configurarBoton(b, new Color(229, 236, 226), new Color(211, 224, 210), CAFE_OSCURO, 11);
        b.setBorder(new EmptyBorder(9, 14, 9, 14));
        return b;
    }

    // BasicButtonUI evita que el tema de Windows reemplace los colores definidos.
    private void configurarBoton(JButton b, Color fondo, Color hover, Color texto, int tamano) {
        b.setUI(new BasicButtonUI());
        b.setFont(new Font("SansSerif", Font.BOLD, tamano));
        b.setForeground(texto);
        b.setBackground(fondo);
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setRolloverEnabled(true);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setMargin(new Insets(8, 14, 8, 14));
        b.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { if (b.isEnabled()) b.setBackground(hover); }
            @Override public void mouseExited(MouseEvent e) { b.setBackground(fondo); }
        });
    }

    private ImageIcon cargarImagen(String ruta, int ancho, int alto) {
        if (ruta != null && !ruta.trim().isEmpty()) {
            File f = new File(ruta);
            if (f.exists()) {
                ImageIcon original = new ImageIcon(ruta);
                Image escalada = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                return new ImageIcon(escalada);
            }
        }
        // Imagen de reemplazo cuando todavía no se ha asociado una fotografía.
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = imagen.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(ARENA); g.fillRect(0, 0, ancho, alto);
        g.setColor(new Color(137, 157, 137));
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, Math.max(45, alto / 2)));
        FontMetrics fm = g.getFontMetrics(); String huella = "🐾";
        g.drawString(huella, (ancho - fm.stringWidth(huella)) / 2, alto / 2 + fm.getAscent() / 3);
        g.setColor(TEXTO_SUAVE); g.setFont(new Font("SansSerif", Font.PLAIN, 10));
        String texto = "Fotografía no disponible"; fm = g.getFontMetrics();
        g.drawString(texto, (ancho - fm.stringWidth(texto)) / 2, alto - 12);
        g.dispose();
        return new ImageIcon(imagen);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) { }
        UIManager.put("Panel.background", FONDO);
        UIManager.put("OptionPane.background", PANEL);
        UIManager.put("OptionPane.messageForeground", TEXTO);
        UIManager.put("Button.foreground", TEXTO);
        UIManager.put("Button.background", CAFE);
        SwingUtilities.invokeLater(() -> new Adoptame().setVisible(true));
    }
}