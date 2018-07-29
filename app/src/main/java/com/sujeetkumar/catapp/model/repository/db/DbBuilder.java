package com.sujeetkumar.catapp.model.repository.db;

import android.database.Cursor;

public interface DbBuilder<T> {

    T buildFromCursor(Cursor cursor);

}
