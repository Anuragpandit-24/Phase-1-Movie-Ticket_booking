package com.ticketbooking.service;

import java.util.ArrayList;
import java.util.List;

import com.ticketbooking.bean.MovieShow;
import com.ticketbooking.bean.MovieShowInfo;

public class ShowAvailableDates {

    private List<MovieShow> movieShows;

    public ShowAvailableDates(List<MovieShow> movieShows) {
        this.movieShows = movieShows;
    }

    public List<String> getAvailableDates() {
        List<String> availableDates = new ArrayList<>();
        for (MovieShow ms : movieShows) {
            availableDates.add(ms.getShowDate());
        }
        return availableDates;
    }

    public List<String> getAvailableShowsByDate(String date) {
        List<String> availableShows = new ArrayList<>();
        for (MovieShow ms : movieShows) {
            if (ms.getShowDate().equals(date)) {
                MovieShowInfo[] showInfo = ms.getMovieShowInfo();
                for (MovieShowInfo info : showInfo) {
                    if (info.getNumberOfSeats() > 0) {
                        availableShows.add(info.getShowTime());
                    }
                }
                break; // No need to check other dates
            }
        }
        return availableShows;
    }
}
