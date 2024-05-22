package co.com.sofka.utils;

import org.jetbrains.annotations.NotNull;

import static co.com.sofka.utils.ArchivosUtil.readFile;

public class CommonXML {
    public static @NotNull String getBody(int valueUno, int valueDos, String operation) {
        return String.format(readFile("src/test/resources/archivosxml/operaciones.xml"),operation, valueUno, valueDos, operation);
    }
}
