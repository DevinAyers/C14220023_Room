package com.example.room.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Query(value = "UPDATE note SET judul=:isi_judul, deskripsi=:isi_deskripsi WHERE id=:isi_id")
    fun update(isi_judul: String, isi_deskripsi: String, isi_id: Int)

    @Delete
    fun delete(note: Note)

    @Query(value = "SELECT * FROM note ORDER BY id asc")
    fun selectAll() : MutableList<Note>
}