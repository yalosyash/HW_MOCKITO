package ru.netology.manager;
import ru.netology.object.Film;

public class FilmManager {

    private Film[] films = new Film[0];

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
        return findParametrise(lengthArr(5));
    }

    public Film[] findLast(int count) {
        return findParametrise(lengthArr(count));
    }

    private int lengthArr(int wishLength) {
        if (wishLength > films.length) {
            wishLength = films.length;
        }
        return wishLength;
    }

    private Film[] findParametrise(int count) {
        Film[] lastFilms = new Film[count];
        int index = films.length - 1;
        for (int i = 0; i < count; i++) {
            lastFilms[i] = films[index];
            index--;
        }
        return lastFilms;
    }
}