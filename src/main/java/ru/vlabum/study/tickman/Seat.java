package ru.vlabum.study.tickman;

/**
 * Место в зале, характеризуется идентификатором и адресом.
 * Примеры адресов "Ряд", "Место". В некоторых случаях может быть еще и "Сектор".
 */
public interface Seat {
    long getId();
    String getFullName();
    String getPartName(int nPart);
}
