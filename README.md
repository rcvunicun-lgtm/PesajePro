# PesajePro

## Descripción

**PesajePro** es una aplicación Java de escritorio para recibir, visualizar y registrar datos de balanzas o equipos industriales que se comuniquen bajo el protocolo rs232 conectadas por puerto serie COM. También permite exportar los registros a Excel.

## Características principales

- Conexión a balanzas por puerto serie COM.
- Lectura y visualización en tiempo real de los datos de peso.
- Gestión de registros desde la interfaz gráfica.
- Exportación de los datos a Excel.

## Estructura del proyecto

```text
src/
├── principal/
├── vistasFrame/
├── vistasPanel/
├── lib/
archivosComplementarios/
recursos/
```

## Requisitos del sistema

- Java JDK 11 o superior.
- Microsoft Office (opcional).

## Dependencias

- Java Swing: para la interfaz gráfica de la aplicación.
- JavaFX 11.0.2: para componentes y ventanas modernas.
- `jSerialComm-2.11.0.jar`: para la comunicación por puerto serial COM con la balanza.
- Apache POI (`poi-5.4.1.jar`): para exportar datos a Excel.
- `jacob.jar` (carpeta `jacob-1.21`): para integrar componentes COM de Windows.
- `gson-2.12.1.jar`: para trabajar con archivos JSON y configuración.

## Instalación y ejecución

### 1. Importar librerías en Eclipse

1. Importa el proyecto en Eclipse.
2. Haz clic derecho sobre el proyecto y entra en `Properties`.
3. Ve a `Java Build Path` y luego a la pestaña `Libraries`.
4. Selecciona `Modulepath` y pulsa `Add External JARs`.
5. Agrega los archivos `.jar` de cada directorio que se encuentran en `src/lib`.

### 2. Ejecutar en Eclipse

1. Ve a `Run > Run Configurations`.
2. En `Arguments`, agrega los siguientes `VM arguments`:

```text
--module-path "src\lib\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib"
--add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web,javafx.swt
```

4. Ejecuta la aplicación.

### 3. Ejecutar desde la terminal (Solo si se ha exportado y extraido como un archivo .jar)

```cmd
java --module-path "lib\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib" \
  --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web \
  -classpath "lib/jSerialComm-2.11.0.jar;lib/poi-3.16.jar" \
  -jar AplicacionDePesaje.jar
```

## Notas importantes

- La clase de arranque es `src/principal/Principal.java`.
- La aplicación usa el puerto local `54321` para evitar que se abran varias instancias al mismo tiempo.
- Mantén las librerías externas en `src/lib/`.

## Crear un ejecutable .exe

Puedes generar un archivo ejecutable `.exe` para tu aplicación siguiendo estos pasos:

1. Exporta el proyecto desde Eclipse como `Runnable JAR file`.
2. Selecciona la clase principal que inicia la aplicación, normalmente `Principal`.
3. Indica la ruta donde se guardará el archivo `.jar` generado.
4. Mantén la opción `Package required libraries into generated JAR` para que las dependencias se incluyan.
5. Extrae o descomprime el `.jar` generado.
6. Abre Launch4j.
7. En la pestaña `Basic`:
   - Selecciona el archivo `.jar` exportado.
   - En `Output file`, coloca la misma ruta del `.jar`, pero con extensión `.exe`.
   - Si deseas, puedes asignar un icono `.ico` al ejecutable.
8. En la pestaña `JRE`:
   - Define `Min JRE version` como `1.8.0` o superior.
   - Deja `Max JRE version` vacío.
   - Añade los siguientes `VM arguments`:

```text
--module-path "lib\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib"
--add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web,javafx.swt
```

9. Haz clic en el botón de la tuerca para generar el archivo.
10. Selecciona la carpeta donde se guardará el `.exe` y confirma con `Save`.
11. Prueba el ejecutable. Si funciona correctamente, puedes comprimir la carpeta completa y compartirla.

> Se recomienda guardar el `.exe` junto con los archivos extraídos del `.jar` para que todo quede bien organizado.

## Crear un instalador con Inno Setup 6.3.3

Puedes generar un instalador para tu aplicación con Inno Setup siguiendo estos pasos:

1. Abre Inno Setup 6.3.3.
2. Ve a `File` y selecciona `New`.
3. En la ventana emergente, haz clic en `Next`.
4. Configura los datos básicos del proyecto:
   - `Application name`: PesajePro
   - `Application version`: 1.0.0
   - `Application publisher`: nombre de tu empresa o nickname
   - `Application website`: opcional (sitio web, GitHub o dejar vacío)
5. Haz clic en `Next`.
   > En la sección `Application folder` no es necesario modificar nada.
6. Haz clic en `Next`.
   > En `Application files`:
   - `Application main executable file`: selecciona el archivo `.exe` generado previamente con Launch4j.
   - `Allow user to start the application after setup has finished`: activado.
   - `The application doesn't have a main executable file`: desactivado.
   - `Other application files`: haz clic en `Add Folder` y selecciona la carpeta donde se encuentra extraído tu proyecto Java.
7. Haz clic en `Next`.
   > En `Application file associations` no es necesario modificar nada.
8. Haz clic en `Next`.
   > En `Application shortcuts` no es necesario modificar nada.
9. Haz clic en `Next`.
   > En `Application documentation` no es necesario modificar nada.
   - `License file`: puedes crear un archivo de licencia.
   - `Information file shown before installation`: puedes agregar un archivo con información que se mostrará antes de instalar.
   - `Information file shown after installation`: puedes agregar un archivo con información que se mostrará después de instalar.
10. Haz clic en `Next`.
    > En `Setup install mode` no es necesario modificar nada.
11. Haz clic en `Next`.
    > En `Application registry keys and values` no es necesario modificar nada.
12. En `Setup languages`, selecciona los idiomas en los que deseas mostrar la información del instalador: Inglés y Español. Luego haz clic en `Next`.
13. En `Compiler settings`:
    - `Custom compiler output folder`: elige una carpeta nueva donde se generará el instalador.
    - `Compiler output base file name`: asigna un nombre, por ejemplo `PesajePro Installer`.
    - `Custom setup icon file`: selecciona un archivo `.ico` para el instalador.
    - `Setup password`: opcional. Puedes agregar una contraseña para proteger la instalación.
14. Haz clic en `Next`.
    > En `Inno Setup compiler` no es necesario modificar nada.
15. Haz clic en `Next`.
16. Haz clic en `Finish`.
17. Aparecerá un mensaje que dice `Would you like to compile the new script now?`.
    - Haz clic en `Yes`.
    - Vuelve a confirmar con `Yes`.
    - Se generará un archivo `.iss`. Guárdalo en la misma carpeta del instalador y dale un nombre.
18. El proceso puede tardar unos minutos. Cuando termine, en la consola de Inno Setup aparecerá un mensaje en verde con la palabra `Finished` junto con la hora y la fecha.
19. Ya puedes usar tu instalador.

## Lo que aprendí con este proyecto

- Comunicación serial con Java.
- Integración de interfaces gráficas con Swing/JavaFX.
- Lectura y exportación de datos a Excel.
- Empaquetado de aplicaciones Java en ejecutables e instaladores.

## Autor

Rodrigo Cantor Vásquez.
