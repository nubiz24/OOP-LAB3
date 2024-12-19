package hust.soict.hedspi.media;

import hust.soict.hedspi.exception.PlayerException;

public interface Playable {
    public void play() throws PlayerException;
}