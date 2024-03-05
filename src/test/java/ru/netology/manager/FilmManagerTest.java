package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.netology.object.Film;

public class FilmManagerTest {

    Film film1 = new Film("Терминатор", "боевик");
    Film film2 = new Film("Бладшот", "боевик");
    Film film3 = new Film("Вперед", "мультфильм");
    Film film4 = new Film("Отель \"Белград\"", "комедия");
    Film film5 = new Film("Джентельмены", "боевик");
    Film film6 = new Film("Человек-невидимка", "ужасы");
    Film film7 = new Film("Тролли. Мировой тур", "мультфильм");
    Film film8 = new Film("Номер один", "комедия");

    @Test
    public void notShouldIncludedFilm() {
        FilmManager manage = new FilmManager();
        Film[] expected = {};
        Film[] actual = manage.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFilm() {
        FilmManager manage = new FilmManager();
        manage.save(film1);
        manage.save(film2);
        manage.save(film3);

        Film[] expected = {film1, film2, film3};
        Film[] actual = manage.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfDefault() {
        FilmManager manage = new FilmManager();
        manage.save(film1);
        manage.save(film2);
        manage.save(film3);
        manage.save(film4);
        manage.save(film5);
        manage.save(film6);
        manage.save(film7);
        manage.save(film8);

        Film[] expected = {film8, film7, film6, film5, film4};
        Film[] actual = manage.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastByCount() {
        FilmManager manage = new FilmManager(3);
        manage.save(film1);
        manage.save(film2);
        manage.save(film3);
        manage.save(film4);
        manage.save(film5);
        manage.save(film6);
        manage.save(film7);
        manage.save(film8);

        Film[] expected = {film8, film7, film6};
        Film[] actual = manage.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfUnderDefault() {
        FilmManager manage = new FilmManager();
        manage.save(film1);
        manage.save(film2);
        manage.save(film3);

        Film[] expected = {film3, film2, film1};
        Film[] actual = manage.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIfOverMax() {
        FilmManager manage = new FilmManager(5);
        manage.save(film1);
        manage.save(film2);
        manage.save(film3);

        Film[] expected = {film3, film2, film1};
        Film[] actual = manage.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}