package org.example.bibliotecadecodigopmi.scrumlibrary;
public interface DatosGenerales {
    String getNombre();

    String getObjetivo();

    void setObjetivo(String objetivo);

    void setNombre(String nombre);

    void setNumero(int numero);

    int getNumero();

    int setSemanas(int duracionEnSemanas);

    int getSemanas();

}
