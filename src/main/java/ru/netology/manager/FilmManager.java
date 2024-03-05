package ru.netology.manager;

import ru.netology.object.Film;

public class FilmManager {
    private int limit = 5;
    private Film[] films = new Film[0];

    public FilmManager() {
    }

    public FilmManager(int limit) {
        this.limit = limit;
    }

    public void save(Film newFilm) {
        Film[] tmp = new Film[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = newFilm;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        return findParametriseArr(lengthArr(limit));
    }

    private int lengthArr(int wishLength) {
        if (wishLength > films.length) {
            wishLength = films.length;
        }
        return wishLength;
    }

    private Film[] findParametriseArr(int limit) {
        Film[] lastFilms = new Film[limit];
        int index = films.length - 1;
        for (int i = 0; i < limit; i++) {
            lastFilms[i] = films[index];
            index--;
        }
        return lastFilms;
    }
}